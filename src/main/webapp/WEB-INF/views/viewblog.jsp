<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 
  <script>document.write('<base href="' + document.location + '" />');</script>
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
<title>viewblog</title>
</head>
<body>
	<form:form action="viewblog"  method="post">
	<!-- Search Blog : <input type="text"> ng-model="searchkeyword"> -->
	<div ng-app="myApp" ng-controller="dataCtrl">
	  Enter Blog Name: 
 		<input type="text" ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
  		  <table class="table table-striped">
   			 <tr>
    			<th>Id</th>
    			<th>Name</th>
    			<th>Date</th>
    			<th>Reason</th>
   				 <th>Title</th>
   				 <th>Status</th>
   				 <th>Image</th>
   			 </tr>
      	  <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.bid}}</td>
            <td>{{ resource.bname}}</td>
            <td>{{ resource.date}}</td>
            <td>{{ resource.reason}}</td>
            <td>{{ resource.title}}</td>
            <td>{{ resource.status}}</td>
              <td>{{ resource.user.userid}}</td>
            <!-- <td><img src="resources/images/{{resource.bid}}.jpg" style="width: 200px;height:150px"></td>
            <td><a href="deleteProduct?id={{resource.product_id}}">Delete</a></td> -->
        </tr>    
    </table>
</div>
<div>
<%-- ${blogs} --%>
</div>
</form:form>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
		$scope.names=${blogs};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
</body>
</html>