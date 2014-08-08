<%@ page import="at.struct.wasbugs.wasbug6.MyServletContainerInitializer" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
    <head>
        <title>PMR 77553 010 61</title>
    </head>
    <body>
    All looks fine, application did at least boot!<br/>
    Nr of handled classes was <%=MyServletContainerInitializer.getNrClasses()%> (should be 1).

    <% if (MyServletContainerInitializer.getNrClasses() != 1)
    {
    %>
        <br/><br/><b>FAILURE! @HandlesTypes doesn't work properly on this container!</b>
    <%
    }
    %>
    </body>
</html>
