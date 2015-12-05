<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<div id="wrapper">
	<div class="header">
		<jsp:include page="header.jsp" />
	</div>

	<div class="nav-bar">
		<div class="container">
			<ul class="nav">
				<li>&nbsp;</li>
			</ul>
		</div>
	</div>
		
	<div class="content">
		<div class="container">
			<div class="main">
				<p>Welcome to HR application. Please use the following links to
					retrieve employee information.
				<ul>
					<li><a href="<c:url value="employee" />">Get list of all
							existing employees</a></li>
					<li><a href="<c:url value="department" />">Salary
							Comparison</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="footer">
		<div class="container">
			&copy; Copyright 2015
		</div>	
	</div>
</div>

<!-- ${controllerMessage} -->
