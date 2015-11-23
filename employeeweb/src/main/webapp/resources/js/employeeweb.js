function viewEmployeeJobProfile(urlPrefix,empId){
	var url = urlPrefix + '/' + empId + "/jobhistory";
	$.getJSON(url, null, function(employeeDetails){
		clearbox();
		$('#jh_header').append("Job History: " + employeeDetails.firstName + " " + employeeDetails.lastName);
		
		var ejHistory = employeeDetails.jobHistory; 
		
		//alert(ejHistory);
		
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