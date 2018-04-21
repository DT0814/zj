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
<div id="bd" class="container" style="height: 90%;width: 90%">
    <div class="row">
        <h1>学生管理</h1>
        <button type="button" v-on:click="addmodal" class="btn btn-default btn-lg active">添加学生</button>
        <table class="table table-hover ">
            <th class="row">
            <td class=" col-md-3">学生名</td>
            <td class=" col-md-3">学号</td>
            <td class=" col-md-3">班级</td>
            <td class=" col-md-3"></td>
            </th>
            <tr class="row" v-for="st in pageInfo.list">
                <td class=" col-md-3">{{st.sname}}</td>
                <td class=" col-md-3">{{st.snum}}</td>
                <td class=" col-md-3">{{st.cname}}</td>
                <td class=" col-md-3"><span class="btn btn-primary " v-on:click="resetPass(st.snum)">重置密码</span>
                    <span class="btn btn-primary " v-on:click="deleteC(st.snum)">点击删除</span>
                </td>
            </tr>
        </table>
    </div>
    <div class="row">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li v-if="!pageInfo.isFirstPage">
                    <a v-on:click="topage(pageInfo.prePage)" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <template v-for="num in pageInfo.navigatepageNums">


                    <template v-if="pageInfo.pageNum==num">
                        <li class="active" v-on:click="topage(num)">
                            <span>{{num}} <span class="sr-only">(current)</span></span>
                        </li>
                    </template>
                    <template v-else>
                        <li v-on:click="topage(num)"><span>
                            <span aria-hidden="true">{{num}}</span>   </span>
                        </li>
                    </template>
                </template>
                <li v-if="!pageInfo.isLastPage">
                    <a v-on:click="topage(pageInfo.nextPage)" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <!-- 添加展示窗口 -->
    <div id="addModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">添加</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="addForm">
                        <div class="form-group">
                            <label>学号</label>
                            <input class="form-control" name="snum"/>
                        </div>
                        <div class="form-group">
                            <label>姓名</label>
                            <input class="form-control" name="sname" type="text">
                        </div>
                        <div class="form-group">
                            <label>班级:</label>
                            <select class="form-control" name="cid">
                                <option v-for="c in cls" v-bind:value="c.cid">
                                    {{c.name}}
                                </option>
                            </select>
                        </div>
                        <div class="text-right">
                            <span class="btn btn-primary" v-on:click="add">提交</span>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
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
            pageInfo: {},
            cls: [],
        },
        mounted(){
            this.$options.methods.topage(1);
        },
        methods: {
            addmodal: function () {
                axios.get('${APP_PATH}/class/findAll.action')
                        .then(function (response) {
                            vu.cls = response.data.data;
                        });
                $("#addModal").modal();
            },
            add: function () {
                axios.post('${APP_PATH}/student/insert.action', $("#addForm").serialize())
                        .then(function (response) {
                            var result = response.data;
                            if (result.code == 200) {
                                alert("添加成功");
                                $("#addModal").modal("hide");
                                vu.$options.methods.topage(1);
                            } else {
                                alert(result.msg);
                            }
                        });
            },
            topage: function (page) {
                axios.get('${APP_PATH}/student/findAll.action?page=' + page)
                        .then(function (response) {
                            console.log(response);
                            vu.pageInfo = response.data.data;
                        });
            },
            deleteC: function (snum) {
                axios.get('${APP_PATH}/student/delete.action?snum=' + snum)
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("删除成功");
                                vu.$options.methods.topage(1);
                            }
                        });
            },
            resetPass: function (snum) {
                axios.get('${APP_PATH}/student/resetPass.action?snum=' + snum)
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("密码重置成功");
                                vu.$options.methods.topage(1);
                            }
                        });
            }
        }

    });
</script>
</body>
</html>
