FROM openjdk:8-jre-alpine


LABEL maintainer="Paulo Merson"  \
      org.label-schema.vcs-url=http://srv-scm.tcu.gov.br/sti/sofia-ms.git \
      org.label-schema.build-date=$DATA_DO_BUILD

EXPOSE 8080

RUN apk add -U tzdata && cp /usr/share/zoneinfo/Brazil/East /etc/localtime
ENTRYPOINT java ${JVM_ARGS:- -Xms128m -Xmx128m} -Djava.security.egd=file:/dev/./urandom -Duser.language=pt -Duser.country=BR -jar app.jar
ADD build/libs/sofia-ms-0.0.1-SNAPSHOT.jar app.jar
