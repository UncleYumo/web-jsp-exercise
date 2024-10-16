<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/16
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.setHeader("Pragma", "No-Cache");  // HTTP 1.0.
    response.setHeader("Cache-Control", "No-Cache");  // HTTP 1.1.
    response.setDateHeader("Expires", 0);  // Proxies.
    if (session != null) {
        String username = (String) session.getAttribute("username");
        if (username!= null) {
            out.print("欢迎您，" + username + "！" + "<br>" + "<a href='LogoutServlet'>安全退出</a>");
        } else {
            out.print("请先登录，5秒后自动跳转到登录页面...");
            response.setHeader("Refresh", "5;url=login.jsp");
        }
    } else {
        out.print("禁止直接访问，请先登录，5秒后自动跳转到登录页面...");
        response.setHeader("Refresh", "5;url=login.jsp");
    }
%>
</body>
</html>
