<%--
  Created by IntelliJ IDEA.
  User: 王虎
  Date: 2021/1/16
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条--%>
<div id="page_nav">
    <%--当前在第一页时，不显示首页和上一页按钮--%>
    <c:if test="${requestScope.page.pageNum > 1}">
        <a href="${requestScope.page.url}&pageNum=1">首页</a>
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum - 1}">上一页</a>
    </c:if>
    <%--中间页码的显示（只显示5个页码）--%>
    <c:choose>
        <%--当总页数小于等于5时--%>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--当总页数大于5时--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--当前页数为前3个时--%>
                <c:when test="${requestScope.page.pageNum<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--当前页数为后3个时--%>
                <c:when test="${requestScope.page.pageNum>=requestScope.page.pageTotal-2}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--在中间时--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNum-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNum+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i==requestScope.page.pageNum}">
            【${i}】
        </c:if>
        <c:if test="${i!=requestScope.page.pageNum}">
            <a href="${requestScope.page.url}&pageNum=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--当前在最后一页时，不显示末页和下一页按钮--%>
    <c:if test="${requestScope.page.pageNum < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageNum + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNum=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.itemTotal}条记录
    到第<input value="${requestScope.page.pageNum}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

</div>
<script type="text/javascript">
    $(function () {
        $("#searchPageBtn").click(function () {
            var pageNum = $("#pn_input").val();
            if (pageNum < 1) {
                pageNum = 1;
            }
            if (pageNum >${requestScope.page.pageTotal}) {
                pageNum =${requestScope.page.pageTotal};
            }
            location.href = "${pageScope.basePath}${requestScope.page.url}&pageNum=" + pageNum;
        });
    });
</script>
