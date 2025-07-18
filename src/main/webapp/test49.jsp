<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.test.apis.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<c:catch var="err">
	<!-- https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx -->
	<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx" var="data"></c:import>
	
	<c:set var="foods" value="${Testutils.parseFood(data) }"></c:set>
	
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/test"
		user="root"
		password="root"			
	/>
	
	<sql:update>DELETE FROM food</sql:update>
	<sql:update>ALTER TABLE food AUTO_INCREMENT = 1</sql:update>
	
	<c:forEach items="${foods }" var="food">
		<sql:update>
			INSERT INTO food (name, tel, addr) VALUES (?,?,?)
			<sql:param>${food.name }</sql:param>
			<sql:param>${food.tel }</sql:param>
			<sql:param>${food.addr }</sql:param>
		</sql:update>
	</c:forEach>
</c:catch>



	

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${!empty err }">${err }</c:when>
		<c:otherwise>Finish</c:otherwise>
		</c:choose>
	</body>
</html>