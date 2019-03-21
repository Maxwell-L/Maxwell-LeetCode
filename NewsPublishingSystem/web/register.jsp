<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/17
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="css/reg.css">
    <%--<script src = "js/reg.js"></script>--%>
</head>
<body>
<div class="block">
    <h1 class="register-title">创建账户</h1>
<form action = "RegisterServlet" method = "post">
<%--<form action = "RegisterServlet" onsubmit="return check()" method = "post">--%>
    <%--<div id="username">--%>
        <%--<input class="user" type="text" name="username" placeholder="请输入用户名" onblur="checkUsername()" onfocus="oFocus_username()">--%>
    <%--</div>--%>
    <p id = "remind_1"></p>
    <table style="font-size: x-large">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input type="password" name="repassword"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="sex" value="男" checked>男
            <input type="radio" name="sex" value="女">女</td>
        </tr>
        <tr>
            <td>职业</td>
            <td><input type="text" name="profession"></td>
        </tr>
        <tr>
            <td>个人爱好</td>
            <td><input type="checkbox" name="favourite" value="电脑网络">电脑网络
                <input type="checkbox" name="favourite" value="影视娱乐">影视娱乐</td>
        </tr>
        <tr>
            <td></td><td><input type="checkbox" name="favourite" value="棋牌娱乐">棋牌娱乐</td>
        </tr>
        <tr>
            <td>个人说明</td>
            <td><textarea name="note" rows="4" cols="22"></textarea></td>
        </tr>
    </table>
    <div><td><input type="submit" value="注册" name="submit"></div>
    <div><input type="button" value="登录" onclick=window.location.href="login.jsp"></div>
</form>
</div>
</body>
</html>
