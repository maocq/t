## Build
FROM public.ecr.aws/e0v3l5t6/general-repo:graalvmmaocq-nic-certificates-21 AS build
WORKDIR /app
COPY . .
RUN ./gradlew nativeCompile

## Deploy
FROM fedora
WORKDIR /app
COPY --from=build /app/build/native/nativeCompile/reactive /app/reactive
CMD [ "/app/reactive" ]
