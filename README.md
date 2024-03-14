## Escuela Colombiana de Ingeniería
### Arquitecturas Empresariales – AREP
# LAB6-AREP
#### TALLER 6: PATRONES ARQUITECTURALES
Para la tarea usted debe construir una aplicación con la arquitectura propuesta y desplegarla en AWS usando EC2 y Docker.

1. El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2
2. LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
3. La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.

## Elementos necesarios 
Para poder ejecutar o correr el proyecto se necesitan unos requisitos minimos los cuales son:
* [Tener Instalado Maven](https://maven.apache.org/download.cgi)
* Docker Desktop
* [Tener una version de Java 17 o mas](https://www.oracle.com/co/java/technologies/downloads/)

## La aplicacion cuenta con 4 clases principales las cuales son

**LogService**:  Esta clase configura un servicio web simple que registra mensajes de log en una base de datos MongoDB cuando recibe solicitudes en la ruta /logservice.
**LogServiceFacdade**: Esta clase proporciona una interfaz unificada para interactuar con varios servicios de logs remotos, enviando mensajes a través de una ruta HTTP y recopilando las respuestas.
**Log Listed**: Esta clase proporciona métodos para agregar logs a una colección en una base de datos MongoDB y para listar los últimos logs en formato JSON.
**Connection DB**: Esta clase proporciona una forma conveniente de obtener una instancia de la base de datos MongoDB utilizando una conexión predefinida y el nombre de la base de datos especificada. Esto facilita la gestión de la conexión y la obtención de la base de datos en otras partes del código.
**RemoteLogServiceInvoker**: Esta clase permite invocar servicios de logs remotos enviando mensajes a través de solicitudes HTTP GET y recopilando las respuestas. La clase mantiene un registro del estado actual de los servicios de logs remotos y alterna entre ellos para distribuir las solicitudes.

## INICIANDO EL PROYECTO
- Lo primero que tenemos que hacer es abrir docker Desktop para poder monitorear la creacion de imagenes y contenedores
- Luego en consola nos vamos a la carpeta LAB6-AREP del proyecto
- Una vez alli compilamos el proyecto con el siguiente comando:

  ``` 
  mvn clean install
  ```

  - Luego ejecutamos los contenedores definidos en el archivo docker-compose.yml con el siguiente comando

    ```
    docker-compose up -d
    ```

   - Verificamos que los contenedores esten corriendo con el siguiente comando:

    ```
     docker ps
    ```

     Deberia aparecer asi:

     ![image](https://github.com/JuanFe2001/LAB6-AREP/assets/123691538/2f8a4525-2e6d-440a-b5b7-b4713fa14976)

     - Una vez hecho esto colocamos en el Browser de nuestra preferencia esta url para probar el funcionamiento de nuestra pagina

        http://localhost:8087/page.html

      - Deberiamos ver la siguiente pagina si seguimos los pasos correctamente

    ![image](https://github.com/JuanFe2001/LAB6-AREP/assets/123691538/a6a39a4f-6fe4-4501-9284-f45756cb3993)



  ##Pruebas
  ![image](https://github.com/JuanFe2001/LAB6-AREP/assets/123691538/447b2a5f-b849-49bf-abbe-4088ec81bf47)



       


    

  














