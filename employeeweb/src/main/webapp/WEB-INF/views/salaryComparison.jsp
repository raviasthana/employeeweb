<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Salary Comparison</title>
	<link href="../../resources/css/employeeweb.css" rel="stylesheet" type="text/css">
	<link href="../../resources/css/TableBarChart.css" rel="stylesheet" type="text/css">
	<script src="../../resources/js/jquery-1.11.1.min.js"></script>
	<script src="../../resources/js/employeeweb.js"></script>
	<script src="../../resources/js/TableBarChart.js"></script>
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
	
	<div id="salaryComparisonBarChartSource" style="display:none">
	</div>
	
	<div id="salaryComparisonBarChartTarget">
	</div>
	
</body>