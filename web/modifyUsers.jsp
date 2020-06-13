<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        function checkit()
        {
            //判断是否是数字的正则表达式
            return true;
        }
    </script>
</head>
<body>
<div class="main">
    <div class="optitle clearfix">
        <div class="title">用户管理&gt;&gt;</div>

    </div>
    <form id="form1" name="form1" method="post" action="UpdateUserServlet" onsubmit="return checkit();">
        <input type="hidden" name="flag" value="doAdd">
        <div class="content">
            <table class="box"><font color="red"></font>
                <tr>
                    <td class="field">用户编号：</td>
                    <td><input type="text" name="userId" id="textfield" class="text" value="${requestScope.user.userID}" readonly/> <font color="red">*</font></td>

                </tr>
                <tr>
                    <td class="field">用户名称：</td>
                    <td><input type="text" name="username" class="text" id="textfield2" value="${requestScope.user.userName}"/> <font color="red">*</font></td>
                </tr>
                <tr>
                    <td class="field">用户密码：</td>

                    <td><input type="password" name="password" class="text" id="textfield3" /> <font color="red">*</font></td>
                </tr>
                <tr>
                    <td class="field">用户电话：</td>
                    <td><input type="text" name="userphone" class="text" id="textfield4" value="${requestScope.user.phone}"/> <font color="red">*</font></td>
                </tr>



                <tr>
                    <td class="field">用户地址：</td>
                    <td><textarea name="address" id="textarea" class="text" cols="45" rows="5">${requestScope.user.address}</textarea></td>
                </tr>

                <tr>
                    <td class="field">用户生日：</td>
                    <td><input type="date" name="birthday" class="text" value="${requestScope.user.birthday}"/></td>
                </tr>

                <tr>
                    <td class="field">用户权限：</td>

                    <td><input type="radio" name="auth" id="auth1" value="0" checked="checked"/>高级用户
                        <input type="radio" name="auth" id="auth2" value="1" />普通用户</td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="submit" name="button" id="button1" value="数据提交" class="input-button"/>
            <input type="button" name="button" id="button2" onclick="window.location='QueryUsersServlet';" value="返回" class="input-button"/>
            <a href="DeleteUserServlet?ID=${requestScope.user.userID}" class="input-button">删除</a>

        </div>

    </form>
</div>
</body>
</html>
