
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>具体商品信息展示</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>商品名称: ${product.productName}</h2>
        <ul class="list-group">
            <li class="list-group-item">商品产地: ${product.place}</li>
            <li class="list-group-item">商品价格: ${product.price}</li>
            <li class="list-group-item">商品市场价: ${product.marketPrice}</li>
        </ul>
    </div>
</body>
</html>
