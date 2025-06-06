# HealthyHabits API

API REST para la gestión de hábitos saludables usando Spring Boot y MySQL.

## Requisitos
- Java 17+
- Maven
- MySQL

## Configuración de la base de datos
Edita el archivo `src/main/resources/application.properties` con los datos de tu base de datos MySQL:

```
spring.datasource.url=jdbc:mysql://localhost:3306/healthy_habits_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
```

Crea la base de datos en MySQL:

```sql
CREATE DATABASE healthy_habits_db;
```

## Ejecución del proyecto

Desde la carpeta raíz ejecuta:

```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080/habits`

## Endpoints y ejemplos CURL

### Crear un hábito
```bash
curl -X POST http://localhost:8080/habits \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Caminar 30 minutos",
    "tipo": "Salud Física",
    "frecuencia": "Diario",
    "objetivo": "Mejorar la salud cardiovascular"
  }'
```

### Obtener todos los hábitos
```bash
curl http://localhost:8080/habits
```

### Obtener un hábito por ID
```bash
curl http://localhost:8080/habits/1
```

### Actualizar un hábito
```bash
curl -X PUT http://localhost:8080/habits/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Caminar 45 minutos",
    "tipo": "Salud Física",
    "frecuencia": "Diario",
    "objetivo": "Mejorar la salud y perder peso"
  }'
```

### Eliminar un hábito
```bash
curl -X DELETE http://localhost:8080/habits/1
```

### Notas para usuarios de PowerShell
Si usas PowerShell, reemplaza los comandos anteriores por:

```powershell
curl -Method POST http://localhost:8080/habits `
  -Headers @{ "Content-Type" = "application/json" } `
  -Body '{
    "nombre": "Caminar 30 minutos",
    "tipo": "Salud Física",
    "frecuencia": "Diario",
    "objetivo": "Mejorar la salud cardiovascular"
  }'
```

## Probar con Postman
1. Abre Postman y crea una nueva colección.
2. Agrega una nueva petición para cada endpoint:
   - **POST**: Selecciona POST, URL: `http://localhost:8080/habits`, Body: raw, JSON, y pega el ejemplo de arriba.
   - **GET**: Selecciona GET, URL: `http://localhost:8080/habits` o `http://localhost:8080/habits/1`.
   - **PUT**: Selecciona PUT, URL: `http://localhost:8080/habits/1`, Body: raw, JSON, y pega el ejemplo de arriba.
   - **DELETE**: Selecciona DELETE, URL: `http://localhost:8080/habits/1`.
3. Haz clic en "Send" para probar cada endpoint.

## Validaciones
- `nombre` no debe estar vacío.
- `tipo` solo puede ser: "Salud Física", "Mental", "Alimentación".
- `frecuencia` solo puede ser: "Diario", "Semanal", "Mensual".

## Manejo de errores
Si envías datos inválidos, la API responderá con un JSON detallando los errores de validación.

---
¡Listo! Ahora puedes gestionar hábitos saludables con esta API. 