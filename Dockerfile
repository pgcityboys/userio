FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
COPY src src

RUN mvn clean package

FROM eclipse-temurin:21

WORKDIR /app
COPY --from=builder /app/target/userio-0.0.1-SNAPSHOT.jar /app/userio.jar
EXPOSE 8080

CMD ["java", "-jar", "userio.jar"]
