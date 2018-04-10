
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>具体商品信息展示</title>
</head>
<body>

    <div class="container">
        <h2>商品名称: ${product.productName}</h2>
        <ul class="list-group">
            <li class="list-group-item">${product.place}</li>
            <li class="list-group-item">${product.price}</li>
            <li class="list-group-item">${product.marketPrice}</li>
        </ul>
    </div>
</body>
</html>
