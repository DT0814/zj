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
        <h1>填空题管理</h1>
        <button type="button" v-on:click="addmodal" class="btn btn-default btn-lg active">添加填空题</button>
        <table class="table table-hover ">
            <th class="row">
            <td class=" col-md-3">题干</td>
            <td class=" col-md-3">正确答案</td>
            <td class=" col-md-2">难度</td>
            <td class=" col-md-2">章节</td>
            <td class=" col-md-2"></td>
            </th>
            <tr class="row" v-for="bl in pageInfo.list">
                <td class=" col-md-3">{{bl.stem}}</td>
                <td class=" col-md-1">{{bl.answer}}</td>
                <td class=" col-md-1">{{bl.dname}}</td>
                <td class=" col-md-1">{{bl.name}}</td>
                <td class=" col-md-2"><span class="btn btn-primary " v-on:click="updateModal(bl)">点击修改</span>
                    <span class="btn btn-primary " v-on:click="deleteC(bl.bid)">点击删除</span>
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
                            <label>题干</label>
                            <textarea style="width: 546px; height: 93px;" name="stem"></textarea>
                        </div>
                        <div class="form-group">
                            <label>正确答案</label>
                            <input class="form-control" name="answer" type="text">
                        </div>
                        <div class="form-group">
                            <label>难度:</label>
                            <select class="form-control" name="did">
                                <option v-for="d in difficulty" v-bind:value="d.did">
                                    {{d.dname}}
                                </option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>所属知识点:</label>
                            <select class="form-control" name="pid">
                                <option v-for="p in point" v-bind:value="p.pid">
                                    {{p.name}}
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
                    <form id="updateForm">
                        <div class="form-group">
                            <label>题干</label>
                            <textarea style="width: 546px; height: 93px;" name="stem"></textarea>
                        </div>
                        <div class="form-group">
                            <label>正确答案</label>
                            <input class="form-control" name="answer" type="text">
                        </div>
                        <div class="form-group">
                            <label>难度:</label>
                            <select class="form-control" name="did">
                                <option v-for="d in difficulty" v-bind:value="d.did">
                                    {{d.dname}}
                                </option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>所属知识点:</label>
                            <select class="form-control" name="pid">
                                <option v-for="p in point" v-bind:value="p.pid">
                                    {{p.name}}
                                </option>
                            </select>
                        </div>
                        <div class="text-right">
                            <span class="btn btn-primary" v-on:click="update">提交</span>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                        <input type="hidden" name="bid">
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
            difficulty: [],
            point: [],
            ch: {}
        },
        mounted(){
            this.$options.methods.topage(1);
        },
        methods: {
            updateModal: function (bl) {
                axios.get('${APP_PATH}/difficulty/findAll.action')
                        .then(function (response) {
                            var dse = $("#updateForm").find("select[name='did']");
                            dse.empty();
                            $.each(response.data.data, function () {
                                var option = $("<option value='" + this.did + "'>" + this.dname + "</option>")
                                if (this.did == bl.did) {
                                    option.attr("selected", "selected");
                                }
                                option.appendTo(dse);
                            })
                        });
                axios.get('${APP_PATH}/point/findAll.action')
                        .then(function (response) {
                            var pse = $("#updateForm").find("select[name='pid']");
                            pse.empty();
                            $.each(response.data.data, function () {
                                var option = $("<option value='" + this.pid + "'>" + this.name + "</option>")
                                if (this.pid == bl.pid) {
                                    option.attr("selected", "selected");
                                }
                                option.appendTo(pse);
                            })
                        });
                $("#updateForm").find("textarea[name='stem']").val(bl.stem);
                $("#updateForm").find("input[name='answer']").val(bl.answer);
                $("#updateForm").find("input[name='bid']").val(bl.bid);

                var dse = $("#updateForm").find("select[name='did']");
                $.each(vu.difficulty, function () {
                    if ($(this).val() == bl.did) {
                        $(this).addClass("active");
                    }
                })
                $("#updateModal").modal();
            },
            update: function () {
                axios.post('${APP_PATH}/blank/update.action', $("#updateForm").serialize())
                        .then(function (response) {
                            var result = response.data;
                            if (result.code == 200) {
                                alert("更新成功");
                                $("#updateModal").modal("hide");
                                vu.$options.methods.topage(1);
                            } else {
                                alert(result.msg);
                            }
                        });
            },
            addmodal: function () {
                axios.get('${APP_PATH}/difficulty/findAll.action')
                        .then(function (response) {
                            vu.difficulty = response.data.data;
                        });
                axios.get('${APP_PATH}/point/findAll.action')
                        .then(function (response) {
                            vu.point = response.data.data;
                        });
                $("#addModal").modal();
            },
            add: function () {
                axios.post('${APP_PATH}/blank/insert.action', $("#addForm").serialize())
                        .then(function (response) {
                            var result = response.data;
                            if (result.code == 200) {
                                alert("添加成功");
                                $("#addModal").modal("hide");
                                vu.$options.methods.topage(10000);
                            } else {
                                alert(result.msg);
                            }
                        });
            },
            topage: function (page) {
                axios.get('${APP_PATH}/blank/findAll.action?page=' + page)
                        .then(function (response) {
                            console.log(response);
                            vu.pageInfo = response.data.data;
                        });
            },
            deleteC: function (bid) {
                axios.get('${APP_PATH}/blank/delete.action?bid=' + bid)
                        .then(function (response) {
                            var data = response.data;
                            if (data.code == 200) {
                                alert("删除成功");
                                vu.$options.methods.topage(1);
                            }
                        });
            }
        }

    });
</script>
</body>
</html>
