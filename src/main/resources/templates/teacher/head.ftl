<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>上海大学实验系统</title>
    <link rel="stylesheet" href="/plug/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/common.js"></script>
    <script src="/plug/bootstrap/js/bootstrap.min.js"></script>
    <link href="/css/simple-sidebar.css" rel="stylesheet">
</head>
<body>

<div id="wrapper" class="toggled">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    欢迎回来
                </a>
            </li>
            <li>
                <a href="/teacher/classList">班级</a>
            </li>
            <li>
                <a href="/teacher/studentList">学生</a>
            </li>
            <li>
                <a href="#">固结实验</a>
            </li>
            <li>
                <a href="#table-menu" class="nav-header" data-toggle="collapse"><i class="icon-table"></i>固结实验
                </a>
            </li>
            <ul id="table-menu" class="nav nav-list collapse">
                <li><a href="/WirelessOrder/table.do?flag=table">初始化数据</a></li>
            </ul>

            <li>
                <a href="/login/teacher/loginout">登出</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">