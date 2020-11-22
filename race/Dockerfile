FROM adoptopenjdk/openjdk15-openj9:alpine

VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]