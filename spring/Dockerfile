FROM gradle:jdk21-alpine
WORKDIR /app
COPY . .
RUN gradle bootJar

FROM amazoncorretto:21-alpine3.18
WORKDIR /app
COPY --from=0 /app/build/libs/reactive-0.0.1-SNAPSHOT.jar /app/reactive.jar

ENV JAVA_OPTS="-XX:+UseContainerSupport -Xlog:gc"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar reactive.jar"]