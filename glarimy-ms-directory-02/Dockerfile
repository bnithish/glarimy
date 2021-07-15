FROM maven:3.6.3-jdk-11-slim AS build
COPY src /use/glarimy/src
COPY pom.xml /usr/glarimy/pom.xml
RUN mvn -f /usr/glarimy/ clean package -DskipTests=true

FROM openjdk:11-jre-slim
COPY --from=build /usr/glarimy/target/glarimy-directory.jar /usr/local/lib/glarimy-directory.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/glarimy-directory.jar"]