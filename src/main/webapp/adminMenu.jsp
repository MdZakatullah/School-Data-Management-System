<%@page import="com.srt.studentdatamanagement.entity.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Admin a=(Admin) session.getAttribute("admin");
if(a!=null){%>
<h1>Welcome to Admin Menu</h1>
<%}else{ %>
Please provide user name and password for accessing the feature
<%} %>

</body>
</html>