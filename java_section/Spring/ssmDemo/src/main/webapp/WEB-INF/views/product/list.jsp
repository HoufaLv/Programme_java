<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <title>展示商品列表</title>
</head>
<body>


    <h3>商品列表</h3>
    <c:if test="${not empty message}">
        <div class="alert alert-info">${message}</div>
    </c:if>
    <a href="/product/new" class="btn btn-primary">添加商品</a>

    <%--实现动态查询效果--%>
    <div class="well-sm">
        <form method="get" class="form-inline">
            <%--将这个表单提交,会提交到 list 那个controller --%>
            <input type="text" name="productName" placeholder="商品名称" class="form-control" value="${param.productName}">
            <input type="text" name="place" placeholder="产地" class="form-control" value="${param.place}">
            <input type="number" name="minPrice" placeholder="最低价格" class="form-control" value="${param.minPrice}">
            <input type="number" name="maxPrice" placeholder="最高价格" class="form-control" value="${param.maxPrice}">
            <button class="btn btn-default">搜索</button>
        </form>
    </div>

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
    <label class="alert alert-info">共: ${pageInfo.total}条记录</label>
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
            /*去下一页的时候,把搜索框里面的productName 带上,不然就会http://localhost:8080/product?p=2*/
            /*但是需要的是                                      http://localhost:8080/product?productName=SONY&p=3*/
            href: "?productName="+encodeURIComponent('${param.productName}')+
            "&place="+encodeURIComponent('${param.place}')+
            "&minPrice="+encodeURIComponent('${param.minPrice}')+
            "&maxPrice="+encodeURIComponent('${param.maxPrice}')+
            "&p={{number}}"
        });

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
