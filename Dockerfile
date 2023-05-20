FROM openjdk:17

COPY target/simple-dev-0.0.1.jar simple-dev.jar

ENTRYPOINT ["java", "-jar", "/simple-dev.jar"]