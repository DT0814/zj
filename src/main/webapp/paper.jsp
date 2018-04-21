<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%!
    int index = 1;
%>
<head>
    <title>试题</title>
    <link rel="stylesheet" type="text/css"
          href="${APP_PATH}/css/bootstrap.css"/>
    <%--<script type="text/javascript" src="${APP_PATH}/js/jquery-1.12.4.js"></script>--%>
    <script type="text/javascript" src="${APP_PATH}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/axios.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.gallery.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/posfixed.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/modernizr.custom.53451.js"></script>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/style.css"/>

</head>

<body style="background: cadetblue">
<div class="row" id="timeDiv" style="margin: 20px">
    <span style="font-family: '微软雅黑', 'Microsoft Yahei', 'Helvetica Neue', Helvetica, Arial, sans-serif;font-size: 22px;"
          id="timeSpan"></span>
</div>
<div class="container" style="background: cornsilk">
    <h1 class="container">${paper.name}</h1>
    <c:forEach items="${choices}" var="ch">
        <div style="margin: 10px">
             <span class="row" style="font-size: 20px"><%=index%>
               <%
                   index = index + 1;
               %>,<span>${ch.stem}</span><br>
             </span>
            <span class="row" style="font-size: 15px">
                 A:${ch.a}<br> B:${ch.b}<br>  C:${ch.c}<br>  D:${ch.d}<br>
            </span>
            <select class="form-control col-md-2 choice" name="choices" value='请选择'>
                    <%-- <option value='0'>选择</option>--%>
                <option value='A' class='xzt'>A</option>
                <option value='B' class='xzt'>B</option>
                <option value='C' class='xzt'>C</option>
                <option value='D' class='xzt'>D</option>
            </select><br>
        </div>
    </c:forEach>
    <c:forEach items="${blanks}" var="bl">
        <div style="margin: 10px">
        <span class="row" style="font-size: 20px"> <%=index%>
            <span>${bl.stem}</span><br>
        </span>
            <input class="form-control col-md-2 blank" name="blanks" value="1" type="text"><br>
        </div>
        <%
            index = index + 1;
        %>,
    </c:forEach>

    <c:forEach items="${sanswers}" var="sa">
        <div style="margin: 10px">
            <span class="row" style="font-size: 20px">
                <%=index%>
                <%
                    index = index + 1;
                %>,
                 <span>${sa.stem}</span><br>
            </span>
            <textarea class="form-control sanswer" name="sanswer" style="width: 80%;height: 200px"></textarea>
        </div>
    </c:forEach>
    <%
        index = 1;
    %>
    <button value="提交" class="btn btn-primary" id="Submit">交卷</button>
</div>
</body>
<script>
    var time;
    $(function () {
        document.onkeydown = function (e) {
            var ev = window.event || e;
            var code = ev.keyCode || ev.which;
            if (code == 116) {
                ev.keyCode ? ev.keyCode = 0 : ev.which = 0;
                cancelBubble = true;
                return false;
            }
        } //禁止f5刷新
        document.oncontextmenu = function () {
            return false
        };//禁止右键刷新


        var flag = true;
        var answer = "";
        time = parseInt(${paper.time}, 10) * 60;
        daojishi();
        $("#timeDiv").posfixed({
            distance: 20,
            pos: "top",
            type: "while",
            hide: false
        });
        $("#Submit").click(function () {
            $(".choice").each(function () {
                var val = $(this).val();
                if (val == null || val == "") {
                    flag = false;
                }
            });
            $(".blank").each(function () {
                var val = $(this).val();
                if (val == null || val == "") {
                    flag = false;
                }
            });
            $(".sanswer").each(function () {
                var val = $(this).val();
                if (val == null || val == "") {
                    flag = false;
                }
            });
            if (!flag) {
                alert("请做完所有题再提交答案。");
                flag = true;
            } else {
                var params = new URLSearchParams();
                params.append('choice', $(".choice").serialize());
                params.append('blank', $(".blank").serialize());
                params.append('snum', $.cookie('student_snum'));
                params.append('paid', ${paper.paid});
                params.append('sanswer', $(".sanswer").serialize());
                axios.post('${APP_PATH}/paper/submitPaper.action', params).then(function (response) {
                    console.log(response);
                    alert(response.data.data);
                })
            }
            answer = "";
        });
    });
    function daojishi() {
        time--;
        if (time > 60) {
            $("#timeSpan").html("考试剩余时间" + Math.floor(time / 60) + "分" + time % 60 + "秒");
        } else {
            $("#timeSpan").html("考试剩余时间" + time + "秒");
        }
        if (Math.floor(time / 60) % 30 == 0 && time % 60 == 0 && Math.floor(time / 60) != 0) {
            alert("剩余考试时间" + Math.floor(time / 60) + "分");
        }
        if (Math.floor(time / 60) == 5 && time % 60 == 0) {
            alert("考试时间仅剩五分钟,请抓紧时间检查试卷交卷");
        }
        if (time == 0) {
            alert("考试时间到");
            $("#Submit").attr("disabled", "disabled");
            $("#Submit").html("考试时间超时,禁止试卷提交请重新作答");
            return;
        }
        setTimeout(daojishi, 1000);
    }
</script>
</html>
