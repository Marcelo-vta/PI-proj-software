<<<<<<< HEAD
FROM eclipse-temurin:21-jre-alpine

COPY target/prova-i-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
=======
FROM eclipse-temurin:21-jre-alpine

COPY target/prova-i-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
>>>>>>> 702b54e7b42d3f1910fc1b420cc0115e5cd0a991
