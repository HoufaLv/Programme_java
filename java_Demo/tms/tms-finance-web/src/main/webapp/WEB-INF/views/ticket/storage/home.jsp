<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>票务首页</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhead.jsp"%>

    <!-- =============================================== -->

    <%-- 该指令会传递需要的参数 --%>
    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="home"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>it all starts here</small>
            </h1>
        </section>


        <section class="content">

        <div class="box">
            <div class="box-header">
                <h4 class="box-title">新增年票入库</h4>
                <div class="box-tools">
                    <a href="/ticket/storage/new" class="btn btn-sm btn-success"><i class="fa fa-plus"></i> 新增入库</a>
                </div>
            </div>
        </div>

        </section>

    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script>
    /* 使用js 控制表单提交 */
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
    });
</script>
</body>
</html>
