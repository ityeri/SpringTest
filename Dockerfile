FROM openjdk:21-jdk

LABEL authors="it"

COPY ./build/libs/SpringTest-0.0.1-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]