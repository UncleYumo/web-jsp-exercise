<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ page import="cn.uncleyumo.shoppingcart.bean.Goods, java.util.ArrayList" %>
<%--使用<jsp:useBean> 引入session中的Cart对象--%>
<jsp:useBean id="cart" class="cn.uncleyumo.shoppingcart.bean.Cart" scope="session">
</jsp:useBean>
<%
    if (cart == null || cart.getGoodsList().isEmpty()) {
        out.println("购物车为空！");
    } else {
        ArrayList<Goods> goodsList = cart.getGoodsList();
    }
    assert cart != null;%>
当前购物车共有<%=cart.getCount()%>件物品<br>
<table>
    <tr>
        <td>序号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>数量</td>
        <td>小计</td>
        <td>操作</td>
        <td></td>
    </tr>
    <%
        ArrayList<Goods> goodsList_temp = cart.getGoodsList();
        for (int i = 0; i < goodsList_temp.size(); i++) {
            Goods goods = goodsList_temp.get(i); %>
    <tr>
        <td><%=i + 1%>
        </td>
        <td><%=goods.getGname()%>
        </td>
        <td><%=String.format("%.2f", goods.getGprice())%>
        </td>
        <td><%=goods.getGcount()%>
        </td>
        <td><%=String.format("%.2f", goods.getGprice() * goods.getGcount())%>
        </td>
        <td><a href="DeleteCartServlet?gid=<%=goods.getGid()%>">删除</a></td>
    </tr>
    <%}%>
    <tr>
        <td>总计:<%=String.format("%.2f", cart.getTotal())%>
        </td>
    </tr>
</table>