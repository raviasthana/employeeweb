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

function showLightbox() {
	
	var box = document.getElementById('box'); 
	document.getElementById('shadowing').style.display='block';	
	
	document.body.style.overflow = 'hidden';
	box.style.display = 'block';
}

function closebox()
{
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
		
		var deptTable = "<table id=\"hor-minimalist-a\" summary=\"Department List\">";
		deptTable = deptTable + "<thead align=\"left\">";
		deptTable = deptTable + "<tr>";
		deptTable = deptTable + "<th scope=\"col\">Select departments for salary comparison</th>";
		deptTable = deptTable + "</tr>";
		deptTable = deptTable + "</thead>";
		deptTable = deptTable + "<tbody>";
		
		for(var i=0; i < departmentList.length; i++){
			deptTable = deptTable + "<tr>";
			deptTable = deptTable + "<td><label>";
			deptTable = deptTable + "<input type=\"checkbox\" value=\"" + departmentList[i].departmentId + "\" name=\"dept\">";
			deptTable = deptTable +	departmentList[i].departmentName
			deptTable = deptTable + "</label></td>";
			deptTable = deptTable + "</tr>";
		}
		
		deptTable = deptTable + "</tbody></table>";
		
		$('#departmentList').append(deptTable);
	});
}