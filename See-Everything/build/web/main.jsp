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
        <script src="stretchy.min.js" async></script>
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
        
        <header><h2 align="center" ><font face="Arial" color="white">&ensp;&ensp;See Everything | St John's College</font></h2></header>
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
        
                                                    <!-- Query Form -->
        <div class = "top-query-form" id="container-query">
            <center><h3>Query Form</h3></center>
            <form class="form-inline" autocomplete="off">
                <label>Field</label>
                <select name="field">
                    <option value = "-1">StaffName</option>                    
                </select>
                <label>Function</label>
                <select name="function">
                    <option value = "-1">Contains</option>  
                    <option value = "0">Does not contain</option>
                    <option value = "1">Equal</option>
                    <option value = "2">Not equal</option>
                    <option value = "3">Begins with</option>
                    <option value = "4">Greater than</option>
                    <option value = "5">Less than</option>
                </select>
                <label>Parameters</label>
                <input type="text" name="firstname" value="">
                <label><input class="Tick_Submit" type="submit" value="✎" ></label>
            </form>                                            
        </div>
                                                                                                       
                                                    <!-- Booking Form -->
        <div class = "right-booking-form" id="conainer-booking">
            <form autocomplete="on">
                <h3>Booking Form</h3>          
                <h4>Venue:</h4> 
                <select name="venues">
                <option value="-1">Select venue</option>
                    <%                  
                        String Query1 = "SELECT * FROM tblVenues";
                        Class.forName("org.sqlite.JDBC");
                        String urlHome = "jdbc:sqlite:C://Users/flemi/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
                        String urlSchool = "jdbc:sqlite:C://Users/24740/Documents/GitHub/See-Everything/See-Everything/SJC_DB.db";
                        Connection conn = null;
                        try{
                        conn = DriverManager.getConnection(urlSchool);
                        Statement stm = conn.createStatement();
                        ResultSet rs = stm.executeQuery(Query1);
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
                </select>
                <br>
                <h4>Day:</h4> 
                <select name="Day">
                    <option value = "Monday">Monday</option>
                    <option value = "Tuesday">Tuesday</option>
                    <option value = "Wednesday">Wednesday</option>
                    <option value = "Thursday">Thursday</option>
                    <option value = "Friday">Friday</option>
                </select>
                <h4>Week:</h4>
                    <input type="radio" name="week" value="Blue" id="radio-one2" class="form-radio2" checked><label for="radio-one">Blue</label>
                    <input type="radio" name="week" value="Maroon" id="radio-one1" class="form-radio1"><label for="radio-one">Maroon</label>
                <h4>Period:</h4>
                <select name="Day">
                    <option value = "0">Period 0</option>
                    <option value = "1">Period 1</option>
                    <option value = "2">Period 2</option>
                    <option value = "3">Period 3</option>
                    <option value = "4">Period 4</option>
                    <option value = "5">Period 5</option>
                    <option value = "6">Period 6</option>
                    <option value = "7">Period 7</option>
                    <option value = "8">Period 8</option>
                    <option value = "9">Period 9</option>
                </select>
                <h4>Staff Name:</h4>
                <input type="text" name="firstname" value="">
                <h4>Activity:</h4>
                <select name="venues">
                <option value="-1">Select activity</option>
                    <%                  
                        String Query2 = "SELECT * FROM tblActivities";
                        try{
                        conn = DriverManager.getConnection(urlSchool);
                        Statement stm = conn.createStatement();
                        ResultSet rs = stm.executeQuery(Query2);
                        while(rs.next()){
                            %>
                            <option value = "<%=rs.getInt("ActivityID")%>"><%=rs.getString("Activity")%></option>
                            <%
                        }                    
                    }catch(Exception ex){
                        ex.printStackTrace();
                        out.print("Error "+ex.getMessage());
                    }           
                    %>
                </select>
                <h4>Date:</h4>
                <input type="date" id="start" name="trip-start"value="yyyy-mm-dd"min="2019-01-01">
                <br><br>
                <input class="Submit" type="submit" value="Submit">
            </form>                
        </div>
                       
                                                    <!-- Footer displays the users name and email -->
        <footer>                                                                      
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
                <div class="bottom-right-help">
                    <a href="img/LoginGUIplanV3.png" target="_blank"><p src="img/SJCfavicon.png" title="Need Help?"><font size = 4 color = #e2e519>Help?</font></p></a>
                </div>
            </center>
        </footer>
    </body>
</html>