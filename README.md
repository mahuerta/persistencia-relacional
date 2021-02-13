<h1 align="center">Practica 2. Módulo Persistencia y Análisis de Datos 👨🏻‍💻 </h1>

<p align="center">
  <a href="/docs" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

Proyecto para realizar operaciones utilizando flyway y campos JSON en la BBDD.
Además, apartado para utilizar mongo y realizar consultas agregadas.

## Authors
👤 **JuanCBM**: Juan Carlos Blázquez Muñoz
* Github: [@JuanCBM](https://github.com/JuanCBM)

👤 **mahuerta**: Miguel Ángel Huerta Rodríguez
* Github: [@mahuerta](https://github.com/mahuerta)

# Ejecución de la aplicación:
**1.** Primero debemos ejecutar los comandos docker para disponer de las BBDD:
> docker run -p 3306:3306 --name mysql-db -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e -d mysql/mysql-server

> docker run -d -p 27017:27017 --name mongo-db mongo:latest

**2.** Cargar los datos en el docker:
> docker cp C:\EclipseProjects\persistencia-relacional\Provincias.json mongo-db:/tmp/Provincias.json

> docker exec mongo-db mongoimport -d test -c provincia --file /tmp/Provincias.json

**3.** Ejecutamos el proyecto en nuestro IDE.

**4.** Podemos ir comprobando en la consola las diferentes consultas que se ejecutan y la información solicitada para cada consulta.


## Apuntes teóricos
Apartado 2 de la práctica:
1. Revisiones de cada avión con JSON
    - No es necesario extraer ahí toda la info de mecánico encargado. Sería solamente su ID.

2. Cada vuelo un JSON con los ids de los tripulantes, sólo los IDs.

**¿Cómo hacerlo?**
- Incluir esos campos en las entidades
- Hacer los scripts, alter table que añadan esos campos
- Las instrucciones SQL para migrar datos de la version sql a json
    - Con estas operaciones: JSON_OBJECT, JSON_ARRAYAGG y JSON_TABLE
- Consultas sobre el campo nuevo.

### Consulta agregación:
La consulta que planteamos para luego sacar los datos con Spring Data fue la siguiente:
```
db.provincia.aggregate([
  {$group:
        {
          _id: '$CA',
          provincias: {$push: '$Nombre'}
        }
  },
  { $project: {
      _id: {$ifNull: ['$_id', 'Sin comunidad']},
      provincias: 1
    }
  }
])
```

