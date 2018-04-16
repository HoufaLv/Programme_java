<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <%--使用动态包含,可以传递不同参数--%>
    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="manage_roles"></jsp:param>
    </jsp:include>


    <%-- 右侧内容部分 --%>
    <div class="content-wrapper">
        <%-- 好像一个panel 一样 --%>
        <section class="content-header">
            <h3>角色管理</h3>
        </section>

        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">角色列表</h3>
                    <a href="/manage/role/new" class="btn btn-success btn-sm pull-right"><i
                            class="fa fa-plus"></i> 新增角色</a>
                </div>

                <div class="box-body">
                    <%-- 在此处完成展示角色功能 --%>
                    <table class="table tree">
                        <thead>
                        </thead>
                        <tbody>
                            <%-- 展示rolesList 信息, 将名字和权限分两行来显示,第一行显示角色名称,第二行显示对应的权限 --%>
                            <c:forEach items="${rolesList}" var="role">
                                <tr class="bg-purple">
                                    <%-- 显示角色名字 --%>

                                    <td>
                                        <strong>角色名称</strong> ${role.rolesName}
                                        <a rel="${role.id}" href="#" class="btn-sm btn-success pull-right">编辑</a>
                                        <a rel="${role.id}" href="#" class="btn-sm btn-danger pull-right">删除</a>
                                    </td>
                                </tr>

                                <%--再来一个循环,显示对应的权限--%>

                                <tr>
                                    <td>
                                        <c:forEach items="${role.permissionList}" var="permission">
                                            <strong>拥有权限: </strong> <i class="fa fa-key"></i> ${permission.permissionName}
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
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
<script src="/static/bower_components/maxazan-jquery-treegrid-447d662/js/jquery.treegrid.js"></script>
<script src="/static/bower_components/maxazan-jquery-treegrid-447d662/js/jquery.treegrid.bootstrap3.js"></script>
<%-- 引入layer.js --%>
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function () {
        $('.tree').treegrid();

        /*/!* 完成删除功能 *!/
        $(".delPermission").click(function () {
            /!* 获取要删除的id *!/
            var id = $(this).attr("rel");
            layer.confirm("将会删除权限",function (index) {
                layer.close(index);
                $.get("/manage/permission/"+id+"/del").done(function (result) {
                    if(result.status == 'success') {
                        /!* 刷新页面 *!/
                        history.go(0);
                    } else {
                        /!* 显示状态信息 *!/
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙");
                });
            })
        });*/
    });
</script>

</body>
</html>

