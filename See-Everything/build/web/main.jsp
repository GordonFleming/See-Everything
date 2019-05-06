<%-- 
    Document   : main
    Created on : 27-Jan-2019, 12:05:10
    Author     : Gordon Fleming
--%>
<%@page import="database.Db_Connection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
        <link rel="shortcut icon" type="image/png" href="img/SJCfavicon.png">
        <link rel="stylesheet" type="text/css" href="StyleSheet.css" />
        <link rel="stylesheet" type="text/css" href="Map.css" />
        <title>See Everything Main Page | St John's</title>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <script type="text/javascript" src="cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
       
        <meta name="google-signin-client_id" content="1056145859345-trlkgoivq1slfk4kmjbvpo0vgfuj85il.apps.googleusercontent.com">
            <script type="text/javascript">
                function SignedIn(googleUser) {                                     /* Fetches user data from google */
                    var profile = googleUser.getBasicProfile();
                    var imagurl=profile.getImageUrl();
                    var name=profile.getName();
                    var email=profile.getEmail();
                    document.getElementById("myImg").src = imagurl;
                    document.getElementById("gname").innerHTML = name;	
                    document.getElementById("gmail").innerHTML = email;
		}
            </script>
            <script>
                function myFunction() {                                             /* Signs out */
                gapi.auth2.getAuthInstance().disconnect();
                location.reload(true);                                              /* Reloads to sign out the user */
                location.replace("http://localhost:8080/See-Everything/");          /* Redirects to login page */
                }
            </script>
    </head>
    <body>
        
                                                    <! -- Other -->
                                                    
        <header><h2 align="center" ><font face="Arial" color="white">&ensp;&ensp;See Everything | St John's College</font></h2></header>
            <div id = "hidden">                     <!-- Hides the sign in button -->
                <div class="g-signin2" data-onsuccess="SignedIn"></div>               
            </div>
            <div class="top-left-GSignOut">                                 <!-- Displays the sign out button -->
                <button class="button" onclick="myFunction()"><span>Sign Out</button>  
            </div>
            <div class = "profile-details">                                 <!-- Displays the Users details -->
                <img id="myImg" style="width:70px;height:70px;">
                <br> 
                <p id="gname"></p>  
            </div>
        <div class="center">
            <div class="map">
                <svg version="1.1" id="St_John_x27_s" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
                y="0px" width="841.68px" height="595.2px" viewBox="0 0 841.68 595.2" style="enable-background:new 0 0 841.68 595.2;"
                xml:space="preserve">
                <g id="C6">
                        <rect x="732.96" y="504.06" width="38.52" height="34.56"/>
                </g>
                <g id="C2">
                        <rect x="732.96" y="431.98" width="38.52" height="34.56"/>
                </g>
                <g id="C1">
                        <rect x="662.84" y="465.97" width="32.7" height="34.86"/>
                </g>
                <g id="P1">
                        <rect x="627.48" y="466" width="32.7" height="34.86"/>
                </g>
                <g id="P6">
                        <rect x="576.58" y="501.14" width="25.2" height="29.6"/>
                </g>
                <g id="P2">
                        <rect x="576.58" y="431.98" width="25.2" height="34.44"/>
                </g>
                <g id="B9">
                        <rect x="475.83" y="501.14" width="35.2" height="28.64"/>
                </g>
                <g id="B7">
                        <rect x="412.1" y="466.9" width="33" height="33"/>
                </g>
                <g id="B4">
                        <rect x="475.83" y="431.98" width="35.22" height="33.96"/>
                </g>
                <g id="B10">
                        <rect x="280.04" y="498.94" width="31.45" height="31.45"/>
                </g>
                <g id="B13">
                        <rect x="280.01" y="478.71" width="31.51" height="18.71"/>
                </g>
                <g id="B14">
                        <rect x="343.79" y="466.9" width="33.48" height="33.48"/>
                </g>
                <g id="B15">
                        <rect x="279.93" y="445.52" width="31.67" height="31.67"/>
                </g>
                <g id="B16">
                        <rect x="280.01" y="408.4" width="31.51" height="35.59"/>
                </g>
                <g id="REB">
                        <rect x="214.94" y="472.06" width="31.62" height="26.48"/>
                </g>
                <g id="E9">
                        <rect x="51.93" y="408.91" width="31.8" height="22.91"/>
                </g>
                <g id="E8">
                        <rect x="85.49" y="408.77" width="32.35" height="35.59"/>
                </g>
                <g id="E7">
                        <rect x="119.59" y="408.92" width="31.8" height="35.3"/>
                </g>
                <g id="E6">
                        <rect x="117.45" y="499.65" width="31.26" height="20.4"/>
                </g>
                <g id="E5">
                        <rect x="180.62" y="498.54" width="32.85" height="22.62"/>
                </g>
                <g id="E4">
                        <rect x="180.62" y="474.55" width="32.85" height="22.62"/>
                </g>
                <g id="E3">
                        <rect x="180.62" y="450.55" width="32.85" height="22.62"/>
                </g>
                <g id="E2">
                        <rect x="180.62" y="426.56" width="32.85" height="22.62"/>
                </g>
                <g id="E1">
                        <rect x="180.62" y="402.56" width="32.85" height="22.62"/>
                </g>
                <g id="G4">
                        <rect x="17.33" y="415.92" width="32.85" height="24.5"/>
                </g>
                <g id="G3">
                        <rect x="17.33" y="441.38" width="32.85" height="24.5"/>
                </g>
                <g id="G2">
                        <rect x="17.37" y="466.85" width="32.85" height="24.5"/>
                </g>
                <g id="G1">
                        <rect x="17.33" y="492.31" width="32.85" height="27.5"/>
                </g>
                <g id="His12B">
                        <path class="st0" d="M-37.46-50.7"/>
                        <rect x="17.95" y="349.6" width="31.7" height="28.35"/>
                </g>
                <g id="His12">
                        <rect x="17.95" y="303.37" width="31.7" height="44.88"/>
                </g>
                <g id="His9">
                        <rect x="50.78" y="359.17" width="31.7" height="28.35"/>
                </g>
                <g id="His8">
                        <rect x="83.54" y="359.17" width="31.7" height="28.35"/>
                </g>
                <g id="His7">
                        <rect x="148.71" y="349.6" width="31.7" height="28.35"/>
                </g>
                <g id="_x34_4">
                        <rect x="246.48" y="292.32" width="32.92" height="45.91"/>
                </g>
                <g id="_x33_9">
                        <rect x="440.48" y="282.19" width="35.36" height="35.36"/>
                </g>
                <g id="_x34_2">
                        <rect x="312.89" y="279.22" width="31.7" height="35.36"/>
                </g>
                <g id="_x36_4">
                        <rect x="735.04" y="208.71" width="38.24" height="29.18"/>
                </g>
                <g id="_x36_5">
                        <rect x="654.72" y="238.85" width="38.24" height="29.18"/>
                </g>
                <g id="_x36_6">
                        <rect x="694.88" y="238.85" width="38.24" height="29.18"/>
                </g>
                <g id="_x36_7">
                        <rect x="735.04" y="238.85" width="38.24" height="29.18"/>
                </g>
                <g id="_x36_8">
                        <rect x="694.88" y="208.71" width="38.24" height="29.18"/>
                </g>
                <g id="_x36_9">
                        <rect x="654.72" y="208.71" width="38.24" height="29.18"/>
                </g>
                <g id="_x32_8">
                        <rect x="46.6" y="92.74" width="32.14" height="36.04"/>
                </g>
                <g id="_x32_9">
                        <rect x="83.49" y="118.97" width="31.8" height="28.63"/>
                </g>
                <g id="_x33_0">
                        <rect x="116.26" y="118.97" width="31.8" height="28.63"/>
                </g>
                <g id="_x33_1">
                        <rect x="149.03" y="118.97" width="31.8" height="28.63"/>
                </g>
                <g id="_x33_2">
                        <rect x="181.8" y="118.97" width="31.8" height="28.63"/>
                </g>
                <g id="_x33_3">
                        <rect x="181.79" y="68.88" width="31.8" height="38.18"/>
                </g>
                <g id="_x33_4">
                        <rect x="148.75" y="68.88" width="31.8" height="38.18"/>
                </g>
                <g id="_x33_5">
                        <rect x="116.26" y="68.88" width="31.8" height="38.18"/>
                </g>
                <g id="_x31_4">
                        <rect x="214.5" y="217.48" width="31.35" height="31.35"/>
                </g>
                <g id="_x31_5">
                        <rect x="181.43" y="217.78" width="31.35" height="31.35"/>
                </g>
                <g id="_x31_6">
                        <rect x="148.97" y="217.78" width="31.35" height="31.35"/>
                </g>
                <g id="_x31_7">
                        <rect x="116.48" y="217.78" width="31.35" height="31.35"/>
                </g>
                <g id="_x34_7">
                        <rect x="247.27" y="197.86" width="31.35" height="35.29"/>
                </g>
                <g id="_x34_8">
                        <rect x="247.27" y="161.32" width="31.35" height="35.38"/>
                </g>
                <g id="_x35_0">
                        <rect x="280.62" y="118.97" width="31.8" height="28.63"/>
                </g>
                <g id="_x35_9">
                        <rect x="511.52" y="107.71" width="31.35" height="31.35"/>
                </g>
                <g id="_x36_0">
                        <rect x="544.11" y="107.71" width="31.35" height="31.35"/>
                </g>
                <g id="_x36_1">
                        <rect x="576.58" y="107.71" width="26.91" height="31.35"/>
                </g>
                <g id="MusGrn">
                        <rect x="731.2" y="107.71" width="41.11" height="30.02"/>
                </g>
                <g id="Dun">
                        <rect x="731.2" y="70.91" width="41.11" height="36.99"/>
                </g>
                <g id="_x37_0">
                        <rect x="628.34" y="69.8" width="30.98" height="35.81"/>
                        <path class="st0" d="M17.9-72.76"/>
                </g>
                <g id="_x33_6">
                        <rect x="83.49" y="68.88" width="31.8" height="38.18"/>
                </g>
                <g id="Other">
                        <polygon points="17.9,161.42 17.96,237.95 50.66,238.85 50.66,218.93 82.94,218.57 82.52,161.48 	"/>
                        <polygon points="628.4,110.67 628.34,138.65 730.04,137.64 730.04,137.64 730.04,70.82 730.04,70.82 661.1,69.8 661.1,69.8 
                                661.1,107.87 628.82,107.87 	"/>
                        <rect x="378.36" y="88.86" width="98.95" height="25.03"/>
                        <rect x="444.73" y="116.67" width="33.54" height="31.35"/>
                        <rect x="378.36" y="116.95" width="65.9" height="30.79"/>
                        <rect x="346.33" y="116.67" width="31.35" height="31.35"/>
                        <rect x="247.27" y="234.31" width="31.35" height="35.38"/>
                        <rect x="247.68" y="118.97" width="31.8" height="28.63"/>
                        <rect x="214.91" y="118.97" width="31.8" height="28.63"/>
                        <path class="st1" d="M74.03,314.58c0-8.13,5.43-14.71,12.13-14.71c4.04,0,8.08,0,12.13,0c0,4.9,0,9.8,0,14.71
                                c0,8.12-5.43,14.7-12.13,14.7C79.46,329.28,74.03,322.7,74.03,314.58z"/>
                        <path class="st1" d="M346.79,86.58c0,16.34-9.48,29.59-21.18,29.59c-11.7,0-21.18-13.25-21.18-29.59h10.59c0,10.5,4.74,19,10.59,19
                                c5.85,0,10.59-8.5,10.59-19H346.79z"/>
                        <path class="st2" d="M21,178.08c0-6.96,5.64-12.6,12.6-12.6c4.33,0,8.67-0.13,13-0.4c-0.27,4.33-0.4,8.67-0.4,13
                                c0,6.96-5.64,12.6-12.6,12.6S21,185.04,21,178.08z"/>
                        <path class="st1" d="M346.79,215.69c0-9.64,8.89-17.45,19.86-17.45c10.98,0,19.87,7.81,19.87,17.45c0,9.65-8.89,17.46-19.87,17.46
                                C355.68,233.15,346.79,225.34,346.79,215.69z"/>
                        <rect x="478.27" y="83.4" width="32.78" height="88.34"/>
                        <rect x="280.01" y="279.22" width="31.7" height="35.36"/>
                        <rect x="346.49" y="279.22" width="31.7" height="35.36"/>
                        <rect x="510.98" y="303.89" width="65.12" height="44.78"/>
                        <rect x="601.04" y="293.07" width="62.44" height="45.44"/>
                        <rect x="577.05" y="303.95" width="23.04" height="44.48"/>
                        <rect x="444.41" y="218.26" width="31.98" height="29.77"/>
                        <rect x="478.31" y="198.26" width="32.67" height="94.81"/>
                        <rect x="404.37" y="282.19" width="35.36" height="35.36"/>
                        <rect x="181.29" y="292.14" width="64.59" height="45.71"/>
                        <rect x="148.8" y="303.56" width="31.52" height="35.36"/>
                        <rect x="50.78" y="499.65" width="32.23" height="20.4"/>
                        <rect x="83.6" y="499.65" width="32.85" height="20.4"/>
                        <rect x="51.68" y="219.37" width="29.88" height="29.88"/>
                        <rect x="475.83" y="467.18" width="35.15" height="32.71"/>
                        <rect x="17.9" y="240.19" width="31.8" height="18.58"/>
                        <rect x="343.91" y="501.38" width="33.24" height="29.12"/>
                        <rect x="151.39" y="500.44" width="27.77" height="20.72"/>
                        <rect x="378.72" y="466.85" width="31.81" height="43.07"/>
                        <rect x="732.96" y="468.02" width="38.52" height="34.56"/>
                        <polygon points="378.72,511.26 378.72,530.74 445.1,530.74 444.63,500.78 412.29,500.78 411.91,511.26 	"/>
                        <rect x="576.58" y="467.18" width="25.2" height="33.19"/>
                </g>
                </svg>
            </div>
            </div>
                                                    <!-- Query Form -->
                                                    
        <div class = "top-query-form" id="container-query">
            <center><h3>Query Form</h3></center>
            <form class="form-inline" autocomplete="off">
                <label>Field</label>
                <select name="field">
                    <option value = "staffName">Staff Name</option>  
                    <option value = "venue">Venue</option>
                    <option value = "activity">Activity</option>
                    <option value = "date">Date</option>
                </select>
                <label>Function</label>
                <select name="function">
                    <option value = "like">Contains</option>  
                    <option value = "=">Equal</option>
                    <option value = "!=">Not equal</option>
                    <option value = "substr(?,1,1) =">Begins with</option>
                </select>
                <label>Parameters</label>
                <input type="text" name="firstname" value="">
                <label><button class="Tick_Submit"><input id="hidden" type="submit" value=""><span></button></label>
            </form>                                            
        </div>
                                                                                                       
                                                    <!-- Booking Form -->
                                                    
              <div class = "right-booking-form" id="conainer-booking">
            <form action="BookingControl" method="post" autocomplete="on">
                <h3>Booking Form</h3>          
                <h4>Venue:</h4> 
                <br>
                <select name="venue">
                <option value="-1">Select venue</option>
                    <%                  
                        String Query1 = "SELECT * FROM tblVenues";
                        Connection conn = null;
                        Db_Connection dbconn=new Db_Connection(); 
                        try{
                        Connection myconnection = dbconn.Connection();
                        Statement stm = myconnection.createStatement();
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
                <h4>Activity:</h4>
                <br>
                <select name="activity">
                <option value="-1">Select activity</option>
                    <%                  
                        String Query2 = "SELECT * FROM tblActivities";
                        try{
                        Connection myconnection = dbconn.Connection();
                        Statement stm = myconnection.createStatement();
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
                <h4>Week:</h4>
                    <input type="radio" name="week" value="Blue" id="radio-one2" class="form-radio2" checked><label for="radio-one">Blue</label>
                    <input type="radio" name="week" value="Maroon" id="radio-one1" class="form-radio1"><label for="radio-one">Maroon</label>
                <h4>Day:</h4>
                <br>
                <select name="day">
                    <option value = "Monday">Monday</option>
                    <option value = "Tuesday">Tuesday</option>
                    <option value = "Wednesday">Wednesday</option>
                    <option value = "Thursday">Thursday</option>
                    <option value = "Friday">Friday</option>
                </select>
                <h4>Period:</h4>
                <br>
                <select name="period">
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
                <input type="text" name="staffName" value="">
                <h4>Date:</h4>
                <input type="date" name="date" value="yyyy-MM-dd" min="2019-01-01">
                <br><br>
                <input class="Submit" type="submit" value="Submit">
            </form>                
        </div>
                       
                                                    <!-- Footer displays the users name and email -->
                                                    
        <footer>                                                                      
            <center>
                <div class="bottom-left-info">
                    <p id="gmail"></p>
                </div>
                <div class="bottom-right-help">
                    <a href="img/LoginGUIplanV3.png" target="_blank"><p src="img/SJCfavicon.png" title="Need Help?"><font size = 4 color = #e2e519>Help?</font></p></a>
                </div>
            </center>
        </footer>
    </body>
</html>