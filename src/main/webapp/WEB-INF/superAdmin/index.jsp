<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
    <meta content=always name=referrer>
    <meta name="renderer" content="webkit">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>管理</title>
    <link rel="stylesheet" href="${APP_PATH }/admin/css/pintuer.css">
    <link rel="stylesheet" href="${APP_PATH }/admin/css/admin.css">
    <script src="${APP_PATH }/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
</head>
<body style="background-color:#f2f9fd;">

<div class="leftnav">
    <div class="leftnav-title" style="margin: 8px">
        <span id="team_name" style="color: #00A4E4;font-size: 13px"></span>
    </div>
    <ul style="display:block;">
        <li><a
                href="${APP_PATH}/admin/toPage.action?pageName=studentManage"
                target="right"><span class="icon-caret-right"></span>学生管理</a>
        </li>
        <li><a
                href="${APP_PATH}/admin/toPage.action?pageName=teacherManage"
                target="right"><span class="icon-caret-right"></span>教师管理</a>
        </li>
        <li><a
                href="${APP_PATH}/admin/toPage.action?pageName=classManage"
                target="right"><span class="icon-caret-right"></span>班级管理</a>
        </li>
        <li><a
                href="${APP_PATH}/admin/toPage.action?pageName=pointManage"
                target="right"><span class="icon-caret-right"></span>知识点管理</a>
        </li>
        <li><a
                href="${APP_PATH}/admin/toPage.action?pageName=difficultyManage"
                target="right"><span class="icon-caret-right"></span>难度分类管理</a>
        </li>
    </ul>
</div>
<div class="admin">
    <iframe scrolling="auto" rameborder="0"
            src=""
            name="right" width="100%" height="100%"></iframe>
</div>
<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<div style="text-align:center;"></div>
</body>
</html>