FROM openjdk:11
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENV TZ Asia/Baku
ENTRYPOINT ["java", "-jar", "/app.jar"]

