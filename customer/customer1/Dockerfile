FROM openjdk:17
EXPOSE 8080
ADD target/docker-spring.jar docker-spring.jar
ENTRYPOINT ["java", "-jar", "docker-spring.jar"]

