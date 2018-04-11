<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <form method="post" class="form-group">
        <legend>修改商品</legend>
        <select name="typeId" class="form-control">
            <c:forEach items="${productTypeList}" var="type">
                <option value="${type.id}">${type.typeName}</option>
            </c:forEach>
        </select>
        商品名称: <input type="text" class="form-control" name="productName" value="${product.productName}">
        商品价格: <input type="text" class="form-control" name="price" value="${product.price}">
        商品市场价: <input type="text" class="form-control" name="marketPrice" value="${product.marketPrice}">
        商品产地: <input type="text" class="form-control" name="place" value="${product.place}">

        <button>保存</button>
    </form>
</div>
</body>
</html>