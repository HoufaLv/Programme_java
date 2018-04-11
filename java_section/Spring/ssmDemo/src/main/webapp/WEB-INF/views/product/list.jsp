<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示商品列表</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<h3>商品列表</h3>
<c:if test="${not empty message}">
    <div class="alert alert-info">${message}</div>
</c:if>
<a href="/product/new" class="btn btn-primary">添加商品</a>
<table class="table">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品市场价</th>
        <th>商品产地</th>
        <th>商品分类</th>
        <th>#</th>
    </tr>
    <%-- 遍历pageInfo 中的List 获取数据 --%>
    <c:forEach items="${pageInfo.list}" var="product">
        <tr>
            <td><a href="#">${product.productName}</a></td>
            <td>${product.price}</td>
            <td>${product.marketPrice}</td>
            <td>${product.place}</td>
            <td>${product.productType.typeName}</td>
            <td><a id="editProduct" rel="${product.id}" href="/product/${product.id}/edit">编辑</a> / <a id="deleteProduct" rel="${product.id}" href="javascript:;">删除</a></td>
        </tr>
    </c:forEach>
</table>
<ul id="pagination-demo" class="pagination pull-right"></ul>


<script src="/static/js/jquery-1.12.4.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/jquery.twbsPagination.js"></script>
<script>
    $(function () {
        //分页
        $('#pagination-demo').twbsPagination({
            totalPages: ${pageInfo.pages},
            visiblePages: 10,
            first: '首页',
            last: '末页',
            prev: '←',
            next: '→',
            href: "?p={{number}}"
        });

        /* //编辑
         $("#editProduct").click(function (s) {
             var id = $("#editProduct").attr("rel");
             window.location.href = "/product/" + id + "/edit"
         });*/

        //删除
        $("#deleteProduct").click(function (s) {
            var id = $("#deleteProduct").attr("rel");
            if (confirm("是否要删除商品")) {
                window.location.href = "/product/" + id + "/del";
            }
        });

    });
</script>
</body>
</html>
