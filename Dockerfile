# Utilisez une image de base avec Java
FROM openjdk:21.04-jdk

WORKDIR /app

# Remplacez "nom_utilisateur" et "nom_projet" par votre nom d'utilisateur GitHub et le nom de votre projet
ENV GITHUB_URL=https://github.com/TheKraken9/stock_management_using_FIFO_LIFO_for_deployement
ENV JAR_NAME=mon-application.jar

# Clone le référentiel GitHub et récupère le fichier JAR
RUN apt-get update && apt-get install -y git
RUN git clone ${GITHUB_URL} .
RUN ./mvnw clean install   # Utilisez cette ligne pour Maven
# RUN ./gradlew build      # Utilisez cette ligne pour Gradle

EXPOSE 8080

CMD ["java", "-jar", ${JAR_NAME}]

