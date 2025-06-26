# Use lightweight OpenJDK image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file
ARG JAR_FILE=build/libs/saic-sb-demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

