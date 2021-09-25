<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
    <link rel="stylesheet" href="CSS/pagina.css">
</head>
<body>

	<header class="principal">
        <div>
            <h1>Menú Principal</h1>
        </div>
    </header>
    <div class="menu">
        <nav class="titulos">
            <li><a href="Usuario.jsp" style="text-decoration:none">Usuarios</a></li><!-- el signo # representa un link a cualquier parte -->
            <li><a href="Cliente.jsp" style="text-decoration:none">Clientes</a></li>
            <li><a href="DatosProv.jsp" style="text-decoration:none">Proveedores</a></li>
            <li><a href="DatosProd.jsp" style="text-decoration:none">Productos</a></li>
            <li><a href="DatosVen.jsp" style="text-decoration:none">Ventas</a></li>
            <li><a href="DatosRep.jsp" style="text-decoration:none">Reportes</a></li>
        </nav>
    </div>
</body>
</html>