# --- Etapa de Construcción (Build Stage) ---
# Usamos una imagen de Maven con Java 21 para compilar nuestro proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Construimos el JAR, saltando los tests para agilizar la construcción de la imagen
RUN mvn clean package -DskipTests

# --- Etapa Final (Final Stage) ---
# Usamos una imagen de Java 21 mucho más ligera, solo para ejecutar la app
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copiamos solo el JAR compilado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Comando para ejecutar la aplicación cuando el contenedor se inicie
ENTRYPOINT ["java", "-jar", "app.jar"]