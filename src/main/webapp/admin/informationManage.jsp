<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
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
    <title></title>
    <link rel="stylesheet" type="text/css"
          href="${APP_PATH}/css/bootstrap.css"/>
    <script type="text/javascript" src="${APP_PATH}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/axios.js"></script>
    <script src="${APP_PATH }/admin/js/pintuer.js"></script>
    <link rel="stylesheet" href="${APP_PATH }/admin/css/pintuer.css">
    <link rel="stylesheet" href="${APP_PATH }/admin/css/admin.css">
</head>
<body>
<div id="bd">
    <h1>个人信息管理</h1>
    <!-- 修改展示窗口 -->
    <div style="height: 50%;width: 50%;">
        <form class="form-group" id="updateForm">
            <div class="form-group">
                <label>名字</label>
                <input class="form-control" name="tname" type="text">
            </div>
            <div class="form-group">
                <label>简介</label>
                <textarea name="introduce" style="width: 100%; height: 100%;"></textarea>
            </div>
            <div class="form-group">
                <label>联系方式(电话)</label>
                <input class="form-control" name="phone" type="text"/>
            </div>
            <input type="hidden" name="tnum">
            <div class="text-right">
                <span class="btn btn-primary" v-on:click="updatePass">密码修改</span>
                <span class="btn btn-primary" v-on:click="update">提交修改</span>
            </div>
        </form>
    </div>
    <!--密码修改-->
    <div id="updatePassModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="updatePassForm">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" v-on:click="showPass($event)"> 显示密码
                            </label>
                        </div>
                        <div class="form-group">
                            <label>原始密码</label>
                            <input class="form-control pass" name="tpass" type="password"/>
                        </div>
                        <div class="form-group">
                            <label>新密码</label>
                            <input class="form-control pass" name="newPass" type="password">
                        </div>
                        <div class="form-group">
                            <label>确认密码:</label>
                            <input class="form-control pass" name="newPass2" type="password">
                        </div>
                        <div class="text-right">
                            <span class="btn btn-primary" v-on:click="submitPass($event)">提交</span>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                        <input name="tnum" type="hidden">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    var vu = new Vue({
        el: "#bd",
        data: {
            team: {}
        },
        mounted(){
            this.$options.methods.findByTnum();
        },
        methods: {
            findByTnum: function () {
                axios.get('/teacher/findByTnum.action?tnum=' + $.cookie('teacher_tnum')).then(function (response) {
                    var e = $("#updateForm");
                    var data = response.data;
                    if (data.code == 200) {
                        console.log(data);
                        $("#updateForm").find("input[name='tname']").val(data.data.tname);
                        $("#updateForm").find("textarea[name='introduce']").html(data.data.introduce);
                        $("#updateForm").find("input[name='phone']").val(data.data.phone);
                        $("#updateForm").find("input[name='tnum']").val(data.data.tnum);
                    } else {
                        alert(data.msg);
                    }
                });
            },
            update: function () {
                axios.post('/teacher/update.action', $("#updateForm").serialize()).then(function (response) {
                    var data = response.data;
                    if (data.code == 200) {
                        console.log(data);
                        alert("更新成功")
                    } else {
                        alert(data.msg);
                    }
                });
            },
            updatePass: function () {
                $("#updatePassModal").modal();
            },
            submitPass: function (event) {
                var form = $(event.currentTarget).parent().parent();
                var pass1 = form.find("input[name='newPass']");
                var pass2 = form.find("input[name='newPass2']");
                form.find("input[name='tnum']").val($.cookie("teacher_tnum"));
                if (pass1.val() != pass2.val()) {
                    alert("两次密码输入不一致")
                } else {
                    axios.post('/teacher/updatePass.action', $("#updatePassForm").serialize()).then(function (response) {
                        var data = response.data;
                        if (data.code == 200) {
                            console.log(data);
                            alert("密码修改成功:请重新登陆");
                            vu.$options.methods.loginOut();
                            $("#updatePassModal").modal("hide");
                        } else {
                            alert(data.msg);
                        }
                    });
                }
            },
            showPass: function (event) {
                var el = $(event.currentTarget);
                if (el.prop("checked") == true) {
                    $.each($(".pass"), function () {
                        $(this).attr("type", "text");
                    })
                } else {
                    $.each($(".pass"), function () {
                        $(this).attr("type", "password");
                    })
                }
            },
            loginOut: function loginOut() {
                $.cookie('teacher_tname', null, {expires: -1, path: '/'});
                $.cookie('teacher_tnum', null, {expires: -1, path: '/'});
                $.cookie('teacher_isLogin', null, {expires: -1, path: '/'});
                parent.location.href = "http://localhost:8080/admin/login.jsp";
            }
        }
    });
</script>
</body>
</html>
