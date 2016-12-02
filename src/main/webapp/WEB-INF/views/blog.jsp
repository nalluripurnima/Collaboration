<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ page isELIgnored="false" %>
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
<title>Add Blog</title>
<style type="text/css">

.input-group{
	width:50%;
	padding : 5px 5px 5px 5px;
}
.header
{
text-align:center;
background-color:white;
}
</style>
</head>
<body>
<div class="header">
		<%@include file="home.jsp"%>
	</div>
<form:form action="blog" method="post">
  <div class="input-group">
        <div class="input-group margin-bottom-20">
        <span class="input-group-addon"><i class="glyphicon glyphicon-star "></i></span>
			<form:input path='bname' id="name" class="form-control" placeholder="Enter Blog name" required="true" title="valid name is required"/>
		</div>
		<br>
		<br>
		<div class="input-group margin-bottom-20">
		<span class="input-group-addon"><i class="glyphicon glyphicon-star "></i></span>
			<form:input path='title' id="pwd" class="form-control" type="text" placeholder="Blog title" required="true"/>
		</div>
		<br>
		<br>
		<div class="input-group margin-bottom-20">
		<span class="input-group-addon"><i class="glyphicon glyphicon-star "></i></span>
			<form:input path='status' id="address" class="form-control"	placeholder="status" required="true"/>
			
		</div>
		<br>
		<br>
		<div class="input-group margin-bottom-20">
		<span class="input-group-addon"><i class="glyphicon glyphicon-star "></i></span>
			<form:input path='reason' id="reason" class="form-control"	placeholder="reason" required="true"/>
		</div>
		<br>
		<br>
		<div class="input-group margin-bottom-20">
		<span class="input-group-addon"><i class="glyphicon glyphicon-star "></i></span>
			<form:textarea path='content' id="Mail" class="form-control"	placeholder="Content" required="true" title="valid mail is required"/>
			</div>
		<br>
        <br>
		<div style="margin-top: 10px" class="form-group">
		
			<div class="col-sm-12 controls">
				<button class="btn btn-info btn-md">add blog</button>
			</div>
			
		</div>
	</div>
    </form:form>
 </body>
</html>
