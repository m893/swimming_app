FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /home/app
COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app
EXPOSE 8080
COPY --from=build /home/app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
