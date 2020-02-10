<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${message}</title>
</head>
<body>
	<form:form actio="${pageContext.request.contextPath}/add-user" modelAttribute="userObj">
		<form:input path="userMobileNumber" /><br>
		<form:input path="userName" /><br>
		<form:input path="userAddress" /><br>
		<input type="submit" name="submit" value="ADD USER" />
	</form:form>
</body>
</html>