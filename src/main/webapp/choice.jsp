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


<table id="table">
    <tr>
        <td>题干</td>
        <td>正确答案</td>
        <td>A</td>
        <td>B</td>
        <td>C</td>
        <td>D</td>
    </tr>
</table>


添加试题
<form action="${APP_PATH}/choice/insert.action" method="post" id="addForm">
    题干:<input type="text" name="stem"><br>
    正确答案:<input type="text" name="answer"><br>
    A选项:<input type="text" name="a"><br>
    B选项:<input type="text" name="b"><br>
    C选项:<input type="text" name="c"><br>
    D选项:<input type="text" name="d"><br>
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

    $.ajax({
        type: "GET",
        url: "${APP_PATH}/choice/findAll.action",
        success: function (data) {
            if (data.code == 200) {
                var el = $("#table");
                $.each(data.data, function () {
                    var tr = $("<tr></tr>");
                    var td = $("<td>" + this.stem + "</td>");
                    td.appendTo(tr);
                    td = $("<td>" + this.answer + "</td>");
                    td.appendTo(tr);
                    td = $("<td>" + this.a + "</td>");
                    td.appendTo(tr);
                    td = $("<td>" + this.b + "</td>");
                    td.appendTo(tr);
                    td = $("<td>" + this.c + "</td>");
                    td.appendTo(tr);
                    td = $("<td>" + this.d + "</td>");
                    td.appendTo(tr);
                    tr.appendTo(el);
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
