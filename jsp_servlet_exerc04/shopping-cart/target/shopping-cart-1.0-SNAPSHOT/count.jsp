<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>页面访问统计</title>
</head>
<body>
<h1>欢迎来到我的网页！</h1>

<%
    // 获取当前访问次数
    Integer visitCount = (Integer) application.getAttribute("visitCount");

    // 如果 visitCount 为 null，说明这是第一次访问
    if (visitCount == null) {
        visitCount = 1; // 初始化为1
    } else {
        visitCount++; // 访问次数加1
    }

    // 设置新的访问次数
    application.setAttribute("visitCount", visitCount);
%>

<p>此页面已被访问 <strong><%= visitCount %></strong> 次。</p>
</body>
</html>
