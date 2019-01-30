package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta name=\"google-signin-client_id\" content=\"YOUR_CLIENT_ID.apps.googleusercontent.com\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div id=\"my-signin2\"></div>\n");
      out.write("  <script>\n");
      out.write("    function onSuccess(googleUser) {\n");
      out.write("      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());\n");
      out.write("    }\n");
      out.write("    function onFailure(error) {\n");
      out.write("      console.log(error);\n");
      out.write("    }\n");
      out.write("    function renderButton() {\n");
      out.write("      gapi.signin2.render('my-signin2', {\n");
      out.write("        'scope': 'profile email',\n");
      out.write("        'width': 240,\n");
      out.write("        'height': 50,\n");
      out.write("        'longtitle': true,\n");
      out.write("        'theme': 'dark',\n");
      out.write("        'onsuccess': onSuccess,\n");
      out.write("        'onfailure': onFailure\n");
      out.write("      });\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <script src=\"https://apis.google.com/js/platform.js?onload=renderButton\" async defer></script>\n");
      out.write("</body>\n");
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
