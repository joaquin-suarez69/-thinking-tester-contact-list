
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - thinking-tester-contact-list</title>
</head>
<body>
    <h1>Thinking tester contact list</h1>

    <h2>Descripción</h2>
    <p>Este proyecto Java utiliza Maven y Serenity para realizar pruebas automatizadas y generar reportes detallados de ejecución.</p>
    
    <h2>Requisitos</h2>
    <ul>
        <li>Java JDK (versión compatible con tu proyecto)</li>
        <li>Maven</li>
    </ul>
    
    <h2>Configuración</h2>
    <p>Para ejecutar el proyecto y generar el reporte de Serenity, sigue estos pasos:</p>
    <ol>
        <li>Clona este repositorio a tu máquina local.</li>
        <li>Abre una terminal y navega hasta el directorio raíz del proyecto.</li>
        <li>Ejecuta el siguiente comando:</li>
    </ol>
    
    <pre>mvn clean verify serenity:aggregate</pre>
    
    <h2>Reporte de Ejecución</h2>
    <p>Una vez completada la ejecución, podrás encontrar el reporte de Serenity en el siguiente directorio:</p>
    <pre>target/site/serenity/index.html</pre>

    
    <hr>
    <p align="center">Creado con ❤️ por tu equipo de desarrollo.</p>
</body>
</html>