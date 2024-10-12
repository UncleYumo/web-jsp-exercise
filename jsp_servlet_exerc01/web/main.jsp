<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>表单处理</title>
</head>
<body>
<h1>接收到的数据</h1>
<ul>
    <li>
        <p><b>站点名:</b>
            <%
                String nameParam = request.getParameter("name");
                String name = (nameParam != null) ?
                        new String(nameParam.getBytes()) :
                        "未提供名称";
            %>
            <%= name %>
        </p>
    </li>
    <li>
        <p><b>网址:</b>
            <%
                String urlParam = request.getParameter("url");
                String url = (urlParam != null) ? new String(urlParam.getBytes()) : "未提供网址";
            %>
            <%= url %>
        </p>
    </li>
</ul>
</body>
</html>
