# Utilisez une image de base avec Java
FROM openjdk:22-jdk-slim

WORKDIR /app

ENV GITHUB_URL=https://github.com/TheKraken9/stock_management_using_FIFO_LIFO_for_deployement
ENV JAR_NAME=mon-application.jar

# Clone le référentiel GitHub et récupère le fichier JAR
RUN apt-get update && apt-get install -y git
RUN git clone ${GITHUB_URL} .
RUN ./mvnw clean install   # Utilisez cette ligne pour Maven

EXPOSE 8080

CMD ["java", "-jar", ${JAR_NAME}]

