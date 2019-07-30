FROM openjdk:8-jre-alpine

LABEL maintainer="Paulo Merson"  \
      org.label-schema.vcs-url=https://github.com/pmerson/helloBootKotlin.git

EXPOSE 8080

ENTRYPOINT java ${JVM_ARGS:- -Xms128m -Xmx128m} -jar app.jar
ADD build/libs/hello-ms-0.0.1-SNAPSHOT.jar app.jar
