<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	Integer lottery = (Integer)request.getAttribute("lottery");
%>


Im test27 <hr>
x = <%= x %> <br>
y = <%= y %> <br>
lottery = <%= lottery %>
	