<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!String Nombre_cliente,cedula; %>
<form action="ventas" method="post">
<div><label>cedula_cliente: </label><input type="text" name="cedula_cliente">
<input type="submit" name="consultarcli" value="Consultar">
<label></label>
<input type="hidden" name="cedula" value="<%=cliente%>">
<div><label></label></div>
</div>

</form>

</body>
</html>