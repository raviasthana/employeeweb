<%@ page language="java" import="javax.servlet.jsp.PageContext" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee List</title>
	<link href="../../resources/css/employeeweb.css" rel="stylesheet" type="text/css">
	<script src="../../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../../resources/js/employeeweb.js"></script>	
</head>
<body>
<h1> 
	Employee List
</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:choose>
	<c:when test="${fn:length(employeeList) > 0}">
		<table id="box-table-a" summary="Employee List">
			<thead align="left">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">Job Title</th>
					<th scope="col">&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td>
							${employee.firstName}&nbsp;${employee.lastName}
						</td>
						<td>${employee.email}</td>
						<td>${employee.phoneNumber}</td>
						<td>${employee.job.jobTitle}</td>
						<td><a href="#" onclick="viewEmployeeJobProfile('/hrweb/employee','${employee.employeeId.id}')">Job History</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="5">
						<c:if test="${prev != null && prev == true}">
							<a href="<c:url value="employee"><c:param name="page" value="${page-1}"/></c:url>">previous</a>
						</c:if>

						<c:if test="${(next != null && next == true) && (prev != null && prev == true)}">
							&nbsp;|&nbsp;
						</c:if>

						<c:if test="${next != null && next == true}">
							<a href="<c:url value="employee"><c:param name="page" value="${page+1}"/></c:url>">next</a>
						</c:if>
					</th>
				</tr>
			</tfoot>
		</table>		
	</c:when>
	<c:otherwise>
		<p>No employee records found
	</c:otherwise>
</c:choose>

	<!-- START - Lightbox -->
	<div id="shadowing"></div>
	<div id="box">
		<div id="boxheader">
			<span id="boxtitle" style="font-size: 16px;"><b id="jh_header"></b></span>
			<span id="boxclose"><a href="#" onclick="closebox()"><b>Close</b></a></span>
		</div>
		<div id="boxcontent">
			<div id="job_history"></div>
		</div>
	</div>
	<!-- END - Lightbox -->
</body>
</html>
