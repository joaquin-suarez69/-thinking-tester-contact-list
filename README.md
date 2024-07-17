<h1 align="center" id="title">Thinking tester contact list</h1>
<p>

<p id="description">Este proyecto Java utiliza Maven, Serenity y Cucumber para realizar pruebas automatizadas y generar reportes detallados de ejecución.</p>
<p>
<p>
<h2>🧐 Características </h2>
<p>
<p>
El proyecto consta de un archivo feature con 3 posibles escenarios para Agregar, Actualizar y Eliminar un contacto de la lista para un usuario determinado. La cuenta de usuario debe ser creada manualmente con el boton de sign up. 

Los datos del nuevo usuario deben ser agregados al archivo config.properties del proyecto en las propiedades para que sean utilizados por el framework.
```
user.email
user.password
```
 En el archivo properties tambien podemos cambiar la URL base y el navegador en el que vamos a ejecutar las pruebas (actualmente Chrome y Firefox) cambiando los valores del campo
```
base.url
base.browser
```
Los datos de los contactos se almacenan en un archivo JSON llamado <code> users.json </code> son cargados al ejecutar las pruebas de manage contacts y pueden adicionarse a gusto siguiendo el mismo formato del objeto.
Para probar distintas combinaciones de usuarios en los tests se pueden modificar los indices de cada paso por ejemplo en el escenario de crear un contacto 
```
Background:
    Given user logs in the system

  @CreateContact
Scenario: Create a contact

    When user tries to "create" contact 1
    Then contact 1 is present on the contacts list
```
el numero <strong>1</strong> indica que se va a usar el primer contacto de la lista de usuarios. 
<p>
<h2>🛠️ Instalación </h2>
<p>
<p>1. Clona este repositorio a tu máquina local.</p>

```
git clone https://github.com/joaquin-suarez69/thinking-tester-contact-list.git
```

<p>2. Abre una terminal y navega hasta el directorio raiz del proyecto.</p>

<p>3. Ejecuta el siguiente comando</p>

```
mvn clean verify serenity:aggregate
```

<p>4. Una vez completada la ejecución podrás encontrar el reporte de Serenity en el siguiente directorio:</p>

```
target/site/serenity/index.html
```
<p>  

<h2>💻 Construido con</h2>

Tecnologias usadas en el proyecto:

*   Maven
*   SerenityBDD
*   Selenium
*   Cucumber
*   Java
<p>  
<h2> ©️ Autor</h2>
<p> * <a href="https://github.com/joaquin-suarez69"> Joaquin Suarez </a> - SDET (Software Development Engineer in Test)