<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.jlr.employeeweb.util.HRConstants" %>
<%@ page session="false" %>
<html>
<head>
	<title>HR Home</title>
	<link href="../../resources/css/employeeweb.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1> 
	HR Application
</h1>
<p>Welcome to HR application. Please use the following links to retrieve employee information.

<ul>
	<li><a href="<c:url value="employee" />">Get list of all existing employees</a></li>
	<li>Salary Comparison</li>
</ul>

<!-- ${controllerMessage} -->
</body>
</html>
