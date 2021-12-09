FROM gradle:7.1.1 AS build

WORKDIR /build

COPY ["./*.gradle", "./*.properties", "./"]
COPY ./style ./style
COPY ./cis-template ./cis-template

RUN gradle cis-template:clean cis-template:check cis-template:buildDist cis-template:build

FROM openjdk:11

WORKDIR  /app

COPY ./cis-template/application-env.yml application.yml
COPY --from=build /build/cis-template/build/libs/cis-template.war /app/app.war

ENTRYPOINT ["java",  "-jar",  "app.war"]
