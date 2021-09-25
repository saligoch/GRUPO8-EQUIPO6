<%@page import="controlador.Conexion"%>
<%@page import="org.apache.catalina.startup.ContextConfig.ContextXml"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="CSS/pagina.css">
</head>
<body>
<%
Conexion cnn=new Conexion();
cnn.Conecta();
%>
<h1>Tienda Genérica</h1>

<!-- <form action="Control" method="post"> <%--action= envía los datos a control que es el controlador metodo oculto --%>
<div><label>Usuario:</label><input type= "text" name="usuario"></div>
<div><label>Contraseña:</label><input type= "number" name="contraseña"></div>
<div><input type= "submit" name="Ingresar" value="Ingresar"></div>
</form> -->


<div><h2><a href="Login.jsp">Ingreso Administrador</a></h2></div>
</body>
</html>



