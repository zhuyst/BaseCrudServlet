<%@ taglib prefix="page" uri="http://www.zhuyst.cc" %>
<%@ page import="pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="enums.CrudTypeEnum" %>
<%@ page import="pojo.Page" %><%--
  Created by IntelliJ IDEA.
  User: zhuyst
  Date: 2017/11/28
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Page<Student> pageInfo = (Page<Student>) request.getAttribute("page");
    String name = request.getParameter("name");
    if(name == null){
        name = "";
    }
%>
<html>
<head>
    <title>学生管理界面</title>
    <style>
        form{
            margin-bottom: 0;
        }
        .pager{
            position: relative;
            top: 20px;
        }
        .page{
            border: 1px solid black;
            padding: 10px;
        }
    </style>
</head>
<body>
<button type="button"
        onclick="window.location.href='${pageContext.request.contextPath}/student?type=<%=CrudTypeEnum.INSERT.getValue()%>'">
      新增学生
</button>
<button type="button"
        onclick="window.location.href='${pageContext.request.contextPath}/article'">
    论文管理
</button>
<br/>
<br/>
<form action="${pageContext.request.contextPath}/student" method="get">
    <label>
        搜索：学生姓名
        <input type="text" name="name" value="<%=name%>" />
    </label>
    <input type="submit" value="搜索">
</form>
<br/>
<table cellpadding="5" cellspacing="1" border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>学校</td>
        <td colspan="3">操作</td>
    </tr>
    </thead>
    <tbody>
    <%
        for(Student student : pageInfo.getList()){
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getSchool()%></td>
        <td>
            <button type="button"
                    onclick="window.location.href='${pageContext.request.contextPath}/student?type=<%=CrudTypeEnum.QUERY.getValue()%>&id=<%=student.getId()%>'">
                查看
            </button>
        </td>
        <td>
            <button type="button"
                    onclick="window.location.href='${pageContext.request.contextPath}/student?type=<%=CrudTypeEnum.UPDATE.getValue()%>&id=<%=student.getId()%>'">
                修改
            </button>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/student" method="post">
                <input type="hidden" name="type" value="<%=CrudTypeEnum.DELETE.getValue()%>">
                <input type="hidden" name="id" value="<%=student.getId()%>">
                <button type="submit">删除</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<page:page url="${pageContext.request.contextPath}/student" page="<%=pageInfo%>"/>
</body>
</html>
