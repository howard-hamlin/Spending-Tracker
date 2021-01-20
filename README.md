# NatWest-Online-Payments

An application to be used for testing other apps.  
Initially used to test tar-agent.  

### In order to run a dummy-app with a java agent that monitors the dummy app, follow steps below:
**1.**  make sure docker is installed on host. you may type the command below and get a list of running containers.  
  docker ps
  
**2.** create settings.properties file under /home/cdd/.cdd, with properties below:  
   cdd.continuous_testing_agent.cdd.url=[CDD URL] e.g. http://lvnapi024198.bpc.broadcom.net:8080/cdd    
   cdd.continuous_testing_agent.cdd.api_key=[USER API KEY]  
   cdd.continuous_testing_agent.cdd.application=[MONITORED APPLICATION NAME]  
   cdd.continuous_testing_agent.cdd.disable_host_verification=true  
   cdd.continuous_testing_agent.cdd.environment=[MONITORED ENVIRONMENT NAME]  
   cdd.continuous_testing_agent.cdd.tenant_id=[TENANT ID]
   cdd.continuous_testing_agent.cdd.trust_self_signed_certificate=true  
   cdd.continuous_testing_agent.cdd.url_path=ct_agent  
   cdd.continuous_testing_agent.log.configuration_file=[OPTIONAL - logback.xml location ] e.g.  /home/cdd/.cdd/ct_agent.logback.xml  
   cdd.continuous_testing_agent.log.level=trace  
   cdd.continuous_testing_agent.log.maximum_memory_size=8000  
   cdd.continuous_testing_agent.packages.exclude=com.ca.cdd.ws,com.ca.cdd.controllers,com.ca.cdd.dao  
   cdd.continuous_testing_agent.packages.include=com.ca.cdd  
  
**3.** run command -  
  docker login -u bldcddbuild.co -p C@passw0rd1 docker-release-candidate-local.artifactory-lvn.broadcom.net
  
**4.** run command -  
  docker run  -d -p 8090:8080 -v /home/cdd/.cdd/conf:/home/cdd/.cdd/conf docker-release-candidate-local.artifactory-lvn.broadcom.net/com/ca/cdd/dummy-app:[BUILD NUMBER - YOU MAY USE LATEST]

**5.** on the browser (e.g. chrome) type. 
    http://[DOCKER ENGINE HOST NAME]:8090/dummy-app


