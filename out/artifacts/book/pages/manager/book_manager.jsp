<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>

</head>
<script type="text/javascript">
    $(function () {
        $("a.delete").click(function () {
            return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");
        });
    });
</script>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/imgs/logo.gif">
    <span class="wel_word">图书管理系统</span>

    <%-- 静态包含 manager管理模块的菜单  --%>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td class="td_name">名称</td>
            <td class="td_price">价格</td>
            <td class="td_author">作者</td>
            <td class="td_sales">销量</td>
            <td class="td_stock">库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr class="tr_books">
                <td class="td_name">${book.name}</td>
                <td class="td_price">${book.price}</td>
                <td class="td_author">${book.author}</td>
                <td class="td_sales">${book.sales}</td>
                <td class="td_stock">${book.stock}</td>
                <td><a href="manager/bookServlet?action=get&id=${book.id}&pageNum=${requestScope.page.pageNum}">修改</a></td>
                <td><a class="delete" href="manager/bookServlet?action=delete&id=${book.id}&pageNum=${requestScope.page.pageNum}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNum=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>

    <%--分页条--%>
    <%@include file="/pages/common/paging.jsp"%>

</div>

</body>
</html>