FROM ubuntu:18.04
USER root

ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

RUN apt-get -y update
RUN apt-get -y install openjdk-8-jdk

COPY . /read-files-service
WORKDIR /read-files-service

RUN ./gradlew build

CMD ["java", "-jar", "./read-files-service/build/libs/read-files-service-1.0-SNAPSHOT.jar"]