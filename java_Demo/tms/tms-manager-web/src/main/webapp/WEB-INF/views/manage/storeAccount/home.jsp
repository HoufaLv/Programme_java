<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>账号管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <%@include file="../../include/css.jsp" %>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp" %>

    <!-- =============================================== -->

    <%@include file="../../include/sider.jsp" %>


    <!-- =============================================== -->

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->

        <section class="content-header">
            <h1>
                销售点账户管理
            </h1>
        </section>

        <section class="content">

            <%-- 动态搜索框 --%>
                <div class="box">
                    <div class="box-body">
                        <form method="get" class="form-inline">
                            <input type="text" name="storeName" class="form-control" placeholder="售票点名称" value="${param.storeName}">
                            <input type="text" name="storeManager" class="form-control" placeholder="联系人" value="${param.storeManager}">
                            <input type="text" name="storeTel" class="form-control" placeholder="联系电话" value="${param.storeTel}">
                            <button class="btn btn-default">搜索</button>
                        </form>
                    </div>
                </div>

            <%--展示账号--%>
            <div class="box">
                <%--新增账号选项--%>
                <div class="box-header">
                    <div class="box-tools">
                        <a href="/manage/storeAcc/new" class="btn btn-success btn-sm">新增销售点账户</a>
                    </div>
                </div>

                <div class="box-body">
                    <table class="table">
                         <tr>
                             <th>营业点名称</th>
                             <th>营业点地址</th>
                             <th>营业点电话</th>
                             <th>营业点法人</th>
                             <th>操作</th>
                         </tr>
                        <c:forEach items="${ticketStoreList}" var="ticketStore">
                            <tr>
                                <td>${ticketStore.storeName}</td>
                                <td>${ticketStore.storeAddress}</td>
                                <td>${ticketStore.storeTel}</td>
                                <td>${ticketStore.storeManager}</td>
                                <td><a href="/manage/storeAcc/${ticketStore.id}/update" class="btn btn-primary">修改</a> <a href="javascript:;" class="btn btn-danger">删除</a> </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </section>

    </div>
    <!-- /.content-wrapper -->


    <%@include file="../../include/footer.jsp" %>
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp" %>

<%-- 引入layer.js --%>
<script src="/static/plugins/layer/layer.js"></script>
<script>

</script>
</body>
</html>

