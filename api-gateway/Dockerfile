FROM eclipse-temurin:17-jre-alpine as build
WORKDIR extracted
ADD target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM eclipse-temurin:17-jre-alpine
WORKDIR application
COPY --from=build extracted/dependencies/ ./
COPY --from=build extracted/spring-boot-loader/ ./
COPY --from=build extracted/snapshot-dependencies/ ./
COPY --from=build extracted/application/ ./
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]