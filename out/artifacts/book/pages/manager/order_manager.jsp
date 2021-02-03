<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
</head>

<script type="text/javascript">
    $(function () {
        //查看详情
        $(".getItemsView").click(function () {
            var orderId = $(this).parent().parent().find("td:nth-child(3)").text();
            $.getJSON("${pageScope.basePath}orderServlet", "action=listItems&orderId=" + orderId, function (data) {
                $("#orderItemsView>.orderItem").remove();
                for (var i = 0; i < data.length; i++) {
                    var $orderItem = createOrderItem(data[i]);
                    $("#orderItemsView").append($orderItem);
                }
            });
            $("#orderItemsView").show();
        });
        //关闭详情页
        $("#closeBth").click(function () {
            $("#closeBth").parent().hide();
        });

        //订单详情项
        function createOrderItem(data) {
            var $orderItem = $("<div class=\"orderItem\">\n" +
                "        <img src=\""+data.imgPath+"\">\n" +
                "        <div>\n" +
                "            <p>"+data.Name+"</p>\n" +
                "            <p>"+data.author+"</p>\n" +
                "            <p>"+data.Count+"本</p>\n" +
                "            <p>￥"+data.totalPrice+"(单价￥"+data.singlePrice+")</p>\n" +
                "        </div>\n" +
                "    </div>");
            return $orderItem;
        }
    })
</script>

<body>
<div id="header">
    <img class="logo_img" alt="" src="static/imgs/logo.gif">
    <span class="wel_word">订单管理系统</span>
    <%-- 静态包含 manager管理模块的菜单  --%>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>用户名</td>
            <td>订单号</td>
            <td>数量</td>
            <td>总价</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:if test="${empty sessionScope.allOrders}">
            <tr>
                <td colspan="5">
                    <a href="index.jsp">目前没有订单哦，快去下单吧！</a>
                </td>
            </tr>
        </c:if>
        <c:forEach items="${sessionScope.allOrders}" var="order">
            <tr>
                <td>${order.orderDate}</td>
                <td>${order.userName}</td>
                <td>${order.orderId}</td>
                <td>${order.itemsCount}</td>
                <td>${order.totalPrice}</td>
                <td>
                    <c:if test="${order.orderStatus == 0}">
                        <a href="orderServlet?action=deliver&orderId=${order.orderId}" style="color: #f44336;text-decoration: none;">点击发货</a>
                    </c:if>
                    <c:if test="${order.orderStatus == 1}">
                        <span style="color: royalblue">已发货</span>
                    </c:if>
                    <c:if test="${order.orderStatus == 2}">
                        <span style="color: #39987c">已签收</span>
                    </c:if>
                </td>
                <td><input class="getItemsView" type="button" value="查看详情"></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="orderItemsView" class="managerOrderItemsView">
    <div>订单详情</div><span id="closeBth">关闭</span>
</div>

</body>
</html>