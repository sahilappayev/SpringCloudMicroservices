FROM openjdk:11
COPY  build/libs/*.jar app.jar
ENV TZ Asia/Baku
ENTRYPOINT ["java", "-jar", "/app.jar"]

