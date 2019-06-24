<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>

<form action="param/testListAndMap" method="post">
    <p>姓名<input type="text" name="pname"></p>
    <p>年龄<input type="text" name="page"></p>

    <p>账户名<input type="text" name="list[0].username"></p>
    <p>账户金额<input type="text" name="list[0].age"></p>
    <p>账户年龄<input type="text" name="list[0].money"></p>
    <p>账户中的用户<input type="text" name="list[0].user.uname"></p>
    <p>账户中的用户年龄<input type="text" name="list[0].user.uage"></p>
    <p>账户中的用户地址<input type="text" name="list[0].user.address"></p>


    <p>姓名<input type="text" name="map['user'].uname"></p>
    <p>年龄<input type="text" name="map['user'].uage"></p>
    <p>地址<input type="text" name="map['user'].address"></p>
    <p><input type="submit" value="提交"></p>
</form>

</body>
</html>
