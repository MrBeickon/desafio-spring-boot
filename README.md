# API Gestión de Tareas

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green)
![Maven](https://img.shields.io/badge/Maven-Build-orange)

API RESTful desarrollada en Java con Spring Boot para la gestión de usuarios y tareas. Este proyecto sigue un enfoque **API-First** y utiliza autenticación mediante tokens **JWT**. Se incluye una base de datos **H2 integrada** para simplificar la configuración.

---

## 📋 Endpoints
### Servidor de desarrollo:
- Base URL: `http://localhost:8080`

### Rutas principales:
| Método | Endpoint                           | Descripción                                       |
|--------|------------------------------------|--------------------------------------------------|
| POST   | `/auth/login`                     | Autentica a un usuario y devuelve un token JWT.  |
| GET    | `/tareas`                         | Obtiene las tareas creadas por el usuario autenticado. |
| POST   | `/tareas`                         | Crea una nueva tarea.                            |
| GET    | `/tareas/{id}`                    | Obtiene una tarea por su ID.                     |
| PUT    | `/tareas/{id}`                    | Actualiza una tarea por su ID.                   |
| DELETE | `/tareas/{id}`                    | Elimina una tarea por su ID.                     |
| GET    | `/tareas/usuario/{userId}`        | Obtiene tareas asociadas al usuario especificado.|
| GET    | `/estados-tarea`                  | Obtiene los estados de las tareas disponibles.   |
| GET    | `/estados-tarea/{id}`             | Obtiene un estado específico de una tarea por ID.|

Los detalles completos de cada endpoint se encuentran definidos en el archivo [OpenAPI YAML](./api.yml) incluido en este proyecto.

---

## 🛠 Importar Colección de Postman

Este proyecto incluye un archivo JSON llamado `API Gestion de Tareas.postman_collection.json` en la raíz del repositorio. Este archivo contiene todos los endpoints configurados para su fácil utilización en [Postman](https://www.postman.com/).

### Pasos para Importar la Colección:
1. Abre Postman.
2. Haz clic en el botón **Importar** en la parte superior izquierda de Postman.
3. Selecciona la pestaña **Archivo**.
4. Haz clic en **Seleccionar archivos** y navega hasta la ubicación del archivo `API Gestion de Tareas.postman_collection.json` dentro del repositorio.
5. Haz clic en **Abrir** para cargar la colección.
6. La colección `API Gestion de Tareas` aparecerá en la barra lateral de Postman.

### Personalización de Variables:
Algunos endpoints pueden requerir configuraciones como tokens de autenticación o parámetros específicos del usuario. Antes de ejecutar las solicitudes:
1. Asegúrate de haber autenticado mediante el endpoint `/auth/login`.
2. Copia el token JWT proporcionado en la respuesta.
3. Abre las variables de entorno de la colección en Postman y define el valor de `{{jwt_token}}` con el token copiado para usarlo en solicitudes autenticadas.

Con esta configuración, podrás interactuar con la API rápidamente sin necesidad de configurar los endpoints manualmente.

---

---

## Requisitos Previos

### 🔧 Software necesario:
1. **Java:** Versión 17 o superior
2. **Maven:** Versión 3.6.3 o superior
3. **Git:** Para clonar el repositorio

---

## 🚀 ¿Cómo correr este proyecto?

### 🔨 Clonar repositorio
```bash
git clone <URL_DEL_PROYECTO>
cd <DIRECTORIO_CLONADO>
```

### ⚙ Configuración predeterminada
El proyecto está configurado para usar una base de datos **H2 en memoria** y no requiere configuraciones adicionales. Sin embargo, puedes cambiar la configuración en `application.properties` o `application.yml` si decides usar otra base de datos.

#### Configuración predeterminada en `application.properties`:
```properties
# Configuración de la base de datos H2
spring.datasource.url=jdbc:h2:mem:gestion_tareas_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

# JWT
jwt.secret=claveSecretaSuperSegura
jwt.expiration=3600000
```

#### Cómo acceder a la consola de H2:
Una vez el proyecto esté corriendo, puedes acceder a la consola web de H2 en:  
`http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:gestion_tareas_db`
- **Usuario:** `sa`
- **Contraseña:** *(vacío)*

### 📦 Construir el proyecto con Maven
Para compilar y empaquetar el proyecto en un archivo `.jar`:
```bash
mvn clean package
```

Esto generará un archivo `.jar` en `target/`.

### ▶ Ejecutar el servidor
#### En entornos de desarrollo:
```bash
mvn spring-boot:run
```

#### Ejecutar el archivo .jar:
```bash
java -jar target/gestion-tareas-1.0.0.jar
```

---

## 📂 Estructura del Proyecto

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com.example.gestiontareas/
│   │       ├── controller/    # Controladores REST
│   │       ├── dto/           # Clases DTO usadas para transferir datos
│   │       ├── model/         # Entidades de base de datos
│   │       ├── repository/    # Repositorios JPA
│   │       ├── service/       # Lógica de negocio
│   │       └── GestionTareasApplication.java # Clase principal
│   ├── resources/
│       ├── application.yml    # Configuración (Base de datos, JWT, etc.)
│       └── static/            # Archivos estáticos (si los hay)
```

---

## 🛠 Principales Tecnologías Usadas
- **Java 17**
- **Spring Boot 3.x (MVC, Security, Data JPA)**
- **Maven**
- **H2 (base de datos en memoria)**
- **JWT (para autenticación)**

---

## 👫 Contacto
- Responsable: **Nicolas Montecinos**
- Correo: [nico20q@gmail.com](mailto:nico20q@gmail.com)