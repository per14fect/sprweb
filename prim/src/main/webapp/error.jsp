<%--
  Created by IntelliJ IDEA.
  User: perfect
  Date: 1/28/19
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>

THIS IS ERROR PAGE. SOMETHING WRONG OCCURS ON SERVER
<br>
${test}
<br>
${requestScope.get("javax.servlet.error.servlet_name")}
${requestScope.get("error")}

<br>
а что если русский язык

</body>
</html>
