FROM openjdk:11
EXPOSE 8000
COPY  build/libs/currency-exchange-service-0.0.1.jar app.jar
ENV TZ Asia/Baku
ENTRYPOINT ["java", "-jar", "/app.jar"]