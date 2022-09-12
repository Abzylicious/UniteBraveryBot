FROM gradle:7.1-jdk16 AS build
COPY --chown=gradle:gradle . /unitebraverybot
WORKDIR /unitebraverybot
RUN gradle shadowJar --no-daemon

FROM openjdk:11.0.16-jre-slim
RUN mkdir /data/
COPY --from=build /unitebraverybot/build/libs/UniteBraveryBot.jar /
COPY --from=build /unitebraverybot/data/pokemon.json /data

ENTRYPOINT ["java", "-jar", "/UniteBraveryBot.jar"]