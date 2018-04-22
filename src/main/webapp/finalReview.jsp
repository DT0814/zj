<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<head>
    <title>试题</title>
    <link rel="stylesheet" type="text/css"
          href="${APP_PATH}/css/bootstrap.css"/>
    <script type="text/javascript" src="${APP_PATH}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/axios.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.gallery.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/modernizr.custom.53451.js"></script>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/style.css"/>

</head>
<%!
    int index = 1;
%>
<body class="container">
<div class="row" id="bd">
    <div class="col-md-3" style="background: #FFF;width: 25%;height: 100%">
        <form class="form-group">
            <span class="row" style="font-size: 20px">答题数量:{{form.num}}</span>
            <span class="row" style="font-size: 20px"> 正确数量:{{form.right}}</span>
            <span class="row" style="font-size: 20px"> 错误量:{{form.error}}</span>
            <span class="row" style="font-size: 20px"> 正确率:{{correctrate}}</span>
            <span class="row" style="font-size: 20px" id="timeSpan"></span>
        </form>
    </div>
    <div class="col-md-9" style="background: #eee;width: 75%;height: 100%">
        <div v-if="choice">
            <span class="row" style="font-size: 20px">
              <span>{{choice.stem}}</span><br>
             </span>
            <div class="radio">
                <label>
                    <input type="radio" name="answer" id="optionsRadios1" value="a" checked>
                    {{choice.a}}
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="answer" id="optionsRadios2" value="b">
                    {{choice.b}}
                </label>
            </div>
            <div class="radio ">
                <label>
                    <input type="radio" name="answer" id="optionsRadios3" value="c">
                    {{choice.c}}
                </label>
            </div>
            <div class="radio ">
                <label>
                    <input type="radio" name="answer" id="optionsRadios5" value="d">
                    {{choice.d}}
                </label>
            </div>
        </div>
        <div class="container">
            <button value="提交" class="btn-primary" id="beginBut" v-on:click="get">开始测试</button>
        </div>

        <div id="answerChonceDiv">
        </div>

        <div v-if="blank">
            <span class="row" style="font-size: 20px">
                <span>{{blank.stem}}</span><br>
            </span>
            <input type="text" class="form-control" id="blankAnswer" placeholder="答案">
        </div>
        <button class="btn btn-primary" v-if="hasSubCh" v-on:click="subChoice()">提交</button>
        <button class="btn btn-primary" v-if="hasNext" v-on:click="get()">下一题</button>
        <button class="btn btn-primary" v-if="hasSubBl" v-on:click="subBlank()">提交</button>
        <div id="answerBlankDiv">

        </div>
    </div>
</div>
</body>
<script>
    var obj = new Vue({
        el: "#bd",
        data: {
            choice: null,
            blank: null,
            form: {
                num: 0,
                right: 0,
                error: 0,
            },
            subCh: false,
            next: false,
            subBl: false,
        },
        computed: {
            correctrate: function () {
                return Math.floor((this.form.right / this.form.num ) * 100) + "%";
            },
            hasSubCh: function () {
                return this.subCh;
            },
            hasNext: function () {
                return this.next;
            },
            hasSubBl: function () {
                return this.subBl;
            }

        },
        mounted(){
            daojishi();
            $(".btn").each(function () {
                $(this).addClass("hide");
            })
        },
        methods: {
            get: function () {
                var random = Math.random();
                $("#beginBut").removeClass("hide").addClass("hide");
                if (random >= 0.5) {
                    //选择题
                    axios.get('${APP_PATH}/choice/getOne.action').then(function (response) {
                        obj.blank = null;
                        obj.choice = response.data.data;
                        $("#answerChonceDiv").html("");
                        $("#answerBlankDiv").html("");
                        obj.subCh = true;
                        obj.next = false;
                        obj.subBl = false;
                    })
                } else {
                    axios.get('${APP_PATH}/blank/getOne.action').then(function (response) {
                        obj.choice = null;
                        obj.blank = response.data.data;
                        $("#answerChonceDiv").html("");
                        $("#answerBlankDiv").html("");
                        obj.subCh = false;
                        obj.next = false;
                        obj.subBl = true;
                    })
                    //填空题
                }
            },
            subChoice: function () {
                var a = $("input[name='answer']:checked").val();
                if (a.toLocaleLowerCase() == obj.choice.answer.toLocaleLowerCase()) {
                    obj.form.num++;
                    obj.form.right++;
                    $("#answerChonceDiv").html("恭喜您回答正确");
                } else {
                    obj.form.num++;
                    obj.form.error++;
                    $("#answerChonceDiv").html("很遗憾您回答错误,正确答案:" + obj.choice.answer);
                }
                obj.subCh = false;
                obj.subBl = false;
                obj.next = true;
            },
            subBlank: function () {
                var a = $("#blankAnswer").val();
                if (a.toLocaleLowerCase() == obj.blank.answer.toLocaleLowerCase()) {
                    obj.form.num++;
                    obj.form.right++;
                    $("#answerBlankDiv").html("恭喜您回答正确");
                } else {
                    obj.form.num++;
                    obj.form.error++;
                    $("#answerBlankDiv").html("很遗憾您回答错误,正确答案:" + obj.blank.answer);
                }
                obj.subCh = false;
                obj.subBl = false;
                obj.next = true;
            },
        }
    })
    var time = 0;
    function daojishi() {
        time++;
        if (time > 60 * 60) {
            $("#timeSpan").html(Math.floor(time / (60 * 60)) + "时" + Math.floor(time / 60) + "分" + time % 60 + "秒");
        }
        else if (time > 60) {
            $("#timeSpan").html("0时" + Math.floor(time / 60) + "分" + time % 60 + "秒");
        } else {
            $("#timeSpan").html("0时" + "00分" + time + "秒");
        }
        setTimeout(daojishi, 1000);
    }
</script>
</html>
