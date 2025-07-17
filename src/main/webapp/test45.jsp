<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:catch var="err">
			<sql:setDataSource
				driver="com.mysql.cj.jdbc.Driver"
				url="jdbc:mysql://localhost/test"
				user="root"
				password="root"			
			/>
			<sql:update var="n1">
				UPDATE cust SET cname = 'bbb' WHERE id >= 9
			</sql:update>
			
			<sql:update var="n2">
				DELETE FROM cust WHERE id >= 9
			</sql:update>
			
			Update: ${n1 } <br>
			Delete: ${n2 } <br>
		</c:catch>
		${err } <br>
		OK
	</body>
</html>