<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/16
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = "";
    String password = "";
    Cookie[] cookies = request.getCookies();
    if (cookies!= null) {
        String userInfo = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userInfo")) {
                userInfo = cookie.getValue();
                break;
            }
        }
        if (userInfo != null) {
            String[] information = userInfo.split("\\|");
            username = information[0];
            password = information[1];
        }
    }
%>
<form action="LoginServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" value="<%=username%>" required>
    <br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="<%=password%>" required>
    <br>
    <input type="submit" value="Login">
    <input type="reset" value="Reset">
</form>
</body>
</html>
