#!/bin/bash
 
echo "CONTAINER_ENV : ${CONTAINER_ENV}"
 
# define default attribute..
APPLICATION_NAME=au-da-dokumart
APPLICATION_JAR="${APPLICATION_NAME}.jar"
 
# prepared arguments allocation memory..
if [[ "x${XMSLimit}" == "x" ]]; then
    # default allocation memory minimum
    XMSLimit="128m"
fi
 
if [[ "x${XMXLimit}" == "x" ]]; then
    # default allocation memory maximum
    XMXLimit="256m"
fi
 
JAVA_OPTS="-Xms${XMSLimit} -Xmx${XMXLimit}"
 
#log level
if [[ "x${LOG_LEVEL}" != "x" ]]; then
    JAVA_OPTS="${JAVA_OPTS} -Dlogging.level.com.doku.au=${LOG_LEVEL}"
fi
 
# set up spring profile active.
if [[ "x${CONTAINER_ENV}" == "x" ]]; then
    # default environment variable
    CONTAINER_ENV="default"
elif [[ "${CONTAINER_ENV,,}" == "sandbox" ]]; then
    JAVA_OPTS="${JAVA_OPTS} -Dspring.cloud.config.enabled=true -Dspring.cloud.config.uri=http://au-spring-cloud-config.apple-b-au.svc:8888"
elif [[ "${CONTAINER_ENV,,}" == "prod" ]]; then
    JAVA_OPTS="${JAVA_OPTS} -Dspring.cloud.config.enabled=true -Dspring.cloud.config.uri=http://au-spring-cloud-config.apple-p-au.svc:8888"
fi
 
JAVA_OPTS="${JAVA_OPTS} -Dspring.profiles.active=${CONTAINER_ENV,,}"
 
# run apps.
eval "java -jar ${JAVA_OPTS} ${APPLICATION_JAR}"