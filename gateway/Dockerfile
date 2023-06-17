FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE  9999
ADD target/gateway-docker.jar gateway-docker.jar
ENTRYPOINT  ["java","jar","/gateway-docker.jar"]
