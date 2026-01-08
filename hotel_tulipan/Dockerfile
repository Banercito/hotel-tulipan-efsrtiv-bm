# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Instalar Maven
RUN apk add --no-cache maven

# Copiar archivos del proyecto
COPY . .

# Construir la app
RUN mvn clean package -DskipTests

# Exponer puerto (Render usa el 8080)
EXPOSE 8080

# Ejecutar el JAR exacto (SIN comodines)
CMD ["java", "-jar", "target/hoteltulipan-0.0.1-SNAPSHOT.jar"]
