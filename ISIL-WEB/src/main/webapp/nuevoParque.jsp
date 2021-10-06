<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nuevo Parque</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">  		
  <script src="js/bootstrap.min.js"></script>   
</head>

<body>
	<div class="container">
      <form action="parque" method="post" role="form" data-toggle="validator" >
        <c:if test ="${empty action}">            	
          <c:set var="action" value="guardar"/>
        </c:if>

        <input type="hidden" id="action" name="action" value="${action}">
        <input type="hidden" id="idParque" name="idParque" value="${parque.id}">
        <h2>Parque</h2>

        <div class="form-group">
          <label for="nombre" class="control-label col-xs-4">Nombre:</label>
          <input type="text" name="nombre" id="nombre" class="form-control" required="true" value="${parque.nombre}"  />
          <label for="aforo" class="control-label col-xs-4">Aforo: </label>          
          <input type="text" name="aforo" id="aforo" class="form-control" required="true" value="${parque.aforo}" /> 
		  <label for="direccion" class="control-label col-xs-4">Dirección:</label>           
         <input type="text" name="direccion" id="direccion" class="form-control" required="true" value="${parque.direccion}" />
			<label for="distrito" class="control-label col-xs-4">Distrito:</label>           
          <input type="text" name="distrito" id="distrito" class="form-control"  required="true" value="${parque.distrito}"/>
          <br></br>

          <button type="submit" class="btn btn-primary">Guardar</button> 
        </div>                            
      </form>
    </div>
</body>
</html>