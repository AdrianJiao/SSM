<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2018/4/8
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login.do" method="post">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="text" name="password"> <br>
        <input type="submit" value="登陆">
    </form>
</body>
</html>
