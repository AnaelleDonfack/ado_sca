FROM adoptopenjdk/openjdk11:alpine-jre
LABEL desc="This is docker for backend api that return a string"
LABEL "website.endpoint" = "/welcome"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/application.jar"]