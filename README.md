# StockSystem
Trabajo Practico de Lenguaje de Programacion IV

Se utilizaron las siguientes tecnologias:

  * Spring MVC 4.2.5
  * Spring Security 4.0.4
  * Java Server Pages (JSP)
  * Hibernate 5.x
  * Database: MySQL

# Antes de ejecutar el Proyecto son necesarios los siguientes pasos:

Click derecho en el proyecto y seleccionar Properties y verificar en el apartado Java Compiler que este utilizando la jdk 1.8, si no la utilizar, destildar la opcion Java Compliance y seleccionar en el combo box la 1.8, darle a Apply y luego a OK.

Asegurarse que se encuentra instalado MySql y MySql Workbench.
Ejecutar MySqlWorkbench y crear un Schema llamado StockSystem con codificacion UTF8.
Seleccionar el Schema creado en el paso anterior y luego ejecutar el archivo StockSystemDBCreate.sql que se encuentra en el repositorio para poder crear las tablas necesarios para el correcto funcionamiento del sistema, asi como tambien crea los siguientes datos:

 * Usuario empleado con password 123
 * Usuario manager  con password 123
 * Crea 5 productos de prueba.
 
Verificar el archivo de propiedades de ds-hibernate-cfg.properties que se encuentra en la carpeta src/main/resources los siguientes campos y reemplazar sus valores en caso que sea necesario:
 
  * ds.url=jdbc:mysql://localhost:3306/StockSystem
  * ds.username=root
  * ds.password=pinote85

# Para poder correr el proyecto son necesarios realizar los siguientes pasos:

Click Derecho en el proyecto y seleccionar:

  * Run As/Run Configurations:
        
Una vez elegida la opcion Run Configurations se abrira una ventana donde debemos realizar click derecho en la opcion Maven Build y seleccionar New.

En la parte derecha de la ventana apareceran muchos parametros para compleatar. Los parametros a completar son los siguientes:

  * Name: Run StockSystem
  * Base directory: ${workspace_loc:/StockSystem}
  * Goals: tomcat7:run
        
Verificar en la pestaña JRE este seleccionada la default del Workspace que deberia ser la 1.8

Una vez completados los parametros requeridos clickear en apply y luego en Run

# El sistema en caso que no exista ningun error de ejecucion se podra utilizar en la siguiente URL:

  * [StockSystem](http://localhost:8080/StockSystem/)
