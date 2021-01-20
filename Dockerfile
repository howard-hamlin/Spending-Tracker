FROM docker-release-local.artifactory-lvn.broadcom.net/broadcom-images/alpine/openjre/tomcat:tomcat8-openjre8-alpine3

USER root

RUN apk --no-cache add shadow

ENV USER_NAME cdd
ENV GROUP_NAME cdd
ENV USER_ID 1010
ENV GROUP_ID 1010
ENV USER_HOME /home/$USER_NAME
ENV CDD_HOME_FOLDER $USER_HOME/.cdd

RUN groupmod -n $GROUP_NAME `getent group $GROUP_ID | cut -d: -f1`
RUN usermod -l $USER_NAME -d $USER_HOME -m `getent passwd $USER_ID | cut -d: -f1`

ARG ARTIFATORY_PASS=AP4C5zH6hLU5yhfaho38LqfsUqR
ENV TOMCAT_HOME /usr/local/apache-tomcat
ENV REPOSITORY_URL https://bldcddbuild.co:$ARTIFATORY_PASS@artifactory-lvn.broadcom.net:443/artifactory
ENV CT_AGENT_URL maven-integration-local/com/ca/cdd/trunk/ct_agent/1.8-SNAPSHOT/ct_agent-1.8-SNAPSHOT.jar
ENV JAVA_OPTS=' -javaagent:$CDD_HOME_FOLDER/ct_agent.jar'

RUN mkdir -p $USER_HOME
RUN chown cdd:cdd $USER_HOME -R

USER cdd
COPY build/libs/dummy.war $TOMCAT_HOME/webapps/dummy.war

ARG WSE_URL=$REPOSITORY_URL/$CT_AGENT_URL
ADD $WSE_URL $CDD_HOME_FOLDER/ct_agent.jar

USER root
RUN chown cdd:cdd $TOMCAT_HOME -R
RUN chmod -R 777 $CDD_HOME_FOLDER

USER cdd

EXPOSE 8080
VOLUME $CDD_HOME_FOLDER
CMD ["catalina.sh", "run"]
