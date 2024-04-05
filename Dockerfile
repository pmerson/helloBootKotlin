# Base image
FROM docker.io/library/eclipse-temurin:11-jre-alpine

# Labels are for image metadata
LABEL maintainer="Paulo Merson"  \
      org.label-schema.vcs-url=https://github.com/pmerson/helloBootKotlin.git

EXPOSE 8080

ENTRYPOINT java ${JVM_ARGS:- -Xms128m -Xmx128m} -jar app.jar

WORKDIR /opt/app

# Security good practice: avoid running as root
ARG USER=appUser
ARG UID=1000
RUN adduser --disabled-password --gecos $USER --uid $UID $USER
ADD build/libs/hello-ms-0.0.1-SNAPSHOT.jar app.jar
ADD data/quotes.txt /data/quotes.txt
RUN chown -R $USER .
USER $USER
