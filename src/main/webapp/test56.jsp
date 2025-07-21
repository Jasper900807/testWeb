<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	Object obj = session.getAttribute("x");
	if (obj == null) {
		//response.sendError(, "get out");
	}

%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Im test56 <br>
		x = ${x } <br>
		y = ${y } <br>
		z = ${z } <hr>
		a1[2] = ${a1[2] }; <br>
		b1 = ${b1 } <br>
		<a href="test57.jsp">test56</a>
	</body>
</html>