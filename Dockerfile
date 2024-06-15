FROM maven:3.9.7-eclipse-temurin-17 AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:17-jdk-alpine
    
COPY --from=build /home/app/target/userio-0.0.1-SNAPSHOT.jar /usr/local/lib/userio.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/userio.jar"]
