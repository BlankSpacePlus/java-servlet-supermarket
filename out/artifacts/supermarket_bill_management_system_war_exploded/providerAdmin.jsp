<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.smbs.entity.SuperProviders" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        function doit(flag,id)
        {
            if(flag=="del")
            {
                if(confirm("确认删除吗？")!=true)
                    return;
            }
            window.location = "provider.do?id="+id+"&flag="+flag;
        }
    </script>
</head>
<body>
<div class="menu">

    <table>
        <tbody><tr><td><form method="post" action="SearchProvidersServlet">
            <input name="flag" value="search" type="hidden">
            供应商名称：<input name="providerName" class="input-text" type="text"> &nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input value="组 合 查 询" type="submit">
        </form></td></tr>
        </tbody></table>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.html'" type="button"></em>
        <div class="title">供应商管理&gt;&gt;</div>
    </div>

    <div class="content">
        <table class="list">
            <tbody><tr>
                <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
                <td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
                <td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
                <td width="100"><div class="STYLE1" align="center">联系人</div></td>
                <td width="100"><div class="STYLE1" align="center">电话</div></td>
                <td width="100"><div class="STYLE1" align="center">地址</div></td>
                <td width="100"><div class="STYLE1" align="center">操作</div></td>
            </tr>
            <%
                List<SuperProviders> list = (List) request.getAttribute("providersList");
                for (SuperProviders tempProvider : list){
            %>
            <tr>
                <td width="70" height="29"><div class="STYLE1" align="center"><%=tempProvider.getProviderID()%></div></td>
                <td width="80"><div class="STYLE1" align="center"><%=tempProvider.getProviderName()%></div></td>
                <td width="100"><div class="STYLE1" align="center"><%=tempProvider.getProviderDesc()%></div></td>
                <td width="100"><div class="STYLE1" align="center">无</div></td>
                <td width="100"><div class="STYLE1" align="center"><%=tempProvider.getProviderTel()%></div></td>
                <td width="100"><div class="STYLE1" align="center"><%=tempProvider.getProviderAddress()%></div></td>
                <td width="100"><div class="STYLE1" align="center"><a href="QueryProviderServlet?providerID=<%=tempProvider.getProviderID()%>">修改</a></div></td>
            </tr>
            <%
                }
            %>

            </tbody></table>
    </div>
</div>
</body>
</html>
