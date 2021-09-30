<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="CSS/pagina.css">
</head>
<meta charset="ISO-8859-1">
<title>MODULO USUARIO</title>
</head>

<body>
<header class="principal">
        <div>
            <h1>MODULO USUARIO</h1>
        </div>
    </header>
   
</body>
<%!String email="",pasword="",usuario="",nombre="";	
int identificacion; %>
<%
if(request.getParameter("identificacion")!=null){
identificacion=Integer.parseInt(request.getParameter("identificacion"));
email=request.getParameter("email");
pasword=request.getParameter("pasword");
usuario=request.getParameter("usuario");
nombre=request.getParameter("nombre");
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
email="";nombre="";pasword="";usuario="";identificacion=0;
}
%>
<form action="Usuarios" method="post">
<table>
<tr>
 <td><label>Cedula:</label></td>
 <td><input type="number" name= "cedula" value="<%=identificacion%>"></td>
</tr>
<tr>
 <td><label>Correo electronico:</label></td>
 <td><input type="text" name= "email" value="<%=email%>"></td>
</tr>
<tr>
 <td><label>Pasword:</label></td>
 <td><input type="text" name= "pasword" value="<%=pasword%>"></td>
</tr>
<tr>
 <td><label>Usuario:</label></td>
 <td><input type="text" name= "usuario" value="<%=usuario %>"></td>
</tr>
<tr>
 <td><label>Nombre:</label></td>
 <td><input type="text" name= "nombre"value="<%=nombre%>"></td>
</tr>
<tr>
<td colspan="2"align='center'>
<input type ="submit"name="insertar" Value="Registrar">
<input type ="submit"name="actualizar" Value="Actualizar">
<input type ="submit"name="eliminar" Value="Eliminar">
</td>
</tr>


</table>
</form>

<div class="menu">
        <nav class="titulos">
            <li><a href="Usuario.jsp" style="text-decoration:none">Usuarios</a></li>
            <li><a href="Cliente.jsp" style="text-decoration:none">Clientes</a></li>
            <li><a href="Proveedores.jsp" style="text-decoration:none">Proveedores</a></li>
            <li><a href="Productos.jsp" style="text-decoration:none">Productos</a></li>
            <li><a href="DatosVen.jsp" style="text-decoration:none">Ventas</a></li>
            <li><a href="DatosRep.jsp" style="text-decoration:none">Reportes</a></li>
        </nav>
    </div>
<hr>
<form action="Usuarios" method="post">
<fieldset>
<legend>Consultar usuario</legend>
<div><label>Cedula:</label><input type="number" name= "identificacion">
<input type ="submit"name="consultar" Value="Consultar"></div>
</fieldset>
</form>

</body>
</html>