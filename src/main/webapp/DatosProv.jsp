<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/pagina.css">
    <title>Datos Proveedores</title>
</head>
<body>
	<header class="principal">
        <div>
            <h1>Formulario Proveedores</h1>
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
    	<label for="Nit">Nit</label><input type="Nit" autofocus name="Nit"  required>
    	<label for="Telefono">Teléfono </label><input type="int" name="Telefono">
    	<p><label for="Nombre Proveedor">Nombre Proveedor</label><input type="text" autofocus name="Nombre Proveedor" required></p>
    	<label for="Ciudad">Ciudad </label><input type="text" name="Ciudad">    
    	<p><label for="Direccion">Dirección</label><input id="name" type="text" autofocus name="Direccion" required></p>
    	
	 	<a href="Index.jsp">CREAR  </a>
 	</div>

</body>
</html>