<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view customer jsp</title>
</head>
<body>

<h1>接收到的id为: ${id}</h1>
<h1>接收到的gender 为: <c:if test="${gender==1}">男</c:if><c:if test="${gender==2}">女</c:if></h1>
</body>
</html>
