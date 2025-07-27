FROM openjdk:11

ARG JAR=target/*.jar

COPY ${JAR} demo.jar

ENTRYPOINT ["java", "-jar", "/demo.jar"]

EXPOSE 8761