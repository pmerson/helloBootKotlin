FROM openjdk:8-jre-alpine

LABEL maintainer="Paulo Merson"  \
      org.label-schema.vcs-url=https://github.com/pmerson/helloBootKotlin.git

EXPOSE 8080

# RUN apk add -U tzdata && cp /usr/share/zoneinfo/Brazil/East /etc/localtime
# ENTRYPOINT java ${JVM_ARGS:- -Xms128m -Xmx128m} -Djava.security.egd=file:/dev/./urandom -Duser.language=pt -Duser.country=BR -jar app.jar

ENTRYPOINT java ${JVM_ARGS:- -Xms128m -Xmx128m} -jar app.jar
ADD build/libs/hello-ms-0.0.1-SNAPSHOT.jar app.jar
