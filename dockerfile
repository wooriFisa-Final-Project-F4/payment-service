FROM openjdk:17-jdk
WORKDIR /app
COPY build/libs/payment-service-0.0.1-SNAPSHOT.jar /app/payment-service.jar
CMD ["java", "-jar", "/app/payment-service.jar"]