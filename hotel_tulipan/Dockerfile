# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiar pom y dependencias
COPY pom.xml .
RUN apk add --no-cache maven \
    && mvn dependency:go-offline

# Copiar el proyecto
COPY . .

# Construir la app
RUN mvn clean package -DskipTests

# Puerto dinámico (Render)
EXPOSE 8080

# Ejecutar la app
CMD ["java", "-jar", "target/*.jar"]
