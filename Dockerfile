FROM openjdk:8
ADD  build/libs/pinetwebapp-0.0.1-SNAPSHOT.jar pinetwebapp-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "pinetwebapp-0.0.1-SNAPSHOT.jar"]

