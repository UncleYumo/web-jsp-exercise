<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/9/25
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册界面</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }
        input[type="text"], input[type="password"] {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>注册</h1>

    <div>
        <label for="username">用户名</label>
        <input type="text" id="username" required>
    </div>
    <div>
        <label for="password">密  码</label>
        <input type="password" id="password" required>
    </div>
    <div>
        <input type="button" value="注册" id="register">
        <input type="reset" value="重置" id="reset">
    </div>
    <div id="responseMessage"></div> <!-- 用于显示返回信息 -->
</div>

<script>
    const RegisterUrl = "http://localhost:8080/jsp_servlet_exerc01/register";
    document.getElementById("register").addEventListener("click", function() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if (username === "" || password === "") {
            alert("用户名或密码不能为空！");
            return;
        }

        const xhr = new XMLHttpRequest();
        xhr.open("POST", RegisterUrl, true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const responseText = xhr.responseText;
                // 显示返回信息
                console.log(responseText);
                const respParts = responseText.split("|");
                console.log(respParts);
                if (respParts[0] === '1') {
                    // window.location.href = respParts[1];
                    alert("注册成功 | " + responseText);
                    window.location.href = respParts[1].trim();
                } else {
                    alert("注册失败 | " + responseText);
                    window.location.href = respParts[1].trim();
                }
            }
        };
        xhr.send("username=" + username + "&password=" + password);
    });
</script>
</body>
</html>
