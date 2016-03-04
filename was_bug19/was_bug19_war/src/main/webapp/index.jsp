<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>was_bug19</title>
</head>
<body>
<%
    if (request.getParameter("inserted") != null && request.getParameter("inserted").length() > 0) {
%>
<p>Inserted <%=request.getParameter("inserted") %> lines</p>
<form action="loadIt" method="GET">
    <button name="action_load">Load Data</button>
</form>
<%
    }
    else if (request.getParameter("loaded") != null && request.getParameter("loaded").length() > 0) {
%>
<p>Loading of <%=request.getParameter("loaded") %> items successful!</p>
<h1>Works fine!</h1>
<%
    }
    else {
%>
<form action="writeIt" method="GET">
    <button name="action_init">Insert Data</button>
</form>
<%
    }
%>
</body>
</html>
