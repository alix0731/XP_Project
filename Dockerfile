FROM openjdk:8
EXPOSE 8081
ADD target/project-0.0.1-SNAPSHOT.jar project-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/project-0.0.1-SNAPSHOT.jar"]