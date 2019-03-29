FROM adoptopenjdk/openjdk11
RUN mkdir /app
COPY build/libs/grpc-demo-*.jar /app/grpc-demo-client.jar
WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "grpc-demo-client.jar"]
