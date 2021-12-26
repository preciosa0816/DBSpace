<%@page import="java.sql.*"  %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	Connection c = DriverManager.getConnection(url, "madang", "madang");
	Statement st = c.createStatement();
	String bookid = request.getParameter("bookid");
	ResultSet rs = st.executeQuery("select * from book where bookid='"+bookid+"'"); 
	if(rs!=null){rs.next();
 %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>** Book VIEW **</title>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">
<table border="1" cellspacing="0" width="400" bordercolor="#9AD2F7"
		bordercolordark="white" bordercolorlight="#B9E0FA">
	<tr>
		<td width="150" height="23">
			<p align="center">
			<span style = "font-size:9pt;">책 제 목 </span></p>		
		</td>
		<td width="513">
			<p><span style = "font-size:9pt;" >
			<%=rs.getString("BOOKNAME") %></span></p>		
		</td>
	</tr>
	<tr>
		<td width="150" height="23">
			<p align="center">
			<span style = "font-size:9pt;">출 판 사 </span></p>		
		</td>
		<td width="513">
			<p><span style = "font-size:9pt;" >
			<%=rs.getString("PUBLISHER") %></span></p>		
		</td>
	</tr>
	<tr>
		<td width="150" height="23">
			<p align="center">
			<span style = "font-size:9pt;">가 격 </span></p>		
		</td>
		<td width="513">
			<p><span style = "font-size:9pt;" >
			<%=rs.getString("PRICE") %></span></p>		
		</td>
	</tr>
</table>
<table cellpadding="0" cellspacing="0" width="400" height="23">
	<tr>
		<td width="150">
			<p align="right"><span style = "font-size:9pt;">
			<a href="booklist.jsp?">
			<font color="black">목록</font></a></span></p>
		</td>
	</tr>
</table>	
<%
	}
	st.close();
	c.close();
%>
</body>
</html>



