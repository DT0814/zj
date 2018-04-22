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
        <h1>班级管理</h1>
        <button type="button" v-on:click="addmodal" class="btn btn-default btn-lg active">添加班级</button>
        <table class="table table-hover ">
            <th class="row">
            <td class=" col-md-4">班级名</td>
            <td class=" col-md-4">状态</td>
            <td class=" col-md-4"></td>
            </th>
            <tr class="row" v-for="cl in cls">
                <td class="col-md-4">{{cl.name}}</td>
                <template v-if="cl.isdel==1">
                    <td class="col-md-4">禁止查询</td>
                </template>
                <template v-else>
                    <td class="col-md-4">正常</td>
                </template>
                <td class="col-md-4">
                    <template v-if="cl.isdel==1">
                        <span class="btn btn-primary " v-on:click="updateStatus(0,cl.cid)">启用</span>
                    </template>
                    <template v-else>
                        <span class="btn btn-primary " v-on:click="updateStatus(1,cl.cid)">停用</span>
                    </template>

                    <span class="btn btn-primary " v-on:click="showUpdateForm(cl)">点击修改</span>
                    <span class="btn btn-primary " v-on:click="deleteC(cl.cid)">点击删除</span>
                </td>
            </tr>
        </table>
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
                            <label>班级名称</label>
                            <input class="form-control" name="name"/>
                        </div>
                        <span class="btn btn-primary " v-on:click="add()">提交</span>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 修改展示窗口 -->
    <div id="updateModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">修改</h1>
                </div>
                <div class="modal-body">
                    <form class="form-group" id="updateForm">
                        <div class="form-group">
                            <label>班级名称</label>
                            <input class="form-control" name="name"/>
                        </div>
                        <span class="btn btn-primary " v-on:click="update()">提交</span>
                        <input type="hidden" name="cid">
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
            cls: {},
        },
        mounted(){
            this.$options.methods.findAll();
        },
        methods: {
            addmodal: function () {
                $("#addModal").modal();
            },
            add: function () {
                axios.post('${APP_PATH}/class/insert.action', $("#addForm").serialize())
                        .then(function (response) {
                            var result = response.data;
                            if (result.code == 200) {
                                alert("添加成功");
                                $("#addModal").modal("hide");
                                vu.$options.methods.findAll();
                            } else {
                                alert(result.msg);
                            }
                        });
            },
            findAll: function () {
                axios.get('${APP_PATH}/class/AdminFindAll.action')
                        .then(function (response) {
                            console.log(response);
                            vu.cls = response.data.data;
                        });
            },
            deleteC: function (cid) {
                axios.get('${APP_PATH}/class/delete.action?cid=' + cid)
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("删除成功");
                                vu.$options.methods.findAll();
                            }
                        });
            },
            showUpdateForm: function (cl) {
                $("#updateForm").find("input[name='name']").val(cl.name);
                $("#updateForm").find("input[name='cid']").val(cl.cid);
                $("#updateModal").modal();
            },
            update: function () {
                axios.post('${APP_PATH}/class/update.action', $("#updateForm").serialize())
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("修改成功");
                                vu.$options.methods.findAll();
                                $("#updateModal").modal('hide');
                            }
                        });
            },
            updateStatus: function (status, cid) {
                var params = new URLSearchParams();
                params.append('isdel', status);
                params.append('cid', cid);
                axios.post('${APP_PATH}/class/update.action', params)
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("状态修改成功");
                                vu.$options.methods.findAll();
                                $("#updateModal").modal('hide');
                            }
                        });
            }
        }

    });
</script>
</body>
</html>
