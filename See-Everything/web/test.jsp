<%-- 
    Document   : test
    Created on : 30-Jan-2019, 17:41:47
    Author     : Gordon Fleming
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
<form method="post">

<table border="2">
<tr>
<td>Time</td>
<td>StaffName</td>
<td>Venue</td>
</tr>
<%
try
{
Class.forName("org.sqlite.JDBC");
String url="jdbc:sqlite:C://Users/flemi/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
String query="SELECT strftime('%H:%M', time('now','-9 hours'))as 'Time', Surname as StaffName, venue\n" +
                                        "FROM tblTimeTablesLocation\n" +
                                        "LEFT JOIN tblStaff on tblStaff.StaffID=tblTimeTablesLocation.StaffID,\n" +
                                        "(SELECT PeriodName FROM tblTimings\n" +
                                        "WHERE time('now','-9 hours') BETWEEN StartTime and EndTime\n" +
                                        "AND week = 'Maroon' \n" +
                                        "AND WeekdayCode = strftime('%w',date('now')))subquery1\n" +
                                        "WHERE period = PeriodName\n" +
                                        "AND week = 'Maroon' \n" +
                                        "AND WeekdayCode = strftime('%w',date('now'))";
Connection conn=DriverManager.getConnection(url);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
    <tr>
    <td><%=rs.getString("Time") %></td>
    <td><%=rs.getString("StaffName") %></td>
    <td><%=rs.getString("venue") %></td>
</tr>
        <%

}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>

</form>
</html> 