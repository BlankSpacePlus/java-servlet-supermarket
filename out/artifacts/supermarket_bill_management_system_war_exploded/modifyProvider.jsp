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
        <div class="title">供应商管理&gt;&gt;</div>
    </div>
    <form id="form1" name="form1" method="post" action="UpdateProviderServlet" onsubmit="return checkit();">
        <div class="content">
            <font color="red"></font>
            <input name="flag" value="doAdd" type="hidden">
            <table class="box">

                <tbody><tr>
                    <td class="field">供应商编号：</td>
                    <td><input name="proId" id="textfield" class="text" type="text" value="${provider.providerID.toString()}" readonly> <font color="red"></font></td>
                </tr>
                <tr>
                    <td class="field">供应商名称：</td>
                    <td><input name="proName" id="textfield2" value="${provider.providerName}" class="text" type="text"> <font color="red">*</font></td>

                </tr>
                <tr>
                    <td class="field">供应商描述：</td>
                    <td><textarea name="proDesc" id="textarea" cols="45" rows="5" >${provider.providerDesc}</textarea></td>
                </tr>
                <tr>
                    <td class="field">供应商电话：</td>
                    <td><input name="phone" id="textfield3" value="${provider.providerTel}" class="text" type="text"></td>
                </tr>
                <tr>
                    <td class="field">供应商地址：</td>
                    <td><input name="address" id="textfield4" value="${provider.providerAddress}" class="text" type="text"></td>
                </tr>
                </tbody></table>
        </div>

        <div class="buttons">
            <input name="button" id="button1" value="提交" class="input-button" type="submit">
            <input name="button" id="button2" onclick="window.location='ProviderAdminServlet';" value="返回" class="input-button" type="button">
            <a href="DeleteProviderServlet?providerID=${provider.providerID.toString()}" class="input-button">删除</a>

        </div>
    </form>
</div>
</body>
</html>
