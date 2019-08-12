# mybatis-rest-dynamic
Generate REST from Mybatis Result

### Problema

MyBatis recomienda mappear el resultado de la ejecución a una clase o a un Map, La clase o Map previamente estan definidos con ciertos campos a la espera del resultado de la ejecución de MyBatis que asu vez lo mapera automaticamente, los campos establecidos no es administrable cuando se requiere una cierta cantidad de consultas a la base de datos ejemplos 10, 20, 50 o 100 consultas, tendriamos que crear la misma cantidad de Clase o Map, en algunos casos reutilizar aquellos con campos similares.

### Solución

Para solucionar este problema solo hacemos uso de un Map para utilizarlo como respuesta de MyBatis y mediante Spring generamos el REST automaticamente, la responsabilidad de los campos y la estructura los pasamos a la base de datos, en este caso a un procedimiento almacenado.

### Características

> Cada consulta debe tener un codigo asignado (QueryId)
 ```
 query1,query2,queryn
  ```
> En este caso acepta 5 parametros, (Ubigeo,Marco,Periodo,Pnum,Psize)
 ```
 %param1=&param2=&paramn=
  ```
> Utilización de procedimiento almacenado que se encarga de ejecutar en función al codigo de QueryId, utilizando Switch y otra técnica

> Se puede ejecutar llamar uno o varias consultas en una misma petición
 ```
 ?querys=Query1,Query2,Queryn
  ```

### Resultados
 /portal/datos.do?querys=SCE05&pnum=1&psize=25
 ```
{
  "SCE05": {
    "size": 4889,
    "data": [
      {
        "distrito": "TAHUANIA",
        "estado": "APROBADO",
        "item": "1",
        "id": "2737",
        "nombre_proyecto": "MEJORAMIENTO DE LA PRODUCCION DEL GANADO VACUNO",
        "titular": "PROYECTO ESPECIAL PICHIS PALCAZU"
      },
      {
        "distrito": "RAYMONDI",
        "estado": "APROBADO",
        "item": "2",
        "id": "2737",
        "nombre_proyecto": "MEJORAMIENTO DE LA PRODUCCION DEL GANADO VACUNO",
        "titular": "PROYECTO ESPECIAL PICHIS PALCAZU"
      }
    ]
  },
  "success": true
}
 ```
 /portal/datos.do?querys=SCE01,SCE02
  ```
 {
  "SCE01": {
    "size": 23,
    "data": [
      {
        "nombre": "2019"
      },
      {
        "nombre": "2018"
      }
    ]
  },
  "SCE02": {
    "size": 3,
    "data": [
      {
        "total": "893",
        "nombre": "CONFORME"
      },
      {
        "total": "3986",
        "nombre": "APROBADO"
      }
    ]
  },
  "success": true
}
  ```
