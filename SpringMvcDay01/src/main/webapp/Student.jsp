<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
    <a href="param/testParam?username=hello&password=123">params绑定</a><br>

<%--自定义类型转化器--%>
<form action="param/saveStudent" method="post">
    <p>姓名<input type="text" name="username"></p>
    <p>年龄<input type="text" name="age"></p>
    <p>生日<input type="text" name="birthday"></p>
    <select name="date"></select>
    <p><input type="submit" value="提交"></p>
</form>

</body>
</html>
