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
    <script type="text/javascript" src="${APP_PATH}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/axios.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.gallery.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/modernizr.custom.53451.js"></script>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/css/style.css"/>

</head>

<body class="container">
<h1 class="container">${paper.name}</h1>
<c:forEach items="${choices}" var="ch">
    <div style="margin: 10px">
       <span>           <%=index%>
           <%
               index = index + 1;
           %>,
       </span>
        <span>${ch.stem}</span><br>
        A:${ch.a} B:${ch.b} C:${ch.c} D:${ch.d}
        <select name="select" value='请选择'>
            <option value=''>选择</option>
            <option value='A' class='xzt'>A</option>
            <option value='B' class='xzt'>B</option>
            <option value='C' class='xzt'>C</option>
            <option value='D' class='xzt'>D</option>
        </select><br>
    </div>

</c:forEach>
<c:forEach items="${blanks}" var="bl">
    <div style="margin: 10px">
        <span>
            <%=index%>
            <%
                index = index + 1;
            %>,
        </span>
        <span>${bl.stem}</span><br>
        <input type="text"><br>
    </div>
</c:forEach>

<c:forEach items="${sansers}" var="sa">
    <div style="margin: 10px">
        <span>
            <%=index%>
            <%
                index = index + 1;
            %>,
        </span>
        <span>${sa.stem}</span><br>
    </div>
</c:forEach>
<%
    index = 1;
%>
<input value="提交" type="button" id="Submit">
</body>
<script>
    $(function () {
        var flag = true;
        var answer = "";
        $("#Submit").click(function () {
            $("select option:checked").each(function () {
                var val = $(this).val();
                if (val == null || val == "") {
                    flag = false;
                }
            });
            if (!flag) {
                alert("请做完所有题再提交答案。");
                flag = true;
            } else {
                $("select option:checked").each(function () {
                    var val = $(this).val();
                    answer += val + ",";
                });
                console.log(answer);
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/resourceLogs/answer.action",
                    data: {
                        "answer": answer,
                        "ordery": ordery,
                        "cid": "${cid}"
                    },
                    dataType: "json",
                    success: function (data) {
                        alert(data.msg);
                    }
                });
            }
            answer = "";
        });
    });

</script>
</html>
