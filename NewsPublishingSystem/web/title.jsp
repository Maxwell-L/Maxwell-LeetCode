<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/7
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.lang.String"%>
<%@ page import="java.lang.Object" %>
<%@ page import="com.vo.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
%>
    <h1>欢迎<%=user.getUsername()%></h1>
</body>
</html>
