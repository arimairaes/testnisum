# NISUM Evaluacion Java - Gabriel Urrutia

# Instrucciones

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


## 2. Inicio de Sesión

**Endpoint:**

- **Método HTTP:** `POST`
- **URL:** `/login`

**URL completa:**

https://testnisum-production.up.railway.app/api/users/login


**Descripción:**

Autentica al usuario y devuelve un token JWT

**Cuerpo de la solicitud (JSON):**

```json
{
  "email": "juan@rodriguez.org",
  "password": "Hunter2!"
}
```

## 3. Obtener Usuario por ID

**Endpoint:**

- **Método HTTP:** `GET`
- **URL:** `/{id}`

**URL completa:**

https://testnisum-production.up.railway.app/api/users/{id}


**Descripción:**

Devuelve los detalles de un usuario específico.

Encabezados necesarios:

- Authorization: Bearer tu-token-jwt-generado



## 4. Listar Todos los Usuarios


**Endpoint:**

- **Método HTTP:** `GET`
- **URL:** `/`

**URL completa:**

https://testnisum-production.up.railway.app/api/users/

**Descripción:**

Devuelve una lista de todos los usuarios registrados.


Encabezados necesarios:

- Authorization: Bearer tu-token-jwt-generado


## 5. Actualizar Usuario


**Endpoint:**

- **Método HTTP:** `PUT`
- **URL:** `/{id}`

**URL completa:**

https://testnisum-production.up.railway.app/api/users/{id}


**Descripción:**

Actualiza los detalles de un usuario existente.

Encabezados necesarios:

- Authorization: Bearer tu-token-jwt-generado
- Content-Type: application/json

**Cuerpo de la solicitud (JSON):**

```json
{
  "name": "Juan R. Actualizado",
  "email": "juan.actualizado@rodriguez.org",
  "password": "NuevaContraseña1!",
  "phones": [
    {
      "number": "0987654321",
      "citycode": "2",
      "countrycode": "57"
    }
  ]
}

```
## 6. Eliminar Usuario

**Endpoint:**

- **Método HTTP:** `DELETE`
- **URL:** `/{id}`

**URL completa:**

https://testnisum-production.up.railway.app/api/users/{id}


**Descripción:**

Elimina un usuario por ID.

Encabezados necesarios:

- Authorization: Bearer tu-token-jwt-generado


## Swagger

Para facilitar la exploración y prueba de la API, se ha habilitado Swagger UI.

**URL de Swagger UI:**

https://testnisum-production.up.railway.app/swagger-ui/index.html

**Descripción:**

Elimina un usuario por ID.

Encabezados necesarios:

- Authorization: Bearer tu-token-jwt-generado

```
graph LR
    subgraph Cliente
        A[Cliente (Postman/Navegador)]
    end

    subgraph Aplicación[Aplicación Spring Boot]
        B[Controladores]
        C[Servicios]
        D[Repositorios]
        E[(Base de Datos en Memoria)]
    end

    subgraph Seguridad
        F[JWT Util]
    end

    subgraph Despliegue[Despliegue]
        G[Docker]
        H[Railway]
    end

    A --> B
    B --> C
    C --> D
    D --> E

    C --> F
    B --> F

    Aplicación --> G
    G --> H
```

