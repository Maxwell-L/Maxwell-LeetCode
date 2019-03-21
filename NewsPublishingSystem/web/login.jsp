<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/18
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="css/login.css">
    <%--<script src="js/login.js"></script>--%>
</head>
<body>
<div class="block">
    <h1 class="login-title">登录</h1>
    <form action="LoginServlet" method="post" name="login">
        <table style="font-size: x-large">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <div class="signup"><input type="submit" value="登录"></div>

                <%--<td><input type="submit" name="submit" value="登录"></td>--%>
        <input type="button" name="register" value="注册" onclick=window.location.href="register.jsp">

    </form>
</div>
</body>
</html>
