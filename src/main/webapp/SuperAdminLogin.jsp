<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <style>body {
        padding-top: 60px;
    }</style>
    <link href="${APP_PATH}/css/bootstrap.css" rel="stylesheet"/>
    <link href="${APP_PATH}/admin/css/login-register.css" rel="stylesheet"/>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <script src="${APP_PATH}/js/jquery-1.12.4.js" type="text/javascript"></script>
    <script type="text/javascript" src="${APP_PATH}/js/jquery.cookie.js"></script>
    <script src="${APP_PATH}/js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="${APP_PATH}/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/js/axios.js"></script>
</head>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<body>
<div class="container" id="login">
    <form id="LoginForm" action="${APP_PATH}/admin/login.action" method="post">
        <input class="form-control" type="text" placeholder="account" name="account">
        <input class="form-control" type="password" placeholder="Password"
               name="pass">
        <input type="submit" class="btn btn-default btn-login" value="登录"/>
    </form>
</div>
<script>
    var msg = "${msg}";
    $(function () {
        if (msg != null && msg != "") {
            alert(msg);
        }
    })

</script>
</body>
</html>

