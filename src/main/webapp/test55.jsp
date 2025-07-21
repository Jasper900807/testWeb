<%@page import="tw.test.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int x = (int)(Math.random()*49+1);
	session.setAttribute("x", x);
	pageContext.setAttribute("y", x);
	request.setAttribute("z", x);
	
	int[] a1 = {1,2,3,4};
	session.setAttribute("a1", a1);
	a1[2] = 100;
	
	Bike b1 = new Bike();
	b1.upSpeed().upSpeed().upSpeed().upSpeed().upSpeed().upSpeed();
	session.setAttribute("b1", b1);
	
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		x = ${x } <br>
		y = ${y } <br>
		z = ${z } <br>
		b1 = ${b1 } <br>
		<% b1.upSpeed().upSpeed().upSpeed().upSpeed(); %>
		<a href="test56.jsp">test56</a>
	</body>
</html>