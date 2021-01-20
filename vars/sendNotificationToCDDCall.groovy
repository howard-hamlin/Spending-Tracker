def call(Map config) {
 try {
  String projectName
  String scope
  if(config){
	projectName = config.projectName
	scope = config.scope
	env.CDD_BUSINESS_APPLICATION_NAME = config.businessApplicationName
  }
  println "Optional Parameter [projectName=${projectName}]."
  println "Optional Parameter [scope=${scope}]."
  println "Optional Parameter [businessApplicationName=${env.CDD_BUSINESS_APPLICATION_NAME}]."
  environmentSetUp(projectName)
  sendNotificationToCDDirector(scope)	 
  processCDDReleases(evaluate("${currentBuild.description}"))
 } catch (ex) {
  echo "Exception occurred. Skipping notification to CDD. Error is [" + ex.toString() + "]"
 }
}

void environmentSetUp(projectName) {
 getTenantIdFromCredentials()
 getAPIKeyFromCredentials(projectName)
 setGitEnvironmentVariables()
 setCDDServerName()
 env.CDD_SERVER_PORT = 0
 env.CDD_USE_SSL = false
 env.CDD_PROXY_SERVER_URL = ""
 env.CDD_PROXY_SERVER_USERNAME = ""
 env.CDD_PROXY_SERVER_PASSWORD = ""
 if(!("${env.CDD_BUSINESS_APPLICATION_NAME}") || 'null' == "${env.CDD_BUSINESS_APPLICATION_NAME}"){
	env.CDD_BUSINESS_APPLICATION_NAME = "${env.GIT_URL.replaceFirst(/^.*\/(.*)\/.*.git$/, '$1')}"
	echo "Using Repository Owner: [${CDD_BUSINESS_APPLICATION_NAME}] as Business Application Name."
 }
 env.CDD_APPLICATION_NAME = "${env.GIT_URL.replaceFirst(/^.*\/([^\/]+?).git$/, '$1')}"
 env.CDD_APPLICATION_VERSION_NAME = "$env.BRANCH_NAME"
 env.CDD_GIT_COMMIT_ID = "$env.GIT_COMMIT"
 env.CDD_PREVIOUS_GIT_COMMIT_ID = "$env.GIT_PREVIOUS_SUCCESSFUL_COMMIT"
}

void setCDDServerName(){
 if("${params.CDD_SERVER_URL}" && 'null' != "${params.CDD_SERVER_URL}"){
   println "Using Project Build Parameter - CDD_SERVER_URL: [${params.CDD_SERVER_URL}]"
   env.CDD_SERVER_NAME = "${params.CDD_SERVER_URL}"
 }else if("${env.CDD_SERVER_URL}" && 'null' != "${env.CDD_SERVER_URL}"){
   println "Using Global Environment Variable - CDD_SERVER_URL: [${env.CDD_SERVER_URL}]"
   env.CDD_SERVER_NAME = "${env.CDD_SERVER_URL}"
 }else{
   env.CDD_SERVER_NAME = "ibndev003773.bpc.broadcom.net"
 }
}

void getTenantIdFromCredentials() {
	println "Getting Tenant ID from Credentials: [CDD_TENANT_ID]"
	def credentials = com.cloudbees.plugins.credentials.CredentialsProvider.findCredentialById('CDD_TENANT_ID',
			com.cloudbees.plugins.credentials.Credentials.class,
			currentBuild.rawBuild, null
			);
	if(credentials && credentials.secret){
		env.CDD_TENANT_ID = credentials.secret
	}
	else{
		env.CDD_TENANT_ID = "00000000-0000-0000-0000-000000000000"
		println "Tenant credential [CDD_TENANT_ID] NOT found, Using Default Tenant ID: [${CDD_TENANT_ID}]."
	}
}

void getAPIKeyFromCredentials(projectName) {
	String apiKeyId = 'CDD_API_KEY';
	if(projectName) {
		apiKeyId = apiKeyId + ".${projectName}";
		println "Using Project: [${projectName}] API Key ID: [${apiKeyId}]."
	}
	println "Getting CDD API Key from Id: [${apiKeyId}]."
	def credentials = com.cloudbees.plugins.credentials.CredentialsProvider.findCredentialById("${apiKeyId}",
			com.cloudbees.plugins.credentials.Credentials.class,
			currentBuild.rawBuild, null
			);
	env.CDD_API_KEY = credentials.secret
}

