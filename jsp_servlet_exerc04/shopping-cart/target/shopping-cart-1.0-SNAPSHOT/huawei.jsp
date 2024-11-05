<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/23
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>华为手机选购页面</title>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <td>商品号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>数量</td>
        <td></td>
    </tr>
    <tr>
        <td>1004</td>
        <td>华为Mate30</td>
        <td>3699.00</td>
        <td>
            <label>
                <input type="number" name="1004" min="1" value="1" size="5"/>
            </label>
        </td>
        <td>
            <a class="link" id="1004">加入购物车</a>
        </td>
    </tr>
    <tr>
        <td>1005</td>
        <td>华为P40</td>
        <td>4188.00</td>
        <td>
            <label>
                <input type="number" name="1005" min="1" value="1" size="5"/>
            </label>
        </td>
        <td>
            <a class="link" id="1005">加入购物车</a>
        </td>
    </tr>
    <tr>
        <td>1006</td>
        <td>华为Nova6</td>
        <td>3499.00</td>
        <td>
            <label>
                <input type="number" name="1006" min="1" value="1" size="5"/>
            </label>
        </td>
        <td>
            <a class="link" id="1006">加入购物车</a>
        </td>
    </tr>
</table>
<script>
    const links = document.getElementsByClassName("link");
    for (let i = 0; i < links.length; i++) {
        let gid = links[i].getAttribute("id");
        links[i].addEventListener("click", function () {
            let count = document.getElementsByName(gid)[0].value;
            console.log(gid + " " + count);
            window.location.href = "AddCartServlet?gid=" + gid + "&gcount=" + count;
        })
    }
</script>
</body>
</html>
