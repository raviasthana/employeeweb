<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page session="false" %>

<div id="wrapper">
	<div class="header">
		<jsp:include page="header.jsp" />
	</div>

	<div class="nav-bar">
		<div class="container">
			<ul class="nav">
				<li>
					<a href="<c:url value="/hrweb/j_spring_security_logout" />">Logout</a>
				</li>
			</ul>
		</div>
	</div>
		
	<div class="content">
		<div class="container">
			<div class="main">
				<p>Welcome to HR application. Please use the following links to
					retrieve employee information.
				<ul>
					<security:authorize ifAnyGranted="EMPLOYEE">
						<li><a href="<c:url value="employee" />">
								Get list of all existing employees
							</a>
						</li>
					</security:authorize>
					<security:authorize ifAnyGranted="DEPARTMENT">
						<li><a href="<c:url value="department" />">
								Salary Comparison
							</a>
						</li>
					</security:authorize>		
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
