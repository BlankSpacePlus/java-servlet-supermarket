<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
    <form method="get" action="SearchBillsServlet">
        商品名称：<input type="text" name="productName" class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
        是否付款：<select name="payStatus">
        <option value="3">请选择</option>
        <option value="1">已付款</option>
        <option value="0">未付款</option>
    </select>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" name="submit" value="组合查询" class="button" />
    </form>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='PreAddBillServlet'" /></em>
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tr>
                <td>账单编号</td>
                <td>商品名称</td>
                <td>商品数量</td>
                <td>交易金额</td>
                <td>是否付款</td>
                <td>供应商名称</td>
                <td>商品描述</td>
                <td>账单时间</td>
                <td>操作</td>
            </tr>

                <c:forEach items="${requestScope.billsList}" var="bill">
            <tr>
                <td>${bill.billID}</td>
                <td>${bill.productName}</td>
                    <td>${bill.productCount}</td>
                    <td>${bill.totalPrice.toString()}</td>
                    <td><c:if test="${bill.isPayment==1}">已付款</c:if><c:if test="${bill.isPayment==2}">未付款</c:if></td>
                    <td><c:forEach items="${requestScope.providersList}" var="provider">
                        <c:if test="${provider.providerID==bill.providerID}">
                            ${provider.providerName}
                        </c:if>
                    </c:forEach> </td>
                    <td>${bill.productDesc}</td>
                    <td>${bill.createTime}</td>
                    <td><a href="PreUpdateBillServlet?ID=${bill.billID}">修改</a></td>
            </tr>
                </c:forEach>

        </table>
    </div>
</div>
</body>
</html>
