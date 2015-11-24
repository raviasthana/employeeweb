<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Salary Comparison</title>
	<link href="../../resources/css/employeeweb.css" rel="stylesheet" type="text/css">
	<script src="../../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../../resources/js/employeeweb.js"></script>
	<script type="text/javascript">
		$( document ).ready(function() {
			showDepartmentCheckboxesForSalaryComparison('/hrweb/department');
		});	
	</script>
</head>
<body>
<h1>
	Salary Comparison
</h1>
	
	<div id="departmentList">
	</div>
	
	<c:choose>
		<c:when test="${fn:length(departmentList) > 0}">
			<table id="hor-minimalist-a" summary="Department List">
				<thead align="left">
					<tr>
						<th scope="col">Select departments for salary comparison</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="department" items="${departmentList}">
						<tr>
							<td>
								<label>
									<input type="checkbox" value="${department.departmentId}" name="dept">
									${department.departmentName}
								</label>
							</td>
							<td></td>							
						</tr>	
					</c:forEach>
				</tbody>
			</table>		
		</c:when>
		<c:otherwise>
			<p>No departments found for salary comparison
		</c:otherwise>
	</c:choose>	
</body>