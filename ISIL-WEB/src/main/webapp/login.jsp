<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Acceso al Sistema ISIL WEB</title>
	</head>
	<body>
		<h1>Sistema ISIL WEB</h1>
		<!-- En el action se coloca el nombre del controlador al que voy a llamar para que realice la acción solicitada -->
		<form action="login" method="POST">
			<input type="hidden" value="validarUsuario" id="opcion" name="opcion">
			<label>Usuario: </label><input type="text" id="nickname" name="nickname"><br><br>
			<label>Password: </label><input type="password" id="password" name="password"><br><br>
			<input type="submit" value="Ingresar">
		</form>
	</body>
</html>