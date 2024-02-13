FROM openjdk:17.0.2-jdk
COPY bank-manager-server/target/bank-manager-server-1.0-SNAPSHOT.jar /app/bank-manager-server.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "-Dspring.datasource.url=${SPRING_DATASOURCE_URL}", "bank-manager-server.jar"]
