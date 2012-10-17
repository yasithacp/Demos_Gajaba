<%@ page import="org.gajaba.demo.ContextListener" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<String> doneList = ContextListener.getDoneList();
    for (String item : doneList) {
%>
<div class="doneImg">
    <p style="padding-left: 10px; text-align: left;">Image Processed</p>

    <div>
        <span>before</span>
        <img src="content/<%= item %>" alt="colour <%= item %>" width="20" height="20">
    </div>
    <div>
        <span>after</span>
        <img src="content/<%= item %>" alt="colour <%= item %>" width="20" height="20">
    </div>
</div>
<%
    }
%>

