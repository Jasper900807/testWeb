<%@page import="tw.test.apis.Bike"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HashMap<String, Object> person = new HashMap<>();
	person.put("name", "Brad");
	person.put("age", 10);
	person.put("gender", false);
	Bike bike = new Bike(); bike.upSpeed().upSpeed().upSpeed().upSpeed();
	person.put("bike", bike);
	pageContext.setAttribute("person", person);

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Name: ${person.name } <br>
		Age: ${person.age } <br>
		Bike: ${person.bike.getSpeed() } <br>
	</body>
</html>