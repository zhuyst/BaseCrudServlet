<%@ taglib prefix="page" uri="http://www.zhuyst.cc" %>
<%@ page import="enums.CrudTypeEnum" %>
<%@ page import="pojo.ArticleDTO" %>
<%@ page import="pojo.Page" %>
<%@ page import="pojo.Student" %>
<%@ page import="util.SessionUtils" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuyst
  Date: 2017/11/29
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Page<ArticleDTO> pageInfo = (Page<ArticleDTO>) request.getAttribute("page");
    Student student = SessionUtils.getStudent(session);
%>
<html>
<head>
    <title>论文管理界面</title>
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
        onclick="window.location.href='${pageContext.request.contextPath}/article?type=<%=CrudTypeEnum.INSERT.getValue()%>'">
    新增论文
</button>
<button type="button"
        onclick="window.location.href='${pageContext.request.contextPath}/student'">
    学生管理
</button>
<br/>
<br/>
<table cellpadding="5" cellspacing="1" border="1">
    <thead>
    <tr>
        <td>ID</td>
        <td>论文标题</td>
        <td>学生姓名</td>
        <td>查看</td>
        <td colspan="2">操作</td>
    </tr>
    </thead>
    <tbody>
    <%
        for(ArticleDTO pojo : pageInfo.getList()){
    %>
    <tr>
        <td><%=pojo.getId()%></td>
        <td><%=pojo.getTitle()%></td>
        <td><%=pojo.getStudent().getName()%></td>
        <td>
            <button type="button"
                    onclick="window.location.href='${pageContext.request.contextPath}/article?type=<%=CrudTypeEnum.QUERY.getValue()%>&id=<%=pojo.getId()%>'">
                查看
            </button>
        </td>
        <%
            if(student.getId().equals(pojo.getStudentId())){
        %>
        <td>
            <button type="button"
                    onclick="window.location.href='${pageContext.request.contextPath}/article?type=<%=CrudTypeEnum.UPDATE.getValue()%>&id=<%=pojo.getId()%>'">
                修改
            </button>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/article" method="post">
                <input type="hidden" name="type" value="<%=CrudTypeEnum.DELETE.getValue()%>">
                <input type="hidden" name="id" value="<%=pojo.getId()%>">
                <button type="submit">删除</button>
            </form>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<page:page url="${pageContext.request.contextPath}/article" page="<%=pageInfo%>" />
</body>
</html>
