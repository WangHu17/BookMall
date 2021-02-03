<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
</head>

<script type="text/javascript">
    $(function () {
        $(".deleteItem").click(function () {
            return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");
        });

        $("#clearCart").click(function () {
            return confirm("你确定要清空购物车吗？");
        });

        $(".cartItemCount").change(function () {
            var id = $(this).attr("bookId");
            var name = $(this).parent().parent().find("td:first").text();
            var count = this.value;
            if (confirm("你确定要修改【" + name + "】的数量为【" + count + "】吗？")) {
                location.href = "${pageScope.basePath}cartServlet?action=updateCount&id=" + id + "&count=" + count;
            } else {
                this.value = this.defaultValue;
            }
        });
    });
</script>

<body>

<div id="header">
    <img class="logo_img" alt="" src="static/imgs/logo.gif">
    <span class="wel_word">购物车</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录 | 注册</a> &nbsp;&nbsp;
            <a href="index.jsp">返回</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书城</span>
            <a href="orderServlet?action=listOrders">我的订单</a>
            <a href="userServlet?action=loginOut">注销</a>&nbsp;&nbsp;
            <a href="index.jsp">主页</a>
        </c:if>
    </div>
</div>
<div id="main">
    <table>
        <tr>
            <td class="cart_td_name">商品名称</td>
            <td class="cart_td_count">数量</td>
            <td class="cart_td_singlePrice">单价</td>
            <td class="cart_td_totalPrice">金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td class="cart_td_name">${entry.value.name}</td>
                    <td class="cart_td_count">
                        <input bookId="${entry.value.id}" class="cartItemCount" type="text" value="${entry.value.count}">
                    </td>
                    <td class="cart_td_singlePrice">${entry.value.singlePrice}</td>
                    <td class="cart_td_totalPrice">${entry.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>

        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">
                    <a href="index.jsp">购物车是空的，去浏览商品吧！</a>
                </td>
            </tr>
        </c:if>
    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

</body>
</html>