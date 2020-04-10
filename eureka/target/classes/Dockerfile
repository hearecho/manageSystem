FROM java:8
VOLUME /tmp
ADD eureka.jar eureka.jar
RUN bash -c 'touch /eureka.jar'

ENV SPRING-CLOUD-EUREKA-ZONE http://192.168.1.94:8761/eureka/
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]
EXPOSE 8761