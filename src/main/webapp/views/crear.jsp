<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Persona</title>
</head>
<body>
	<h1>Crear Persona</h1>

	<form action="personas" method="post">
	<input type="hidden" name="opcion" value="guardar">
		<table border="1">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>

			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="apellidos" size="100"></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>