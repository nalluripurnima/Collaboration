<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Add Comment</title>
<style type="text/css">
  .input-group{
	width:50%;
	padding : 5px 5px 5px 5px;
}
</style>
</head>
<body>
<form:form action="store5" method="post">
<div class = "input-group">             	 
	 <%-- 
	 <c:forEach var="e" items="${errors}">
		<li>${e.getDefaultMessage()}" </li>
	</c:forEach> --%>
	<div class="input-group margin-bottom-20">
			<span class="input-group-addon"><i class="glyphicon glyphicon-star "></i></span>
			<form:input path='cname' id="name" class="form-control"	placeholder="Enter name" required="true" title="valid name is required"/>
			</div>
	 
		<br>
		<br>
		<div class="input-group margin-bottom-20">
			<span class="input-group-addon"><i class="glyphicon glyphicon-star "></i></span>
			<form:textarea  path='cdesc' id="Mail" class="form-control"	placeholder="Enter mail id" required="true" title="valid mail is required"/>
			</div>
		<br>
		<br>
		
		<div style="margin-top: 10px" class="form-group">
		<center>
			<div class="col-sm-12 controls">
				<button class="btn btn-info btn-md">add comment</button>
			</div>
			</center>
		</div>  
   </div>
   </form:form>
</body>
</html>
