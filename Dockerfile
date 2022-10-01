FROM maven:3-amazoncorretto-17

WORKDIR /awesome-bank
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run