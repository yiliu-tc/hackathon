FROM openjdk:8-jre-alpine
COPY target/*.jar /usr/app/review-provider.jar
VOLUME /tmp
WORKDIR /usr/app
RUN sh -c 'touch review-provider.jar'
EXPOSE 8001
CMD [ "java","-jar","review-provider.jar" ]
