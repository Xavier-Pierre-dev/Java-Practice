<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Veuillez vous authentifier</h1>
	<h2><%= new Date() %></h2>
	
	<% for(int i=1; i<=6; i++){ %>
		<h<%= i %>>Titre de niveau <%= i %></h<%= i %>>
	<% } %>
</body>
</html>