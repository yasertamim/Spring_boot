FROM openjdk:17
ADD target/docker-spring.jar docker-spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-spring.jar"]