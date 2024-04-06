#Build
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY shopapp-backend /app/shopapp-backend
RUN mvn package -f /app/shopapp-backend/pom.xml

#multi-staging
FROM openjdk:17-slim  
WORKDIR /app
COPY --from=build /app/shopapp-backend/target/shopapp-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build /app/shopapp-backend/uploads uploads

EXPOSE 8088
CMD ["java","-jar","app.jar"]

#docker build -t shopapp-spring:1.0.4 -f ./DockerfileJavaSpring .
#docker login
#create sunlight4d/shopapp-spring:1.0.4 repository on DockerHub
#docker tag shopapp-spring:1.0.4 sunlight4d/shopapp-spring:1.0.4
#docker push sunlight4d/shopapp-spring:1.0.4


