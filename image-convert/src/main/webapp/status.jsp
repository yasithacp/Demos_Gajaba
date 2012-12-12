<%@ page import="org.gajaba.demo.ContextListener" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<String> processingList = ContextListener.getProcessingList();
    for (String item : processingList) {
%>
<div class="doneImg">
    <p style="border-bottom: 1px solid #999999">Image Processed</p>

    <a href="../content/<%= item %>">
        <div class="statusImg">
            <div>before</div>
            <img src="../content/TH_<%= item %>" alt="before <%= item %>">
        </div>
    </a>

    <div class="statusImg">
        <div>after</div>
        <img src="ui/img/325.png">
    </div>
</div>
<%
    }
%>


<%
    List<String> doneList = ContextListener.getDoneList();
    for (String item : doneList) {
%>
<div class="doneImg">
    <p style="border-bottom: 1px solid #999999">Image Processed</p>

    <a href="../content/<%= item %>">
        <div class="statusImg">
            <div>before</div>
            <img src="../content/TH_<%= item %>" alt="before <%= item %>">
        </div>
    </a>

    <a href="../content/CO_<%= item %>">
        <div class="statusImg">
            <div>after</div>
            <img src="../content/TH_CO_<%= item %>" alt="after <%= item %>">
        </div>
    </a>
</div>
<%
    }
%>
