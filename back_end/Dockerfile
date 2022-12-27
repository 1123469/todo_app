FROM openjdk:8
VOLUME /tmp
ADD ./target/mpdemo-0.0.1-SNAPSHOT.jar TodoApp.jar
ENTRYPOINT ["sh","-c","java -jar TodoApp.jar"]