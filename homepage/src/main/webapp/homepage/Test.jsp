<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String ID = "root";
		String PWD = "tjddnjs18!@";
		String PORTNO = "3306";
		String DBNAME = "MySQL";
		String TIMEZONE = "serverTimeZone=UTC";
		
		String Query = "jdbc:mysql://localhost:" + PORTNO + "/" + DBNAME + "?" + TIMEZONE;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(Query, ID, PWD);
		
		if (conn != null){
			out.println("WebDb 연결. <br>");
			conn.close();
			out.println("연결 해제<br>");
		}
		else{
			out.println("Webdb 연결 할 수 없습니다. <br>");
		}
	 %>

</body>
</html>