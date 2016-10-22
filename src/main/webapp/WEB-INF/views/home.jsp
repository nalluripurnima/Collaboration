<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>home</title>
<style>
/* On using dropdown menu (To right shift popuped) */
.navbar-fixed-left .navbar-nav>li {
	margin-top: -50px;
	margin-left: 140px;
}
.custom-search-input{
    padding: 2px;
    border: solid 1px #E4E4E4;
    border-radius: 6px;
    background-color: #fff;
    width: 400px;
    
}
.custom-search-input input{
    border: 0;
    box-shadow: none;
    size:10px;
}
.custom-search-input button{
    margin: 2px 0 0 0;
    background: none;
    box-shadow: none;
    border: 0;
    color: #666666;
    padding: 0 8px 0 10px;
    border-left: solid 1px #ccc;
}
.custom-search-input button:hover{
    border: 0;
    box-shadow: none;
    border-left: solid 1px #ccc;
}
.custom-search-input .glyphicon-search{
    font-size: 23px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><I><B>thinkQuest</B></I></a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="home">Home</a></li>
			<li><a href="about">About Us</a></li>
			<li><a href="contact">Contact Us</a></li>
			<li><a href="blog">Blog</a></li>
			<li><a href="comment">Comment</a></li>
			<li><a href="event">Event</a></li>
			<li><a href="forum">Forum</a></li>
			<li><a href="addasfriend">Add Friend</a></li>
			<!-- <li><div id="custom-search-input">
					<div class="input-group col-md-12">
						<input type="text" class="form-control input-sm"  style="top:10px;"
							placeholder="Search Products" /> <span class="input-group-btn" style="width:20px; top:10px" >
							<button class="btn btn-primary" type="button">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</span>
					</div>
				</div></li> -->
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><c:if test="${empty Welcome}">
					<div style="float: right; position: absolute; toppadding: 20px; right: 90px; color: white;">
						<a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a><br>
					</div>
					<div style="float: right; position: absolute;  right: 20px; color: white;">
						<a href="register"><span class="glyphicon glyphicon-user"></span>Register</a>
					</div>
			</c:if></li>
			<c:if test="${not empty Welcome}">
				<div style="float: right; position: absolute; top: 0px; right: 110px; color: white; size:50px;"><a href="viewcart"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></div>
				<div style="float: right; position: fixed; top: 0px; right: 300px; color: white;">Welcome ${Welcome.name}!!</div>
				<div style="float: right; position: absolute; top: 0px; right: 180px; color: white;"><a href="profile"><span class="glyphicon glyphicon-user">MyProfile</span></a></div>
                  <a href="logout"><span class="glyphicon glyphicon-user">SignOut</span></a>>
		</c:if>
		</ul>
	</div>
	</nav>
</body>
</html>