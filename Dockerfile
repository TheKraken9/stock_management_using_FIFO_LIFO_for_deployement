# Utilisez une image de base avec Java
FROM openjdk:21.04-jdk

# Définissez le répertoire de travail
WORKDIR /app

# Copiez le fichier JAR dans le conteneur
COPY target/mon-application.jar .

# Exposez le port sur lequel l'application écoute
EXPOSE 8080

# Commande pour démarrer l'application
CMD ["java", "-jar", "mon-application.jar"]
