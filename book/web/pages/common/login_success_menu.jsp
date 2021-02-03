<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/5
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <c:if test="${empty sessionScope.user}">
        <a href="pages/user/login.jsp">登录 | 注册</a> &nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </c:if>
    <c:if test="${not empty sessionScope.user}">
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书城</span>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="orderServlet?action=listOrders">我的订单</a>
        <a href="userServlet?action=loginOut">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">主页</a>
    </c:if>
</div>