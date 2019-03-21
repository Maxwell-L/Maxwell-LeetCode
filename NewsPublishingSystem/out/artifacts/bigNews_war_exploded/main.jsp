<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/7
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.vo.User" %>
<html>
  <head>
    <title>主页面</title>
  </head>
  <frameset rows="20%, 80%" border="2" frameborder="yes">
    <frame src="title.jsp" name="title">
    <frameset cols="20%, 80%" frameborder="yes" border="2">
      <frame src="menu.jsp" name="menu">
      <frame src="content.jsp" name="content">
    </frameset>
  </frameset>
  <body>

  </body>
</html>
