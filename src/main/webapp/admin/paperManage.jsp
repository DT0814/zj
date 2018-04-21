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
        <h1>试卷管理</h1>
        <button type="button" v-on:click="addmodal" class="btn btn-default btn-lg active">创建试卷</button>
        <table class="table table-hover ">
            <th class="row">
            <td class=" col-md-2">选择题数量</td>
            <td class=" col-md-2">填空题数量</td>
            <td class=" col-md-2">简答题数量</td>
            <td class=" col-md-2">名字</td>
            <td class=" col-md-2">答题时间</td>
            <td class=" col-md-2"></td>
            </th>
            <tr class="row" v-for="pa in papers">
                <td class=" col-md-2">{{pa.snum}}</td>
                <td class=" col-md-2">{{pa.bnum}}</td>
                <td class=" col-md-2">{{pa.sanum}}</td>
                <td class=" col-md-2">{{pa.name}}</td>
                <td class=" col-md-2">{{pa.time}}</td>
                <td class=" col-md-2">
                    <span class="btn btn-primary " v-on:click="deleteC(pa.paid)">点击删除</span>
                    <span class="btn btn-primary " v-on:click="showMsg(pa.paid)">查看完成情况</span>
                </td>
            </tr>
        </table>
    </div>
    <!-- 添加展示窗口 -->
    <div id="addModal" class="modal fade">
        <div class="modal-dialog" style="height: 300px;width: 800px">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">添加</h1>
                </div>
                <div class="modal-body">
                    <form id="addForm">
                        <div class="row">
                            <div class="col-md-4">
                                <label>选择班级</label>
                                <select class="form-control" name="cid">
                                    <option v-for="c in cls" v-bind:value="c.cid">
                                        {{c.name}}
                                    </option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label>设置答题时间</label>
                                <input class="form-control col-md-2" name="time" type="text" value="90"/>
                            </div>
                            <div class="col-md-2">
                                <label>设置试卷名字</label>
                                <input class="form-control col-md-2" name="name" type="text" value="试卷"/>
                            </div>
                        </div>
                        <table class="table">
                            <tr>
                                <td>知识点</td>
                                <td>选择题</td>
                                <td>填空题</td>
                                <td>简答题</td>
                            </tr>
                            <tr v-for="p in point">
                                <td>{{p.name}}</td>
                                <td><input class="form-control choice" name="choice" type="text" value="0"/></td>
                                <td><input class="form-control blank" name="blank" type="text" value="0"/></td>
                                <td><input class="form-control sanswer" name="sanswer" type="text" value="0"/></td>
                            </tr>
                        </table>
                        <div class="text-right">
                            <span class="btn btn-primary" v-on:click="add">提交</span>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                        <input type="hidden" name="tnum">
                    </form>
                </div>
            </div>
        </div>
    </div>


    <!-- 查看完成情况模态框 -->
    <div id="showMsg" class="modal fade">
        <div class="modal-dialog" style="height: 300px;width: 800px">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">展示详细</h1>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <tr>
                            <td>学生名</td>
                            <td>分数</td>
                            <td></td>
                        </tr>
                        <tr v-for="st in students">
                            <td>{{st.sname}}</td>
                            <td>
                                <template v-if="st.score">
                                    {{st.score.score}}
                                </template>
                                <template v-else>
                                    未完成
                                </template>
                            </td>
                            <td>
                                <template v-if="st.score">
                                    <span class="btn btn-primary"
                                          v-on:click="showStudentSAnswer(st.snum)">查看简答题</span>
                                </template>
                            </td>
                        </tr>
                    </table>
                    <div class="text-right">
                        <button class="btn btn-danger" data-dismiss="modal">退出</button>
                    </div>
                    <input type="hidden" id="paidHidden" name="paid">
                </div>
            </div>
        </div>
    </div>
    <!-- 查看简答题模态框 -->
    <div id="AnswerModal" class="modal fade">
        <div class="modal-dialog" style="height: 300px;width: 800px">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">简答题情况</h1>
                </div>
                <div class="modal-body">
                    <template v-for="sp in sAnswerPaperStudent">
                        <label class="control-label"
                               style="margin: 20px;font-size: 15px">题干:&nbsp;&nbsp;{{sp.sanswer.stem}}</label><br>
                        <label style="margin: 20px;font-size: 15px">学生答案:&nbsp;&nbsp;{{sp.answer}}</label><br>
                    </template>
                    <div class="text-right">
                        <button class="btn btn-danger" data-dismiss="modal">退出</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


<script>
    var vu = new Vue({
        el: "#bd",
        data: {
            papers: {},
            difficulty: [],
            point: [],
            ch: {},
            cls: [],
            students: [],
            sAnswerPaperStudent: []
        },
        mounted(){
            this.$options.methods.findByTnum();
        },
        methods: {
            addmodal: function () {
                axios.get('${APP_PATH}/difficulty/findAll.action')
                        .then(function (response) {
                            vu.difficulty = response.data.data;
                        });
                axios.get('${APP_PATH}/point/findAll.action')
                        .then(function (response) {
                            vu.point = response.data.data;
                        });
                axios.get('/class/findAll.action')
                        .then(function (response) {
                            vu.cls = response.data.data;
                        });
                $("#addForm").find("input[name='tnum']").val($.cookie('teacher_tnum'))
                $("#addModal").modal();
            },
            add: function () {
                var score = 0;
                $.each($(".choice"), function () {
                    score += $(this).val() * 1;
                })
                $.each($(".blank"), function () {
                    score += $(this).val() * 2;
                })
                $.each($(".sanswer"), function () {
                    score += $(this).val() * 5;
                })
                if (score != 100) {
                    alert("试卷总分为" + score + "不等于一百分请您检查习题分布");
                    return;
                }
                axios.post('${APP_PATH}/paper/add.action', $("#addForm").serialize())
                        .then(function (response) {
                            var result = response.data;
                            if (result.code == 200) {
                                alert("添加成功");
                                $("#addModal").modal("hide");
                                vu.$options.methods.findByTnum();
                            } else {
                                alert(result.msg);
                            }
                        });
            },
            findByTnum: function () {
                axios.get('${APP_PATH}/paper/findByTnum.action?tnum=' + $.cookie('teacher_tnum'))
                        .then(function (response) {
                            console.log(response);
                            vu.papers = response.data.data;
                        });
            },
            deleteC: function (paid) {
                if (confirm("您确定要删除这张试卷么?")) {
                    axios.get('${APP_PATH}/paper/delete.action?paid=' + paid)
                            .then(function (response) {
                                var data = response.data;
                                if (data.code == 200) {
                                    alert("删除成功");
                                    vu.$options.methods.findByTnum();
                                }
                            });
                }
            },
            showMsg: function (paid) {
                axios.get('/paper/showMsg.action?paid=' + paid)
                        .then(function (response) {
                            vu.students = response.data.data;
                        });
                $("#paidHidden").val(paid);
                $("#showMsg").modal();
            },
            showStudentSAnswer: function (snum) {
                var paid = $("#paidHidden").val();
                axios.get('/sAnswerPaperStudent/findBySnumAndPaid.action?paid=' + paid + '&snum=' + snum)
                        .then(function (response) {
                            vu.sAnswerPaperStudent = response.data.data;
                        });
                $("#AnswerModal").modal();
            }
        }

    });
</script>
</body>
</html>
