<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>无标题文档</title>
    <link href="css/global.css" rel="stylesheet" type="text/css"/>
    <link href="../global.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<script language="javascript" type="text/javascript">
    function checkAll() {
        var elements = document.form1.ids;
        for (i = 0; i < elements.length; i++) {
            var element = elements[i];
            element.checked = true;
        }
    }
    function uncheckAll() {
        var elements = document.form1.ids;
        for (i = 0; i < elements.length; i++) {
            var element = elements[i];
            element.checked = !element.checked;
        }
    }
    function goPage() {
        window.location.href = "Dep_toAdd"
    }

</script>
<div align="center">我的帖子</div>
<hr/>
<form id="form1" name="form1" method="post" action="/board/postDeleteAction">
    <table width="100%" border="0">
        <tr><td><span style="color: red"><h2>${msg}</h2></span></td></tr>
        <tr>
            <td>帖子名称</td>
            <td>发帖时间</td>
            <td>点击量</td>
            <td align="right">
                <input type="checkbox" name="checkbox" value="checkbox" onclick="checkAll()">
                全选
                <input type="checkbox" name="checkbox2" value="checkbox" onClick="uncheckAll()">

                反选
            </td>
        </tr>
        <c:forEach var="postList" items="${postList}">
            <tr>
                <td><a href="/board/postInfo?post.id=${postList.id}" target="_blank">${postList.name}</a>&nbsp;</td>
                <td>${postList.publishTime}&nbsp;</td>
                <td>${postList.count}&nbsp;</td>
                <td><input id="ids" type="checkbox" name="ids" value="${postList.id}">&nbsp;</td>
                <td>&nbsp;&nbsp;</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6"><input type="submit" name="Submit" value="删除"/> 　　　
                <input type="button" name="Submit2" value="添加"
                       onclick="javascript:window.location='/board/boardIndex.action'"/>　　　
                　　　　　　　　　　　　　　　　　　　　　　　　　　　　
                首页　上一页　　下一页　　末页
            </td>
        </tr>
    </table>
</form>
</body>
</html>
