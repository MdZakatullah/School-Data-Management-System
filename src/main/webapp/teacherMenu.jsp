<%@page import="com.srt.studentdatamanagement.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Teacher t=(Teacher) session.getAttribute("teacher");
if(t!=null){%>
<h1>Welcome to Teacher Menu</h1>
<%}else{ %>
Please provide user name and password for accessing the feature
<%} %>

</body>
</html>