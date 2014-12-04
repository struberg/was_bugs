<%@ page import="at.struct.wasbugs.wasbug9.WasBug9StartupSingleton" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
@Singleton @Startup bean got properly initialized: <%= WasBug9StartupSingleton.initialized%>
</body>
</html>
