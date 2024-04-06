FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY . /app

RUN mvn package -f /app/shopapp/pom.xml

FROM openjdk:17-slim  
WORKDIR /app
COPY --from=build /app/shopapp/target/shopapp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java","-jar","app.jar"]

#docker build -f ./Dockerfile -t shopapp-spring:1.0.0 .
#docker create --name shopapp-container shopapp-spring:1.0.0


