<!-- http://211.183.8.23:8080/JavaDB_Web/booklist.jsp -->

<%@page import="java.sql.*"  %>  
<!-- ----java.sql.뒤에 붙은거 전부 다 import -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	Connection c = DriverManager.getConnection(url, "madang", "madang");
	Statement st = c.createStatement();
	String select = "select * from book";
	ResultSet rs = st.executeQuery(select); 
 %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>** BOOK LIST **</title>
</head>
<body bgcolor="white" text="black" link="blue" vlink="purple" alink="red">
<table border="1" cellspacing="0" width="400" bordercolor="#9AD2F7"
bordercolordark="white" bordercolorlight="#B9E0FA">
	<tr>
		<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
				<span style="font-size:8pt;"><b>BOOKNAME</b></span></p>
		</td>
		<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
				<span style="font-size:8pt;"><b>PUBLISHER</b></span></p>
		</td>
		<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
				<span style="font-size:8pt;"><b>PRICE</b></span></p>
		</td>
	</tr>
	<%
		if(rs != null) {
			while(rs.next()) {
				String W_BOOKID=rs.getString("bookid");
				String W_BOOKNAME=rs.getString("bookname");
				String W_PUBLISHER=rs.getString("publisher");
				String W_PRICE=rs.getString("price");							
			%>
	<tr>
		<td width="150" height="20">
			<p><span style="font-size:9pt;">
			<a href="bookview.jsp?bookid=<%=W_BOOKID %>">
			<font face="돋움체"  color="black">
			<%=W_BOOKNAME %></font></a></span></p>
		</td>
			<td width="150" height="20">
				<p align="center"><span style="font-size:9pt;">
				<font face="돋움체" ><%=W_PUBLISHER %></font></span></p>			
			</td>
			<td  width="150" height="20">
				<p align="center"><span style="font-size:9pt;">
				<font face="돋움체" ><%=W_PRICE %></font></span></p>	
			</td>
	</tr>
<%
			}
		}
	st.close();
	c.close();
			
%>
</table>
<table cellpadding="0" cellspacing="0" width="400" height="23">
	<tr>
		<td width="1350">
			<p align="left"><b><a href="booklist.jsp">
			<font size="1"  face="돋움체"  color="black">LIST</font></a></b></p>
		</td>
	</tr>
</table>
</body>
</html>


<%---------------------------------
<% 이 안에 있는 내용은 자바 관련 내용  %>
<이 안에 있는 내용은 html(client)에게 보내는 내용> 
-------------------------------------%>