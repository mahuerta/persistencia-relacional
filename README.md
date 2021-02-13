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

Cargar los datos en el docker:
https://stackoverflow.com/questions/49895447/i-want-to-execute-mongoimport-on-a-docker-container

> mongoimport --db mongo-db --collection provincia --file C:\EclipseProjects\persistencia-relacional\Provincias.json --jsonArray
> docker exec -i mongo-db sh -c 'mongoimport -c provincia -d test --drop' < xxx.json

#>docker exec -it <container-name> mongo
#>docker cp xxx.json <container-name-or-id>:/tmp/xxx.json
#>docker exec <container-name-or-id> mongoimport -d <db-name> -c <c-name> --file /tmp/xxx.json


**2.** Ejecutamos el proyecto en nuestro IDE.

**3.** Podemos ir comprobando en la consola las diferentes consultas que se ejecutan y la información solicitada para cada consulta.


## Apuntes teóricos
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
