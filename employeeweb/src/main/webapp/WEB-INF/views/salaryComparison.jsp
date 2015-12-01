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
	<style type="text/css">
		table {
			border-collapse: collapse;
		}
		caption {
			background: #D3D3D3;
		}
		th {
			background: #A7C942;
			border: 1px solid #98BF21;
			color: #ffffff;
			font-weight: bold;
			text-align: left;
		}
		td {
			border: 1px solid #98BF21;
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
		<div id="barChartTarget">
		</div>
	</div>
	
</body>