<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP - JDBC</title>
</head>
<body>

<%--    <%--%>
<%--        String jdbc_driver = "com.mysql.cj.jdbc.Driver";--%>
<%--        String db_url = "jdbc:mysql://*******:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";--%>
<%--        String db_user = "test";--%>
<%--        String db_password = "*******";--%>

<%--        try {--%>
<%--            Class.forName(jdbc_driver);--%>
<%--        } catch (ClassNotFoundException e) {--%>
<%--            throw new RuntimeException(e);--%>
<%--        }--%>

<%--        try {--%>
<%--                Connection conn = DriverManager.getConnection(db_url, db_user, db_password);--%>
<%--            Statement stmt = conn.createStatement();--%>
<%--            String sql = "insert into goods(gName, gPrice) values('红米 K30Pro', '2699.00')";--%>
<%--            int i = stmt.executeUpdate(sql);--%>

<%--            out.println("成功添加" + i + "行数据");--%>
<%--            stmt.close();--%>
<%--            conn.close();--%>

<%--            } catch (SQLException e) {--%>
<%--                throw new RuntimeException(e);--%>
<%--            }--%>
<%--    %>--%>

    <%
        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String db_url = "jdbc:mysql://*******:3306/jsp_db?useUnicode=true&characterEncoding=UTF-8";
        String db_user = "test";
        String db_password = "*******";

        try {
            Class.forName(jdbc_driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection conn = DriverManager.getConnection(db_url, db_user, db_password);
            Statement stmt = conn.createStatement();
            String sql = "select gId, gName, gPrice from goods where gName like '红米%'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String gId = rs.getString("gId");
                String gName = rs.getString("gName");
                String gPrice = rs.getString("gPrice");
                out.println(gId + "&nbsp;" + gName + "&nbsp;" + gPrice + "<br>");
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    %>
</body>
</html>