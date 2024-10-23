<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/23
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<script src="js/addcart.js"></script>
</body>
</html>
