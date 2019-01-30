<%-- 
    Document   : success
    Created on : 27-Jan-2019, 12:05:10
    Author     : flemi
--%>

 
        <%
        String img = (String)request.getParameter("myImg");
        String name = (String)request.getParameter("name");
        String email = (String)request.getParameter("email");
        %>
        <%=img %>
    <br>
        <%=name %> 
    <br>
        <%=email %> 
    <br>
