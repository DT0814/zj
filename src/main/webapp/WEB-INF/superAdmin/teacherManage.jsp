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
        <h1>教师管理</h1>
        <button type="button" v-on:click="addmodal" class="btn btn-default btn-lg active">添加教师</button>
        <table class="table table-hover ">
            <th class="row">
            <td class=" col-md-2">教师工号</td>
            <td class=" col-md-2">教师名</td>
            <td class=" col-md-4">教师简介</td>
            <td class=" col-md-2">电话</td>
            <td class=" col-md-2"></td>
            </th>
            <tr class="row" v-for="te in pageInfo.list">
                <td class=" col-md-2">{{te.tnum}}</td>
                <td class=" col-md-2">{{te.tname}}</td>
                <td class=" col-md-4">{{te.introduce}}</td>
                <td class=" col-md-2">{{te.phone}}</td>
                <td class=" col-md-2"><span class="btn btn-primary " v-on:click="resetPass(te.tnum)">重置密码</span>
                    <span class="btn btn-primary " v-on:click="deleteC(te.tnum)">点击删除</span>
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
                            <label>工号</label>
                            <input class="form-control" name="tnum"/>
                        </div>
                        <div class="form-group">
                            <label>姓名</label>
                            <input class="form-control" name="tname" type="text">
                        </div>
                        <div class="form-group">
                            <label>介绍</label>
                            <input class="form-control" name="introduce" type="text">
                        </div>
                        <div class="form-group">
                            <label>电话</label>
                            <input class="form-control" name="phone" type="text">
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
        },
        mounted(){
            this.$options.methods.topage(1);
        },
        methods: {
            addmodal: function () {
                $("#addModal").modal();
            },
            add: function () {
                axios.post('${APP_PATH}/teacher/insert.action', $("#addForm").serialize())
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
                axios.get('${APP_PATH}/teacher/findAll.action?page=' + page)
                        .then(function (response) {
                            console.log(response);
                            vu.pageInfo = response.data.data;
                        });
            },
            deleteC: function (tnum) {
                axios.get('${APP_PATH}/teacher/delete.action?tnum=' + tnum)
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("删除成功");
                                vu.$options.methods.topage(1);
                            }
                        });
            },
            resetPass: function (tnum) {
                axios.get('${APP_PATH}/teacher/resetPass.action?tnum=' + tnum)
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
