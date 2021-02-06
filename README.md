# persistencia-relacional

Practica 1 Modulo Persistencia y Analisis de Datos


> docker run -p 3306:3306 --name mysql-db -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e -d mysql/mysql-server
>
>
>
Herencia:
Estrategia Concrete table inheritance con Mapped Superclass:
Hemos dedicido esta implementación porque:

* No necesitamos realizar consultas polimórficas.
* Esta variante mejora la eficiencia:
    * Escrituras en una sola tabla.
    * Lecturas sin joins.
