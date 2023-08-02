# PruebaAmaris

- Proyectos dieseñados para presentar la prueba tecnica para java developer

## Instalar los proyectos

#####  requsitos basicos 

- jdk 11
- node v16.15.1 o superior
- npm 8.11.0 o superior
- maven 3.6.3 o superior
- intellj
- visual studio code

# proyecto java backend (amaris)

- Descarga el archivo WAR del proyecto desde el repositorio o asegúrate de tener el archivo WAR disponible en tu sistema.

- Despliega el archivo WAR en tu servidor de aplicaciones Java EE. Los pasos para desplegar el archivo WAR pueden variar según el servidor que estés utilizando. Aquí tienes un ejemplo para Apache Tomcat:

- Copia el archivo WAR en la carpeta webapps de Tomcat.
- Ejecuta el servidor Tomcat ejecutando el script startup.bat (Windows) o startup.sh (Linux/Mac).
- El servidor debería desplegar automáticamente la aplicación.
- Una vez que la aplicación esté desplegada, abre un navegador web y accede a la URL de la aplicación. Por ejemplo, si estás ejecutando Tomcat en tu máquina local, puedes acceder a http://localhost:8080/api/employee/getEmployeeList se mostrara el listado de empleados o un mensaje de error segun corresponda.

##### Opciones Adicionales
Si deseas compilar el proyecto desde el código fuente, sigue estos pasos:

- Clona el repositorio del proyecto en tu máquina local utilizando Git:
<pre>
git clone https://github.com/Deadmanw/PruebaAmaris
</pre>

- Navega al directorio del proyecto:

<pre>cd ....\PruebaAmaris\amaris</pre>

- Compila el proyecto usando Maven:
<pre>mvn package</pre>

- El comando anterior generará el archivo WAR en el directorio target. Luego, sigue los pasos de la sección "Instalación y Ejecución" para desplegar el archivo WAR en tu servidor de aplicaciones..


# proyecto react front (amaris-front)

- Clona el repositorio del proyecto en tu máquina local utilizando Git:

<pre>
git clone https://github.com/Deadmanw/PruebaAmaris
</pre>

- Navega al directorio del proyecto:

<pre>
cd ....\PruebaAmaris\amaris-front
</pre>

- Instala las dependencias del proyecto usando npm:

<pre>
npm install
</pre>


- Ejecución Para ejecutar el proyecto en modo desarrollo, utiliza el siguiente comando:

<pre>
 npm start
</pre>


- Esto iniciará la aplicación en modo de desarrollo y se abrirá automáticamente en tu navegador en la dirección http://localhost:3000.

######Compilación

Para compilar el proyecto y generar una versión optimizada para producción, utiliza el siguiente comando:

<pre>
npm run build
</pre>

El comando anterior generará una carpeta llamada build que contiene los archivos estáticos listos para ser desplegados en un servidor web.

