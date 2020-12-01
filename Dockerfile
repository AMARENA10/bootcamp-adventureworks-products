FROM openjdk:11-jre
LABEL maintainer="BCP-BOOTCAMP"
ENV spring.application.name bootcamp-adventureworks-products

COPY build/libs/bootcamp-adventureworks-products-*SNAPSHOT.jar /opt/bootcamp-adventureworks-products.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/bootcamp-adventureworks-products.jar"]
