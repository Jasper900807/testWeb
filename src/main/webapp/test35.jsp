<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (!request.getMethod().equals("POST")) {
		response.sendError(405, "只接受POST");		
	}
 
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Account: ${param.account }<br>
		Habit: <br>
		1. ${paramValues.habit[0]} <br>
		2. ${paramValues.habit[1]} <br>
		3. ${paramValues.habit[2]} <br>
		4. ${paramValues.habit[3]} <br>
		5. ${paramValues.habit[4]} <br>
		6. ${paramValues.habit[5]} <br>
	</body>
</html>