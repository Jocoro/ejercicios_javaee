<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<a href="toAltaAlumnos">Alta de alumnos</a>  <a href="alumnos">Alumnos por curso</a>
<h1>Formulario para el alta de cursos</h1>
<form action="alta" method="post">
Denominaci�n:<input type="text" name="denominacion"><br>
Duraci�n:<input type="number" name="duracion"><br>
Precio:<input type="number" name="precio"><br>
Fecha de inicio:<input type="date" name="fechaInicio"><br>
<input type="submit" value="Alta">
</form>
<h1>Filtrar por fechas</h1>
<form action="filtroPorFechas" method="get">
Fecha de inicio:<input type="date" name="fechaInicial"><br>
Fecha final:<input type="date" name="fechaFinal"><br>
<input type="submit" value="Filtrar">
</form>
<h1>Filtrar por duraci�n</h1>

<form action="filtroPorDuracion" method="get">
Duracion m�xima:<input type="number" name="duracion"><br>
<input type="submit" value="Filtrar">
</form>
<h1>Buscar curso</h1>
<form action="buscarCurso" method="get">
Id del curso:<input type="number" name="idCurso"><br>
<input type="submit" value="Buscar">
</form>
<h1>Rebajar cursos</h1>
<form action="modificarCursos" method="get">
Porcentaje de rebaja:<input type="number" name="porcentaje"><br>
Curso con duraci�n superior a:<input type="number" name="duracionMin"><br>
<input type="submit" value="Rebajar">
</form>
</center>
</body>
</html>