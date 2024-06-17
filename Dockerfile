FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar db-notification-api.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/db-notification-api.jar"]
