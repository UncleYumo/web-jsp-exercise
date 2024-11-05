<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/11/5
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小米手机选购页面</title>
</head>
<body>
<%@include file="header.jsp" %>
<table>
    <tr>
        <td>商品号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>数量</td>
        <td></td>
    </tr>
    <tr>
        <td>1001</td>
        <td>小米 10</td>
        <td>3999.00</td>
        <td>
            <label>
                <input type="number" name="1001" min="1" value="1" size="5"/>
            </label>
        </td>
        <td>
            <a class="link" id="1001">加入购物车</a>
        </td>
    </tr>
    <tr>
        <td>1002</td>
        <td>红米 K30</td>
        <td>1999.00</td>
        <td>
            <label>
                <input type="number" name="1002" min="1" value="1" size="5"/>
            </label>
        </td>
        <td>
            <a class="link" id="1002">加入购物车</a>
        </td>
    </tr>
    <tr>
        <td>1003</td>
        <td>红米 Note8</td>
        <td>999.00</td>
        <td>
            <label>
                <input type="number" name="1003" min="1" value="1" size="5"/>
            </label>
        </td>
        <td>
            <a class="link" id="1003">加入购物车</a>
        </td>
    </tr>
</table>
<script>
    // 点击“加入购物车”按钮，将商品信息和数量信息传递给Servlet
    const links = document.getElementsByClassName("link"); // 获取所有“加入购物车”按钮
    for (let i = 0; i < links.length; i++) {
        let gid = links[i].getAttribute("id");  // 获取商品号 - gid
        // 给“加入购物车”按钮添加点击事件，并将商品信息和数量信息传递给Servlet
        links[i].setAttribute("href", "javascript:void(0);onClick=addToCart(" + gid + ")");
    }

    function addToCart(gid) {
        let label = document.getElementsByName(gid);
        let count = label[0].value;
        // 将商品信息和数量信息传递给Servlet
        window.location.href = "AddCartServlet?gid=" + gid + "&gcount=" + count;
    }

</script>
</body>
</html>