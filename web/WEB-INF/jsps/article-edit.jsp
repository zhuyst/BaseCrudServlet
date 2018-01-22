<%@ page import="enums.CrudTypeEnum" %>
<%@ page import="pojo.ArticleDTO" %>
<%@ page import="pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Article" %>
<%@ page import="util.SessionUtils" %><%--
  Created by IntelliJ IDEA.
  User: zhuyst
  Date: 2017/11/29
  Time: 12:00
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
            ArticleDTO pojo = (ArticleDTO) request.getAttribute("entity");
            if(typeEnum == CrudTypeEnum.QUERY || typeEnum == CrudTypeEnum.UPDATE){
                title = "文章 - " + pojo.getTitle() + " - " + typeEnum.getName();
            }
            else if(typeEnum == CrudTypeEnum.INSERT){
                Article article = new Article();
                article.setTitle("");
                article.setContent("");
                pojo = new ArticleDTO(article);

                Student student = SessionUtils.getStudent(session);
                pojo.setStudent(student);

                title = "新增文章";
            }
        %>
        <%=title%>
    </title>
    <script>
        function loadImg(){
            var img = document.getElementById("img");

            //获取文件
            var file = img.files[0];

            //创建读取文件的对象
            var reader = new FileReader();

            //创建文件读取相关的变量
            var imgFile;

            //为文件读取成功设置事件
            reader.onload=function(e) {
                imgFile = e.target.result;
                document.getElementById("imgContent").setAttribute("src",imgFile);
            };

            //正式读取文件
            reader.readAsDataURL(file);
        }
    </script>
    <style>
        .disable{
            background: #ccc;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/article" method="post" enctype="multipart/form-data">
    <input type="hidden" name="type" value="<%=typeEnum.getValue()%>">
    <%
        if(typeEnum != CrudTypeEnum.INSERT){
    %>
    <label>
        ID:
        <input type="text" name="id" value="<%=pojo.getId()%>" class="disable" readonly>
        <br/>
        <br/>
    </label>
    <input type="hidden" name="studentId" value="<%=pojo.getStudent().getId()%>">
    <label>
        学生用户名：
        <%=pojo.getStudent().getName()%>
        <br/>
        <br/>
    </label>
    <%
        }
        else {
    %>
    <label>
        学生姓名：
        <input type="text" value="<%=pojo.getStudent().getName()%>" class="disable" readonly>
        <br/>
        <br/>
    </label>
    <%
        }
    %>
    <label>
        论文标题：
        <input type="text" name="title" value="<%=pojo.getTitle()%>" <%=readonly%> required>
        <br/>
        <br/>
    </label>
    <label>
        论文封面：
        <%
            if(typeEnum != CrudTypeEnum.QUERY){
        %>
        <input type="file" id="img" name="newPicture" accept="image/*" onchange="loadImg()">
        <br/>
        <br/>
        <%
            }
            if(pojo.getPicture() != null){
        %>
        <input type="hidden" name="picture" value="<%=pojo.getPicture()%>">
        <img src="${pageContext.request.contextPath}/article/show?id=<%=pojo.getId()%>"
             id="imgContent" style="max-height: 300px"/>
        <%
            }
            else{
        %>
        <img src="" id="imgContent" style="max-height: 300px"/>
        <%
            }
        %>
        <br/>
        <br/>
    </label>
    <label>
        论文内容：
        <textarea name="content" cols="50" rows="10" <%=readonly%> required>
            <%=pojo.getContent()%>
        </textarea>
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
