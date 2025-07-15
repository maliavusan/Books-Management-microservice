# Use a base image with Java (Java 8 example)
FROM eclipse-temurin:8-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR (make sure to build the app first)
COPY target/Books-Management-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT [ "java", "-jar", "app.jar" ]