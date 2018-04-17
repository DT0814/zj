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
添加学生
<form action="${APP_PATH}/student/insert.action" method="post">
    学生账号:<input type="text" name="snum"><br>
    学生密码:<input type="password" name="spass"><br>
    学生姓名:<input type="text" name="sname"><br>
    <select name="cid" id="studentClass">
    </select>
    <input type="submit" value="提交">
</form>
删除学生
<form action="${APP_PATH}/student/delete.action" method="post">
    学生账号:<input type="text" name="snum"><br>
    <input type="submit" value="提交">
</form>

修改学生
<form id="updateForm">
    学生账号:<input type="text" name="snum"><br>
    学生密码:<input type="password" name="spass"><br>
    学生姓名:<input type="text" name="sname"><br>
    <select name="cid" id="studentUpdata">
    </select>
    <input type="button" id="updateBut" value="提交">
</form>
<br>
<br>
<script>
    $.ajax({
        type: "GET",
        url: "${APP_PATH}/class/findAll.action",
        success: function (data) {
            if (data.code == 200) {
                var el = $("#studentUpdata");
                $.each(data.data, function () {
                    $("<option value='" + this.cid + "'>" + this.name + "</option>").appendTo(el);
                })
            }
        },
        error: function () {
            alert("error");
        }
    });
    $.ajax({
        type: "GET",
        url: "${APP_PATH}/class/findAll.action",
        success: function (data) {
            if (data.code == 200) {
                var el = $("#studentClass");
                $.each(data.data, function () {
                    $("<option value='" + this.cid + "'>" + this.name + "</option>").appendTo(el);
                })
            }
        },
        error: function () {
            alert("error");
        }
    });
    $.ajax({
        type: "GET",
        url: "${APP_PATH}/choice/findAll.action",
        success: function (data) {
            if (data.code == 200) {
                console.log(data.data);
            }
        },
        error: function () {
            alert("error");
        }
    });
    $("#updateBut").click(function () {
        $.ajax({
            type: "POST",
            url: "${APP_PATH}/student/update.action",
            data: $("#updateForm").serialize(),
            success: function (data) {
                if (data.code == 200) {
                    console.log(data);
                }
            },
            error: function () {
                alert("error");
            }
        });
    })
</script>
</body>

</html>
