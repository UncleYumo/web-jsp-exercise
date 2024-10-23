<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/23
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.bean.UserJava" scope="session">
</jsp:useBean>
<h1>来自page1.jsp的JavaBean</h1>
<jsp:getProperty name="user" property="username"/><br>
<jsp:getProperty name="user" property="id"/><br>
<jsp:getProperty name="user" property="gender"/><br>
<jsp:getProperty name="user" property="age"/><br>
<jsp:getProperty name="user" property="member"/><br>

</body>
</html>
