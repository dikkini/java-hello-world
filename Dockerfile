FROM openjdk:14

WORKDIR /app

ADD ./app/ .

RUN ./mvnw package

CMD [ "java", "-jar", "target/java-hello-world-0.0.1-SNAPSHOT.jar" ]