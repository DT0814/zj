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
<body class="container" style="background: cadetblue">
<div style="background: cornsilk">
    <input type="hidden" id="types" value="${types}">
    <form id="choiceForm">
        <c:forEach items="${choiceList}" var="ch">
            <div style="margin: 10px">
             <span class="row" style="font-size: 20px"><%=index%>
               <%
                   index = index + 1;
               %>,<span>${ch.stem}</span><br>
             </span>
            <span class="row" style="font-size: 15px">
                 A:${ch.a}<br> B:${ch.b}<br>  C:${ch.c}<br>  D:${ch.d}<br>
            </span>
                <select class="form-control choices col-md-2" name="choices" value='请选择'>
                    <option value='0'>选择</option>
                    <option value='A' class='xzt'>A</option>
                    <option value='B' class='xzt'>B</option>
                    <option value='C' class='xzt'>C</option>
                    <option value='D' class='xzt'>D</option>
                </select><br>
            </div>
        </c:forEach>
    </form>
    <form id="blankForm">
        <c:forEach items="${blankList}" var="bl">
            <div style="margin: 10px">
        <span>
            <%=index%>
            <%
                index = index + 1;
            %>,
        </span>
                <span>${bl.stem}</span><br>
                <input class="blanks col-md-3" type="text" name="blanks"><br>
            </div>
        </c:forEach>
    </form>
    <%
        index = 1;
    %>
    <div style="margin: 20px;text-align: right">
        <button onclick="submit()" class="btn btn-primary">提交答案</button>
    </div>
</div>
</body>
<script>
    function submit() {
        if ($("#types").val() == 1) {
            var i = 1, msg = 0;
            $(".choices").each(function () {
                if ($(this).val() == "0") {
                    alert("第" + i + "题未作答");
                    msg = 1;
                    return false;
                }
                i++;
            })
            if (msg == 1) {
                return;
            }
            axios.post('${APP_PATH}/trying/submitTrying.action', $(".choices").serialize()).then(function (response) {
                console.log(response);
                var result = response.data;
                if (result.code == 200) {
                    alert(result.data);
                }
            })
        } else {
            var i = 1, msg = 0;
            $(".blanks").each(function () {
                if ($(this).val() == "") {
                    alert("第" + i + "题未作答");
                    msg = 1;
                    return false;
                }
                i++;
                console.log($(this).val())
            })
            if (msg == 1) {
                return;
            }
            axios.post('${APP_PATH}/trying/submitTrying.action', $(".blanks").serialize()).then(function (response) {
                console.log(response);
                var result = response.data;
                if (result.code == 200) {
                    alert(result.data);
                }
            })
        }
    }

</script>
</html>
