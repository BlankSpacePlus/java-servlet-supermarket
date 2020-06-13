<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>

<div class="main">
    <div class="optitle clearfix">
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <form method="post" action="UpdateBillServlet" onsubmit="return checkit();">
        <div class="content">
            <table class="box">
                <tr>
                    <td class="field">账单编号：</td>
                    <td><input type="text" name="billNum" class="text" value="${requestScope.bill.billID}" readonly/></td>
                </tr>
                <tr>
                    <td class="field">商品名称：</td>
                    <td><input type="text" name="productName" class="text" value="${requestScope.bill.productName}" /></td>
                </tr>
                <tr>
                    <td class="field">商品数量：</td>
                    <td><input type="text" name="productNum" class="text" value="${requestScope.bill.productCount}" /></td>

                </tr>
                <tr>
                    <td class="field">交易金额：</td>
                    <td><input type="text" name="money" class="text" value="${requestScope.bill.totalPrice}"/></td>
                </tr>
                <tr>
                    <td class="field">商品描述：</td>
                    <td><textarea name="discription">${requestScope.bill.productDesc}</textarea></td>
                </tr>

                <tr>
                    <td class="field">所属供应商：</td>
                    <td><select name="providerID">
                        <c:forEach items="${requestScope.providersList}" var="provider">
                            <c:choose>
                                <c:when test="${provider.providerID==requestScope.bill.providerID}">
                                    <option value="${provider.providerID}" selected>
                                            ${provider.providerName}
                                    </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${provider.providerID}">
                                            ${provider.providerName}
                                    </option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td class="field">是否付款：</td>
                    <td><select name="isPay">
                        <c:choose>
                        <c:when test="${requestScope.bill.isPayment==1}">
                            <option value="1" selected>是</option>
                        </c:when>
                            <c:otherwise>
                                <option value="1">是</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${requestScope.bill.isPayment==2}">
                                <option value="2" selected>否</option>
                            </c:when>
                            <c:otherwise>
                                <option value="2">否</option>
                            </c:otherwise>

                        </c:choose>

                    </select><td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="submit" name="submit" value="确认" class="input-button" />
            <input type="button" name="button" value="返回" class="input-button" onclick="window.location='QueryBillsServlet';" />
            <a href="DeleteBillServlet?ID=${requestScope.bill.billID}" class="input-button">删除</a>

        </div>
    </form>
</div>
</body>
</html>
