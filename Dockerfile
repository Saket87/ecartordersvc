FROM openjdk:8
ADD target/ecartordersvc.jar ecartordersvc.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ecartordersvc.jar"]