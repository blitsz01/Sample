<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Password</title>
</head>
<style>
	.error{
		color: #ff0000;
	}
	.errorBlock{
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
</style>
<body>
	<h2>User Information</h2>
<form:form method = "POST" action = "/HelloPassword/infoDisplay" modelAttribute = "user">
<form:errors path = "*" cssClass = "errorBlock" element = "div" />
	<table>
		<tr>
			<td><form:label path = "username">User Name</form:label></td>
			<td><form:input path = "username" /></td>
		</tr>
		<tr>
			<td><form:label path = "password">Password</form:label></td>
			<td><form:password path = "password" /></td>
		</tr>
		<tr>
			<td><form:label path = "address">Address</form:label></td>
			<td><form:textarea path = "address" rows = "5" cols = "30"/></td>
		</tr>
		<tr>
			<td><form:label path = "receivePaper">Subscribe Newsletter</form:label></td>
			<td><form:checkbox path = "receivePaper" /></td>
		</tr>
		<tr>
			<td><form:label path = "favoriteFrameworks">Favorite Web Frameworks</form:label></td>
			<td><form:checkboxes items = "${ webFrameworkList }" path = "favoriteFrameworks" /></td>
		</tr>
		<tr>
			<td><form:label path = "gender">Gender</form:label></td>
			<td><form:radiobutton path = "gender" value = "M" label = "Male"/>
				<form:radiobutton path = "gender" value = "F" label = "Female"/>
				<form:radiobutton path = "gender" value = "NS" label = "Not Sure"/></td>
		</tr>
		<tr>
			<td><form:label path = "paymentType">Favorite Web Frameworks</form:label></td>
			<td><form:radiobuttons items = "${ paymentTypeList }" path = "paymentType" /></td>
		</tr>
		<tr>
			<td><form:label path = "country">Country</form:label></td>
			<td>
				<form:select path = "country">
					<form:option value = "NONE" label = "Select"/>
					<form:options items = "${ countryList }"/>
				</form:select>
			</td>
		</tr>
		<tr>
			<td colspan = "2">
				<input type = "submit" value = "Submit" />
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>