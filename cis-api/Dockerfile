FROM gradle:7.1.1 AS build

WORKDIR /build

COPY ["./*.gradle", "./*.properties", "./"]
COPY ./style ./style
COPY ./cis-data ./cis-data
COPY ./cis-api ./cis-api

RUN gradle cis-api:clean cis-api:check cis-api:build

FROM openjdk:11

WORKDIR  /app

RUN mkdir /app/uploads

COPY ./cis-api/docker-scripts/env-file-var.sh .
RUN chmod 755 env-file-var.sh

COPY ./cis-api/application-env.yml application.yml
COPY --from=build /build/cis-api/build/libs/cis-api.jar /app/app.jar

ENTRYPOINT ["./env-file-var.sh", "java",  "-jar",  "app.jar"]
