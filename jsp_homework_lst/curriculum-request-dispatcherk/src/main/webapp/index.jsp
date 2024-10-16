<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Chapter 4</title>
</head>

<body>

<div style="text-align: center;">
    <h1>请求转发 - 测试表单</h1>
</div>
<form action="firstServlet">
    <span>用户名: </span>
    <label>
        <input type="text" name="username">
    </label><br>
    <span>密  码: </span>
    <label>
        <input type="password" name="password">
    </label><br>
    <span>所在区域: </span>
    <label>
        <select name="country">
            <option value="中国">中国</option>
            <option value="美国">美国</option>
            <option value="英国">英国</option>
        </select><br>
    </label>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>

<h1><%= "This is the JSP page for the Servlet Kotlin Example" %>
</h1>
</body>

</html>