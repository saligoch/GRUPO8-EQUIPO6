<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/pagina.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="Reportes" method="post">
		<div class="form-boton">
			<input type="submit" name="Listadousuarios" class="rj-btn-sr-green"
				value="Listado de Usuarios"> <input type="submit"
				name="Listadoclientes"class="rj-btn-sr-blue"
				value="Listado de Clientes"> <input type="submit"
				name="Ventasclientes" class="rj-btn-sr-orange"
				value="Ventas por cliente">
		</div>
</form>
<div class="tablareportes">
	<%
	if (request.getParameter("usuarios") != null) {
		String[][] usuarios = (String[][]) request.getAttribute("usuarios");
	%>
	<table>
		<tr>
			<td>Cedula</td>
			<td>Nombre</td>
			<td>Correo Electronico</td>
			<td>Usuario</td>
			<td>Password</td>
		</tr>
		<%
		for (int i=0;i<usuarios.length;i++){
		%>
		<tr>
			<td><%=usuarios[i][0]%></td>
			<td><%=usuarios[i][4]%></td>
			<td><%=usuarios[i][1]%></td>
			<td><%=usuarios[i][3]%></td>
			<td><%=usuarios[i][2]%></td>
		</tr>
		<%
	
	}
	%>
	</table>
	<%
	
	}
	%>
	<%
	if (request.getParameter("ventasclientes") != null) {
		String[][] ventasclientes = (String[][]) request.getAttribute("ventasclientes");
	%>
	<table>
		<tr>
			<td>Cedula</td>
			<td>Nombre</td>
			<td>Total ventas</td>
			
		</tr>
		<%
		for (int i=0;i<ventasclientes.length;i++){
		%>
		<tr>
			<td><%=ventasclientes[i][0]%></td>
			<td><%=ventasclientes[i][1]%></td>
			<td><%=ventasclientes[i][2]%></td>
		
		</tr>
		<%
	
	}
	%>
	</table>
	<%
	}
	%>
	<%
	if (request.getParameter("clientes") != null) {
		String[][] clientes = (String[][]) request.getAttribute("clientes");
	%>
	<table>
		<tr>
			<td>Cedula</td>
			<td>Direccion</td>
			<td>Correo Electronico</td>
			<td>Nombre</td>
			<td>Telefono</td>
		</tr>
		<%
		for (int i=0;i<clientes.length;i++){
		%>
		<tr>
			<td><%=clientes[i][0]%></td>
			<td><%=clientes[i][1]%></td>
			<td><%=clientes[i][2]%></td>
			<td><%=clientes[i][3]%></td>
			<td><%=clientes[i][4]%></td>
		</tr>
		<%
	
	}
		%>
		</table>
		<%
		}
		%>
	
</div>
</body>
</html>