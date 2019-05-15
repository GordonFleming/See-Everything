<%-- 
    Document   : test
    Created on : 30-Jan-2019, 17:41:47
    Author     : flemi
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="database.DbConnection"%>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="Map.css" />
  <script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
  <script type="text/javascript" src="Map.js"></script>
</head>
<body bgcolor=yellow>
    <%
    try
    {
        String query="select * from tblVenues";
        DbConnection dbconn=new DbConnection(); 
        Connection myconnection = dbconn.Connection();
        Statement stm = myconnection.createStatement();
        ResultSet rs = stm.executeQuery(query);%>
    %><table border=1 align=center style="text-align: center">
        <%while(rs.next())
        {
            %>
            <tr>
                <td><%out.print(rs.getString("Name"));%></td>

            </tr>
            <%
        }%>
        </table><br>
    <%}
    catch(SQLException e){
        out.print(e.getMessage());%><br><%
    }
    %>
</body>
</html>