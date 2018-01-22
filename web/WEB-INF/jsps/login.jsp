<%--
  Created by IntelliJ IDEA.
  User: 13553
  Date: 2017/12/19
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label>
        学生姓名：
        <input type="text" name="name" value="">
    </label>
    <br/><br/>
    <input type="submit" value="登陆">
</form>
<p class="error">${error}</p>
</body>
</html>
