library 'cdd-global-pipeline-libraries'
properties([
 pipelineTriggers([githubPush()]),
 parameters([
   string(defaultValue: 'http://ibndev003773.bpc.broadcom.net:8080', description: '', name: 'CDD_SERVER_URL', trim: true),
   string(defaultValue: '00000000-0000-0000-0000-000000000000', description: '', name: 'CDD_TENANT_ID', trim: true)])
 ])
params.each { k, v -> env[k] = v }
pipeline {
 agent {
  label 'master'
 }
 stages {
  stage('Checkout') {
   steps {
    echo "***Build***"
   }
  }
 }
 post {
  success {
    sendNotificationToCDDCall projectName: 'Demo', scope: 'BUSINESS_APPLICATION', businessApplicationName: 'ClearSpend'
  }
 }
}
