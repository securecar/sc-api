FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

# Use a porta 8080 como padrão se PORT não estiver definido
ENV PORT 8080

EXPOSE ${PORT}

COPY --from=build /target/sc-api-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]