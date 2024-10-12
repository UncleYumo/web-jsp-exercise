<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/9
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>JSP基本语法程序</title>
</head>
<body>
<h2>自动刷新实例</h2>
<%
    // 设置每隔5秒自动刷新
    response.setIntHeader("Refresh", 5);
    // 获取当前时间
    Calendar calendar = new GregorianCalendar();
    String am_pm;
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    if(calendar.get(Calendar.AM_PM) == 0)
        am_pm = "AM";
    else
        am_pm = "PM";
    String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
    out.println("当前时间: " + CT + "\n");
%>
</body>
</html>