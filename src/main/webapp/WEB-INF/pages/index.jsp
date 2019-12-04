<%--
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
<style type="text/css">
    #main{
        width:980px;
        margin:10px auto;
        background: #ebf3d6;
        border:2px outset #f9a95b;
        color: #2b4c80;
    }
</style>
<script type="text/javascript">
    var i=1;
    function write()
    {
        var id=document.getElementById("main");
        var msg="${blog.btxt}";
        var len=msg.length;
        var msg1=msg.substring(0,i);
        id.innerHTML=msg1;
        if(i==len){clearInterval(time)}
        else
            i++;
    };
    function time1()
    {
        var time=setInterval(function(){write()},120);
    }
</script>
</head>
<body onload="time1()">
    <center><div><h4>${blog.btitle}</h4></div></center>
    <div id="main"></div>
</body>
</html>
