<%-- 
    Document   : login
    Created on : Nov 13, 2012, 12:37:46 PM
    Author     : kasuncp
--%>

<%@page import="com.org.SampleServiceStub" %>
<%
    String targetEndpoint = "http://localhost:8084/axis2/services/SampleService";
    SampleServiceStub stub = new SampleServiceStub(targetEndpoint);

    String name     = (String)session.getAttribute("name");
    String pwd      = (String)session.getAttribute("password");
    String title    = request.getParameter("title");
    String content  = request.getParameter("content");
    
    String message = title + "~" + content;

    String xml = stub.insertMessage(name, pwd, stub.getGroup(), message);

    String url = "";

    if (xml.charAt(0) == '<') {
        url = "http://localhost:8084/XBlog/home.jsp";
        session.setAttribute("name", name);
        session.setAttribute("password", pwd);
        session.setAttribute("ws_response", null);
    } else {
        url = "http://localhost:8084/XBlog/newpost.jsp";
        session.setAttribute("ws_response", xml);
    }
    
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", url);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
