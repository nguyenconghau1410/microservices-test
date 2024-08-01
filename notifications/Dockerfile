FROM openjdk:17-jdk-slim

WORKDIR /app
COPY ./target/notifications-0.0.1-SNAPSHOT.jar ./notifications-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "notifications-0.0.1-SNAPSHOT.jar"]