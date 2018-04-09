<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

<%--设置表单格式为文件上传格式--%>
<form action="/upload" method="post" enctype="multipart/form-data">

文件名: <input type="text" name="fileName"> <br>
    <input type="file" name="uploadFile">
    <button>上传</button>
    <c:if test="${not empty message}">
        <h3>${message}</h3>
    </c:if>

</form>
</body>
</html>
