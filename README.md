# Lab-2_Grupo-7_TBD-BDA
Este repositorio contiene todos los archivos relacionados con el laboratorio 2 del ramo de Taller de base de datos o base de datos avanzada.

* **IMPORTANTE: Para poder conectarse correctamente a la Base de Datos, se debe utilizar el usuario "postgres" y la contraseña "postgres"**

## Acerca del proyecto

### Colaboradores
* [Sergio Espinoza](https://github.com/Ch3chS)
* [Gonzalo Ibáñez](https://github.com/Gr3yW0lfChie)
* [Cristóbal Olivares](https://github.com/ToTozudo)

### Descripción
El proyecto consiste en desarrollar un sistema para la gestión del voluntariado espontáneo con Api Restful cuya interfaz sea realizada en Vue.js y Backend en Spring Boot y, a diferencia de la vez anterior, se hará uso de PostGIS.<br>

### Tareas a realizar
- [x] Entender el problema
- [x] Investigar tecnologías a usar
- [ ] Dividir el trabajo
- [ ] Realizar el diseño 
  - [x] Diseñar base de datos
  - [x] Diseñar Back-end
  - [ ] Diseñar Front-End
- [ ] Realizar construcción de base de datos, Back-End y Front-end
- [ ] Realizar ppt para la presentación
- [ ] Preparar entrega
- [ ] Pulir README.md
- [ ] Entregar y presentar

### Organización carpetas



## Instalación

### Requisitos y herramientas de desarrollo
Para ejecutar correctamente todo el proyecto, además de los archivos del repositorio se requieren las siguientes tecnologías:

* [Postgres SQL](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads) versión 12 o superior.
* [PostGis](https://postgis.net/) compatible con la versión de postgres SQL.
* [PgAdmin](https://www.pgadmin.org) versión 4.
* [Visual studio code](https://code.visualstudio.com/download) deberia funcionar con cualquier versión, con la extensión de Spring Boot Tools.
* [Nuxt + VUE](https://nuxtjs.org) versión 2.

### Instrucciones de ejecución
- Crear base de datos con el nombre de "demo" en pgAdmin4
- Abrir la Query Tool en la base de datos recien creada (demo)
- En la Query Tool, abrir y ejecutar el archivo dbCreate de la carpeta Database (Esto creara las tablas)
- Inicializar aplicación:
Dirigirse a directorio de aplicación back-end desde terminal
$ cd ./Lab-2_Grupo-7_TBD-BDA/Backend

Ejecutar el proyecto, cuyo acceso será: http://localhost:3000
$ ./gradlew bootRun


- Inicializar pagina de acceso:
 Dirigirse a directorio de aplicación front-end desde terminal
$ cd ./Lab-1_Grupo-7_TBD-BDA/Frontend

### Instalar dependencias necesarias para la ejecución
$ yarn install

Ejecutar el proyecto, cuyo acceso será: http://localhost:3000
$ yarn dev
$ yarn build

- Ingresar a <a href="http://localhost:3000/">http://localhost:3000/</a>
