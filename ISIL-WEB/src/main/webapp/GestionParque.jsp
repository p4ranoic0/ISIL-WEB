<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/bootstrap.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="GestionParque.jsp">Locales<span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="mantColaborador.jsp">Colaboradores</a>
		      </li>
		    </ul>
		  </div>
		</nav>
	
		<div class="container">
		<h2>Parques</h2>
		<!-- Formulario buscar Parque -->
		<form action="parque" method="GET" id="buscarParque" role="form">
			<input type="hidden" id="opcion" name="opcion" value="buscarPorNombre">
			<div class="form-group col-xs-5">
				Nombre del Parque: 
				<input type="text" name="nombreParque" id="nombreParque" class="form-control" 
					placeholder="Escriba el nombre del Parque" />
			</div>
			<button type="submit" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Buscar
			</button>
		</form>
	
		<form action="parque" method="GET" id="nuevoParque" role="form">
			<input type="hidden" id="opcion" name="opcion" value="nuevo"> <br></br>
			<button type="submit" class="btn btn-primary  btn-md">Nuevo Parque</button>
		</form>
		
		<form action="parque" method="POST" id="parqueForm" role="form">							
			<input type="hidden" id="action" name="action">
			<input type="hidden" id="idParque" name="idParque">	
		<c:choose>
			<c:when test="${not empty listaParques}">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nombre</td>
							<td>Aforo</td>
							<td>Dirección</td>
							<td>Distrito</td>
							<td>Estado</td>
							<td>Acción</td>
						</tr>
					</thead>
					<c:forEach var="objParque" items="${listaParques}">
						<tr>
							<td><a href="parque?idParque=${objParque.id}&opcion=editar">
								${objParque.id}</a></td>
							<td>${objParque.nombre}</td>
							<td>${objParque.aforo}</td>
							<td>${objParque.direccion}</td>
							<td>${objParque.distrito}</td>
							<td>${objParque.estado}</td>
							<td><a href="#" id="eliminar"
									onclick="document.getElementById('idParque').value='${objParque.id}';
	            									document.getElementById('action').value='eliminar';
	            									document.getElementById('parqueForm').submit();">
										<span class="glyphicon glyphicon-trash">Eliminar</span>
									</a>
							</td>
						</tr>
					</c:forEach>				
				</table>
			</c:when>
			<c:otherwise>
				<br>
				<div class="alert alert-info">No se encontraron registros para la búsqueda</div>
			</c:otherwise>
		</c:choose>
		</form>
	</div>
	</body>
</html>