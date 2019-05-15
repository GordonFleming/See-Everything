<%-- 
    Document   : main
    Created on : 27-Jan-2019, 12:05:10
    Author     : Gordon Fleming
--%>
<%@page import="database.DbConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
        <link rel="shortcut icon" type="image/png" href="img/SJCfavicon.png">       <!-- Links the favicon -->
        <link rel="stylesheet" type="text/css" href="StyleSheet.css" />             <!-- Links CSS file -->
        <link rel="stylesheet" type="text/css" href="Map.css" />                    <!-- Links CSS file -->
        <title>See Everything Main Page | St John's</title>
        <script src="https://apis.google.com/js/platform.js" async defer></script>  <!-- Links google javascript file -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script> <!-- Links jquery library file -->
        <script type="text/javascript" src="StJohnsMap.js"></script>                <!-- Links javascript file -->
        <script type="text/javascript" src="\See-Everything\JSON.js"></script>      <!-- Links javascript file -->
       
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
            <div id = "hidden">                                             <!-- Hides the sign in button -->
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
        <div class="center">                                                <!-- Centres the map -->
            <div class="map">                                               <!-- Styles the map. Displays the SVG map. Styles all other venues differently. Each classroom is a separate object contained within <g> tags -->
                <svg version="1.1" id="St_John_x27_s" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" 
                y="0px" width="850px" height="500px" viewBox="0 0 841.68 595.2" style="enable-background:new 0 0 841.68 595.2;"
                xml:space="preserve">
                    <style type="text/css">
                        .st0{fill:white;stroke:#000000}                         
                        .st1{fill:grey;stroke:#000000}
                        .st2{font-family:'Calibri';}
                        .st3{font-size:10px;}
                        .st4{font-size:12px;}
                        .st5{font-family:'Calibri';}
                        .st6{fill:white;stroke:#000000;stroke-miterlimit:10;}
                        .st7{fill:none;stroke:#000000;stroke-width:2;stroke-linejoin:round;stroke-miterlimit:10;}
                        .st8{font-size:11px;}
                    </style>
                    <g id="36">                                                 
                                    <rect x="115.5" y="88" width="31.8" height="38.2"/>
                                    <text transform="matrix(1 0 0 1 124.9877 105.6497)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">36</tspan><tspan x="-4.3" y="12" class="st1 st2 st3">ART</tspan></text>
                            </g>
                            <g id="C6">
                                    <rect x="765" y="523.2" width="38.5" height="34.6"/>
                                    <text transform="matrix(1 0 0 1 779.093 538.8501)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">C6</tspan><tspan x="-2.2" y="12" class="st1 st2 st3">SCI</tspan></text>
                            </g>
                            <g id="C2">
                                    <rect x="765" y="451" width="38.5" height="34.6"/>
                                    <text transform="matrix(1 0 0 1 776.743 464.5501)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">C2</tspan><tspan x="-2.2" y="12" class="st1 st2 st3">SCI</tspan></text>
                            </g>
                            <g id="C1">
                                    <rect x="694.8" y="485" width="32.7" height="34.9"/>
                                    <text transform="matrix(1 0 0 1 704.1431 498.2003)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">C1</tspan><tspan x="-2.2" y="12" class="st1 st2 st3">SCI</tspan></text>
                            </g>
                            <g id="P1">
                                    <rect x="659.5" y="485" width="32.7" height="34.9"/>
                                    <text transform="matrix(1 0 0 1 669.2544 498.2001)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">P1</tspan><tspan x="-2.7" y="12" class="st1 st2 st3">SCI</tspan></text>
                            </g>
                            <g id="P6">
                                    <rect x="608.6" y="520.2" width="25.2" height="29.6"/>
                                    <text transform="matrix(1 0 0 1 615.5043 529.8001)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">P6</tspan><tspan x="-2.7" y="12" class="st1 st2 st3">SCI</tspan></text>
                            </g>
                            <g id="P2">
                                    <rect x="608.6" y="451" width="25.2" height="34.4"/>
                                    <text transform="matrix(1 0 0 1 615.5044 464.5502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">P2</tspan><tspan x="-2.7" y="12" class="st1 st2 st3">SCI</tspan></text>
                            </g>
                            <g id="B9">
                                    <rect x="507.8" y="520.2" width="35.2" height="28.6"/>
                                    <text transform="matrix(1.0295 0 0 1 518.3419 528.8502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">B9</tspan><tspan x="-2.9" y="12" class="st1 st2 st3">BIO</tspan></text>
                            </g>
                            <g id="B7">
                                    <rect x="444.1" y="486" width="33" height="33"/>
                                    <text transform="matrix(1.0295 0 0 1 452.8419 497.7502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">B7</tspan><tspan x="-2.9" y="12" class="st1 st2 st3">BIO</tspan></text>
                            </g>
                            <g id="B4">
                                    <rect x="507.8" y="451" width="35.2" height="34"/>
                                    <text transform="matrix(1.0295 0 0 1 518.2919 468.3502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">B4</tspan><tspan x="-2.9" y="12" class="st1 st2 st3">BIO</tspan></text>
                            </g>
                            <g id="B10">
                                    <rect x="312" y="518" width="31.5" height="31.5"/>
                                    <text transform="matrix(1.0295 0 0 1 317.517 529.8003)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">B10</tspan><tspan x="0.3" y="12" class="st1 st2 st3">BIO</tspan></text>
                            </g>
                            <g id="B13">
                                    <rect x="312" y="497.8" width="31.5" height="18.7"/>
                                    <text transform="matrix(1.0295 0 0 1 317.5169 510.4501)" class="st1 st2 st3">B13</text>
                            </g>
                            <g id="B14">
                                    <rect x="375.8" y="486" width="33.5" height="33.5"/>
                                    <text transform="matrix(1.0295 0 0 1 382.167 497.7502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">B14</tspan><tspan x="0.8" y="12" class="st1 st2 st3">SCI</tspan></text>
                            </g>
                            <g id="B15">
                                    <rect x="311.9" y="464.5" width="31.7" height="31.7"/>
                                    <text transform="matrix(1.0295 0 0 1 317.417 478.4006)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">B15</tspan><tspan x="4.7" y="12" class="st1 st2 st3">IT</tspan></text>
                            </g>
                            <g id="B16">
                                    <rect x="312" y="427.5" width="31.5" height="35.6"/>
                                    <text transform="matrix(1.0295 0 0 1 317.417 444.2502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">B16</tspan><tspan x="4.7" y="12" class="st1 st2 st3">IT</tspan></text>
                            </g>
                            <g id="REB">
                                    <rect x="246.9" y="491.2" width="31.6" height="26.5"/>
                                    <text transform="matrix(1.0295 0 0 1 251.3837 507.5)" class="st1 st2 st3">REB</text>
                            </g>
                            <g id="E9">
                                    <rect x="83.9" y="428" width="31.8" height="22.9"/>
                                    <text transform="matrix(1 0 0 1 90.7026 444.2504)" class="st1 st2 st4">E9</text>
                            </g>
                            <g id="E8">
                                    <rect x="117.5" y="427.8" width="32.3" height="35.6"/>
                                    <text transform="matrix(1 0 0 1 125.4529 451.0502)" class="st1 st2 st4">E8</text>
                            </g>
                            <g id="E7">
                                    <rect x="151.6" y="428" width="31.8" height="35.3"/>
                                    <text transform="matrix(1 0 0 1 159.3026 450.8504)" class="st1 st2 st4">E7</text>
                            </g>
                            <g id="E6">
                                    <rect x="149.4" y="518.7" width="31.3" height="20.4"/>
                                    <text transform="matrix(1 0 0 1 159.3026 533.7004)" class="st1 st2 st4">E6</text>
                            </g>
                            <g id="E5">
                                    <rect x="212.6" y="517.5" width="32.9" height="22.6"/>
                                    <text transform="matrix(1 0 0 1 221.5026 533.7004)" class="st1 st2 st4">E5</text>
                            </g>
                            <g id="E4">
                                    <rect x="212.6" y="493.5" width="32.9" height="22.6"/>
                                    <text transform="matrix(1 0 0 1 221.5026 510.4504)" class="st1 st2 st4">E4</text>
                            </g>
                            <g id="E3">
                                    <rect x="212.6" y="469.5" width="32.9" height="22.6"/>
                                    <text transform="matrix(1 0 0 1 221.5026 484.9504)" class="st1 st2 st4">E3</text>
                            </g>
                            <g id="E2">
                                    <rect x="212.6" y="445.7" width="32.9" height="22.6"/>
                                    <text transform="matrix(1 0 0 1 221.5026 460.4504)" class="st1 st2 st4">E2</text>
                            </g>
                            <g id="E1">
                                    <rect x="212.6" y="421.7" width="32.9" height="22.6"/>
                                    <text transform="matrix(1 0 0 1 221.5026 434.9504)" class="st1 st2 st4">E1</text>
                            </g>
                            <g id="G4">
                                    <rect x="49.3" y="435" width="32.8" height="24.5"/>
                                    <text transform="matrix(1 0 0 1 57.0895 451.05)" class="st1 st2 st4">G4</text>
                            </g>
                            <g id="G3">
                                    <rect x="49.3" y="460.5" width="32.8" height="24.5"/>                                
                                    <text transform="matrix(1 0 0 1 57.0896 478.4005)" class="st1 st2 st4">G3</text>
                            </g>
                            <g id="G2">
                                    <rect x="49.4" y="486" width="32.8" height="24.5"/>
                                    <text transform="matrix(1 0 0 1 57.0897 502.4501)" class="st1 st2 st4">G2</text>
                            </g>
                            <g id="G1">
                                    <rect x="49.3" y="511.3" width="32.8" height="27.5"/>
                                    <text transform="matrix(1 0 0 1 57.0897 528.85)" class="st1 st2 st4">G1</text>
                            </g>
                            <g id="His12B">
                                    <path class="st6" d="M-5.5-31.6"/>
                                    <rect x="50" y="368.7" width="31.7" height="28.4"/>
                                    <text transform="matrix(1 0 0 1 55.8135 378.2505)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">12B</tspan><tspan x="-0.5" y="12" class="st1 st2 st3">Hist</tspan></text>
                            </g>
                            <g id="His12">
                                    <rect x="50" y="322.5" width="31.7" height="44.9"/>
                                    <text transform="matrix(1 0 0 1 59.3378 340.3503)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">12</tspan><tspan x="-4.2" y="12" class="st1 st2 st3">Hist</tspan></text>
                            </g>
                            <g id="His9">
                                    <rect x="82.8" y="378.3" width="31.7" height="28.4"/>
                                    <text transform="matrix(1 0 0 1 95.4691 388.2505)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">9</tspan><tspan x="-7.4" y="12" class="st1 st2 st3">Hist</tspan></text>
                            </g>
                            <g id="His8">
                                    <rect x="115.5" y="378.3" width="31.7" height="28.4"/>
                                    <text transform="matrix(1 0 0 1 128.819 388.2502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">8</tspan><tspan x="-7.4" y="12" class="st1 st2 st3">Hist</tspan></text>
                            </g>
                            <g id="His7">
                                    <rect x="180.7" y="368.7" width="31.7" height="28.4"/>
                                    <text transform="matrix(1 0 0 1 194.1183 378.2502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">7</tspan><tspan x="-7.4" y="12" class="st1 st2 st3">Hist</tspan></text>
                            </g>
                            <g id="44">
                                    <rect x="278.5" y="311.3" width="32.9" height="45.9"/>
                                    <text transform="matrix(1 0 0 1 289.2382 329.0497)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">44</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="39">
                                    <rect x="472.5" y="301.3" width="35.4" height="35.4"/>
                                    <text transform="matrix(1 0 0 1 483.8376 315.9499)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">39</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="42">
                                    <rect x="344.9" y="298.3" width="31.7" height="35.4"/>
                                    <text transform="matrix(1 0 0 1 354.3876 312.15)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">42</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="64">
                                    <rect x="767" y="227.8" width="38.2" height="29.2"/>
                                    <text transform="matrix(1.0295 0 0 1 779.5497 238.4506)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">64</tspan><tspan x="-3" y="12" class="st1 st2 st3">Ger</tspan></text>
                            </g>
                            <g id="65">
                                    <rect x="686.7" y="258" width="38.2" height="29.2"/>
                                    <text transform="matrix(1.0295 0 0 1 699.2498 268.5502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">65</tspan><tspan x="-1.9" y="12" class="st1 st2 st3">Zul</tspan></text>
                            </g>
                            <g id="66">
                                    <rect x="726.9" y="258" width="38.2" height="29.2"/>
                                    <text transform="matrix(1.0295 0 0 1 739.4497 267.9502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">66</tspan><tspan x="-1.9" y="12" class="st1 st2 st3">Zul</tspan></text>
                            </g>
                            <g id="67">
                                    <rect x="767" y="258" width="38.2" height="29.2"/>
                                    <text transform="matrix(1.0295 0 0 1 779.5497 268.5504)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">67</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="69">
                                    <rect x="686.7" y="227.8" width="38.2" height="29.2"/>
                                    <text transform="matrix(1.0295 0 0 1 699.2498 238.4502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">69</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="28">
                                    <rect x="78.6" y="111.8" width="32.1" height="36"/>
                                    <text transform="matrix(1 0 0 1 88.2876 129.7501)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">28</tspan><tspan x="-4.5" y="12" class="st1 st2 st3">AFR</tspan></text>
                            </g>
                            <g id="29">
                                    <rect x="115.5" y="138.1" width="31.8" height="28.6"/>
                                    <text transform="matrix(1.0295 0 0 1 125.4497 148.1272)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">29</tspan><tspan x="-4.5" y="12" class="st1 st2 st3">AFR</tspan></text>
                            </g>
                            <g id="30">
                                    <rect x="148.3" y="138.1" width="31.8" height="28.6"/>
                                    <text transform="matrix(1.0295 0 0 1 157.5997 148.1272)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">30</tspan><tspan x="-4.5" y="12" class="st1 st2 st3">AFR</tspan></text>
                            </g>
                            <g id="31">
                                    <rect x="181" y="138.1" width="31.8" height="28.6"/>
                                    <text transform="matrix(1.0295 0 0 1 189.9997 148.1272)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">31</tspan><tspan x="-4.5" y="12" class="st1 st2 st3">AFR</tspan></text>
                            </g>
                            <g id="32">
                                    <rect x="213.8" y="138.1" width="31.8" height="28.6"/>
                                    <text transform="matrix(1.0295 0 0 1 222.4997 148.1272)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">32</tspan><tspan x="-4.5" y="12" class="st1 st2 st3">AFR</tspan></text>
                            </g>
                            <g id="33">
                                    <rect x="213.8" y="88" width="31.8" height="38.2"/>
                                    <text transform="matrix(1 0 0 1 223.3376 105.6497)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">33</tspan><tspan x="-4.3" y="12" class="st1 st2 st3">ART</tspan></text>
                            </g>
                            <g id="35">
                                    <rect x="148.3" y="88" width="31.8" height="38.2"/>
                                    <text transform="matrix(1 0 0 1 157.788 105.6498)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">35</tspan><tspan x="-4.3" y="12" class="st1 st2 st3">ART</tspan></text>
                            </g>
                            <g id="14">
                                    <rect x="246.5" y="236.6" width="31.4" height="31.4"/>
                                    <text transform="matrix(1 0 0 1 256.4377 248.0497)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">14</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="15">
                                    <rect x="213.4" y="236.9" width="31.4" height="31.4"/>
                                    <text transform="matrix(1 0 0 1 223.3377 248.0497)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">15</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="16">
                                    <rect x="181" y="236.9" width="31.4" height="31.4"/>
                                    <text transform="matrix(1 0 0 1 190.9377 248.0497)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">16</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="17">
                                    <rect x="148.5" y="236.9" width="31.3" height="31.4"/>
                                    <text transform="matrix(1 0 0 1 158.6877 248.0499)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">17</tspan><tspan x="-4.5" y="12" class="st1 st2 st3">AFR</tspan></text>
                            </g>
                            <g id="47">
                                    <rect x="279.3" y="216.9" width="31.3" height="35.3"/>
                                    <text transform="matrix(1 0 0 1 289.238 234.7997)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">47</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="48">
                                    <rect x="279.3" y="180.4" width="31.3" height="35.4"/>
                                    <text transform="matrix(1 0 0 1 289.2379 196.9498)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">48</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="50">
                                    <rect x="312.6" y="138.1" width="31.8" height="28.6"/>
                                    <text transform="matrix(1.0295 0 0 1 321.1997 152.35)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">50</tspan><tspan x="-7" y="12" class="st1 st2 st3">Math</tspan></text>
                            </g>
                            <g id="59">
                                    <rect x="543.5" y="126.8" width="31.4" height="31.3"/>
                                    <text transform="matrix(1.0295 0 0 1 552.6497 141.7502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">59</tspan><tspan x="-2.1" y="12" class="st1 st2 st3">Div</tspan></text>
                            </g>
                            <g id="60">
                                    <rect x="576.1" y="126.8" width="31.3" height="31.3"/>
                                    <text transform="matrix(1.0295 0 0 1 585.1997 141.7502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">60</tspan><tspan x="-2.5" y="12" class="st1 st2 st3">Fre</tspan></text>
                            </g>
                            <g id="61">
                                    <rect x="608.6" y="126.8" width="26.9" height="31.3"/>
                                    <text transform="matrix(1.0295 0 0 1 615.4997 141.7502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">61</tspan><tspan x="-2.5" y="12" class="st1 st2 st3">Fre</tspan></text>
                            </g>
                            <g id="MusGrn">
                                    <rect x="763.2" y="126.8" width="41.1" height="30"/>
                                    <text transform="matrix(1.0295 0 0 1 771.2577 135.9502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">GRN</tspan><tspan x="1.2" y="12" class="st1 st2 st3">Mus</tspan></text>
                            </g>
                            <g id="Dun">
                                    <rect x="763.2" y="90" width="41.1" height="37"/>
                                    <text transform="matrix(1.0295 0 0 1 766.6678 105.6502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">DUNG</tspan><tspan x="7.2" y="12" class="st1 st2 st3">Dra</tspan></text>
                            </g>
                            <g id="70">
                                    <rect x="660.3" y="88.9" width="31" height="35.8"/>
                                    <path class="st6" d="M49.9-53.8"/>
                                    <text transform="matrix(1.0295 0 0 1 669.2997 107.9502)" class="st0"><tspan x="0" y="0" class="st1 st2 st3">70</tspan><tspan x="-3" y="12" class="st1 st2 st3">Dra</tspan></text>
                            </g>
                            <g id="Other">
                                    <polygon class="st0" points="49.9,180.4 50,257 82.7,258 82.7,237.9 114.9,237.7 114.5,180.6 		"/>
                                    <polygon class="st0" points="660.4,129.8 660.3,157.7 762,156.7 762,156.7 762,89.9 762,89.9 693.1,88.9 693.1,88.9 693.1,127 660.8,127 		"/>
                                    <rect class="st0" x="410.4" y="108" width="99" height="25"/>
                                    <rect class="st0" x="476.7" y="135.8" width="33.5" height="31.4"/>
                                    <rect class="st0" x="410.4" y="136" width="65.9" height="30.8"/>
                                    <rect class="st0" x="378.3" y="135.8" width="31.4" height="31.4"/>
                                    <rect class="st0" x="279.3" y="253.4" width="31.3" height="35.4"/>
                                    <rect class="st0" x="279.7" y="138.1" width="31.8" height="28.6"/>
                                    <rect class="st0" x="246.9" y="138.1" width="31.8" height="28.6"/>
                                    <path class="st7" d="M106,333.7c0-8.1,5.4-14.7,12.1-14.7c4,0,8.1,0,12.1,0c0,4.9,0,9.8,0,14.7c0,8.1-5.4,14.7-12.1,14.7
                                            S106,341.8,106,333.7z"/>
                                    <path class="st7" d="M378.8,105.7c0,16.3-9.5,29.6-21.2,29.6s-21.2-13.3-21.2-29.6H347c0,10.5,4.7,19,10.6,19s10.6-8.5,10.6-19
                                            H378.8z"/>
                                    <path class="st1" d="M53,197.2c0-7,5.6-12.6,12.6-12.6c4.3,0,8.7-0.1,13-0.4c-0.3,4.3-0.4,8.7-0.4,13c0,7-5.6,12.6-12.6,12.6
                                            S53,204.1,53,197.2z"/>
                                    <path class="st7" d="M378.8,234.8c0-9.6,8.9-17.4,19.9-17.4s19.9,7.8,19.9,17.4c0,9.6-8.9,17.5-19.9,17.5
                                            C387.7,252.2,378.8,244.4,378.8,234.8z"/>
                                    <rect class="st0" x="510.3" y="102.5" width="32.8" height="88.3"/>
                                    <rect class="st0" x="312" y="298.3" width="31.7" height="35.4"/>
                                    <rect class="st0" x="378.5" y="298.3" width="31.7" height="35.4"/>
                                    <rect class="st0" x="543" y="323" width="65.1" height="44.8"/>
                                    <rect class="st0" x="633" y="312.2" width="62.4" height="45.4"/>
                                    <rect class="st0" x="609" y="323" width="23" height="44.5"/>
                                    <rect class="st0" x="476.4" y="237.4" width="32" height="29.8"/>
                                    <rect class="st0" x="510.3" y="217.4" width="32.7" height="94.8"/>
                                    <rect class="st0" x="436.4" y="301.3" width="35.4" height="35.4"/>
                                    <rect class="st0" x="213.3" y="311.2" width="64.6" height="45.7"/>
                                    <rect class="st0" x="180.8" y="322.7" width="31.5" height="35.4"/>
                                    <rect class="st0" x="82.8" y="518.7" width="32.2" height="20.4"/>
                                    <rect class="st0" x="115.6" y="518.7" width="32.8" height="20.4"/>
                                    <rect class="st0" x="83.7" y="238.4" width="29.9" height="29.9"/>
                                    <rect class="st0" x="507.8" y="486.3" width="35.1" height="32.7"/>
                                    <rect class="st0" x="49.9" y="259.3" width="31.8" height="18.6"/>
                                    <rect class="st0" x="375.9" y="520.5" width="33.2" height="29.1"/>
                                    <rect class="st0" x="183.4" y="519.5" width="27.8" height="20.7"/>
                                    <rect class="st0" x="410.7" y="486" width="31.8" height="43.1"/>
                                    <rect class="st0" x="765" y="487" width="38.5" height="34.6"/>
                                    <polygon class="st0" points="410.7,530.3 410.7,549.8 477.1,549.8 476.6,519.8 444.3,519.8 443.9,530.3 		"/>
                                    <rect class="st0" x="608.6" y="486.3" width="25.2" height="33.2"/>
                                    <text transform="matrix(1 0 0 1 581.1875 230.05)" class="st5 st4">David Quad</text>
                                    <text transform="matrix(1 0 0 1 78.1445 303.1496)" class="st5 st4">Stairs up to Hist</text>
                                    <text transform="matrix(1 0 0 1 364.4485 205.7001)" class="st5 st4">Pelican Quad</text>
                                    <text transform="matrix(1 0 0 1 325.0703 94.7001)" class="st5 st4">Amphitheatre</text>
                                    <text transform="matrix(1 0 0 1 679.7334 146.5999)" class="st1 st5 st4">Big School</text>
                                    <text transform="matrix(1 0 0 1 135.7852 493)" class="st5 st4">REA</text>
                                    <text transform="matrix(1 0 0 1 150.3926 205.5999)" class="st5 st8">Matric Lawn</text>
                                    <text transform="matrix(1 0 0 1 233.7581 336.6499)" class="st1 st2 st3">Nash</text>
                                    <text transform="matrix(1 0 0 1 642.9623 334.5)" class="st1 st5 st3">Reception</text>
                                    <text transform="matrix(1 0 0 1 512.5057 236.5499)" class="st0"><tspan x="0" y="0" class="st1 st5 st3">Darr</tspan><tspan x="1.1" y="12" class="st1 st5 st3">Hall</tspan></text>
                                    <g id="68">
                                            <rect class="st0" x="726.9" y="227.8" width="38.2" height="29.2"/>
                                    </g>
                                    <g id="34">
                                            <rect class="st0" x="180.8" y="88" width="31.8" height="38.2"/>
                                    </g>
                            </g>
                    </g>
                    </svg>
                </div>
            </div>
                                                    <!-- Query Form -->
                                                    
        <div class = "top-query-form" id="container-query">
            <center><h3>Query Form</h3></center>
            <form class="form-inline" action="QueryController" autocomplete="off">
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
                <label><button class="Tick_Submit"><input id="hidden" type="submit" name = "query" value=""><span></button></label>
            </form>                                            
        </div>
                                                                                                       
                                                    <!-- Booking Form -->
                                                    
              <div class = "right-booking-form" id="conainer-booking">
            <form action="BookingControl" method="post" autocomplete="on">
                <h3>Booking Form</h3>          
                <h4>Venue:</h4> 
                <br>
                <select name="venue">
                <option value="-1">Select venue</option>     <!-- Creates SQL Query then reads through all results and outputs sufficient amount of <options> while records still remain -->
                    <%                  
                        String Query1 = "SELECT * FROM tblVenues";   
                        DbConnection dbconn=new DbConnection(); 
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
                <option value="-1">Select activity</option> <!-- Creates SQL Query then reads through all results and outputs sufficient amount of <options> while records still remain -->
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
                       
                                                    <!-- Footer displays the users name and email, details are taken from their google login -->
                                                    
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