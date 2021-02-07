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


# Sobre la entrega:
## Apartado 1: Estructura
### Decisión de Herencia:
Estrategia Concrete table inheritance con Mapped Superclass:
Hemos dedicido esta implementación porque:
* No necesitamos realizar consultas polimórficas.
* Esta variante mejora la eficiencia:
  * Escrituras en una sola tabla.
  * Lecturas sin joins.

### Decisión de Compañía y Empresa:
Hemos planteado una solución tratando ambos conceptos como lo mismo ya que no se realizan consultas
sobre el grueso de empleados de una Compañía, siempre se realizan consultas sobre miembros de la tripulación o sobre mecánicos.

## Apartado 2: Consultas
* En la consulta 2, hemos utilizado una Query nativa porque JPQL Standar no soporta estas operaciones sobre periodos.
  * https://stackoverflow.com/questions/2856386/java-jpql-date-function-to-add-a-time-period-to-another-date


# Ejecución de la aplicación:
**1.** Primero debemos ejecutar el comando docker para disponer de la BBDD. Hemos preparado un script para poder ejecutarlo de forma más comoda:
> docker run -p 3306:3306 --name mysql-db -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e -d mysql/mysql-server

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