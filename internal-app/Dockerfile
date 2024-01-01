FROM amazoncorretto:17-alpine3.16
WORKDIR /app
COPY build/libs/internal-app-0.0.1-SNAPSHOT.jar /app/internal-app-0.0.1-SNAPSHOT.jar
EXPOSE 8081
CMD ["java", "-jar", "internal-app-0.0.1-SNAPSHOT.jar"]