<%--
  Created by IntelliJ IDEA.
  User: Legion_133
  Date: 2024/9/24
  Time: 23:09
  To change this template use File | Settings | File Templates.
  Task: 用JSP声明编写一个函数，输入一个整数参数、以集合形式表示各种纸币找零的数量，输入1-100中的数值。假如系统中有50、20、10、5、1
  这5中面额的纸币，显示每种纸币应该找的数量。例如，78应该中50元1张、20元1张、5元1张、1元3张。
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%!
    public String getChange(int amount) {
        // 定义纸币面额
        int[] denominations = {50, 20, 10, 5, 1};
        // 用于存储每种纸币的数量
        StringBuilder result = new StringBuilder();

        // 遍历每种面额
        for (int denomination : denominations) {
            if (amount == 0) {
                break;
            }
            int count = amount / denomination;
            amount = amount - (count * denomination);
            result.append(denomination + "元" + count + "张, ");
        }

        // 去掉最后一个逗号
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
%>

<html>
<head>
    <title>找零系统</title>
</head>
<body>
<form method="post">
    <label for="amount">请输入金额（1-100）：</label>
    <input type="number" id="amount" name="amount" min="1" max="100" required>
    <input type="submit" value="计算找零">
</form>

<%
    // 接收用户输入并调用函数
    String changeResult = "";
    String amountStr = request.getParameter("amount");
    if (amountStr != null) {
        int amount = Integer.parseInt(amountStr);
        changeResult = getChange(amount);
    }
%>

<p>
    <% if (!changeResult.isEmpty()) { %>
    找零结果：<%= changeResult %>
    <% } else { %>
    请输入金额并提交。
    <% } %>
</p>
</body>
</html>
