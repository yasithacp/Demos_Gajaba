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

      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("        <title>UploadiFive Test</title>\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"/gajaba_app/uploadify/jquery.uploadify.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"/gajaba_app/uploadify/uploadify.css\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body {\n");
      out.write("                font: 13px Arial, Helvetica, Sans-serif;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(function() {\n");
      out.write("                $('#file_upload').uploadify({\n");
      out.write("                    'swf'      : '/gajaba_app//uploadify/uploadify.swf',\n");
      out.write("                    'uploader' : '/gajaba_app/Upload'\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>Uploadify Demo</h1>\n");
      out.write("        <div class=\"bootcamp\">\n");
      out.write("            <h1>GitHub Bootcamp <span>If you are still new to things, weâve provided a few walkthroughs to get you started.</span>\n");
      out.write("                <a original-title=\"Hide this notice forever\" href=\"https://github.com/dashboard/dismiss_bootcamp\" class=\"js-dismiss-bootcamp dismiss-bootcamp dismiss tooltipped leftwards\"><span class=\"mini-icon mini-icon-remove-close\"></span></a>\n");
      out.write("            </h1>\n");
      out.write("            <div class=\"bootcamp-body\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"setup\">\n");
      out.write("                        <a href=\"http://help.github.com/set-up-git-redirect\" target=\"_blank\">\n");
      out.write("                            <div class=\"image\"></div>\n");
      out.write("                            <div class=\"desc\">\n");
      out.write("                                <h2>Set Up Git</h2>\n");
      out.write("                                <p>A quick guide to help you get started with Git.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <span class=\"step-number one\"></span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"create-a-repo\">\n");
      out.write("                        <a href=\"http://help.github.com/create-a-repo\" target=\"_blank\">\n");
      out.write("                            <div class=\"image\"></div>\n");
      out.write("                            <div class=\"desc\">\n");
      out.write("                                <h2>Create A Repository</h2>\n");
      out.write("                                <p>Create the place where your commits will be stored.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <span class=\"step-number two\"></span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"fork-a-repo\">\n");
      out.write("                        <a href=\"http://help.github.com/fork-a-repo\" target=\"_blank\">\n");
      out.write("                            <div class=\"image\"></div>\n");
      out.write("                            <div class=\"desc\">\n");
      out.write("                                <h2>Fork a Repository</h2>\n");
      out.write("                                <p>Copy a repo to create a new, unique project from its contents.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <span class=\"step-number three\"></span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"be-social\">\n");
      out.write("                        <a href=\"http://help.github.com/be-social\" target=\"_blank\">\n");
      out.write("                            <div class=\"image\"></div>\n");
      out.write("                            <div class=\"desc\">\n");
      out.write("                                <h2>Be social</h2>\n");
      out.write("                                <p>Follow a friend.<br>Watch a project.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <span class=\"step-number four\"></span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div> <!-- /bootcamp-body -->\n");
      out.write("        </div> <!-- /bootcamp -->\n");
      out.write("        <form>\n");
      out.write("            <div id=\"queue\"></div>\n");
      out.write("            <input id=\"file_upload\" name=\"file_upload\" type=\"file\" multiple=\"true\">\n");
      out.write("        </form>\n");
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
