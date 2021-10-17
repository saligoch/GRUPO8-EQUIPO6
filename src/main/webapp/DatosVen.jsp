<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/pagina.css">
    <title>Datos Ventas</title>
</head>
<body>
	<header class="principal">
        <div>
            <h1>Formulario Ventas</h1>
        </div>
    </header>
    <div class="menu">
        <nav class="productos">
            <li><a href="DatosUsu.jsp" style="text-decoration:none">Usuarios</a></li><!-- el signo # representa un link a cualquier parte -->
            <li><a href="DatosCli.jsp" style="text-decoration:none">Clientes</a></li>
            <li><a href="DatosProv.jsp" style="text-decoration:none">Proveedores</a></li>
            <li><a href="DatosProd.jsp" style="text-decoration:none">Productos</a></li>
            <li><a href="DatosVen.jsp" style="text-decoration:none">Ventas</a></li>
            <li><a href="DatosRep.jsp" style="text-decoration:none">Reportes</a></li>
        </nav>
    </div>

<%!String producto="",producto2="",producto3="",codProd="",codProd2="",codProd3="",nombre="", cedula="",nombreusu="", cedulausu="",codigoventa;
  float preciou=0,totalp=0,totiva=0,totalven=0, preciou2=0,preciou3=0,iva=0,iva2=0,iva3=0;
  int cant1,cant2,cant3;%>
   
<%
if(request.getParameter("producto")!=null){
	producto=request.getParameter("producto");
	codProd=request.getParameter("codProd");
	preciou=Float.parseFloat(request.getParameter("preciou"));
	iva=Float.parseFloat(request.getParameter("iva"));
	cant1=Integer.parseInt(request.getParameter("cant1"));
}
if(request.getParameter("producto2")!=null){
	producto2=request.getParameter("producto2");
	codProd2=request.getParameter("codProd2");
	preciou2=Float.parseFloat(request.getParameter("preciou2"));
	iva2=Float.parseFloat(request.getParameter("iva2"));
	cant2=Integer.parseInt(request.getParameter("cant2"));
}
if(request.getParameter("producto3")!=null){
	producto3=request.getParameter("producto3");
	codProd3=request.getParameter("codProd3");
	preciou3=Float.parseFloat(request.getParameter("preciou3"));
	iva3=Float.parseFloat(request.getParameter("iva3"));
	cant3=Integer.parseInt(request.getParameter("cant3"));
}
if(request.getParameter("nombre")!=null){
	nombre=request.getParameter("nombre");
	cedula=request.getParameter("cedula");
	
}
if(request.getParameter("nombreusu")!=null){
	nombreusu=request.getParameter("nombreusu");
	cedulausu=request.getParameter("cedulausu");
	
}

if(request.getParameter("tot")!=null){
	preciou=Float.parseFloat(request.getParameter("tot"));
	preciou2=Float.parseFloat(request.getParameter("tot2"));
	preciou3=Float.parseFloat(request.getParameter("tot3"));
	totalp=Float.parseFloat(request.getParameter("totalp"));
	totiva=Float.parseFloat(request.getParameter("totiva"));
	totalven=Float.parseFloat(request.getParameter("totalven"));
	codigoventa=request.getParameter("codigoventa");
}

if(request.getParameter("men")!=null){
String mensaje=request.getParameter("men");
out.print("<script type='text/javascript'>alert('"+mensaje+"');</script>");	
}
%>

	<form action="DetalleVentas" method="post">
    <div class="formulario">
    	<label for="Cedula">Cédula : </label><input type="text" autofocus name="Cedula"value="<%=cedula%>"   >
    	<input type="submit" name="consultarCliente" value="Consultar">
    	<label for="Cliente">Cliente : </label><input type="text" autofocus name="Cliente" value="<%=nombre%>"   >
    	</div>
	<div class="formulario">
    	<p> <label for="Consecutivo">Consecutivo venta : </label><input type="text" autofocus name="Consecutivo" value="<%=codigoventa%>"  >
    	<p> <label for="Cedula_Usuario">Cedula Usuario : </label><input type="text" autofocus name="Cedula_usuario"value="<%=cedulausu%>" >
    	<input type="submit" name="consultarUsuario" value="Consultar">
    	<label for="Nombre_Usuario">Nombre_usuario : </label><input type="text" autofocus name="Nombre_Usuario" value="<%=nombreusu%>"   >

		<p><label for="Cod.Producto">Cod. Producto 1: </label>
		<input type="text" autofocus name="CodProducto1" value ="<%=codProd%>">  
		<input type="submit" name="consultarProducto1" value="Consultar">
    	<input type="text" value ="<%=producto%>">
    	<input type="hidden"name="iva" value ="<%=iva%>">
    	<p> <label for="Cantidad">Cantidad : </label> <input type="text" autofocus name="Cantidad" value="<%=cant1%>" >
    	<label for="VlrTotal">Vlr Total : </label><input type="number" autofocus name="VlrTotal" value="<%=preciou%>" >    
    	
		<p><label for="Cod.Producto">Cod. Producto 2: </label>
		<input type="text" autofocus name="CodProducto2" value ="<%=codProd2%>">  
		<input type="submit" name="consultarProducto2" value="Consultar">
    	<input type="text" value ="<%=producto2%>">
    	<input type="hidden"name="iva2" value ="<%=iva2%>">
    	<p> <label for="Cantidad">Cantidad : </label> <input type="text" autofocus name="Cantidad2" value="<%=cant2%>"  >
    	<label for="Vlr Total">Vlr Total : </label><input type="number" autofocus name="VlrTotal2"  value="<%=preciou2%>" >   

		<p><label for="Cod. Producto">Cod. Producto 3: </label>
		<input type="text" autofocus name="CodProducto3" value ="<%=codProd3%>" >
		<input type="submit" name="consultarProducto3" value="Consultar">
    	<input type="text" value ="<%=producto3%>">
    	<input type="hidden" name="iva3" value ="<%=iva3%>">
    	<p> <label for="Cantidad">Cantidad : </label> <input type="text" autofocus name="Cantidad3" value="<%=cant3%>"  >
    	<label for="Vlr Total">Vlr Total : </label><input type="number" autofocus name="VlrTotal3"  value="<%=preciou3%>" >   >
    	
    	<p><label for="Total Venta">Total Venta : </label><input type="text" autofocus name="Total Venta" value="<%=totalp%>"   ></p>
    	<p><label for="Total IVA">Total IVA : </label><input type="text" autofocus name="Total IVA"value="<%=totiva%>"  ></p>
    	<p><label for="Total con IVA">Total con IVA : </label><input type="text" autofocus name="Total con IVA" value="<%=totalven%>" ></p>

 	</div>
 	<div><input type="submit" name="confirmar" value="CONFIRMAR"></div>
 	<p>
 	</form>

</body>
</html>