FROM java:8
VOLUME /tmp
ADD finance.jar finance.jar
RUN bash -c 'touch /finance.jar'
ENV SPRING-CLOUD-EUREKA-ZONE http://192.168.1.94:8761/eureka/
ENV SPRING-CLOUD-MYSQL-HOST 192.168.1.94
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/finance.jar"]
EXPOSE 8030