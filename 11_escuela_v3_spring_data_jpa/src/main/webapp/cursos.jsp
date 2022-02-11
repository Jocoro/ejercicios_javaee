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
<h1>Listado de cursos</h1>
<table border="1">
<tr><th>Denominación</th><th>Duración</th><th>Precio</th><th>Fecha inicio</th></tr>
<c:forEach var="curso" items="${requestScope.cursos}">
<tr>
<td>
${curso.denominacion}
</td>
<td>
${curso.duracion}
</td>
<td>
${curso.precio}
</td>
<td>
${curso.fechaInicio}</td>
</tr>
</c:forEach>
<br><br>
<a href="inicio">Volver</a>
</table>
</center>
</body>
</html>