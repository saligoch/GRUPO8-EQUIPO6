<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/pagina.css">
    <title>Datos Usuarios</title>
</head>
<body>
	<header class="principal">
        <div>
            <h1>Formulario Usuarios</h1>
        </div>
    </header>
    <div class="menu">
        <nav class="titulos">
            <li><a href="DatosUsu.jsp" style="text-decoration:none">Usuarios</a></li><!-- el signo # representa un link a cualquier parte -->
            <li><a href="DatosCli.jsp" style="text-decoration:none">Clientes</a></li>
            <li><a href="DatosProv.jsp" style="text-decoration:none">Proveedores</a></li>
            <li><a href="DatosProd.jsp" style="text-decoration:none">Productos</a></li>
            <li><a href="DatosVen.jsp" style="text-decoration:none">Ventas</a></li>
            <li><a href="DatosRep.jsp" style="text-decoration:none">Reportes</a></li>
        </nav>
    </div>

    <div class="formulario">
    	<label for="Cedula">Cédula</label><input type="text" autofocus name="Cedula"  required>
    	<label for="Usuario">Usuario </label><input type="text" name="Usuario">
    	<p><label for="Nombres de usuario">Nombre Completo</label><input type="text" autofocus name="Nombres de usuario" required></p>    
    	<label for="Password">Contraseña </label><input type="Password" name="Password"><!-- oculata los datos de la contraseña -->
    	<p><label for="Email">Correo Electronico</label><input id="name" type="text" autofocus name="Email" required></p>
	 	<a href="Index.jsp">CREAR  </a>
 	</div>

</body>
</html>