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
<title>MODULO PROVEEDORES</title>
</head>

<body>
<header class="principal">
        <div>
            <h1>MODULO PROVEEDORES</h1>
        </div>
    </header>
   
</body>
<%!String ciudad="",direccion="",nombre="",telefono="";	
int identificacion; %>
<%
if(request.getParameter("identificacion")!=null){
identificacion=Integer.parseInt(request.getParameter("identificacion"));
ciudad=request.getParameter("ciudad");
direccion=request.getParameter("direccion");
nombre=request.getParameter("nombre");
telefono=request.getParameter("telefono");
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");
ciudad="";direccion="";nombre="";telefono="";identificacion=0;
}
%>
<form action="Proveedor" method="post">
<table>
<tr>
 <td><label>Nit:</label></td>
 <td><input type="number" name= "nit" value="<%=identificacion%>"></td>
</tr>
<tr>
 <td><label>Ciudad:</label></td>
 <td><input type="text" name= "ciudad" value="<%=ciudad%>"></td>
</tr>
<tr>
 <td><label>Direccion:</label></td>
 <td><input type="text" name= "direccion" value="<%=direccion%>"></td>
</tr>
<tr>
 <td><label>Nombre:</label></td>
 <td><input type="text" name= "nombre" value="<%=nombre %>"></td>
</tr>
<tr>
 <td><label>Telefono:</label></td>
 <td><input type="text" name= "telefono"value="<%=telefono%>"></td>
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
<form action="Proveedor" method="post">
<fieldset>
<legend>Consultar proveedor</legend>
<div><label>Nit:</label><input type="number" name= "identificacion">
<input type ="submit"name="consultar" Value="Consultar"></div>
</fieldset>
</form>

</body>
</html>