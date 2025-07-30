# Imagen base con Java 17 (ajusta si usas otra versión)
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copia el JAR al contenedor
COPY target/*.jar app.jar

# Exponer puerto si tu app corre en 8080
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]