FROM adoptopenjdk/openjdk11
RUN mkdir /app
COPY build/libs/grpc-server-*-all.jar /app/grpc-demo-server.jar
WORKDIR /app

EXPOSE 50051

ENTRYPOINT ["java", "-jar", "grpc-demo-server.jar"]
