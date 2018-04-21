<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <style>body {
        padding-top: 60px;
    }</style>
    <link href="${APP_PATH}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${APP_PATH}/admin/css/login-register.css" rel="stylesheet"/>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <script src="${APP_PATH}/js/jquery-1.12.4.js" type="text/javascript"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
    <script src="${APP_PATH}/js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="${APP_PATH}/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/axios.js"></script>
</head>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<body>
<div class="container" id="login">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <a v-on:click="showLogin">登录</a>
            <a v-on:click="showregistert">注册</a>
        </div>
        <div class=" col-sm-4">
        </div>
    </div>

    <div class="modal fade login" id="loginModal">
        <div class="modal-dialog login animated">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Login with</h4>
                </div>
                <div class="modal-body">
                    <div class="box">
                        <div class="content">
                            <div class="error"></div>
                            <div class="form loginBox">
                                <form id="LoginForm">
                                    <input class="form-control" type="text" placeholder="account" name="snum">
                                    <input class="form-control" type="password" placeholder="Password"
                                           name="spass">
                                    <span class="btn btn-default btn-login" v-on:click="login">登录</span>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="forgot login-footer">
                        <span>没有账号<a v-on:click="showregistert">去注册</a> </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade login" id="registerModal">
        <div class="modal-dialog login animated">
            <div class="modal-content">
                <div class="modal-header">
                    <%--  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                    <h4 class="modal-title">Register with</h4>
                </div>
                <div class="modal-body">
                    <div class="box">
                        <div class="content registerBox">
                            <div class="form">
                                <form id="registerForm">
                                    <input class="form-control" type="text" placeholder="名字" name="sname">
                                    <input class="form-control" type="text" placeholder="学号" name="snum">
                                    <input class="form-control pass" type="password" placeholder="输入密码"
                                           name="spass">
                                    <input class="form-control pass" type="password" placeholder="重新输入密码">
                                    <input class="form-control" type="text" placeholder="输入密保问题用于以后找回密码"
                                           name="token">
                                    <input class="form-control" type="text" placeholder="输入密保问题答案"
                                           name="tokenpass">
                                    <label>选择班级</label>
                                    <select class="form-control" name="cid">
                                        <option v-for="c in cls" v-bind:value="c.cid">
                                            {{c.name}}
                                        </option>
                                    </select>
                                    <span class="btn btn-default btn-register" v-on:click="register">注册</span>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="forgot login-footer">
                        <span>已有账号<a v-on:click="showLogin">去登录</a> </span>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
<script>
    var vu = new Vue({
        el: "#login",
        data: {
            msg: {
                has: false,
                msg: "",
            },
            cls: [],
        },
        mounted(){
            $("#loginModal").modal({backdrop: 'static', keyboard: false});

        },
        methods: {
            showLogin: function () {
                $("#registerModal").modal("hide");
                $("#loginModal").modal({backdrop: 'static', keyboard: false});
            },
            showregistert: function () {
                axios.get('/class/findAll.action')
                        .then(function (response) {
                            vu.cls = response.data.data;
                        });
                $("#loginModal").modal("hide");
                $("#registerModal").modal({backdrop: 'static', keyboard: false});
            },
            login: function () {
                axios.post('/student/login.action', $("#LoginForm").serialize())
                        .then(function (response) {
                            var result = response.data;
                            if (result.code == 200) {
                                alert("登陆成功");
                                vu.$options.methods.loginSuccess(result.data, 1);
                            } else {
                                alert(result.msg);
                            }
                        });
            },
            register: function () {
                var pas;
                console.log($("#registerForm").serialize());
                $(".pass").each(function () {
                            if (pas == null) {
                                pas = $(this).val();
                                console.log(pas);
                            } else {
                                if ($.trim(pas) != $.trim($(this).val())) {
                                    vu.msg.has = true;
                                    vu.msg.msg = "两次密码输入不一致";
                                    console.log($(this).val() + "sss");
                                    return;
                                } else {
                                    vu.msg.has = false;
                                }
                            }
                        }
                )
                if ($.trim(vu.msg.has) == $.trim("true")) {
                    alert(vu.msg.msg);
                    return;
                }
                $("#registerForm").find("input").each(function () {
                    if ($(this).val() == null || $(this).val() == "") {
                        vu.msg.has = true;
                        vu.msg.msg = "注册输入框不能为空";
                    } else {
                        vu.msg.has = false;
                    }
                })
                if ($.trim(vu.msg.has) == $.trim("true")) {
                    alert(vu.msg.msg);
                    return;
                }
                axios.post("/student/register.action", $("#registerForm").serialize()).then(function (response) {
                    var result = response.data;
                    if (result.code == 200) {
                        vu.$options.methods.loginSuccess(result.data, 2);
                    } else {
                        alert(result.msg);
                    }
                });

            },
            loginSuccess: function (data, status) {
                if (status == 1) {
                    $.cookie('student_sname', data.sname, {expires: 7, path: '/'});
                    $.cookie('student_snum', data.snum, {expires: 7, path: '/'});
                    $.cookie('student_isLogin', true, {expires: 7, path: '/'});
                    location.href = "http://localhost:8080/index.jsp";
                } else if (status == 2) {
                    if (confirm("恭喜您注册成功!点击确定进入管理页面")) {
                        $.cookie('student_sname', data.sname, {expires: 7, path: '/'});
                        $.cookie('student_snum', data.snum, {expires: 7, path: '/'});
                        $.cookie('student_isLogin', true, {expires: 7, path: '/'});
                        location.href = "http://localhost:8080/index.jsp";
                    } else {
                        $("#loginModal").modal({backdrop: 'static', keyboard: false});
                    }
                }
            }
        }
    });
</script>
</body>
</html>

