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
<jsp:useBean id="goods" class="com.example.bean.Goods" scope="page">
</jsp:useBean>
<jsp:setProperty name="goods" property="gname" value="iPhone X Pro"/>
<jsp:getProperty name="goods" property="gname"/>

<br>
<jsp:useBean id="user" class="com.example.bean.UserJava" scope="session">
</jsp:useBean>

<jsp:setProperty name="user" property="id" value="123456"/>
<jsp:setProperty name="user" property="username" value="Uncle Yumo"/>
<jsp:setProperty name="user" property="gender" value="男"/>
<jsp:setProperty name="user" property="age" value="22"/>
<jsp:setProperty name="user" property="member" value="true"/>

<span>User ID:</span><jsp:getProperty name="user" property="id"/><br>
<span>Username:</span><jsp:getProperty name="user" property="username"/><br>
<span>Gender:</span><jsp:getProperty name="user" property="gender"/><br>
<span>Age:</span><jsp:getProperty name="user" property="age"/><br>
<span>Member:</span><jsp:getProperty name="user" property="member"/><br>

</body>
</html>
