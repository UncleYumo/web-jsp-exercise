<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/12/14
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验7</title>
</head>
<body>
欢迎你, <%= session.getAttribute("username") %>

<br>

<a href="../LogoutServlet">退出登录</a>
</body>
</html>
