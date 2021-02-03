<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
</head>
<script type="text/javascript">
    $(function () {
        //加入购物车
        $(".join_cart").click(function () {
            if (${empty sessionScope.user}) {
                alert("请先登录！");
            } else {
                var id = $(this).attr("bookId");
                // 方法一
                <%--location.href = "${pageScope.basePath}cartServlet?action=addItem&id=" + id;--%>
                //方法二：Ajax
                $.getJSON("${pageScope.basePath}cartServlet","action=ajaxAddItem&id=" + id,function (data) {
                    $("#topNews>span").text("您的购物车中有"+data.totalCount+"件商品");
                    $("#topNews>div>span").text(data.lastItem);
                });
            }
        });
        //后台管理访问
        $("#managerBtn").click(function () {
            if(${empty sessionScope.user}){
                alert("请先登录！");
                return false;
            }
            if(${sessionScope.user.username!="admin"}){
                alert("对不起，你不是管理员，无法访问后台！");
                return false;
            }
        });
    });
</script>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/imgs/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录 | 注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书城</span>
            <a href="pages/cart/cart.jsp">购物车</a>
            <a href="orderServlet?action=listOrders">我的订单</a>
            <a href="userServlet?action=loginOut">注销</a>&nbsp;&nbsp;
        </c:if>
        <%--<c:if test="${sessionScope.user.username=='admin'}">--%>
            <a href="pages/manager/manager.jsp" id="managerBtn">后台管理</a>
        <%--</c:if>--%>
    </div>
</div>

<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
                <a href="index.jsp"><input type="button" value="重置"></a>
            </form>

        </div>
        <div id="topNews" style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <span style="color: red">你的购物车是空的哦，快加入一点吧</span>
                <div><span>&nbsp;</span></div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.lastItem}</span>加入到了购物车中
                </div>
            </c:if>
        </div>

        <%--图书展示板块--%>
        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <%--已售完--%>
                <c:if test="${book.stock<=0}">
                    <div class="mask">
                        <img src="static/imgs/saleOut.png" class="sale_out" alt=""/>
                    </div>
                </c:if>
                <img class="book_img" alt="" src="${book.img_path}"/>
                <div class="book_info">
                    <p class="sp1">${book.name}</p>
                    <p class="sp1">${book.author}</p>
                    <p class="sp1">￥${book.price}</p>
                    <p class="sp1">销量：${book.sales} &nbsp; &nbsp; &nbsp; 库存：${book.stock}</p>
                    <button class="join_cart" bookId="${book.id}">加入购物车</button>
                </div>
            </div>
        </c:forEach>
    </div>

    <%--分页条--%>
    <%@include file="/pages/common/paging.jsp" %>

</div>

</body>
</html>