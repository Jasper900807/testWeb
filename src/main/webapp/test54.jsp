<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.test.apis.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<c:catch var="err">
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/north"
		user="root"
		password="root"
	/>
	<sql:query var="rs">
		SELECT * FROM orders o 
		JOIN customers c ON (o.CustomerID = c.CustomerID)
		JOIN employees e ON (o.EmployeeID = e.EmployeeID)
		JOIN orderdetails od ON (o.OrderID = od.OrderID)
		JOIN products p ON (od.ProductID = p.ProductID)
		WHERE o.OrderID = ?
		<sql:param>${param.orderId }</sql:param>
	</sql:query>
	${Testutils.orderToJSON(rs.rows) }
	

</c:catch>
${err }