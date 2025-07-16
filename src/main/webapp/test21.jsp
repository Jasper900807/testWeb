<%@page import="java.util.TreeSet"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name"); 
	if (name == null) name = "world";
	// HashSet<Integer> lotterys = new HashSet<>();
	TreeSet<Integer> lotterys = new TreeSet<>();
	while (lotterys.size() < 6) {
		lotterys.add((int)(Math.random()*49+1));
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>Hello, <% out.print(name); %></div>
		<div>lottery: <%= lotterys %></div>
		<hr>
	</body>
</html>