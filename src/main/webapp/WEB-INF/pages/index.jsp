<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="cn.bin.zhang.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: bns
  Date: 2019/10/8
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>blog</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    %>
    <link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
    <link href="<%=basePath%>/static/css/index.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=basePath%>/static/css/style.css">
    <script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
    <script type="text/javascript">
        var i = 1;
        var time;

        function write() {
            var id = document.getElementById("main");
            var msg = "${blg.btxt}";
            var len = msg.length;
            var msg1 = msg.substring(0, i);
            id.innerHTML = msg1;
            if (i == len) {
                clearInterval(time)
            } else
                i++;
        };

        function time1() {
            time = setInterval(function () {
                write()
            }, 120);
        }
    </script>
</head>
<body onload="time1()">
<div>
    <div style="float: left">
        <div style="float: left">
            <a href="#modal-opened" id="modal-closed"><img src="<%=basePath%>/static/image/default.jpg" width="110px"
                                                           style="float:left;margin-right:1px;"/></a>
            <div style="margin-left: 24px">
                ${usr.uinfo}
            </div>
        </div>
        <div>
            <form id="upForm" method="post" action="<%=basePath%>/fileupload.action" enctype="multipart/form-data">
                <input type="file" name="file1">
                <%--<button id="uploadFileBtn">上传文件</button>--%>
                <input type="submit" value="上传文件"/>
            </form>
        </div>
    </div>
    <%
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user= (User) request.getSession().getAttribute("usr");
        String date= format.format(user.getUbirthday());
    %>
    <div style="margin-left: 30%">
        <div style="margin-left: 38%"><h4>${blg.btitle}</h4></div>
        <div id="main"></div>
    </div>
</div>
<div class="modal-container" id="modal-opened">
    <div class="modal">
        <form action="<%=basePath%>/blog/update.action" method="post">
            <div class="modal__details">
                <h1 class="modal__title">个人信息修改</h1>
                用户名：<input type="text" id="uname" name="uname" class="modal__description" size="20"
                          value="${usr.uname}"/><br/>
                <hr/>
                年龄：<input type="number" id="uage" name="uage" class="modal__description" size="20"
                          value="${usr.uage}"/><br/>
                <hr/>
                生日：&nbsp;&nbsp;<input type="date" id="ubirthday" class="modal__description" name="ubirthday" size="20"
                                      value="<%=date%>"/><br/>
                <hr/>
                简介：&nbsp;&nbsp;<textarea name="uinfo" id="uinfo" class="modal__description" rows="5"
                                         cols="20">${usr.uinfo}</textarea>
                <input type="hidden" id="uid" name="uid" value="${usr.uid}">
            </div>
            <button class="modal__btn">数据更新</button>
            <a href="#modal-closed" class="link-2"></a>
        </form>
    </div>
</div>
</body>
</html>
