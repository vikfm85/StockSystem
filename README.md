# StockSystem
Trabajo Practico de Lenguaje de Programacion IV

Se utilizaron las siguientes tecnologias:

  * Spring MVC 4.2.5
  * Spring Security 4.0.4
  * Java Server Pages (JSP)
  * Hibernate 5.x
  * Database: MySQL

# Importar el proyecto al Eclipse

  * Importar el proyecto seleccionando la opcion Existing Maven Proyect dentro de la carpeta Maven
  * En la venta que se abrira al seleccionar esa opcion clickear donde dice browse y dirigirnos a la ubicacion donde se encuentran los       archivos descagados o clonados del repositorio de git.
  * Tildar el checkbox que aparece al lado del pom (/pom.xml ar.edu.iue.est:StockSystem:0.0.1-SNAPSHOT:war) y luego Clickear Finish.
  * Una vez que el proyecto se encuentra importado en el eclipse hacer click derecho en el mismo y dentro de la opcion Maven seleccionar la opcion Update Proyect.
  * En la ventana que se nos abrira tildar el checkbox del Proyecto (StockSystem) y tildar la opcion Force Update of Snapshots/Releases y luego darle OK.

La razon para realizar estos pasos es para que Maven se encargue de descargar las dependencias necesarias para el funcionamiento del proyecto y su correcta configuracion.
Es importante tener en cuenta que la primera vez que se ejecutan estos pasos es necesario poseer Internet.
Una vez finalizado, el proyecto se encuentra listo para ser ejecutado.

# Antes de ejecutar el Proyecto son necesarios los siguientes pasos:

Asegurarse que el proyecto este utilizando la jdk1.8.
Si no lo esta utilizando es necesario realizar lo siguiente, Click derecho en el proyecto y seleccionar Properties y verificar en el apartado Java Compiler que este utilizando la jdk 1.8, si no la utilizar, destildar la opcion Java Compliance y seleccionar en el combo box la 1.8, darle a Apply y luego a OK.
Asegurarse que se encuentra instalado MySql y MySql Workbench.
Ejecutar MySqlWorkbench y crear un Schema llamado StockSystem con codificacion UTF8. Seleccionar el Schema creado en el paso anterior y luego ejecutar el archivo StockSystemDBCreate.sql que se encuentra en el repositorio para poder crear las tablas necesarios para el correcto funcionamiento del sistema, asi como tambien crea los siguientes datos:

  * Usuario empleado con password 123
  * Usuario manager  con password 123
  * Crea 5 productos de prueba.
 
Verificar el archivo de propiedades de ds-hibernate-cfg.properties que se encuentra en la carpeta src/main/resources los siguientes campos y reemplazar sus valores en caso que sea necesario (los valores a continuacion son los de mi computadora):
 
  * ds.url=jdbc:mysql://localhost:3306/StockSystem
  * ds.username=root
  * ds.password=root

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
