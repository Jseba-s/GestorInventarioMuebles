# Usar una imagen base de Maven para compilar
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Copiar el código fuente al contenedor
WORKDIR /app
COPY . .

# Compilar el proyecto y generar el .jar
RUN mvn clean package -DskipTests

# -----------------------

# Imagen final basada en Java para correr el JAR
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone un puerto si es necesario (si tu app usa sockets o servidor embebido)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
