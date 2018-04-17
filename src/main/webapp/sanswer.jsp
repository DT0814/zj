<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商家</title>
    <script type="text/javascript"
            src="${APP_PATH}/js/jquery-1.12.4.js"></script>
</head>
<body>
<h2>Hello World!</h2>
添加试题
<form action="${APP_PATH}/sanswer/insert.action" method="post" id="addForm">
    题干:<input type="text" name="stem"><br>
    所属知识点
    <select name="pid">
    </select>
    所属难度等级
    <select name="did">
    </select>
    <input type="submit" value="提交">
</form>
<br>
<script>
    $.ajax({
        type: "GET",
        url: "${APP_PATH}/point/findAll.action",
        success: function (data) {
            if (data.code == 200) {
                var el = $("#addForm").find("select[name=pid]");
                $.each(data.data, function () {
                    $("<option value='" + this.pid + "'>" + this.name + "</option>").appendTo(el);
                })
            }
        },
        error: function () {
            alert("error");
        }
    });
    $.ajax({
        type: "GET",
        url: "${APP_PATH}/difficulty/findAll.action",
        success: function (data) {
            if (data.code == 200) {
                var el = $("#addForm").find("select[name=did]");
                $.each(data.data, function () {
                    $("<option value='" + this.did + "'>" + this.dname + "</option>").appendTo(el);
                })
            }
        },
        error: function () {
            alert("error");
        }
    });
</script>
</body>

</html>
