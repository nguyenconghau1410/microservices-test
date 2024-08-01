FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/student-0.0.1-SNAPSHOT.jar ./student-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "student-0.0.1-SNAPSHOT.jar"]