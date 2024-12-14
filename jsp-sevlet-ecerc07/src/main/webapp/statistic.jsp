<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/12/14
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistic</title>
</head>
<body>
历史访问总量:
<%= (application.getAttribute("count") == null) ? 0 : application.getAttribute("count")%>
<br>
在线用户成绩:
<%= (application.getAttribute("userCount") == null) ? 0 : application.getAttribute("userCount")%>
</body>
</html>
