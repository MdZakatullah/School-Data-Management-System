<%@page import="com.srt.studentdatamanagement.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Student s=(Student) session.getAttribute("student");
if(s!=null){%>
<h1>Welcome to Student Menu</h1>
<%}else{ %>
Please provide user name and password for accessing the feature
<%} %>

</body>
</html>