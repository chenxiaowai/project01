<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>表现层：查询所有账户</h1>

    <c:forEach items="${accounts}" var="account">
        ${account.name}
        ${account.money}
    </c:forEach>

</body>
</html>
