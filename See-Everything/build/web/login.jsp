<%-- 
    Document   : index
    Created on : 27-Jan-2019, 11:37:03
    Author     : flemi
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
        <link rel="shortcut icon" type="image/png" href="img/SJCfavicon.png">
        <link rel="stylesheet" type="text/css" href="StyleSheet.css" />
        <title>See Everything Login | St John's</title>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="1056145859345-trlkgoivq1slfk4kmjbvpo0vgfuj85il.apps.googleusercontent.com">
            <script type="text/javascript">
                function onSignIn(googleUser) {
                    var profile = googleUser.getBasicProfile();
                    var imagurl=profile.getImageUrl();
                    var name=profile.getName();
                    var email=profile.getEmail();
                   window.location.href='main.jsp?email='+email+'&name='+name+'';
		}
            </script>
            <script>
                function myFunction() {
                gapi.auth2.getAuthInstance().disconnect();
                location.reload(true);                      /* Reloads from server if (true) and from browser cache if (false) */
                }
            </script>
    </head>
    <body>
            <br>
        <img src="img/SJCtransparentLogo.png" alt="St John's" class="centerLogo">       
            <br>
        <h1 align="center" ><font face="Arial" color="white">See Everything | Web App</font></h1>
            <br>
        <h2 align="center"><font face="Arial" color="white">A venue information and booking system, using a dynamic / interactive map</font></h2>
                    
            <div class="GSignInCentered">
                <div class="g-signin2" data-onsuccess="onSignIn" data-width="300" data-height="60" id="myP"></div>               
            </div>
    <center>
        <br>
            <img id="myImg"><br>
            <p id="name"></p>  
        <div id="my-signin2">  </div>
    </center>
        <div class="GSignOutCentered">
            <button class="button" onclick="myFunction()"><span>Sign Out</button>  
        </div>
        <footer>
            <center>
                <div id="bottom-right-help">
                    <a href="img/Background.jpg" target="_blank"><p src="img/SJCfavicon.png" title="Need Help?"><font size = 5 color = #e2e519>Help?</font></p></a>
                </div>
            </center>
        </footer>
    </body>
</html>
