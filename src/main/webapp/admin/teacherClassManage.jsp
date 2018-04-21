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
        <h1>简答题管理</h1>
        <button type="button" v-on:click="addmodal" class="btn btn-default btn-lg active">添加班级</button>
        <table class="table table-hover ">
            <th class="row">
            <td class=" col-md-10">班级名字</td>
            <td class=" col-md-2"></td>
            </th>
            <tr class="row" v-for="tc in data">
                <td class=" col-md-10">{{tc.name}}</td>
                <td class=" col-md-2">
                    <span class="btn btn-primary " v-on:click="deleteC(tc.tcid)">点击删除</span>
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
                        <div class="col-md-4">
                            <label>选择班级</label>
                            <select class="form-control" name="cid">
                                <option v-for="c in cls" v-bind:value="c.cid">
                                    {{c.name}}
                                </option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <span class="btn btn-primary" v-on:click="add">提交</span>
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
            cls: [],
            data: []
        },
        mounted(){
            this.$options.methods.findByTunm();
        },
        methods: {
            addmodal: function () {
                axios.get('${APP_PATH}/class/findAll.action')
                        .then(function (response) {
                            vu.cls = response.data.data;
                        });
                $("#addModal").find("input[name='tnum']").val($.cookie('teacher_tnum'));
                $("#addModal").modal();
            },
            add: function () {
                axios.post('${APP_PATH}/teacherClass/insert.action', $("#addForm").serialize())
                        .then(function (response) {
                            var result = response.data;
                            if (result.code == 200) {
                                alert("添加成功");
                                $("#addModal").modal("hide");
                                vu.$options.methods.findByTunm();
                            } else {
                                alert(result.msg);
                            }
                        });
            },
            findByTunm: function () {
                axios.get('${APP_PATH}/teacherClass/findByTunm.action?tnum=' + $.cookie('teacher_tnum'))
                        .then(function (response) {
                            console.log(response);
                            vu.data = response.data.data;
                        });
            },
            deleteC: function (tcid) {
                var params = new URLSearchParams();
                params.append('tcid', tcid);       //你要传给后台的参数值 key/value
                axios.post('${APP_PATH}/teacherClass/delete.action', params)
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("删除成功");
                                vu.$options.methods.findByTunm();
                            }
                        });
            }
        }

    });
</script>
</body>
</html>
