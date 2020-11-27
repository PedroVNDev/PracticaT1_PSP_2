# Aplicación PSP 2, 2ºDAM
Aplicación que permite agregar empleados con un email y salario aleatorios a una base de datos mediante Xampp MySQL utilizando hilos dinámicos


### Pre-requisitos 📋

* Java 8
* Xampp MySql
* Base de datos BBDD_PSP_1


### Instalación 🔧

Puedes descargar el proyecto mediante el botón CODE o clonando el repositorio con git bash
--> $ git clone https://github.com/PinguExtremo/PraticaT1_PSP_2


## Ejecución del programa ⚙️

Para ejecutar la aplicación utiliza la linea de comandos, encuentra donde guardaste el proyecto:
-->cd C://RutaEjemplo/Practica_T1_PSP_2

Una vez dentro de la carpeta del proyecto ejecuta el archivo jar con:
java -jar Practica_T1_PSP_2.jar


### Instrucciones de uso ⌨️

Al inicializar la aplicación tendremos la posibilidad de seleccionar entre estas opciones:

```
¿Que paso quieres realizar?
1. Paso1
2. Paso2
0. Salir
```

# Opciones del Programa 💻

-El paso 1 creara un hilo que leera de manera secuencial todos los empleados de la base de datos mostrando sus datos, calculando todos los ingresos y mostrando el tiempo de ejecución

-El paso 2 creara 5 hilos que leeran de manera concurrente todos los empleados de la base de datos, esta operacion calcula todos los ingresos y muestra el tiempo de ejecución de el proceso

-La opcion salir nos permitira salir de la aplicación

# Reglas y Excepciones 📄

* No se puede introducir numeros negativos
* No se puede introducir letras
* La base de datos tiene que estar operativa para poder funcionar correctamente

- Incumplir cualquiera de estas reglas provocara que le programa no funcione correctamente

---Ejemplo de Paso1---

```
Introduce una opción: 1
ID: 1
Email: eryn.heller@hotmail.com
Ingresos: 802

ID: 2
Email: evan.herzog@yahoo.com
Ingresos: 269

ID: 3
Email: timmy.haley@gmail.com
Ingresos: 110

ID: 4
Email: chrystal.osinski@yahoo.com
Ingresos: 470

ID: 5
Email: keven.farrell@gmail.com
Ingresos: 455

La tarea tardo: 11 milisegundos
Los ingresos totales son: 11480

```

---Ejemplo de Paso2

```
Introduce una opción: 2
la suma del hilo es: 2812
la suma del hilo es: 1095
la suma del hilo es: 2106
la suma del hilo es: 2952
la suma del hilo es: 2515

La suma total de todos los hilos es: 11480

La tarea tardo: 61 milisegundos
```

-Podremos repetir ambos pasos las veces que queramos siempre que no introduzcamos un 0.

## Base de datos 📦

-Información necesaria para conectarse a la base de datos

Base de datos: BBDD_PSP_1
Tabla: EMPLEADOS
Usuario: DAM2020_PSP
Contraseña: DAM2020_PSP


## Construido con 🛠️

* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/) - Entorno de desarrollo
* [Java](https://www.java.com/es/download/) - Lenguaje de Programación
* [Xampp MySql](https://www.apachefriends.org/blog/news-article-61070.html) - Base de datos Local


## Creado por ✒️

* **Pedro Vicente Navas** - *Desarrollador* - [PinguExtremo](https://github.com/PinguExtremo)
