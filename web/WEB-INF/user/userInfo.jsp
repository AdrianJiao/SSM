<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2018/4/8
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
   用户名：${user.username}|<br>
   年龄: ${user.age}|<br>
   生日：${user.birthday}|<br>
   头像：<img src="${pageContext.request.contextPath}/file/${user.headportrait}">
</body>
</html>
