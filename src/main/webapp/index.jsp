<%@ page import="com.sun.org.apache.bcel.internal.generic.LUSHR" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/4/15
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        function getData() {
            var ajax;
            if (window.XMLHttpRequest) {
                ajax = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                ajax = new ActiveXObject("Msxm12.XMLHTTP");
            }
            ajax.onreadystatechange = function () {
                //判断Ajax的状态码
                // if (ajax.readyState == 4){
                //判断响应状态码
                //  if (ajax.State == 200)//{
                //获取响应内容
                var result = ajax.responseText;
                //获取元素对象
                var showdiv = document.getElementById("showdiv");
                showdiv.innerHTML = result;
                // }else if (ajax.State == 404){
                //    var showdiv = document.getElementById("showdiv");
                // showdiv.innerHTML = "请求资源不存在";
                // }else if (ajax.State == 500){
                // var showdiv = document.getElementById("showdiv");
                //     showdiv.innerHTML = "服务器繁忙"
                // }
            }
            // }
            //get请求
            ajax.open("get","cs");
            ajax.send(null);
            //post请求
            //     ajax.open(post,ajax);
            //     ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            //     ajax.send("name=张三&pwd=123");
            //     alert("hhh")
        }






    </script>
</head>
<body>
    <form method="post" action="cs" id="fr">
        要查询星期几：
<%--        <input type="text" name="Week" value="星期"><br>--%>
        <select name="Week">
            <option value ="星期一">星期一</option>
            <option value ="星期二">星期二</option>
            <option value="星期三">星期三</option>
            <option value="星期四">星期四</option>
            <option value="星期五">星期五</option>
            <option value="星期六">星期六</option>
            <option value="星期日">星期日</option>
        </select><br>


        要查询的周数：<input type="text" name="SEweek"><br>
        要查询的节次：<br>
        <input type="radio" value="'_3,4_' OR 节次 LIKE '_3_' OR 节次 LIKE '_2,3,4_' OR 节次 LIKE '_1,2,3_'" name="Session">3,4节
        <input type="radio" value="'_1,2_' OR 节次 LIKE '_3,4_' OR 节次 LIKE '_2_' OR 节次 LIKE '_3_' OR 节次 LIKE '_2,3,4_' OR 节次 LIKE '_1,2,3_' OR 节次 LIKE '_1_'" name="Session">1,2,3,4节
        <input type="radio" value="'_5,6,7_' OR 节次 LIKE '_5,6_' OR 节次 LIKE '_5_' OR 节次 LIKE '_6,7_' OR 节次 LIKE '_7_'" name="Session">5,6,7节
        <input type="radio" value="'_8,9_' OR 节次 LIKE '_8_'" name="Session">8,9节<br>
        <input type="submit" value="查询">
<%--        <div id="showdiv"></div>--%>
    </form>


</body>
</html>
