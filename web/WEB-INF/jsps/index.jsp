<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>管理主界面</title>
  </head>
  <body>
<button type="button"
        onclick="window.location.href='${pageContext.request.contextPath}/student'">
  学生管理
</button>
<button type="button"
        onclick="window.location.href='${pageContext.request.contextPath}/article'">
  论文管理
</button>
  </body>
</html>