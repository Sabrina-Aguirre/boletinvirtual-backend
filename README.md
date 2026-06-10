# 📋 BoletínVirtual — Sistema de Gestión de Alumnos y Calificaciones

Sistema de gestión académica desarrollado con Spring Boot 4 y MariaDB. Permite administrar alumnos, profesores, materias y calificaciones con un frontend web incluido.

---

## 🛠️ Tecnologías utilizadas

- Java 17+
- Spring Boot 4.0.6
- Spring Data JPA + Hibernate
- MariaDB 10.11 (Docker)
- Maven
- HTML + CSS + JavaScript (frontend estático)

---

## ⚙️ Requisitos previos

- Java 17 o superior instalado
- Maven instalado
- Docker Desktop instalado y corriendo

---

## 🚀 Cómo levantar el proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/Sabrina-Aguirre/boletinvirtual-backend.git
cd boletinvirtual-backend
```

### 2. Levantar la base de datos con Docker

```bash
docker run --name boletinvirtual-db \
  -e MARIADB_ROOT_PASSWORD=root \
  -e MARIADB_DATABASE=boletinvirtual_db \
  -p 3308:3306 \
  -d mariadb:10.11
```

> Si ya existe el contenedor de una sesión anterior, levantarlo con:
> ```bash
> docker start boletinvirtual-db
> ```

### 3. Correr la aplicación

```bash
.\mvnw.cmd spring-boot:run
```

En Linux/Mac:
```bash
./mvnw spring-boot:run
```

La aplicación arranca en `http://localhost:8080`

---

## 🌐 Frontend

El frontend está incluido en el proyecto. Una vez que la aplicación esté corriendo, abrir en el navegador:

| Página | URL |
|--------|-----|
| Alumnos | http://localhost:8080/alumnos.html |
| Profesores | http://localhost:8080/profesores.html |
| Materias | http://localhost:8080/materias.html |
| Calificaciones | http://localhost:8080/calificaciones.html |
| Reporte | http://localhost:8080/reporte.html |

---

## 📡 Endpoints disponibles

### Alumnos
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/alumno | Lista todos los alumnos |
| GET | /api/alumno/{id} | Obtiene un alumno por id |
| POST | /api/alumno | Crea un alumno nuevo |
| PUT | /api/alumno | Actualiza un alumno |
| DELETE | /api/alumno/{id} | Elimina alumno y sus calificaciones |

### Profesores
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/profesor | Lista todos los profesores |
| POST | /api/profesor | Crea un profesor nuevo |
| PUT | /api/profesor | Actualiza un profesor |
| DELETE | /api/profesor/{id} | Elimina profesor y sus materias |

### Materias
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/materia | Lista todas las materias con su profesor |
| POST | /api/materia | Crea una materia (valida código único) |
| PUT | /api/materia | Actualiza una materia |
| DELETE | /api/materia/{id} | Elimina una materia |

### Calificaciones
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/calificacion | Lista todas las calificaciones |
| POST | /api/calificacion | Crea una calificación |
| PUT | /api/calificacion | Actualiza una calificación |
| DELETE | /api/calificacion/{id} | Elimina una calificación |
| GET | /api/calificacion/alumno/{id} | Calificaciones de un alumno |
| GET | /api/calificacion/promedio/{id} | Promedio de un alumno |
| GET | /api/calificacion/aprobados | Alumnos con promedio >= 6 |
| GET | /api/calificacion/desaprobados | Alumnos con promedio < 6 |

### Reporte
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/reporte/alumnos | Reporte completo alumno-materia-promedio |
| GET | /api/reporte/aprobados | Solo aprobados por materia |
| GET | /api/reporte/desaprobados | Solo desaprobados por materia |

---

## 🏗️ Arquitectura

El sistema usa arquitectura **MVC** en 4 capas:

```
Controller → Service → Repository → Base de Datos
```

- **Model** — Entidades JPA: Alumno, Profesor, Materia, Calificacion (heredan de Persona)
- **Repository** — Interfaces Spring Data JPA
- **Service** — Lógica de negocio, validaciones, cálculos
- **Controller** — Endpoints REST

## 🎨 Patrones de diseño aplicados

- **Strategy** — Módulo de reportes (`ReporteService` / `ReporteServiceImpl`)
- **Template Method** — Herencia de `Persona` (@MappedSuperclass)
- **Repository Pattern** — Acceso a datos desacoplado
- **MVC** — Arquitectura general del sistema

---

## 🗄️ Configuración de la base de datos

```properties
spring.datasource.url=jdbc:mysql://localhost:3308/boletinvirtual_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

> Las tablas se crean automáticamente al levantar la aplicación.

---

## 👩🏽‍💻 Autora

Sabrina Aguirre — Laboratorio de Software
