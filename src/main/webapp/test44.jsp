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
			<sql:update>
				INSERT INTO cust (cname,tel,birthday) VALUES ('aaa','123','1989-07-13'),
				('bbb','123','1989-07-13'), ('ccc','123','1989-07-13')
			</sql:update>
		</c:catch>
		${err } <br>
		OK
	</body>
</html>