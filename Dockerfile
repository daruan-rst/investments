FROM openjdk:11

EXPOSE 2080

ADD build/libs/investments-0.0.1.jar investments-0.0.1.jar

ENTRYPOINT ["java","-jar","investments-0.0.1.jar"]