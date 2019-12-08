<%--
  Created by IntelliJ IDEA.
  User: bns
  Date: 2019/10/8
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>重新登录页面</title>
</head>
<body>
    <div id="box">
        <c:if test="${lock!=null}">
            <p>${lock},页面在<span id="Os">3</span>s后跳转</p>
        </c:if>
        <c:if test="${relogin!=null}">
             <p>${relogin},页面在<span id="Os">3</span>s后跳转</p>
        </c:if>
    </div>
    <script type="text/javascript">
        var Os=document.getElementById("Os");
        var num=3;
        var timer=setInterval(function () {
            num--;
            Os.innerText=num;
            if(num==0){
                window.location.href='<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()%>'+'<%=request.getContextPath()%>'+"/login.html";
            }
        },1000);
    </script>
</body>
</html>
