<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/17
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册错误页面</title>
</head>
<body>
<h1 style="color:red;text-align:center">操作失败</h1>
<div>
    <%
        List<String> errorList = (List<String>)request.getAttribute("errorList");
    %>
    你的输入有以下错误，请重新输入：<br>
    <%
        for(String error : errorList){
    %>
    <%=error%><br>
    <%
        }
    %>
</div>
<br>请点击<input type = "button" value = "返回" onclick="history.back()">
</body>
</html>
