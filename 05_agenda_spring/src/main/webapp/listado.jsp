<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Listado de contactos</h1>
<table border="1">
<tr><th>Nombre</th><th>Email</th><th>Edad</th></tr>
<c:forEach var="con" items="${requestScope.contactos}">
<tr>
<td>
${con.nombre}
</td>
<td>
${con.email}
</td>
<td>
${con.edad}
</td>
<td><a href="baja?email=${con.email}">Eliminar</a></td>
</tr>
</c:forEach>
<br><br>
<a href="entrada">Volver</a>
</table>
</center>
</body>
</html>