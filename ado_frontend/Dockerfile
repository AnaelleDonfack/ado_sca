FROM adoptopenjdk/openjdk11:alpine-jre as builder
# First stage : Extract the layers
WORKDIR application
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
RUN addgroup -S appgroup && adduser -S nonroot -G appgroup
# Tell docker that all future commands should run as the appuser user
USER nonroot
LABEL desc="This is docker for frontend sca that contact ado_backend"
LABEL "website.endpoint" = "/"
EXPOSE 8081
CMD ["java", "org.springframework.boot.loader.JarLauncher"]
