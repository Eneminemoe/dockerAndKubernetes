FROM adoptopenjdk/openjdk11:ubi
#base jdk

ARG JAR_FILE=target/*.jar
#copy jar to the image
COPY ${JAR_FILE} app.jar
#expose port to make it reachable
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
