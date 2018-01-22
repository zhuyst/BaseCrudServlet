<%@ page import="enums.CrudTypeEnum" %>
<%@ page import="pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: zhuyst
  Date: 2017/11/28
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CrudTypeEnum typeEnum = (CrudTypeEnum) request.getAttribute("type");
    String readonly = "";
    if(typeEnum == CrudTypeEnum.QUERY){
        readonly = "readonly";
    }
%>
<html>
<head>
    <title>
        <%
            String title = "";
            Student student = (Student) request.getAttribute("entity");
            if(typeEnum == CrudTypeEnum.QUERY || typeEnum == CrudTypeEnum.UPDATE){
                title = "学生 - " + student.getId() + " - " + typeEnum.getName();
            }
            else if(typeEnum == CrudTypeEnum.INSERT){
                student = new Student();
                student.setName("");
                student.setSchool("");
                title = "新增学生";
            }
        %>
        <%=title%>
    </title>
    <style>
        .disable{
            background: #ccc;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/student" method="post">
    <input type="hidden" name="type" value="<%=typeEnum.getValue()%>">
    <%
        if(typeEnum != CrudTypeEnum.INSERT){
    %>
    <label>
        ID:
        <input type="text" name="id" value="<%=student.getId()%>" class="disable" readonly>
        <br/>
        <br/>
    </label>
    <%
        }
    %>
    <label>
        姓名：
        <input type="text" name="name" value="<%=student.getName()%>" <%=readonly%> required>
        <br/>
        <br/>
    </label>
    <label>
        学校：
        <input type="text" name="school" value="<%=student.getSchool()%>" <%=readonly%>>
        <br/>
        <br/>
    </label>
    <%
        if(typeEnum != CrudTypeEnum.QUERY){
    %>
    <button type="submit"><%=typeEnum.getName()%></button>
    <%
        }
    %>
    <button type="button" onclick="window.history.back()">返回</button>
</form>
</body>
</html>
