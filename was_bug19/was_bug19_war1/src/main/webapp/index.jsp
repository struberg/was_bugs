<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>was_bug19</title>
</head>
<body>
<%
    if (request.getParameter("inserted") == null && request.getParameter("inserted").length() == 0) {
%>
<form action="writeIt" method="GET">
    <button name="action_init">Init Data</button>
</form>
<%
    }
    else {
%>
<p>Inserted <% request.getParameter("inserted"); %> lines</p>
<a href="/was_bug19_2">To load Page...</a>
<%
    }
%>
</body>
</html>
