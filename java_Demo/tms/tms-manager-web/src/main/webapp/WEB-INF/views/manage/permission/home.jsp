<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Blank Page</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <%@include file="../../include/css.jsp" %>
    <link rel="stylesheet" href="/static/bower_components/maxazan-jquery-treegrid-447d662/css/jquery.treegrid.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/header.jsp" %>

    <%@include file="../../include/sider.jsp" %>

    <%-- 右侧内容部分 --%>
    <div class="content-wrapper">
        <%-- 好像一个panel 一样 --%>
        <section class="content-header">
            <h3>权限管理</h3>
        </section>

        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">权限列表</h3>
                    <a href="/manage/permission/new" class="btn btn-success btn-sm pull-right"><i
                            class="fa fa-plus"></i> 新增权限</a>
                </div>

                <%-- 将权限以父子关系展示出来 --%>
                <%-- 下面是内容区域 --%>
                <div class="box-body">
                    <table class="table tree">
                        <thead>
                        <th>权限名称</th>
                        <th>权限代号</th>
                        <th>类型</th>
                        <th>#</th>
                        </thead>
                        <tbody>

                        </tbody>
                        <tfoot></tfoot>
                    </table>

                </div>
            </div>


        </section>

    </div>

    <%-- 底部部分 --%>
    <%@include file="../../include/footer.jsp" %>
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp" %>
<%-- 引入treegrid.js --%>
<script src="/static/bower_components/maxazan-jquery-treegrid-447d662/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/bower_components/maxazan-jquery-treegrid-447d662/js/jquery.treegrid.js"></script>
<script>
    $(function () {
        $('.tree').treegrid();
    });
</script>

</body>
</html>

