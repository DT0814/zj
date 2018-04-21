<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>计算机组成原理在线学习系统</title>
    <link href="${APP_PATH}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${APP_PATH}/admin/css/login-register.css" rel="stylesheet"/>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <script src="${APP_PATH}/js/jquery-1.12.4.js" type="text/javascript"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
    <script src="${APP_PATH}/js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="${APP_PATH}/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/axios.js"></script>
</head>
<body>
<div id="bd" class="container" style="background: cornsilk;width: 80%;height: 100%">
    <div style="font-family: '微软雅黑', 'Microsoft Yahei', 'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 18px;
padding-top: 6px;padding-top: 10px;font-weight: bold;">
        欢迎 <span id="nameSpan" style="color:red"></span>
        <a v-on:click="logOut" style="margin: 10px;cursor:pointer;">注销</a>
    </div>
    <ul id="catalog" class="nav nav-pills  nav-justified " style="margin-top: 20px">
        <li class="active"><a href="http://localhost:8080">Home</a></li>
        <li class=""><a v-on:click="select($event,1)">单元测试</a></li>
        <li class=""><a v-on:click="select($event,2)">考试</a></li>
        <li class=""><a v-on:click="select($event,3)">期末练习</a></li>
    </ul>
    <div id="bodyDiv">

    </div>
    <%--    <div>
            <span class="btn btn-primary " v-on:click="showModal()">点击练习</span>
            <span class="btn btn-primary " v-on:click="showExam()">考试详情</span>
        </div>--%>
    <!--练习题-->
    <div id="addModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                    </button>
                </div>
                <div class="modal-body" id="tryingFormDiv">
                    <form class="form-group" id="tryingForm">
                        <div class="form-group">
                            <label>试题数量:</label>
                            <input class="form-control" type="text" name="num" value="10">
                        </div>
                        <div class="form-group">
                            <label>选择试题类型:</label>
                            <select class="form-control" name="catalog">
                                <option value="1">选择题</option>
                                <option value="2">填空题</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>选择练习题难度:</label>
                            <select class="form-control" name="did">
                                <option value="0">选择练习题难度</option>
                                <option v-for="d in difficulty" v-bind:value="d.did">
                                    {{d.dname}}
                                </option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>所属知识点:</label>
                            <select class="form-control" name="pid">
                                <option value="0">选择练习题知识点</option>
                                <option v-for="p in point" v-bind:value="p.pid">
                                    {{p.name}}
                                </option>
                            </select>
                        </div>
                        <div class="text-right">
                            <span class="btn btn-primary" v-on:click="trying">开始练习</span>
                            <button class="btn btn-danger" data-dismiss="modal">取消</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--展示试卷-->
    <div id="showPaper" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content" style="height:500px;">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                    </button>
                </div>
                <div class="modal-body" id="examTabDiv">
                    <table class="table table-striped" id="examTab">
                        <tr v-for="pa in papers" class="row">
                            <td class="col-md-4">试卷名:{{pa.name}}</td>
                            <td class="col-md-4">考试时间:{{pa.time}}分钟</td>
                            <template v-if="pa.score">
                                <td class="col-md-4">分数:{{pa.score.score}}分
                                </td>
                            </template>
                            <template v-else>
                                <td class="col-md-4"><span class="btn btn-primary"
                                                           v-on:click="begin(pa.paid)">开始考试</span></td>
                            </template>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <form id="paperSubmitForm">

    </form>

</div>
<script>
    var tryingForm;
    var examTab;
    var vu = new Vue({
        el: "#bd",
        data: {
            student: {},
            difficulty: [],
            point: [],
            papers: [],
        },
        mounted(){
            if ($.trim($.cookie('student_isLogin')) != $.trim("true")) {
                location.href = "http://localhost:8080/login.jsp";
            }
            this.student.sname = $.cookie('student_sname');
            $("#nameSpan").text("   " + $.cookie('student_sname'));
            tryingForm = $("#tryingForm");
            examTab = $("#examTabDiv");
        },
        methods: {
            logOut: function () {
                $.cookie('studen_sname', null, {expires: -1, path: '/'});
                $.cookie('student_snum', null, {expires: -1, path: '/'});
                $.cookie('student_isLogin', null, {expires: -1, path: '/'});
                alert("注销成功 !");
                location.href = "http://localhost:8080/login.jsp";
            },
            /*            showModal: function () {
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
             showExam: function () {
             axios.get('${APP_PATH}/paper/showMyPaper.action?snum=' + $.cookie('student_snum'))
             .then(function (response) {
             vu.papers = response.data.data;
             });
             $("#showPaper").modal();
             },*/
            begin: function (paid) {
                var form = $("#paperSubmitForm");
                var url = "${APP_PATH}/paper/getPaper.action";
                form.attr("action", url);
                $("<input name='paid' value='" + paid + "'>").appendTo(form);
                form.submit();
            },
            trying: function () {
                $("#tryingForm").attr("action", "${APP_PATH}/trying/getTrying.action");
                $("#tryingForm").submit();
            },
            select: function (ele, num) {
                $.each($("#catalog").find("li"), function () {
                    $(this).removeClass("active");
                });
                $(ele.currentTarget).parent().attr("class", "active");
                var bd = $("#bodyDiv");
                bd.empty();
                if (num == 1) {
                    axios.get('${APP_PATH}/difficulty/findAll.action')
                            .then(function (response) {
                                vu.difficulty = response.data.data;
                            });
                    axios.get('${APP_PATH}/point/findAll.action')
                            .then(function (response) {
                                vu.point = response.data.data;
                            });
                    tryingForm.appendTo(bd);
                } else if (num == 2) {
                    axios.get('${APP_PATH}/paper/showMyPaper.action?snum=' + $.cookie('student_snum'))
                            .then(function (response) {
                                vu.papers = response.data.data;
                            });
                    examTab.appendTo(bd);
                } else if (num == 3) {
                    $("#bodyDiv").html("期末练习");
                }
            },
        }
    });
</script>
</body>

</html>
