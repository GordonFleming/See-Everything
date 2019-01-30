package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <link rel=\"icon\" type=\"image/ico\" href=\"http://example.com/image.png\" />\n");
      out.write("        <title>See Everything | St John's</title>\n");
      out.write("\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"1056145859345-trlkgoivq1slfk4kmjbvpo0vgfuj85il.apps.googleusercontent.com\">\n");
      out.write("        </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" data-width=\"300\" data-height=\"50\"\n");
      out.write("        data-longtitle=\"true\">button</div>\n");
      out.write("\n");
      out.write("        <img id=\"myImg\"><br>\n");
      out.write("        <p id=\"name\"></p>  \n");
      out.write("        <div id=\"status\">  </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\t\t\tfunction onSignIn(googleUser) {\n");
      out.write("\t\t\t// window.location.href='success.jsp';\n");
      out.write("                \t\tvar profile = googleUser.getBasicProfile();\n");
      out.write("\t\t\t\tvar imagurl=profile.getImageUrl();\n");
      out.write("\t\t\t\tvar name=profile.getName();\n");
      out.write("\t\t\t\tvar email=profile.getEmail();\n");
      out.write("\t\t\t\tdocument.getElementById(\"myImg\").src = imagurl;\n");
      out.write("\t\t\t\tdocument.getElementById(\"name\").innerHTML = name;\n");
      out.write("\t\t\t\tdocument.getElementById(\"myP\").style.visibility = \"hidden\";\t\t\t\t  \n");
      out.write("\t\t\t\tdocument.getElementById(\"status\").innerHTML = 'Welcome '+name+'!<a href=success.jsp?email='+email+'&name='+name+'/>Continue with Google login</a></p>'\t   \n");
      out.write("\t\t\t }\n");
      out.write("        </script>\n");
      out.write("            <button onclick=\"myFunction()\">Sign Out</button>\n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("            gapi.auth2.getAuthInstance().disconnect();\n");
      out.write("            location.reload();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
