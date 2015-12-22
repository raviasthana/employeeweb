<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page session="false" %>

<div id="wrapper">

	<div class="header">
		<jsp:include page="header.jsp" />
	</div>

	<div class="nav-bar">
		<div class="container">
			<ul class="nav">
				<li><a href="/hrweb/">Home</a></li>
				<security:authorize ifAnyGranted="EMPLOYEE">
					<li><a href="/hrweb/employee">Employee List</a></li>
				</security:authorize>
				<li class="active">Salary Comparison</li>
				<li>
					<a href="<c:url value="/hrweb/j_spring_security_logout" />">Logout</a>
				</li>				
			</ul>
		</div>
	</div>
	
	<div class="content">
		<div class="container">
			<div class="main">
				<div id="departmentList">
				</div>
	
				<div id="salaryComparisonBarChartSource" style="display:none">
				</div>
				
				<div id="salaryComparisonBarChartTarget">
					<div id="barChartTarget">
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<div class="container">
			&copy; Copyright 2015
		</div>	
	</div>

</div>

	<script type="text/javascript">
		$( document ).ready(function() {
			showDepartmentCheckboxesForSalaryComparison('/hrweb/department');
		});
	</script>
	<style type="text/css">
		table {
			border-collapse: collapse;
		}
		caption {
			background: #D3D3D3;
		}
		th {
			border: 0px;
			color: #ffffff;
			font-weight: bold;
			text-align: left;
		}
		td {
			border: 0px;
			text-align: left;
			font-weight: normal;
			color: #000000;
		}
		tr:nth-child(odd) {
			background: #ffffff;
		}
		tbody tr:nth-child(odd) th {
			background: #ffffff;
			color: #000000;
		}
		tr:nth-child(even) {
			background: #EAF2D3;
		}
		tbody tr:nth-child(even) th {
			background: #EAF2D3;
			color: #000000;
		}
		#barChartTarget {
			width: 1000px;
			height: 400px;
		}
	</style>

	