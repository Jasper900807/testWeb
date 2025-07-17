<%@page import="jakarta.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="showResult" value="${not empty param.id or not empty param.cname}" />


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="editSQL.jsp">
			<select name="method">
				<option value="1" ${param.method == 1?"selected":"" }>SELECT</option>
				<option value="2" ${param.method == 2?"selected":"" }>INSERT</option>
				<option value="3" ${param.method == 3?"selected":"" }>UPDATE</option>
				<option value="4" ${param.method == 4?"selected":"" }>DELETE</option>
			</select>
			<input type="submit" value="確認">
		</form>
		<hr>
		<form action="editSQL.jsp">
			<c:choose>
				<c:when test="${param.method == 1 }">
					<input type="hidden" name="method" value="${param.method}">
					SELECT * <br>
					FROM cust <br>
					WHERE id = <input name="id"> <br>
				</c:when>

				<c:when test="${param.method == 2 }">
					<input type="hidden" name="method" value="${param.method}">
					INSERT INTO cust <br>
					VALUES (cname,tel,birthday) = ( <input name="cname">, <input name="tel">, <input name="birthday"> ) <br>
				</c:when>
				
				<c:when test="${param.method == 3 }">
					<input type="hidden" name="method" value="${param.method}">
					UPDATE cust <br>
					SET cname = <input name="cname">, tel = <input name="tel"> <br>
					WHERE id = <input name="id">
				</c:when>
				
				<c:when test="${param.method == 4 }">
					<input type="hidden" name="method" value="${param.method}">
					DELETE FROM cust <br>
					WHERE id = <input name="id"> <br>
				</c:when>
				
			</c:choose>
			<input type="submit" value="送出">
		</form>
		<hr>
		<c:if test="${showResult }">
			<jsp:include page="resultSQL.jsp" />
		</c:if>
		
	</body>
</html>