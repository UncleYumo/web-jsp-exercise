<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/17
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String color = null;

    Cookie[] cookies = request.getCookies();
    if (cookies!= null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("color")) {
                color = cookie.getValue();
                out.println("从 Cookie 中获取当前背景颜色：" + color);
                break;
            }
        }
    }

    if (request.getParameter("color") != null) {
        color = request.getParameter("color");
        Cookie colorCookie = new Cookie("color", color);
        colorCookie.setMaxAge(60 * 5);  // Cookie 有效期为 5 分钟
        response.addCookie(colorCookie);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面</title>
</head>
<body style="background-color:<%= color != null ? color : "white" %>;">
<h1>欢迎访问！</h1>
</body>
</html>
