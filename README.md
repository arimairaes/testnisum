# NISUM Evaluacion Java - Gabriel Urrutia

# Descripción del Proyecto

Desarrolla una aplicación que exponga una **API RESTful** para la **creación de usuarios**.

- Todos los endpoints deben aceptar y retornar solamente **JSON**, inclusive para los mensajes de error.
- Todos los mensajes deben seguir el formato:

      {"mensaje": "mensaje de error"}

## Registro de Usuario

- El endpoint debe recibir un usuario con los campos `"nombre"`, `"correo"`, `"contraseña"`, más un listado de objetos `"teléfono"`, respetando el siguiente formato:

      {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
          {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
          }
        ]
      }

- Responder el código de estado HTTP adecuado.

- En caso de éxito, retornar el usuario y los siguientes campos:

  - `id`: ID del usuario (puede ser el que se genera por la base de datos, pero sería más deseable un UUID).
  - `created`: Fecha de creación del usuario.
  - `modified`: Fecha de la última actualización del usuario.
  - `last_login`: Fecha del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación).
  - `token`: Token de acceso de la API (puede ser UUID o JWT).
  - `isactive`: Indica si el usuario sigue habilitado dentro del sistema.

- Si el correo ya consta en la base de datos, deberá retornar un error:

      {"mensaje": "El correo ya registrado"}

- El correo debe seguir una **expresión regular** para validar que el formato sea el correcto (por ejemplo: `aaaaaaa@dominio.cl`).

- La contraseña debe seguir una **expresión regular** para validar que el formato sea el correcto. **El valor de la expresión regular debe ser configurable**.

- El token deberá ser persistido junto con el usuario.

---

# Requisitos

- **Plazo**: 3 días. Si tienes algún inconveniente con el tiempo, comunícate con nosotros.

- **Base de datos en memoria**: Ejemplo, HSQLDB o H2.

- **Proceso de build**: Vía Gradle o Maven.

- **Persistencia con JPA**: Ejemplo, EclipseLink, Hibernate u OpenJPA.

- **Framework**: Spring Boot.

- **Java 8+**

- **Entrega**: En un repositorio público (GitHub o Bitbucket) con el código fuente y script de creación de la base de datos.

- **README**: Explicando cómo probar la aplicación.

- **Diagrama de la solución.**

- **JWT** como token.

- **Pruebas unitarias.**

- **Swagger** para documentación de la API.

- Se recomienda y se valorará mucho la utilización de **Patrones de Diseño** y **buenas prácticas**.


# Cómo Probar la API

La aplicación está desplegada y disponible en la siguiente URL:

**https://testnisum-production.up.railway.app/api/users**

Puedes probar la API utilizando herramientas como **Postman** o **cURL**. A continuación, se detallan los pasos para probar cada uno de los endpoints disponibles.

## Endpoints Disponibles

1. **Registro de Usuario**
2. **Inicio de Sesión**
3. **Obtener Usuario por ID**
4. **Listar Todos los Usuarios**
5. **Actualizar Usuario**
6. **Eliminar Usuario**

---

## 1. Registro de Usuario

**Endpoint:**

- **Método HTTP:** `POST`
- **URL:** `/register`

**URL completa:**


Pensamiento sobre 41 segundos

¡Claro! Aquí tienes el contenido actualizado para tu README.md, incluyendo instrucciones sobre cómo probar la API en la URL proporcionada y cómo utilizar Swagger. Todo está escapado en un solo bloque de texto para que puedas copiarlo:

markdown
Copiar código
# Descripción del Proyecto

Desarrolla una aplicación que exponga una **API RESTful** para la **creación de usuarios**.

- Todos los endpoints deben aceptar y retornar solamente **JSON**, inclusive para los mensajes de error.
- Todos los mensajes deben seguir el formato:

      {"mensaje": "mensaje de error"}

## Registro de Usuario

- El endpoint debe recibir un usuario con los campos `"nombre"`, `"correo"`, `"contraseña"`, más un listado de objetos `"teléfono"`, respetando el siguiente formato:

      {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
          {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
          }
        ]
      }

- Responder el código de estado HTTP adecuado.

- En caso de éxito, retornar el usuario y los siguientes campos:

  - `id`: ID del usuario (puede ser el que se genera por la base de datos, pero sería más deseable un UUID).
  - `created`: Fecha de creación del usuario.
  - `modified`: Fecha de la última actualización del usuario.
  - `last_login`: Fecha del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación).
  - `token`: Token de acceso de la API (puede ser UUID o JWT).
  - `isactive`: Indica si el usuario sigue habilitado dentro del sistema.

- Si el correo ya consta en la base de datos, deberá retornar un error:

      {"mensaje": "El correo ya registrado"}

- El correo debe seguir una **expresión regular** para validar que el formato sea el correcto (por ejemplo: `aaaaaaa@dominio.cl`).

- La contraseña debe seguir una **expresión regular** para validar que el formato sea el correcto. **El valor de la expresión regular debe ser configurable**.

- El token deberá ser persistido junto con el usuario.

---

# Requisitos

- **Plazo**: 3 días. Si tienes algún inconveniente con el tiempo, comunícate con nosotros.

- **Base de datos en memoria**: Ejemplo, HSQLDB o H2.

- **Proceso de build**: Vía Gradle o Maven.

- **Persistencia con JPA**: Ejemplo, EclipseLink, Hibernate u OpenJPA.

- **Framework**: Spring Boot.

- **Java 8+**

- **Entrega**: En un repositorio público (GitHub o Bitbucket) con el código fuente y script de creación de la base de datos.

- **README**: Explicando cómo probar la aplicación.

- **Diagrama de la solución.**

- **JWT** como token.

- **Pruebas unitarias.**

- **Swagger** para documentación de la API.

- Se recomienda y se valorará mucho la utilización de **Patrones de Diseño** y **buenas prácticas**.

---

# Cómo Probar la API

La aplicación está desplegada y disponible en la siguiente URL:

**https://testnisum-production.up.railway.app/api/users**

Puedes probar la API utilizando herramientas como **Postman** o **cURL**. A continuación, se detallan los pasos para probar cada uno de los endpoints disponibles.

## Endpoints Disponibles

1. **Registro de Usuario**
2. **Inicio de Sesión**
3. **Obtener Usuario por ID**
4. **Listar Todos los Usuarios**
5. **Actualizar Usuario**
6. **Eliminar Usuario**

---

## 1. Registro de Usuario

**Endpoint:**

- **Método HTTP:** `POST`
- **URL:** `/register`

**URL completa:**

https://testnisum-production.up.railway.app/api/users/register


**Descripción:**

Registra un nuevo usuario con nombre, correo, contraseña y una lista de teléfonos.

**Cuerpo de la solicitud (JSON):**

```json
{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "Hunter2!",
  "phones": [
    {
      "number": "1234567890",
      "citycode": "1",
      "countrycode": "57"
    }
  ]
}
```
Ejemplo con cURL:
curl -X POST \
  https://testnisum-production.up.railway.app/api/users/register \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "Hunter2!",
    "phones": [
      {
        "number": "1234567890",
        "citycode": "1",
        "countrycode": "57"
      }
    ]
  }'



