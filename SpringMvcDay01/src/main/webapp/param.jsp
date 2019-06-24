<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
    <a href="param/testParam?username=hello&password=123">params绑定</a><br>


<form action="param/saveAccount" method="post">
    <p>姓名<input type="text" name="username"></p>
    <p>年龄<input type="text" name="age"></p>
    <p>金额<input type="text" name="money"></p>
    <p>用户名<input type="text" name="user.uname"></p>
    <p>用户年龄<input type="text" name="user.uage"></p>
    <p>姓名地址<input type="text" name="user.address"></p>
    <p><input type="submit" value="提交"></p>
</form>

</body>
</html>
