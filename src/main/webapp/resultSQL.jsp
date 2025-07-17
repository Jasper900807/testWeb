<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<c:catch var="err">
<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/test"
		user="root"
		password="root"			
	/>
	<c:choose>
		<c:when test="${param.method == 1 }">
			<sql:query var="rs">
				SELECT * FROM cust WHERE id = ?
				<sql:param>${param.id }</sql:param>
			</sql:query>
		</c:when>
		
		<c:when test="${param.method == 2 }">
			<sql:update var="rs">
				INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)
				<sql:param>${param.cname }</sql:param>
				<sql:param>${param.tel }</sql:param>
				<sql:param>${param.birthday }</sql:param>
			</sql:update>
		</c:when>
		
		<c:when test="${param.method == 3 }">
			<sql:update var="rs">
				UPDATE cust SET cname = ?, tel = ? WHERE id = ?
				<sql:param>${param.cname }</sql:param>
				<sql:param>${param.tel }</sql:param>
				<sql:param>${param.id }</sql:param>
			</sql:update>
		</c:when>
		
		<c:when test="${param.method == 4 }">
			<sql:update var="rs">
				DELETE FROM cust WHERE id = ?
				<sql:param>${param.id }</sql:param>
			</sql:update>
		</c:when>
	</c:choose>
	
</c:catch>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
	<c:choose>
		<c:when test="${param.method == 1 }">
			<c:choose>
				<c:when test="${rs.rowCount>0 }">
					<table width="100%" border="1">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Tel</th>
							<th>Birthday</th>
						</tr>
						<c:forEach items="${rs.rows }" var="cust">
							<tr>
								<td>${cust.id }</td>
								<td>${cust.cname }</td>		
								<td>${cust.tel }</td>
								<td>${cust.birthday }</td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>Failed</c:otherwise>
			</c:choose>
			
			
		</c:when>
		
		<c:when test="${param.method == 2 }">
			<c:choose>
				<c:when test="${rs>0 }">Success</c:when>
				<c:otherwise>Fail</c:otherwise>
			</c:choose>
		</c:when>
		
		<c:when test="${param.method == 3 }">		
			<c:choose>
				<c:when test="${rs>0 }">Success</c:when>
				<c:otherwise>Fail</c:otherwise>
			</c:choose>
		</c:when>
		
		<c:when test="${param.method == 4 }">
			<c:choose>
				<c:when test="${rs>0 }">Success</c:when>
				<c:otherwise>Fail</c:otherwise>
			</c:choose>
		</c:when>
	</c:choose>
	
	</body>
</html>