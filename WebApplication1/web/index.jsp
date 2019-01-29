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
        <title>Insert title here</title>

        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="1056145859345-trlkgoivq1slfk4kmjbvpo0vgfuj85il.apps.googleusercontent.com">
        </head>
    <body>

        <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>

        <img id="myImg"><br>
        <p id="name"></p>  
        <div id="status">  </div>
        <script type="text/javascript">
			function onSignIn(googleUser) {
			// window.location.href='success.jsp';
                		var profile = googleUser.getBasicProfile();
				var imagurl=profile.getImageUrl();
				var name=profile.getName();
				var email=profile.getEmail();
				document.getElementById("myImg").src = imagurl;
				document.getElementById("name").innerHTML = name;
				document.getElementById("myP").style.visibility = "hidden";				  
				document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=success.jsp?email='+email+'&name='+name+'/>Continue with Google login</a></p>'	   
			 }
        </script>
            <button onclick="myFunction()">Sign Out</button>
        <script>
            function myFunction() {
            gapi.auth2.getAuthInstance().disconnect();
            location.reload();
            }
        </script>
    </body>
</html>
