<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee List</title>
</head>
<body>
<h1> 
	Employee List
</h1>

<ul>
	<c:forEach var="employee" items="${employeeList}">
		<li>${employee.firstName}&nbsp;${employee.lastName}</li>
	</c:forEach>
</ul>

<c:if test="${prev != null && prev == true}">
<a href="<c:url value="employee"><c:param name="page" value="${page-1}"/></c:url>">previous</a>
</c:if>

<c:if test="${(next != null && next == true) && (prev != null && prev == true)}">
&nbsp;|&nbsp;
</c:if>

<c:if test="${next != null && next == true}">
<a href="<c:url value="employee"><c:param name="page" value="${page+1}"/></c:url>">next</a>
</c:if>

</body>
</html>
