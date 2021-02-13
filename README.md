<h1 align="center">Practica 1. Módulo Persistencia y Análisis de Datos 👨🏻‍💻 </h1>

<p align="center">
  <a href="/docs" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

Proyecto para realizar modelos de BBDD con JPA y realizar consultas avanzadas poniendo atención al rendimiento.

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
<<<<<<< HEAD
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
=======
### Operaciones transaccionales:
- ***save*** y ***saveAll*** ya son operaciones transaccionales
- En grandes guardados de datos, conviene repartir el trabajo en varias hebras


- ***saveAll*** realiza una sola transacción, las lecturas concurrentes no ven nada. 
- Sin embargo, si realizamos un ***save*** *oneByOne*, vemos en accesos concurrentes los datos que se han introducido.
- En procesos muy largos de guardado, como hemos dicho conviene dividir las operaciones en hebras.
- El número de hebras, se puede pedir a java, y le damos el nº de hebras -1 para dejar 1 libre. Se puede obtener con el comando: 
> Runtime.getRuntime().availableProcessors();
- Para mejorar las lecturas utilizaremos índices.
- Para mejorar las escrituras utilizaremos diferentes hebras.

### Escalabilidad horizontal vs vertical
- Escalabilidad horizontal: Réplicas, más máquinas del mismo o similar tamaño.
- Escalabilidad vertical: Más capacidad de la máquina única.
>>>>>>> origin/persistencia-relacional-2
