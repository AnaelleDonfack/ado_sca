FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR application
LABEL desc="This is docker for backend api that return a string"
LABEL "website.endpoint" = "/welcome"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
# Second stage : Copy the extracted layers
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
# Create a group and user
RUN addgroup -S appgroup && adduser -S ado_backend -G appgroup
# Tell docker that all future commands should run as the appuser user
USER ado_backend
EXPOSE 8080
CMD ["java", "org.springframework.boot.loader.JarLauncher"]