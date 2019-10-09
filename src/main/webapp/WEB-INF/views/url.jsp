<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/8 0008
  Time: 上午 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" isELIgnored="false" %>
<html>
<head>
    <title>URL</title>
</head>
<body>
<h1>${message}</h1>
名字:${name}
年龄:${age}
<br>

<form action="${pageContext.request.contextPath}/login" method="post">
    用户：<input type="text" name="name"><br>
    密码：<input type="password" name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
