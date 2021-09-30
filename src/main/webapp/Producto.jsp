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
<title>MODULO PRODUCTO</title>
</head>

<body>
<div class="menu">
        <nav class="titulos">
            <li><a href="Usuario.jsp" style="text-decoration:none">Usuarios</a></li>
            <li><a href="Cliente.jsp" style="text-decoration:none">Clientes</a></li>
            <li><a href="Proveedor.jsp" style="text-decoration:none">Proveedores</a></li>
            <li><a href="Producto.jsp" style="text-decoration:none">Productos</a></li>
            <li><a href="DatosVen.jsp" style="text-decoration:none">Ventas</a></li>
            <li><a href="DatosRep.jsp" style="text-decoration:none">Reportes</a></li>
        </nav>
    </div>
    <h1 >MODULO PRODUCTO</h1>
       

   
</body>
<%!String nombre="";	
int identificacion, nit_proveedor;
float iva,precioc,preciov;%>
<%
if(request.getParameter("identificacion")!=null){
identificacion=Integer.parseInt(request.getParameter("identificacion"));
nit_proveedor=Integer.parseInt(request.getParameter("nit_proveedor"));
iva=Float.parseFloat(request.getParameter("iva"));
nombre=request.getParameter("nombre");
precioc=Float.parseFloat(request.getParameter("precioc"));
preciov=Float.parseFloat(request.getParameter("preciov"));
}
if(request.getParameter("men")!=null){
	String mensaje=request.getParameter("men");
out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");

}
%>
<form action="Producto" method="post">
<table>
<tr>
 <td><label>Codigo producto:</label></td>
 <td><input type="number" name= "codpro" value="<%=identificacion%>"></td>
</tr>
<tr>
 <td><label>Iva:</label></td>
 <td><input type="number" name= "iva" value="<%=iva%>"></td>
</tr>
<tr>
 <td><label>Nit_proveedor:</label></td>
 <td><input type="number" name= "nit_proveedor" value="<%=nit_proveedor%>"></td>
</tr>
<tr>
 <td><label>Nombre:</label></td>
 <td><input type="text" name= "nombre" value="<%=nombre %>"></td>
</tr>
<tr>
 <td><label>Precio Compra:</label></td>
 <td><input type="number" name= "precioc"value="<%=precioc%>"></td>
</tr>
<tr>
<td><label>Precio Venta:</label></td>
 <td><input type="number" name= "preciov"value="<%=preciov%>"></td>
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
<form action="Producto" method="post">
<fieldset>
<legend>Consultar Producto</legend>
<div><label>Codigo Producto:</label><input type="number" name= "identificacion">
<input type ="submit"name="consultar" Value="Consultar"></div>
</fieldset>
</form>
</body>
</html>