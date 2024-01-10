FROM eclipse-temurin:21-jre

MAINTAINER <MAINTAINER>

RUN mkdir /opt/spring-template
COPY application/build/libs/application-*.jar /opt/spring-template/spring-template.jar

EXPOSE 8080
HEALTHCHECK --interval=5s --start-period=10s --retries=3 CMD curl --fail http://localhost:8080/actuator/health || exit 1

WORKDIR /opt/spring-template

CMD ["sh", "-c", "java -jar $JAVA_OPTS spring-template.jar"]