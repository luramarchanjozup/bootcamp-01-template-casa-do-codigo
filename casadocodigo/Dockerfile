FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPS=${ADDITIONAL_OPS}

WORKDIR /opt/casadocodigo

COPY /target/casadocodigo*.jar casadocodigo.jar

SHELL ["/bin/sh","-c"]

EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar casadocodigo.jar --spring.profiles.active=${PROFILE}