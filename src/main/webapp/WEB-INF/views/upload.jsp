<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/9 0009
  Time: 上午 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
    <title>图片上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploadImage" method="post" enctype="multipart/form-data">
    选择图片:<input type="file" name="image" accept="image/*" /> <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
