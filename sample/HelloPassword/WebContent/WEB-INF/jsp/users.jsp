<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
	<h2>Submitted User Information</h2>
	<table border ="1" cellspacing ="0" cellpadding="5" bordercolor="#000000"
	style="border-collapse: collapse">
		<tr>
		<th>Label</th>
		<th>Data</th>
		</tr>
		<tr>
			<td>User Name : </td>
			<td>${ username }</td>
		</tr>
		<tr>
			<td>Password : </td>
			<td>${ password }</td>
		</tr>
		<tr>
			<td>Address : </td>
			<td>${ address }</td>
		</tr>
		<tr>
			<td>Subscribe to Newsletter : </td>
			<td>${ receivePaper }</td>
		</tr>
		<tr>
			<td>Favorite Web Framework List : </td>
			<td><% String[] favoriteFrameworks = (String[])request.getAttribute("favoriteFrameworks");
				for(String framework: favoriteFrameworks){
					out.println(framework + "</br>");
				}
			%></td>
		</tr>
		<tr>
			<td>Gender : </td>
			<td><% String gender = (String)request.getAttribute("gender"); 
				if(gender.equals("M")){
					out.println("Male");
				}
				else if(gender.equals("F")){
					out.println("Female");
				}
				else {
					out.println("Confused");
				}		
			%>
			</td>
		</tr>
		<tr>
			<td>Payment Option : </td>
			<td>${ paymentType }</td>
		</tr>
		<tr>
			<td>Country : </td>
			<td>${ country }</td>
		</tr>
		<tr>
		<td colspan = "2"><a href="/HelloPassword/user">Back</a></td>
		</tr>
	</table>
</body>
</html>