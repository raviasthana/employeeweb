<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page session="false" %>

<style>
	.errorBlock {
		color: #ff0000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
</style>

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
				
				<h3>Please login to get access to HR application</h3>
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL}">
					<div class="errorBlock">
						Your login attempt was not successful, try again. <br/>
						Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</div>
				</c:if>
				
				<form name="login_form" action="<c:url value="../j_spring_security_check" />" method='POST'>					
					<table>
						<tr>
							<td>User:</td>
							<td><input type="text" name="j_username" value="" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="j_password" /></td>
						</tr>
					</table>
					<p>
					<div style="width: 250px;">
						<div style="float: left;">
							<input type="submit" name="submit" value="submit" />
						</div>
						<div style="float: right;">
							<input type="reset" name="reset" />
						</div>
					</div>					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
				
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
