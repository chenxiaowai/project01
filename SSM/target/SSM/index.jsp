<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">springMvc测试</a><br>

    <form action="/account/saveAccount" method="post">
        <p>姓名：<input type="text" name="name"></p>
        <p>金额：<input type="text" name="money"></p>
        <p><input type="submit" value="提交"></p>
    </form>
</body>
</html>
