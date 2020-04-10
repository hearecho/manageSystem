FROM java:8
VOLUME /tmp
ADD api.jar api.jar
RUN bash -c 'touch /api.jar'
ENV SPRING-CLOUD-EUREKA-ZONE http://192.168.1.94:8761/eureka/
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api.jar"]
EXPOSE 8020