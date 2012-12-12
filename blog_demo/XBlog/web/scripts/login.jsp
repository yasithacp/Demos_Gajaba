<%-- 
    Document   : login
    Created on : Nov 13, 2012, 12:37:46 PM
    Author     : kasuncp
--%>

<%@page import="com.org.SampleServiceStub" %>
<%
    String targetEndpoint = "http://localhost:8084/axis2/services/SampleService";
    SampleServiceStub stub = new SampleServiceStub(targetEndpoint);

    String name = request.getParameter("name");
    String pwd = request.getParameter("password");

    String xml = stub.logIn(name, pwd);

    String url = "";

    if (xml.charAt(0) == '<') {
        url = "http://localhost:8084/XBlog/home.jsp";
        session.setAttribute("name", name);
        session.setAttribute("password", pwd);
        session.setAttribute("ws_response", null);
    } else {
        url = "http://localhost:8084/XBlog/index.jsp";
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
