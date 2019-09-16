/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import database.DbConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 24740
 */
public class Query extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws FileNotFoundException, ServletException, IOException {
        try {
            String html = "<html>\n" +
                    "    <head>       \n" +
                    "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">   \n" +
                    "        <link rel=\"shortcut icon\" type=\"image/ico\" href=\"img/favicon.ico\">       <!-- Links the favicon -->\n" +
                    "        <link rel=\"stylesheet\" type=\"text/css\" href=\"StyleSheet.css\" />             <!-- Links CSS file -->\n" +
                    "        <link rel=\"stylesheet\" type=\"text/css\" href=\"Map.css\" />                    <!-- Links CSS file -->\n" +
                    "        <title>See Everything Main Page | St John's</title>\n" +
                    "        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>  <!-- Links google javascript file -->\n" +
                    "        <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\" integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\" crossorigin=\"anonymous\"></script> <!-- Links jquery library file -->\n" +
                    "        <script type=\"text/javascript\" src=\"StJohnsMap.js\"></script>                <!-- Links javascript file -->\n" +
                    "        <script type=\"text/javascript\" src=\"\\See-Everything\\JSON.js\"></script>      <!-- Links javascript file -->\n" +
                    "       \n" +
                    "        <meta name=\"google-signin-client_id\" content=\"1056145859345-trlkgoivq1slfk4kmjbvpo0vgfuj85il.apps.googleusercontent.com\">\n" +
                    "            <script type=\"text/javascript\">\n" +
                    "                function SignedIn(googleUser) {                                     /* Fetches user data from google */\n" +
                    "                    var profile = googleUser.getBasicProfile();\n" +
                    "                    var imagurl=profile.getImageUrl();\n" +
                    "                    var name=profile.getName();\n" +
                    "                    var email=profile.getEmail();\n" +
                    "                    document.getElementById(\"myImg\").src = imagurl;\n" +
                    "                    document.getElementById(\"gname\").innerHTML = name;	\n" +
                    "                    document.getElementById(\"gmail\").innerHTML = email;\n" +
                    "		}\n" +
                    "            </script>\n" +
                    "            <script>\n" +
                    "                function myFunction() {                                             /* Signs out */\n" +
                    "                gapi.auth2.getAuthInstance().disconnect();\n" +
                    "                location.reload(true);                                              /* Reloads to sign out the user */\n" +
                    "                location.replace(\"http://localhost:8080/See-Everything/\");          /* Redirects to login page */\n" +
                    "                }\n" +
                    "            </script>\n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "        \n" +
                    "                                                    <! -- Other -->\n" +
                    "                                                    \n" +
                    "        <header><h2 align=\"center\" ><font face=\"Arial\" color=\"white\">&ensp;&ensp;See Everything | St John's College</font></h2></header>\n" +
                    "            <div id = \"hidden\">                                             <!-- Hides the sign in button -->\n" +
                    "                <div class=\"g-signin2\" data-onsuccess=\"SignedIn\"></div>               \n" +
                    "            </div>\n" +
                    "            <div class=\"top-left-GSignOut\">                                 <!-- Displays the sign out button -->\n" +
                    "                <button class=\"button\" onclick=\"myFunction()\"><span>Sign Out</button>  \n" +
                    "            </div>\n" +
                    "            <div class = \"profile-details\">                                 <!-- Displays the Users details -->\n" +
                    "                <img id=\"myImg\" style=\"width:70px;height:70px;\">\n" +
                    "                <br> \n" +
                    "                <p id=\"gname\"></p>  \n" +
                    "            </div>\n" +
                    "        <div class=\"center\">                                                <!-- Centres the map -->\n" +
                    "            <div class=\"map\">                                               <!-- Styles the map. Displays the SVG map. Styles all other venues differently. Each classroom is a separate object contained within <g> tags -->\n" +
                    "                <svg version=\"1.1\" id=\"St_John_x27_s\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" \n" +
                    "                y=\"0px\" width=\"850px\" height=\"500px\" viewBox=\"0 0 841.68 595.2\" style=\"enable-background:new 0 0 841.68 595.2;\"\n" +
                    "                xml:space=\"preserve\">\n" +
                    "                    <style type=\"text/css\">\n" +
                    "                        .st0{fill:white;stroke:#000000}                         \n" +
                    "                        .st1{fill:grey;stroke:#000000}\n" +
                    "                        .st2{font-family:'Calibri';}\n" +
                    "                        .st3{font-size:10px;}\n" +
                    "                        .st4{font-size:12px;}\n" +
                    "                        .st5{font-family:'Calibri';}\n" +
                    "                        .st6{fill:white;stroke:#000000;stroke-miterlimit:10;}\n" +
                    "                        .st7{fill:none;stroke:#000000;stroke-width:2;stroke-linejoin:round;stroke-miterlimit:10;}\n" +
                    "                        .st8{font-size:11px;}\n" +
                    "                    </style>\n" +
                    "                    <g id=\"36\">                                                 \n" +
                    "                                    <rect x=\"115.5\" y=\"88\" width=\"31.8\" height=\"38.2\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 124.9877 105.6497)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">36</tspan><tspan x=\"-4.3\" y=\"12\" class=\"st1 st2 st3\">ART</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"C6\">\n" +
                    "                                    <rect x=\"765\" y=\"523.2\" width=\"38.5\" height=\"34.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 779.093 538.8501)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">C6</tspan><tspan x=\"-2.2\" y=\"12\" class=\"st1 st2 st3\">SCI</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"C2\">\n" +
                    "                                    <rect x=\"765\" y=\"451\" width=\"38.5\" height=\"34.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 776.743 464.5501)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">C2</tspan><tspan x=\"-2.2\" y=\"12\" class=\"st1 st2 st3\">SCI</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"C1\">\n" +
                    "                                    <rect x=\"694.8\" y=\"485\" width=\"32.7\" height=\"34.9\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 704.1431 498.2003)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">C1</tspan><tspan x=\"-2.2\" y=\"12\" class=\"st1 st2 st3\">SCI</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"P1\">\n" +
                    "                                    <rect x=\"659.5\" y=\"485\" width=\"32.7\" height=\"34.9\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 669.2544 498.2001)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">P1</tspan><tspan x=\"-2.7\" y=\"12\" class=\"st1 st2 st3\">SCI</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"P6\">\n" +
                    "                                    <rect x=\"608.6\" y=\"520.2\" width=\"25.2\" height=\"29.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 615.5043 529.8001)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">P6</tspan><tspan x=\"-2.7\" y=\"12\" class=\"st1 st2 st3\">SCI</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"P2\">\n" +
                    "                                    <rect x=\"608.6\" y=\"451\" width=\"25.2\" height=\"34.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 615.5044 464.5502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">P2</tspan><tspan x=\"-2.7\" y=\"12\" class=\"st1 st2 st3\">SCI</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B9\">\n" +
                    "                                    <rect x=\"507.8\" y=\"520.2\" width=\"35.2\" height=\"28.6\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 518.3419 528.8502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">B9</tspan><tspan x=\"-2.9\" y=\"12\" class=\"st1 st2 st3\">BIO</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B7\">\n" +
                    "                                    <rect x=\"444.1\" y=\"486\" width=\"33\" height=\"33\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 452.8419 497.7502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">B7</tspan><tspan x=\"-2.9\" y=\"12\" class=\"st1 st2 st3\">BIO</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B4\">\n" +
                    "                                    <rect x=\"507.8\" y=\"451\" width=\"35.2\" height=\"34\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 518.2919 468.3502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">B4</tspan><tspan x=\"-2.9\" y=\"12\" class=\"st1 st2 st3\">BIO</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B10\">\n" +
                    "                                    <rect x=\"312\" y=\"518\" width=\"31.5\" height=\"31.5\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 317.517 529.8003)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">B10</tspan><tspan x=\"0.3\" y=\"12\" class=\"st1 st2 st3\">BIO</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B13\">\n" +
                    "                                    <rect x=\"312\" y=\"497.8\" width=\"31.5\" height=\"18.7\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 317.5169 510.4501)\" class=\"st1 st2 st3\">B13</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B14\">\n" +
                    "                                    <rect x=\"375.8\" y=\"486\" width=\"33.5\" height=\"33.5\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 382.167 497.7502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">B14</tspan><tspan x=\"0.8\" y=\"12\" class=\"st1 st2 st3\">SCI</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B15\">\n" +
                    "                                    <rect x=\"311.9\" y=\"464.5\" width=\"31.7\" height=\"31.7\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 317.417 478.4006)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">B15</tspan><tspan x=\"4.7\" y=\"12\" class=\"st1 st2 st3\">IT</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"B16\">\n" +
                    "                                    <rect x=\"312\" y=\"427.5\" width=\"31.5\" height=\"35.6\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 317.417 444.2502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">B16</tspan><tspan x=\"4.7\" y=\"12\" class=\"st1 st2 st3\">IT</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"REB\">\n" +
                    "                                    <rect x=\"246.9\" y=\"491.2\" width=\"31.6\" height=\"26.5\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 251.3837 507.5)\" class=\"st1 st2 st3\">REB</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E9\">\n" +
                    "                                    <rect x=\"83.9\" y=\"428\" width=\"31.8\" height=\"22.9\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 90.7026 444.2504)\" class=\"st1 st2 st4\">E9</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E8\">\n" +
                    "                                    <rect x=\"117.5\" y=\"427.8\" width=\"32.3\" height=\"35.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 125.4529 451.0502)\" class=\"st1 st2 st4\">E8</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E7\">\n" +
                    "                                    <rect x=\"151.6\" y=\"428\" width=\"31.8\" height=\"35.3\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 159.3026 450.8504)\" class=\"st1 st2 st4\">E7</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E6\">\n" +
                    "                                    <rect x=\"149.4\" y=\"518.7\" width=\"31.3\" height=\"20.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 159.3026 533.7004)\" class=\"st1 st2 st4\">E6</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E5\">\n" +
                    "                                    <rect x=\"212.6\" y=\"517.5\" width=\"32.9\" height=\"22.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 221.5026 533.7004)\" class=\"st1 st2 st4\">E5</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E4\">\n" +
                    "                                    <rect x=\"212.6\" y=\"493.5\" width=\"32.9\" height=\"22.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 221.5026 510.4504)\" class=\"st1 st2 st4\">E4</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E3\">\n" +
                    "                                    <rect x=\"212.6\" y=\"469.5\" width=\"32.9\" height=\"22.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 221.5026 484.9504)\" class=\"st1 st2 st4\">E3</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E2\">\n" +
                    "                                    <rect x=\"212.6\" y=\"445.7\" width=\"32.9\" height=\"22.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 221.5026 460.4504)\" class=\"st1 st2 st4\">E2</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"E1\">\n" +
                    "                                    <rect x=\"212.6\" y=\"421.7\" width=\"32.9\" height=\"22.6\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 221.5026 434.9504)\" class=\"st1 st2 st4\">E1</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"G4\">\n" +
                    "                                    <rect x=\"49.3\" y=\"435\" width=\"32.8\" height=\"24.5\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 57.0895 451.05)\" class=\"st1 st2 st4\">G4</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"G3\">\n" +
                    "                                    <rect x=\"49.3\" y=\"460.5\" width=\"32.8\" height=\"24.5\"/>                                \n" +
                    "                                    <text transform=\"matrix(1 0 0 1 57.0896 478.4005)\" class=\"st1 st2 st4\">G3</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"G2\">\n" +
                    "                                    <rect x=\"49.4\" y=\"486\" width=\"32.8\" height=\"24.5\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 57.0897 502.4501)\" class=\"st1 st2 st4\">G2</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"G1\">\n" +
                    "                                    <rect x=\"49.3\" y=\"511.3\" width=\"32.8\" height=\"27.5\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 57.0897 528.85)\" class=\"st1 st2 st4\">G1</text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"His12B\">\n" +
                    "                                    <path class=\"st6\" d=\"M-5.5-31.6\"/>\n" +
                    "                                    <rect x=\"50\" y=\"368.7\" width=\"31.7\" height=\"28.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 55.8135 378.2505)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">12B</tspan><tspan x=\"-0.5\" y=\"12\" class=\"st1 st2 st3\">Hist</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"His12\">\n" +
                    "                                    <rect x=\"50\" y=\"322.5\" width=\"31.7\" height=\"44.9\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 59.3378 340.3503)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">12</tspan><tspan x=\"-4.2\" y=\"12\" class=\"st1 st2 st3\">Hist</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"His9\">\n" +
                    "                                    <rect x=\"82.8\" y=\"378.3\" width=\"31.7\" height=\"28.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 95.4691 388.2505)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">9</tspan><tspan x=\"-7.4\" y=\"12\" class=\"st1 st2 st3\">Hist</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"His8\">\n" +
                    "                                    <rect x=\"115.5\" y=\"378.3\" width=\"31.7\" height=\"28.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 128.819 388.2502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">8</tspan><tspan x=\"-7.4\" y=\"12\" class=\"st1 st2 st3\">Hist</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"His7\">\n" +
                    "                                    <rect x=\"180.7\" y=\"368.7\" width=\"31.7\" height=\"28.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 194.1183 378.2502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">7</tspan><tspan x=\"-7.4\" y=\"12\" class=\"st1 st2 st3\">Hist</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"44\">\n" +
                    "                                    <rect x=\"278.5\" y=\"311.3\" width=\"32.9\" height=\"45.9\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 289.2382 329.0497)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">44</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"39\">\n" +
                    "                                    <rect x=\"472.5\" y=\"301.3\" width=\"35.4\" height=\"35.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 483.8376 315.9499)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">39</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"42\">\n" +
                    "                                    <rect x=\"344.9\" y=\"298.3\" width=\"31.7\" height=\"35.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 354.3876 312.15)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">42</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"64\">\n" +
                    "                                    <rect x=\"767\" y=\"227.8\" width=\"38.2\" height=\"29.2\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 779.5497 238.4506)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">64</tspan><tspan x=\"-3\" y=\"12\" class=\"st1 st2 st3\">Ger</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"65\">\n" +
                    "                                    <rect x=\"686.7\" y=\"258\" width=\"38.2\" height=\"29.2\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 699.2498 268.5502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">65</tspan><tspan x=\"-1.9\" y=\"12\" class=\"st1 st2 st3\">Zul</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"66\">\n" +
                    "                                    <rect x=\"726.9\" y=\"258\" width=\"38.2\" height=\"29.2\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 739.4497 267.9502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">66</tspan><tspan x=\"-1.9\" y=\"12\" class=\"st1 st2 st3\">Zul</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"67\">\n" +
                    "                                    <rect x=\"767\" y=\"258\" width=\"38.2\" height=\"29.2\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 779.5497 268.5504)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">67</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"69\">\n" +
                    "                                    <rect x=\"686.7\" y=\"227.8\" width=\"38.2\" height=\"29.2\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 699.2498 238.4502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">69</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"28\">\n" +
                    "                                    <rect x=\"78.6\" y=\"111.8\" width=\"32.1\" height=\"36\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 88.2876 129.7501)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">28</tspan><tspan x=\"-4.5\" y=\"12\" class=\"st1 st2 st3\">AFR</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"29\">\n" +
                    "                                    <rect x=\"115.5\" y=\"138.1\" width=\"31.8\" height=\"28.6\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 125.4497 148.1272)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">29</tspan><tspan x=\"-4.5\" y=\"12\" class=\"st1 st2 st3\">AFR</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"30\">\n" +
                    "                                    <rect x=\"148.3\" y=\"138.1\" width=\"31.8\" height=\"28.6\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 157.5997 148.1272)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">30</tspan><tspan x=\"-4.5\" y=\"12\" class=\"st1 st2 st3\">AFR</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"31\">\n" +
                    "                                    <rect x=\"181\" y=\"138.1\" width=\"31.8\" height=\"28.6\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 189.9997 148.1272)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">31</tspan><tspan x=\"-4.5\" y=\"12\" class=\"st1 st2 st3\">AFR</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"32\">\n" +
                    "                                    <rect x=\"213.8\" y=\"138.1\" width=\"31.8\" height=\"28.6\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 222.4997 148.1272)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">32</tspan><tspan x=\"-4.5\" y=\"12\" class=\"st1 st2 st3\">AFR</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"33\">\n" +
                    "                                    <rect x=\"213.8\" y=\"88\" width=\"31.8\" height=\"38.2\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 223.3376 105.6497)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">33</tspan><tspan x=\"-4.3\" y=\"12\" class=\"st1 st2 st3\">ART</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"35\">\n" +
                    "                                    <rect x=\"148.3\" y=\"88\" width=\"31.8\" height=\"38.2\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 157.788 105.6498)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">35</tspan><tspan x=\"-4.3\" y=\"12\" class=\"st1 st2 st3\">ART</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"14\">\n" +
                    "                                    <rect x=\"246.5\" y=\"236.6\" width=\"31.4\" height=\"31.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 256.4377 248.0497)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">14</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"15\">\n" +
                    "                                    <rect x=\"213.4\" y=\"236.9\" width=\"31.4\" height=\"31.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 223.3377 248.0497)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">15</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"16\">\n" +
                    "                                    <rect x=\"181\" y=\"236.9\" width=\"31.4\" height=\"31.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 190.9377 248.0497)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">16</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"17\">\n" +
                    "                                    <rect x=\"148.5\" y=\"236.9\" width=\"31.3\" height=\"31.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 158.6877 248.0499)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">17</tspan><tspan x=\"-4.5\" y=\"12\" class=\"st1 st2 st3\">AFR</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"47\">\n" +
                    "                                    <rect x=\"279.3\" y=\"216.9\" width=\"31.3\" height=\"35.3\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 289.238 234.7997)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">47</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"48\">\n" +
                    "                                    <rect x=\"279.3\" y=\"180.4\" width=\"31.3\" height=\"35.4\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 289.2379 196.9498)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">48</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"50\">\n" +
                    "                                    <rect x=\"312.6\" y=\"138.1\" width=\"31.8\" height=\"28.6\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 321.1997 152.35)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">50</tspan><tspan x=\"-7\" y=\"12\" class=\"st1 st2 st3\">Math</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"59\">\n" +
                    "                                    <rect x=\"543.5\" y=\"126.8\" width=\"31.4\" height=\"31.3\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 552.6497 141.7502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">59</tspan><tspan x=\"-2.1\" y=\"12\" class=\"st1 st2 st3\">Div</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"60\">\n" +
                    "                                    <rect x=\"576.1\" y=\"126.8\" width=\"31.3\" height=\"31.3\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 585.1997 141.7502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">60</tspan><tspan x=\"-2.5\" y=\"12\" class=\"st1 st2 st3\">Fre</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"61\">\n" +
                    "                                    <rect x=\"608.6\" y=\"126.8\" width=\"26.9\" height=\"31.3\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 615.4997 141.7502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">61</tspan><tspan x=\"-2.5\" y=\"12\" class=\"st1 st2 st3\">Fre</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"MusGrn\">\n" +
                    "                                    <rect x=\"763.2\" y=\"126.8\" width=\"41.1\" height=\"30\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 771.2577 135.9502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">GRN</tspan><tspan x=\"1.2\" y=\"12\" class=\"st1 st2 st3\">Mus</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"Dun\">\n" +
                    "                                    <rect x=\"763.2\" y=\"90\" width=\"41.1\" height=\"37\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 766.6678 105.6502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">DUNG</tspan><tspan x=\"7.2\" y=\"12\" class=\"st1 st2 st3\">Dra</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"70\">\n" +
                    "                                    <rect x=\"660.3\" y=\"88.9\" width=\"31\" height=\"35.8\"/>\n" +
                    "                                    <path class=\"st6\" d=\"M49.9-53.8\"/>\n" +
                    "                                    <text transform=\"matrix(1.0295 0 0 1 669.2997 107.9502)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st2 st3\">70</tspan><tspan x=\"-3\" y=\"12\" class=\"st1 st2 st3\">Dra</tspan></text>\n" +
                    "                            </g>\n" +
                    "                            <g id=\"Other\">\n" +
                    "                                    <polygon class=\"st0\" points=\"49.9,180.4 50,257 82.7,258 82.7,237.9 114.9,237.7 114.5,180.6 		\"/>\n" +
                    "                                    <polygon class=\"st0\" points=\"660.4,129.8 660.3,157.7 762,156.7 762,156.7 762,89.9 762,89.9 693.1,88.9 693.1,88.9 693.1,127 660.8,127 		\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"410.4\" y=\"108\" width=\"99\" height=\"25\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"476.7\" y=\"135.8\" width=\"33.5\" height=\"31.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"410.4\" y=\"136\" width=\"65.9\" height=\"30.8\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"378.3\" y=\"135.8\" width=\"31.4\" height=\"31.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"279.3\" y=\"253.4\" width=\"31.3\" height=\"35.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"279.7\" y=\"138.1\" width=\"31.8\" height=\"28.6\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"246.9\" y=\"138.1\" width=\"31.8\" height=\"28.6\"/>\n" +
                    "                                    <path class=\"st7\" d=\"M106,333.7c0-8.1,5.4-14.7,12.1-14.7c4,0,8.1,0,12.1,0c0,4.9,0,9.8,0,14.7c0,8.1-5.4,14.7-12.1,14.7\n" +
                    "                                            S106,341.8,106,333.7z\"/>\n" +
                    "                                    <path class=\"st7\" d=\"M378.8,105.7c0,16.3-9.5,29.6-21.2,29.6s-21.2-13.3-21.2-29.6H347c0,10.5,4.7,19,10.6,19s10.6-8.5,10.6-19\n" +
                    "                                            H378.8z\"/>\n" +
                    "                                    <path class=\"st1\" d=\"M53,197.2c0-7,5.6-12.6,12.6-12.6c4.3,0,8.7-0.1,13-0.4c-0.3,4.3-0.4,8.7-0.4,13c0,7-5.6,12.6-12.6,12.6\n" +
                    "                                            S53,204.1,53,197.2z\"/>\n" +
                    "                                    <path class=\"st7\" d=\"M378.8,234.8c0-9.6,8.9-17.4,19.9-17.4s19.9,7.8,19.9,17.4c0,9.6-8.9,17.5-19.9,17.5\n" +
                    "                                            C387.7,252.2,378.8,244.4,378.8,234.8z\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"510.3\" y=\"102.5\" width=\"32.8\" height=\"88.3\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"312\" y=\"298.3\" width=\"31.7\" height=\"35.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"378.5\" y=\"298.3\" width=\"31.7\" height=\"35.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"543\" y=\"323\" width=\"65.1\" height=\"44.8\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"633\" y=\"312.2\" width=\"62.4\" height=\"45.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"609\" y=\"323\" width=\"23\" height=\"44.5\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"476.4\" y=\"237.4\" width=\"32\" height=\"29.8\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"510.3\" y=\"217.4\" width=\"32.7\" height=\"94.8\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"436.4\" y=\"301.3\" width=\"35.4\" height=\"35.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"213.3\" y=\"311.2\" width=\"64.6\" height=\"45.7\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"180.8\" y=\"322.7\" width=\"31.5\" height=\"35.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"82.8\" y=\"518.7\" width=\"32.2\" height=\"20.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"115.6\" y=\"518.7\" width=\"32.8\" height=\"20.4\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"83.7\" y=\"238.4\" width=\"29.9\" height=\"29.9\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"507.8\" y=\"486.3\" width=\"35.1\" height=\"32.7\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"49.9\" y=\"259.3\" width=\"31.8\" height=\"18.6\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"375.9\" y=\"520.5\" width=\"33.2\" height=\"29.1\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"183.4\" y=\"519.5\" width=\"27.8\" height=\"20.7\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"410.7\" y=\"486\" width=\"31.8\" height=\"43.1\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"765\" y=\"487\" width=\"38.5\" height=\"34.6\"/>\n" +
                    "                                    <polygon class=\"st0\" points=\"410.7,530.3 410.7,549.8 477.1,549.8 476.6,519.8 444.3,519.8 443.9,530.3 		\"/>\n" +
                    "                                    <rect class=\"st0\" x=\"608.6\" y=\"486.3\" width=\"25.2\" height=\"33.2\"/>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 581.1875 230.05)\" class=\"st5 st4\">David Quad</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 78.1445 303.1496)\" class=\"st5 st4\">Stairs up to Hist</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 364.4485 205.7001)\" class=\"st5 st4\">Pelican Quad</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 325.0703 94.7001)\" class=\"st5 st4\">Amphitheatre</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 679.7334 146.5999)\" class=\"st1 st5 st4\">Big School</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 135.7852 493)\" class=\"st5 st4\">REA</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 150.3926 205.5999)\" class=\"st5 st8\">Matric Lawn</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 233.7581 336.6499)\" class=\"st1 st2 st3\">Nash</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 642.9623 334.5)\" class=\"st1 st5 st3\">Reception</text>\n" +
                    "                                    <text transform=\"matrix(1 0 0 1 512.5057 236.5499)\" class=\"st0\"><tspan x=\"0\" y=\"0\" class=\"st1 st5 st3\">Darr</tspan><tspan x=\"1.1\" y=\"12\" class=\"st1 st5 st3\">Hall</tspan></text>\n" +
                    "                                    <g id=\"68\">\n" +
                    "                                            <rect class=\"st0\" x=\"726.9\" y=\"227.8\" width=\"38.2\" height=\"29.2\"/>\n" +
                    "                                    </g>\n" +
                    "                                    <g id=\"34\">\n" +
                    "                                            <rect class=\"st0\" x=\"180.8\" y=\"88\" width=\"31.8\" height=\"38.2\"/>\n" +
                    "                                    </g>\n" +
                    "                            </g>\n" +
                    "                    </g>\n" +
                    "                    </svg>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "                                                    <!-- Query Form -->\n" +
                    "                                                    \n" +"<div class = \"top-query-form\" id=\"container-query\">\n" +
"            <center><h3>Query Form</h3></center>\n" +
"            <form class=\"form-inline\" action=\"query\" autocomplete=\"off\">\n" +
"                <label>Field</label>\n" +
"                <select name=\"field\">\n" +
"                    <option value = \"staffName\">Staff Name</option>  \n" +
"                    <option value = \"activity\">Venue</option>\n" +
"                    <!--<option value = \"date\">Date</option>-->\n" +
"                </select>\n" +
"                <label>Function</label>\n" +
"                <select name=\"function\" >\n" +
"                     \n" +
"                    <option value = \"=\" >Equal</option>\n" +
"                    \n" +
"                    \n" +
"                </select>\n" +
"                <label>Parameters</label>\n" +
"                \n" +
"                <input type=\"text\" name=\"text\">\n" +
"                <label><button class=\"Tick_Submit\"><input id=\"hidden\" type=\"submit\" name = \"query\" value=\"\"><span></button></label>\n" +
"            </form>                                            \n" +
"        </div>"+
                    "                                                                                                       \n" +
                    "                                                    <!-- Booking Form -->\n" +
                    "                                                    \n" +
                    "        <div class = \"right-booking-form\" id=\"conainer-booking\">\n" +
                    "            <form action=\"BookingControl\" method=\"post\" autocomplete=\"on\">\n" +
                    "                <h3>Booking Form</h3>          \n" +
                    "                <h4>Venue:</h4> \n" +
                    "                <br>\n" +
                    "                <select name=\"venue\">\n" +
                    "                <option value=\"-1\">Select venue</option>     <!-- Creates SQL Query then reads through all results and outputs sufficient amount of <options> while records still remain -->\n" +
                    "                    <%                  \n" +
                    "                        String Query1 = \"SELECT * FROM tblVenues\";   \n" +
                    "                        DbConnection dbconn=new DbConnection(); \n" +
                    "                        try{\n" +
                    "                        Connection myconnection = dbconn.Connection();\n" +
                    "                        Statement stm = myconnection.createStatement();\n" +
                    "                        ResultSet rs = stm.executeQuery(Query1);\n" +
                    "                        while(rs.next()){\n" +
                    "                            %>\n" +
                    "                            <option value = \"<%=rs.getInt(\"VenueID\")%>\"><%=rs.getString(\"Name\")%></option>\n" +
                    "                            <%\n" +
                    "                        }                    \n" +
                    "                    }catch(Exception ex){                   //Prints out the error\n" +
                    "                        ex.printStackTrace();\n" +
                    "                        out.print(\"Error \"+ex.getMessage());\n" +
                    "                    }           \n" +
                    "                    %>\n" +
                    "                </select>\n" +
                    "                <h4>Activity:</h4>\n" +
                    "                <br>\n" +
                    "                <select name=\"activity\">\n" +
                    "                <option value=\"-1\">Select activity</option> <!-- Creates SQL Query then reads through all results and outputs sufficient amount of <options> while records still remain -->\n" +
                    "                    <%                  \n" +
                    "                        String Query2 = \"SELECT * FROM tblActivities\";\n" +
                    "                        try{\n" +
                    "                        Connection myconnection = dbconn.Connection();\n" +
                    "                        Statement stm = myconnection.createStatement();\n" +
                    "                        ResultSet rs = stm.executeQuery(Query2);\n" +
                    "                        while(rs.next()){\n" +
                    "                            %>\n" +
                    "                            <option value = \"<%=rs.getInt(\"ActivityID\")%>\"><%=rs.getString(\"Activity\")%></option>\n" +
                    "                            <%\n" +
                    "                        }                    \n" +
                    "                    }catch(Exception ex){               //Prints out the error\n" +
                    "                        ex.printStackTrace();\n" +
                    "                        out.print(\"Error \"+ex.getMessage());\n" +
                    "                    }           \n" +
                    "                    %>\n" +
                    "                </select>\n" +
                    "                <h4>Week:</h4>\n" +
                    "                    <input type=\"radio\" name=\"week\" value=\"Blue\" id=\"radio-one2\" class=\"form-radio2\" checked><label for=\"radio-one\">Blue</label>\n" +
                    "                    <input type=\"radio\" name=\"week\" value=\"Maroon\" id=\"radio-one1\" class=\"form-radio1\"><label for=\"radio-one\">Maroon</label>\n" +
                    "                <h4>Day:</h4>\n" +
                    "                <br>\n" +
                    "                <select name=\"day\">\n" +
                    "                    <option value = \"Monday\">Monday</option>\n" +
                    "                    <option value = \"Tuesday\">Tuesday</option>\n" +
                    "                    <option value = \"Wednesday\">Wednesday</option>\n" +
                    "                    <option value = \"Thursday\">Thursday</option>\n" +
                    "                    <option value = \"Friday\">Friday</option>\n" +
                    "                </select>\n" +
                    "                <h4>Period:</h4>\n" +
                    "                <br>\n" +
                    "                <select name=\"period\">\n" +
                    "                    <option value = \"0\">Period 0</option>\n" +
                    "                    <option value = \"1\">Period 1</option>\n" +
                    "                    <option value = \"2\">Period 2</option>\n" +
                    "                    <option value = \"3\">Period 3</option>\n" +
                    "                    <option value = \"4\">Period 4</option>\n" +
                    "                    <option value = \"5\">Period 5</option>\n" +
                    "                    <option value = \"6\">Period 6</option>\n" +
                    "                    <option value = \"7\">Period 7</option>\n" +
                    "                    <option value = \"8\">Period 8</option>\n" +
                    "                    <option value = \"9\">Period 9</option>\n" +
                    "                </select>\n" +
                    "                <h4>Staff Name:</h4>\n" +
                    "                <input type=\"text\" name=\"staffName\" value=\"\">\n" +
                    "                <h4>Date:</h4>\n" +
                    "                <input type=\"date\" name=\"date\" value=\"yyyy-MM-dd\" min=\"2019-01-01\">\n" +
                    "                <br><br>\n" +
                    "                <input class=\"Submit\" type=\"submit\" value=\"Submit\">\n" +
                    "            </form>                \n" +
                    "        </div>"+"<div class = \"left-results\" id=\"conainer-results\">\n" +
                    "            <form method=\"post\">\n" +
                    "                <table border=\"2\">\n" +
                    "                <tr>\n" +
                    "                <td><b>Time</td>\n" +
                    "                <td><b>StaffName</td>\n" +
                    "                <td><b>Venue</td>\n" +
                    "                </tr>\n" +
                    "                ";
            String type = req.getParameter("field");
            //String function = req.getParameter("function");
            String text = req.getParameter("text");
            if(text==""){
                text="%";
            }
            DbConnection dbconn=new DbConnection();
            Connection myconnection = dbconn.Connection();
            Statement stm = myconnection.createStatement();
            ResultSet rs;
            String query;
            switch(type){
                case "staffName":
                    query="SELECT strftime('%H:%M', time('now','-4 hours'))as 'Time', Surname as StaffName, venue\n" +
                            "FROM tblTimeTablesLocation\n" +
                            "LEFT JOIN tblStaff on tblStaff.StaffID=tblTimeTablesLocation.StaffID,\n" +
                            "(SELECT PeriodName FROM tblTimings\n" +
                            "WHERE time('now','-4 hours') BETWEEN StartTime and EndTime\n" +
                            "AND week = 'Maroon' \n" +
                            "AND WeekdayCode = strftime('%w',date('now')))subquery1\n" +
                            "WHERE period = PeriodName\n" +
                            "AND week = 'Maroon' \n" +
                            "AND WeekdayCode = strftime('%w',date('now')) AND Surname like \""+text+"\"";
                    myconnection = dbconn.Connection();
                    stm = myconnection.createStatement();
                    rs=stm.executeQuery(query);
                    html += dothething(rs);
                    
                        break;
                case "activity":
                    query="SELECT strftime('%H:%M', time('now','-4 hours'))as 'Time', Surname as StaffName, venue\n" +
                            "FROM tblTimeTablesLocation\n" +
                            "LEFT JOIN tblStaff on tblStaff.StaffID=tblTimeTablesLocation.StaffID,\n" +
                            "(SELECT PeriodName FROM tblTimings\n" +
                            "WHERE time('now','-4 hours') BETWEEN StartTime and EndTime\n" +
                            "AND week = 'Maroon' \n" +
                            "AND WeekdayCode = strftime('%w',date('now')))subquery1\n" +
                            "WHERE period = PeriodName\n" +
                            "AND week = 'Maroon' \n" +
                            "AND WeekdayCode = strftime('%w',date('now')) AND venue like \""+text+"\"";
                    myconnection = dbconn.Connection();
                    stm = myconnection.createStatement();
                    rs=stm.executeQuery(query);
                    html += dothething(rs);
                    break;
                    
            }
            html +="</table>\n" +
                    
"                </form>\n" +
"        </div>\n" +
"                       \n" +
"                                                    <!-- Footer displays the users name and email, details are taken from their google login -->\n" +
"                                                    \n" +
"        <footer>                                                                      \n" +
"            <center>\n" +
"                <div class=\"bottom-left-info\">\n" +
"                    <p id=\"gmail\"></p>\n" +
"                </div>\n" +
"                <div class=\"bottom-right-help\">\n" +
"                    <a href=\"img/MainPageActual_Help(V1).png\" target=\"_blank\"><p src=\"img/SJCfavicon.png\" title=\"Need Help?\"><font size = 4 color = #e2e519>Help?</font></p></a>\n" +
"                </div>\n" +
"            </center>\n" +
"        </footer>\n" +
"    </body>\n" +
"</html>";
            PrintWriter out = res.getWriter();
                    out.print(html);
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static String dothething(ResultSet rs) throws SQLException{
        String html = "";
        while(rs.next()){
            html+="<tr><td>";
                html+=rs.getString("Time") +"</td>"+
                    "<td>"+rs.getString("StaffName")+"</td>"+
                    "<td>"+rs.getString("venue") +"</td>";
            html+="</tr>";
        }
        return html;
    }
}
