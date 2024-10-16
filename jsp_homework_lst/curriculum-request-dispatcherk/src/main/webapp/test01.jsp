<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/17
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择背景颜色</title>
</head>
<body>
<form action="test02.jsp" method="post">
    选择一个颜色：
    <select name="color">
        <option value="red">红色</option>
        <option value="yellow">黄色</option>
        <option value="green">绿色</option>
        <option value="blue">蓝色</option>
        <option value="pink">粉红色</option>
        <option value="black">黑色</option>
        <option value="white">白色</option>
    </select>
    <input type="submit" value="提交">
</form>
<br>
<form action="test02.jsp" method="post">
    <label>不传入任何颜色，使用本页面的Cookie</label>
    <input type="submit" value="提交">
</form>
</body>
</html>
