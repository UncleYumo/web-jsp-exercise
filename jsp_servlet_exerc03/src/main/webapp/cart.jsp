<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/10/23
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ page import="com.example.bean.Goods,java.util.ArrayList" %>
<%-- 使用<jsp:useBean>标签引入session中存储的Cart对象 --%>
<jsp:useBean id="cart" class="com.example.bean.Cart" scope="session"/>
<%
    if (cart == null || cart.getGoodsList().size() == 0) {
        out.println("购物车为空！");
    } else {
        ArrayList<Goods> goodsList = cart.getGoodsList();
    }
%>
当前购物车共有<%=cart.getGcount()%>件物品<br>
<table>
    <tr>
        <td>序号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>数量</td>
        <td>小计</td>
        <td></td>
    </tr>
    <%
        ArrayList<Goods> goodsList_temp = cart.getGoodsList();
        for (int i = 0; i < goodsList_temp.size(); i++) { Goods goods = goodsList_temp.get(i); %>
    <tr>
        <td><%=i+1%></td>
        <td><%=goods.getGname()%></td>
        <td><%=String.format("%.2f", goods.getGprice())%></td>
        <td><%=goods.getGcount()%></td>
        <td><%=String.format("%.2f", goods.getGprice()*goods.getGcount())%></td>
    </tr><%}%>
    <tr><td>总计:<%=String.format("%.2f", cart.getTotal())%></td></tr>
</table>

