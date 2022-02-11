<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<a href="inicio">Volver</a>
<form action="alumnosPorCurso" method="get">
<select name="idCurso">
<c:forEach var="curso" items="${requestScope.cursos}">
<option value="${curso.idCurso}">${curso.denominacion}</option>
</c:forEach>
</select>
<input type="submit" value="Buscar alumnos">
</form>
<h1>Listado de alumnos</h1>
<table border="1" class="table table-striped">
<thead><tr><th>Dni</th><th>Nombre</th><th>Edad</th><th>Email</th></tr></thead>
<tbody>
<c:forEach var="alumno" items="${requestScope.alumnos}">
<tr>
<td>
${alumno.dni}
</td>
<td>
${alumno.nombre}
</td>
<td>
${alumno.edad}
</td>
<td>
${alumno.email}</td>
</tr>
</c:forEach>
</tbody>
</div>
</body>
</html>