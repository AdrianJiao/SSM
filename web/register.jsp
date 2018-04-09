<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 2018/4/8
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
   <form action="${pageContext.request.contextPath}/register.do" method="post" enctype="multipart/form-data">
       用户名：<input type="text" name="username"> <br>
       密码：<input type="text" name="password"> <br>
       年龄：<input type="text" name="age"> <br>
       生日：<input type="text" name="birthday"> <br>
       上传图片：<input type="file" name="picture"> <br>
       <input type="submit" value="注册">
   </form>
</body>
</html>
