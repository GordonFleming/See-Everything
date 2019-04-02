package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>       \r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">   \r\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"img/SJCfavicon.png\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"StyleSheet.css\" />\r\n");
      out.write("        <title>See Everything Main Page | St John's</title>\r\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\r\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"1056145859345-trlkgoivq1slfk4kmjbvpo0vgfuj85il.apps.googleusercontent.com\">\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("                function SignedIn(googleUser) {                                     /* Fetches user data from google */\r\n");
      out.write("                    var profile = googleUser.getBasicProfile();\r\n");
      out.write("                    var imagurl=profile.getImageUrl();\r\n");
      out.write("                    var name=profile.getName();\r\n");
      out.write("                    var email=profile.getEmail();\r\n");
      out.write("                    document.getElementById(\"myImg\").src = imagurl;\r\n");
      out.write("                    document.getElementById(\"name\").innerHTML = name;\t\r\n");
      out.write("                    document.getElementById(\"myP\").style.visibility = \"hidden\";\t\r\n");
      out.write("\t\t}\r\n");
      out.write("            </script>\r\n");
      out.write("            <script>\r\n");
      out.write("                function myFunction() {                                             /* Signs out */\r\n");
      out.write("                gapi.auth2.getAuthInstance().disconnect();\r\n");
      out.write("                location.reload(true);                                              /* Reloads to sign out the user */\r\n");
      out.write("                location.replace(\"http://localhost:8080/See-Everything/login.jsp\"); /* Redirects to login page */\r\n");
      out.write("                }\r\n");
      out.write("            </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("                                                    <! -- Other -->\r\n");
      out.write("        \r\n");
      out.write("        <h2 align=\"center\" ><font face=\"Arial\" color=\"white\">See Everything | St John's College</font></h2>\r\n");
      out.write("            <div id = \"hidden\" class = \"GSignInCentered\">                     <!-- Hides the sign in button -->\r\n");
      out.write("                <div class=\"g-signin2\" data-onsuccess=\"SignedIn\"></div>               \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"top-left-GSignOut\">                                 <!-- Displays the sign out button -->\r\n");
      out.write("                <button class=\"button\" onclick=\"myFunction()\"><span>Sign Out</button>  \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"profile-details\">                                 <!-- Displays the Users details -->\r\n");
      out.write("                <img id=\"myImg\" style=\"width:70px;height:70px;\">\r\n");
      out.write("                <br> \r\n");
      out.write("                <p id=\"name\"></p>  \r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("                                                    <!-- Booking Form -->\r\n");
      out.write("        <div class = \"right-booking-form\">\r\n");
      out.write("            <form>\r\n");
      out.write("                <h3>Booking Form</h3> <br>               \r\n");
      out.write("                Venue: <br><br>\r\n");
      out.write("                <select name=\"venues\">\r\n");
      out.write("                <option value=\"-1\">Select venue</option>\r\n");
      out.write("                ");
                  
                        String Query = "SELECT * FROM tblVenues";
                        Class.forName("").newInstance();
                        String url = "jdbc:sqlite:C://Users/flemi/Documents/GitHub/Netbeans_Repository/Users.db";
                        Connection conn = null;
                        try{
                        conn = DriverManager.getConnection(url);
                        Statement stm = conn.createStatement();
                        ResultSet rs=stm.executeQuery(Query);
                        while(rs.next()){
                            
      out.write("\r\n");
      out.write("                            <option value = \"");
      out.print(rs.getInt("VenueID"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("Name"));
      out.write("</option>\r\n");
      out.write("                            ");

                        }                    
                    }catch(Exception ex){
                        ex.printStackTrace();
                        out.print("Error "+ex.getMessage());
                    }           
                
      out.write("\r\n");
      out.write("                </select> <br><br>\r\n");
      out.write("                <input type=\"submit\" value=\"Submit\">\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <footer>                                                            <!-- Footer displays the users name and email -->\r\n");
      out.write("            <center>\r\n");
      out.write("                <div class=\"bottom-left-info\">\r\n");
      out.write("                    ");

                    String name = (String)request.getParameter("name");
                    String email = (String)request.getParameter("email");
                    
      out.write("\r\n");
      out.write("                    ");
      out.print(name );
      out.write("\r\n");
      out.write("                    <br>\r\n");
      out.write("                    ");
      out.print(email );
      out.write(" \r\n");
      out.write("                </div>\r\n");
      out.write("            </center>\r\n");
      out.write("        </footer>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
