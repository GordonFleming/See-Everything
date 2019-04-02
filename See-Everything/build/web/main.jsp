<%-- 
    Document   : main
    Created on : 27-Jan-2019, 12:05:10
    Author     : Gordon Fleming
--%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
        <link rel="shortcut icon" type="image/png" href="img/SJCfavicon.png">
        <link rel="stylesheet" type="text/css" href="StyleSheet.css" />
        <title>See Everything Main Page | St John's</title>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="1056145859345-trlkgoivq1slfk4kmjbvpo0vgfuj85il.apps.googleusercontent.com">
            <script type="text/javascript">
                function SignedIn(googleUser) {                                     /* Fetches user data from google */
                    var profile = googleUser.getBasicProfile();
                    var imagurl=profile.getImageUrl();
                    var name=profile.getName();
                    var email=profile.getEmail();
                    document.getElementById("myImg").src = imagurl;
                    document.getElementById("name").innerHTML = name;	
                    document.getElementById("myP").style.visibility = "hidden";	
		}
            </script>
            <script>
                function myFunction() {                                             /* Signs out */
                gapi.auth2.getAuthInstance().disconnect();
                location.reload(true);                                              /* Reloads to sign out the user */
                location.replace("http://localhost:8080/See-Everything/login.jsp"); /* Redirects to login page */
                }
            </script>
    </head>
    <body>
        
                                                    <! -- Other -->
        
        <h2 align="center" ><font face="Arial" color="white">See Everything | St John's College</font></h2>
            <div id = "hidden" class = "GSignInCentered">                     <!-- Hides the sign in button -->
                <div class="g-signin2" data-onsuccess="SignedIn"></div>               
            </div>
            <div class="top-left-GSignOut">                                 <!-- Displays the sign out button -->
                <button class="button" onclick="myFunction()"><span>Sign Out</button>  
            </div>
            <div class = "profile-details">                                 <!-- Displays the Users details -->
                <img id="myImg" style="width:70px;height:70px;">
                <br> 
                <p id="name"></p>  
            </div>
        <img src="img/MainPageGUIplanV2.png" alt="St John's Map" class="center">
        
                                                    <!-- Booking Form -->
        <div class = "right-booking-form">
            <form>
                <h3>Booking Form</h3> <br>               
                Venue: <br><br>
                <select name="venues">
                <option value="-1">Select venue</option>
                    <%                  
                        String Query = "SELECT VenueID, Name FROM tblVenues";
                        Class.forName("org.sqlite.JDBC");
                        String url = "jdbc:sqlite:C://Users/flemi/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
                        Connection conn = null;
                        try{
                        conn = DriverManager.getConnection(url);
                        Statement stm = conn.createStatement();
                        ResultSet rs = stm.executeQuery(Query);
                        while(rs.next()){
                            %>
                            <option value = "<%=rs.getInt("VenueID")%>"><%=rs.getString("Name")%></option>
                            <%
                        }                    
                    }catch(Exception ex){
                        ex.printStackTrace();
                        out.print("Error "+ex.getMessage());
                    }           
                    %>
                </select> <br><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        
        <footer>                                                            <!-- Footer displays the users name and email -->
            <center>
                <div class="bottom-left-info">
                    <%
                    String name = (String)request.getParameter("name");
                    String email = (String)request.getParameter("email");
                    %>
                    <%=name %>
                    <br>
                    <%=email %> 
                </div>
            </center>
        </footer>
    </body>
</html>