<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String start = request.getParameter("start");
	String rows = request.getParameter("rows");
	String cols = request.getParameter("cols");

	final int START = start==null?2:Integer.parseInt(start);
	final int ROWS = rows==null?3:Integer.parseInt(rows);
	final int COLS = cols==null?3:Integer.parseInt(cols);;
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Test Company</h1>
		<hr>
		<form action="test99.jsp">
			Start: <input type="number" name="start" />
			Rows: <input type="number" name="rows" />
			Columns: <input type="number" name="cols" />
			<input type="submit" name="change">
		</form>
		<hr>
		<table width='100%' border='1'>
			<%
				for(int k=0; k<ROWS; k++) {
					out.println("<tr>");
					for(int j=START+COLS*k; j<START+COLS*(k+1); j++) {
						if (k%2 == 0) {
							if (j%2 == 0)out.println("<td bgcolor='yellow'>");
							else out.println("<td bgcolor='pink'>");														
						}
						else {
							if (j%2 != 0)out.println("<td bgcolor='yellow'>");
							else out.println("<td bgcolor='pink'>");	
						}
						
						for (int i=1; i<=9; i++) {
							out.println(String.format("%d x %d = %d<br>", j, i, j*i));
						}	
						out.println("</td>");
					}
					out.println("</tr>");
				}
			%>
			
			
			
		</table>
	</body>
</html>