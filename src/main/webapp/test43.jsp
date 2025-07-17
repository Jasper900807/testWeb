<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] names = {"Brad", "Amy", "Tony", "Eric", "Peter", "Mark", "May"};
	pageContext.setAttribute("names", names);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table width="100%" border="1">
			<tr>
				<th>Index</th>
				<th>Count</th>
				<th>Name</th>
				<th>First</th>
				<th>Last</th>
			</tr>
			<c:forEach items="${names}" var="name" varStatus="status">
				<tr>
					<td>${status.index }</td>
					<td>${status.count }</td>
					<td>${name }</td>
					<td>${status.first }</td>
					<td>${status.last }</td>
				</tr>				
			</c:forEach>
		</table>
	</body>
</html>