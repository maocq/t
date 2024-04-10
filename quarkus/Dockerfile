FROM maven:3.9.6-amazoncorretto-21
WORKDIR /app
COPY . .
RUN mvn package

FROM amazoncorretto:21-alpine3.18
WORKDIR /app
COPY --from=0 /app/target/quarkus-performance-test-1.0.0-SNAPSHOT-runner.jar /app/app.jar

ENV JAVA_OPTS="-XX:+UseContainerSupport -Xlog:gc"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]