# Getting Started
Formas para ejecutar el projecto:
1) Desde un IDE

	a) Introduccion de parametros: Menu-Run-->Run Configurations-->Arguments, establecemos un Id del cliente a buscar. Por ejemplo 5.r
	
	b) desde la clase: /ProyectoIbm/src/main/java/org/cirilo/micha/ibm/Application.java Click derecho->Run As->Java Aplication
	c) En caso de que haya resultados, se genera una archivo plano en el /ProyectoIbm/src/main/resources/ibmData/FicheroIbmAAAAMMDD (año mes dia)
	
2) Desde una consola:

	a) Compilar y ejecutar ./Applicacion.java {idCliente}. Ejemplo ./Appplication.java 5
	b)	En caso de que haya resultados, se crea un directorio y se genera una archivo plano en el /ProyectoIbm/src/main/resources/ibmData/FicheroIbmAAAAMMDD (año mes dia)

### Dependencias
Principalmente Lombok, para la generacion automatica de setter y getter.
Y la correspondiente dependencia para la conexion a la base de datos mysql.

### Mejoras
Utilizar formato fecha (Date, DateTime,...) para las fechas.

