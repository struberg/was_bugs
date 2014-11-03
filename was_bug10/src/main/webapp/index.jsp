<%@ page import="at.struct.wasbugs.wasbug10.WasBug10RandomCdiBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
@Singleton @Startup bean got properly initialized: <%= WasBug10RandomCdiBean.initialized%>
</body>
</html>
