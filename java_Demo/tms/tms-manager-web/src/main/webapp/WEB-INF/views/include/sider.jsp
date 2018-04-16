<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>

            <%-- 标记class 为treeview 的都是有下拉效果的菜单 --%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-dashboard"></i> <span>首页</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>

            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-files-o"></i>
                    <span>系统管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
            </li>

            <li>
                <a href="#">
                    <i class="fa fa-th"></i> <span>账号管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
            </li>
            <li class=""${param.menu=='manage_roles' ? 'active' : ''}"">
                <a href="/manage/role">
                    <i class="fa fa-pie-chart"></i>
                    <span>角色管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <i class="fa fa-angle-left pull-right"></i>
            </li>

            <li class="${param.menu=='manage_permission' ? 'active' : ''}">
                <a href="/manage/permission">
                    <i class="fa fa-pie-chart"></i>
                    <span>权限管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <i class="fa fa-angle-left pull-right"></i>
            </li>



    </section>
    <!-- /.sidebar -->
</aside>