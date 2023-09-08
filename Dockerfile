FROM maven:3.9.4-eclipse-temurin-17 as builder

COPY src /app/src 
COPY pom.xml /app 

RUN mvn -f /app/pom.xml clean package  

FROM openjdk:17-ea-jdk-buster

RUN  useradd -ms /bin/bash java \
    && mkdir /app \
    && chown java:java /app

COPY --from=builder /app/target/proyectos-0.0.1-SNAPSHOT.jar /app/app.jar
#COPY target/proyectos-0.0.1-SNAPSHOT.jar /app/app.jar

USER java
WORKDIR /app

ENTRYPOINT ["java"]
CMD ["-jar","-Djava.security.egd=file:/dev/./urandom","/app/app.jar"]
