<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/4/15
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #showdiv{
            border: solid 1px;
            width: 200px;
            height: 100px;
        }
    </style>

<%--    <script type="text/javascript" src="jquery-3.3.1.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        function getData() {--%>
<%--            var ajax;--%>
<%--            if (window.XMLHttpRequest) {--%>
<%--                ajax = new XMLHttpRequest();--%>
<%--            } else if (window.ActiveXObject) {--%>
<%--                ajax = new ActiveXObject("Msxm12.XMLHTTP");--%>
<%--            }--%>
<%--            ajax.onreadystatechange = function () {--%>
<%--                //判断Ajax的状态码--%>
<%--                // if (ajax.readyState == 4){--%>
<%--                //判断响应状态码--%>
<%--                //  if (ajax.State == 200)//{--%>
<%--                //获取响应内容--%>
<%--                var result = ajax.responseText;--%>
<%--                alert(result)--%>
<%--                //获取元素对象--%>

<%--                // var showdiv = document.getElementById("showdiv");--%>
<%--                // showdiv.innerHTML = result;--%>

<%--                // }else if (ajax.State == 404){--%>
<%--                //    var showdiv = document.getElementById("showdiv");--%>
<%--                // showdiv.innerHTML = "请求资源不存在";--%>
<%--                // }else if (ajax.State == 500){--%>
<%--                // var showdiv = document.getElementById("showdiv");--%>
<%--                //     showdiv.innerHTML = "服务器繁忙"--%>
<%--                // }--%>
<%--            }--%>
<%--            // }--%>
<%--            //get请求--%>
<%--            ajax.open("get","cs");--%>
<%--            ajax.send(null);--%>
<%--            //post请求--%>
<%--            //     ajax.open(post,ajax);--%>
<%--            //     ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");--%>
<%--            //     ajax.send("name=张三&pwd=123");--%>
<%--            //     alert("hhh")--%>
<%--        }--%>
<%--    </script>--%>


</head>
<body>
<i>一教：</i><br>
<i>一楼：</i><span><c:forEach items="${yi}" var="s">${s}&nbsp;</c:forEach></span><br>
<i>二楼：</i><span><c:forEach items="${er}" var="s">${s}&nbsp;</c:forEach></span><br>
<i>三楼：</i><span><c:forEach items="${san}" var="s">${s}&nbsp;</c:forEach></span><br>
<i>四楼：</i><span><c:forEach items="${si}" var="s">${s}&nbsp;</c:forEach></span><br>
<i>二教：</i><br>
<i>一楼：</i><span><c:forEach items="${wu}" var="s">${s}&nbsp;</c:forEach></span><br>
<i>二楼：</i><span><c:forEach items="${liu}" var="s">${s}&nbsp;</c:forEach></span><br>
<i>三楼：</i><span><c:forEach items="${qi}" var="s">${s}&nbsp;</c:forEach></span><br>
<i>四楼：</i><span><c:forEach items="${ba}" var="s">${s}&nbsp;</c:forEach></span><br>

<%--    <c:forEach items="${lu}" var="s">--%>
<%--        ${s}&nbsp;--%>
<%--    </c:forEach>--%>
<%--    <%--%>
<%--        List<String> lu = (List<String>)request.getSession().getAttribute("lu");--%>
<%--        for (int i = 0;i < lu.size(); i++){--%>
<%--            String n = lu.get(i);--%>
<%--            %>--%>
<%--    <%=n%>--%>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--    <input type="button" value="测试" onclick="getData()">--%>
<%--    <div id="showdiv"></div>--%>
</body>
</html>