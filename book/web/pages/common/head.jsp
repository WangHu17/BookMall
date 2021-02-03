<%--
  Created by IntelliJ IDEA.
  User: 王虎
  Date: 2021/1/7
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--动态访问地址--%>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath",basePath);
%>
<base href="<%=basePath%>">
<link rel="shortcut icon" type="image/x-icon" href="static/imgs/favicon.png" />
<script src="static/js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="static/css/style.css">
