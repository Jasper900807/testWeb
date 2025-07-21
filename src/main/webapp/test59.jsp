<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="test" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Test Company</h1>
		<hr>
		<test:test1 /> <br>
		<test:test2 /> <br>
		<test:test3 /> <br>
		<table width="100%" border="1">
			<tr>
				<th>Name</th>			
				<th>Price</th>
			</tr>
			<test:test4 pname="mouse" price="100" />
			<test:test4 pname="PS5" price="20000" />
			<test:test4 pname="keyboard" price="123456" />
		</table>
	</body>
</html>