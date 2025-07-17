<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- default scope="page" -->
		<c:set var="x" value="10"></c:set>		
		x = ${x } <br>
		<c:set var="x" value="123" scope="request"></c:set>
		x = ${pageScope.x } <br>
		x = ${requestScope.x } <br>
		<c:set var="y" >777</c:set>
		y = ${y } <br>
		<hr>
		<c:out value="Hello world"></c:out> <br>
		param.x = ${param.x } <br>
		param.x = <c:out value="${param.x }" default="OK"></c:out>
		<hr>
		<jsp:useBean id="member" class="tw.test.apis.Member"></jsp:useBean>
		
		<c:set target="${member }" property="id">2</c:set>
		<c:set target="${member }" property="account">test123</c:set>
		<c:set target="${member }" property="name">Name456</c:set>
		${member.id } : ${member.account } : ${member.name } <br>
		${member } <br>
		<c:remove var="member"/>
		<c:out value="----"></c:out>
		${member } <br>
		
	</body>
</html>