void setGitEnvironmentVariables() {
 if (!env.GIT_URL) env.GIT_URL = sh(returnStdout: true, script: 'git config remote.origin.url').trim()
 if (!env.GIT_COMMIT) env.GIT_COMMIT = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
 if (!env.GIT_PREVIOUS_SUCCESSFUL_COMMIT) env.GIT_PREVIOUS_SUCCESSFUL_COMMIT = getLastSuccessfulCommit()
}

String getLastSuccessfulCommit() {
 String lastSuccessfulHash = null
 def lastSuccessfulBuild = currentBuild.rawBuild.getPreviousSuccessfulBuild()
 println "Previous Successful Build: [$lastSuccessfulBuild]."
 if (lastSuccessfulBuild) {
  def scmAction = lastSuccessfulBuild?.actions.find {
   action -> action instanceof jenkins.scm.api.SCMRevisionAction
  }
  lastSuccessfulHash = scmAction?.revision?.hash
  println "Previous Successful Build Revision: [${scmAction?.revision}], Hash: [$lastSuccessfulHash], Source Id: [${scmAction?.sourceId}]."
 }
 if(lastSuccessfulHash)
	 return lastSuccessfulHash
 return getFirstCommit()
}

String getFirstCommit() {
 println "Previous Successful Commit is NULL. Fetching First Commit..."
 String firstCommit = sh(returnStdout: true, script: "git rev-list $env.GIT_COMMIT | tail -1").trim()
 println "Using First Commit found as Previous Successful Commit: [$firstCommit]"
 return firstCommit
}

void sendNotificationToCDDirector(scope) {
 echo '----------Sending Change Notification to CDD--------------'
 echo "Environment variables: GIT_URL: [$env.GIT_URL], GIT_BRANCH: [$env.GIT_BRANCH], BRANCH_NAME: [$env.BRANCH_NAME], GIT_LOCAL_BRANCH: [$env.GIT_LOCAL_BRANCH], CDD_APPLICATION_NAME: [${CDD_APPLICATION_NAME}], CDD_APPLICATION_VERSION_NAME: [${CDD_APPLICATION_VERSION_NAME}], GIT_COMMIT: [${env.GIT_COMMIT}], GIT_PREVIOUS_SUCCESSFUL_COMMIT: [${env.GIT_PREVIOUS_SUCCESSFUL_COMMIT}]"
 sendNotificationToCDD useSourceCodeRepositoryNameAsApplicationName: true,
  applicationName: "${CDD_APPLICATION_NAME}",
  useSourceCodeRepositoryBranchNameAsApplicationVersionName: true,
  applicationVersionName: "${CDD_APPLICATION_VERSION_NAME}",
  gitCommit: "${CDD_GIT_COMMIT_ID}",
  gitPreviousSuccessfulCommit: "${CDD_PREVIOUS_GIT_COMMIT_ID}",
  overrideCDDConfiguration: [
   customApiKey: "${CDD_API_KEY}",
   customProxyUrl: "${CDD_PROXY_SERVER_URL}",
   customProxyUsername: "${CDD_PROXY_SERVER_USERNAME}",
   customProxyPassword: "${CDD_PROXY_SERVER_PASSWORD}",
   customServerName: "${CDD_SERVER_NAME}",
   customServerPort: "${CDD_SERVER_PORT}",
   customTenantId: "${CDD_TENANT_ID}",
   customUseSSL: "${CDD_USE_SSL}"
  ],
  ignoreNonexistentApplication: true,
  releaseTokens: '{}',
  onlyIntelligentTestSuites: false,
  commitSource: '', 
  scope: "${scope}",
  fileSourceName:"",
  fileSourceParameters:'{"branch":"${CDD_APPLICATION_VERSION_NAME}"}',
  dslFilename:"",
  dslParameters:'{"BUSINESS_APPLICATION_NAME": "${CDD_BUSINESS_APPLICATION_NAME}", "BUSINESS_APPLICATION_VERSION_NAME": "${CDD_APPLICATION_VERSION_NAME}", "APPLICATION_NAME":"${CDD_APPLICATION_NAME}","APPLICATION_VERSION_NAME":"${CDD_APPLICATION_VERSION_NAME}"}'
 echo '----------Jenkins Pipeline completed successfully--------------'
}

void processCDDReleases(Map cddReleaseMap) {
 if (cddReleaseMap) {
  echo '----------Process CDD Releases--------------'
  cddReleaseMap.eachWithIndex {
   entry,
   index ->
   println "[$entry.key] = [$entry.value]"
   env.
   "$entry.key" = "$entry.value";
  }
 }
}
