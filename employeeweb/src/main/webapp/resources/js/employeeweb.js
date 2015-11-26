function viewEmployeeJobProfile(urlPrefix,empId){
	
	var url = urlPrefix + '/' + empId + "/jobhistory";
	$.getJSON(url, null, function(employeeDetails){
		
		clearbox();
		$('#jh_header').append("Job History: " + employeeDetails.firstName + " " + employeeDetails.lastName);
		
		var ejHistory = employeeDetails.jobHistory; 
		
		if(ejHistory.length > 0){
			
			var jHistory = "<table id=\"box-table-a\" summary=\"Employee List\"><thead><tr>";
			jHistory = jHistory + "<th scope=\"col\">Job Title</th>";
			jHistory = jHistory + "<th scope=\"col\">Department</th>";
			jHistory = jHistory + "<th scope=\"col\">Start Date</th>";
			jHistory = jHistory + "<th scope=\"col\">End Date</th>";
			jHistory = jHistory + "</tr></thead>";
			jHistory = jHistory + "<tbody>";
			
			for(var i=0; i < ejHistory.length; i++){
				jHistory = jHistory + "<tr>";
				jHistory = jHistory + "<td>" + ejHistory[i].job.jobTitle + "</td>";
				jHistory = jHistory + "<td>" + "&nbsp;" + "</td>";
				jHistory = jHistory + "<td>" + ejHistory[i].jobHistoryId.startDate + "</td>";
				jHistory = jHistory + "<td>" + ejHistory[i].endDate + "</td>";
				jHistory = jHistory + "</tr>";
			}
			
			jHistory = jHistory + "</tbody></table>";
			
			$('#job_history').append(jHistory);
		}else{
			$('#job_history').append("<p>No Job History Records Found.</p>");
		}
		
		showLightbox();
	});
}

function showLightbox(){
	
	var box = document.getElementById('box'); 
	document.getElementById('shadowing').style.display='block';	
	
	document.body.style.overflow = 'hidden';
	box.style.display = 'block';
}

function closebox(){
   document.getElementById('box').style.display='none';
   document.getElementById('shadowing').style.display='none';
   document.body.style.overflow = 'visible';
}

function clearbox(){
	  $('#jh_header').empty();
	  $('#job_history').empty();  
}

function showDepartmentCheckboxesForSalaryComparison(urlPrefix){
	
	var allDeptUrl = urlPrefix + '/all';
	
	$.getJSON(allDeptUrl, null, function(departmentList){
		
		var deptTable = "<table id=\"hor-minimalist-b\" summary=\"Department List\">";
		deptTable = deptTable + "<thead align=\"left\">";
		deptTable = deptTable + "<tr>";
		deptTable = deptTable + "<th scope=\"col\" colspan=\"10\">Select departments for salary comparison</th>";
		deptTable = deptTable + "</tr>";
		deptTable = deptTable + "</thead>";
		deptTable = deptTable + "<tbody>";
		var k=0;
		for(var i=0; i < departmentList.length; i+=k){
			deptTable = deptTable + "<tr>";
			k=0;
			for(var j=i; j < (i+10) && j < departmentList.length; j++,k++){
				deptTable = deptTable + "<td><label>";
				deptTable = deptTable +	departmentList[j].departmentName;
				deptTable = deptTable + "<br>";
				deptTable = deptTable + "<input type=\"checkbox\" value=\"" + departmentList[j].departmentId + "\" name=\"dept\">";
				deptTable = deptTable + "</label></td>";
			}
			deptTable = deptTable + "</tr>";
		}
		
		deptTable = deptTable + "</tbody>";
		deptTable = deptTable + "<tfoot><tr><th colspan=\"10\">";
		deptTable = deptTable + "<input type=\"button\" class=\"pure-button pure-button-primary\" " +
								"value=\"Compare Salary For Selected Departments\" " +
								"onclick=\"compareSalaryForDepartments('" + urlPrefix + "')\"/>";
		deptTable = deptTable +	"</th></tr></tfoot>";
		deptTable = deptTable + "</table>";
		
		$('#departmentList').append(deptTable);
	});
}

function compareSalaryForDepartments(urlPrefix){
	
	var depts = [];
	$.each($("input[name='dept']:checked"), function() {
		depts.push($(this).val());
	});

	if (depts.length < 2) {
		alert("Please select two or more departments for salary comparison");
		return;
	}
	
	var url = urlPrefix + "/" + depts.join(",") + "/avgsalary";
	
	$.getJSON(url, null, function(departmentAvgSalaryList){
		
		if(departmentAvgSalaryList.length > 0){
						
			var sourceBarChartTable = "<table id=\"barChartSource\" >";
			sourceBarChartTable = sourceBarChartTable + "<caption>Average Salary By Deapartment</caption>";
			sourceBarChartTable = sourceBarChartTable + "<thead><tr><th></th><th></th></tr></thead>";
			sourceBarChartTable = sourceBarChartTable + "<tbody>";
			
			for(var i=0; i<departmentAvgSalaryList.length; i++){
				
				var deptSalRecord = departmentAvgSalaryList[i];
				
				sourceBarChartTable = sourceBarChartTable + "<tr>";
		
				sourceBarChartTable = sourceBarChartTable + "<th>";
				sourceBarChartTable = sourceBarChartTable + deptSalRecord[0];
				sourceBarChartTable = sourceBarChartTable + "</th>";
				sourceBarChartTable = sourceBarChartTable + "<td>";
				sourceBarChartTable = sourceBarChartTable + deptSalRecord[1];
				sourceBarChartTable = sourceBarChartTable + "</td>";

				sourceBarChartTable = sourceBarChartTable + "</tr>";
			}
			
			sourceBarChartTable = sourceBarChartTable + "</tbody></table>";
			
			$('#salaryComparisonBarChartSource').append(sourceBarChartTable);
			
			$('#barChartSource').tableBarChart('#salaryComparisonBarChartTarget', '', false);
			
		}else{
			alert('No salary comparison data found for selected departments');
		}
		
	});
}