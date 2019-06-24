<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

    <script>
        <%--页面加载，绑定单击事件--%>
      $(function () {
          $("#btn").click(function () {
              $.ajax({
                  url:"user/testAjax",
                  contentType:"application/json;charset=utf-8",
                  data:'{"username":"www","password":"123","age":"22"}',
                  dataType:"json",
                  type:"post",
                  success:function (data) {
                    /*接受servlet返回来的json数据*/
                    alert(data);
                    alert(data.username);
                    alert(data.password);
                    alert(data.age);

                    window.document.write(data.username)

                  }
              })
          });
      });

    </script>
</head>
<body>
    <%--<a href="hello">springMvc入门</a>--%>


    <a href="user/testSpring">testSpring</a>
    <br/>

    <a href="user/testVoid">testVoid</a>

    <br/>
    <a href="user/testModelAndView">testModelAndView</a>

    <br/>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

    <br/>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
