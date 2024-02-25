# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/ticketSystemApp.jar /app/ticketSystemApp.jar
EXPOSE 8080
CMD ["java", "-jar", "ticketSystemApp.jar"]