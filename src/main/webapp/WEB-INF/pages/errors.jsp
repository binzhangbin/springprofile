<%--
  Created by IntelliJ IDEA.
  User: bns
  Date: 2019/10/8
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>

    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
</head>
<body>
错误页面,跳转到<a href="<%=basePath%>/register.html">注册页</a>|<a href="<%=basePath%>/login.html">登录页</a>,错误信息-${ex}
</body>
</html>
