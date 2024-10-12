<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/9/25
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示日期</title>
    <meta charset="UTF-8">
</head>
<body>
    <div style="text-align: center;" id="div-date">
        <div>
            <h1>获取当前日期</h1>
            <button onclick="showDate()">显示日期</button>
        </div>
        <h2><span id="span-date"></span></h2>
    </div>
    <script>
        function showDate() {
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var strDate ="UTC时间：" + date.toUTCString();
            strDate += "<br>格式化时间：" + year + "年" + month + "月" + day + "日" +
                " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
            document.getElementById("span-date").innerHTML = strDate;
        }
    </script>
</body>
</html>
