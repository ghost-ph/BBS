<%@ page contentType="text/html; charset=UTF-8" language="java"  errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>无标题文档</title>
    <link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="../global.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div align="right">${msg}</div>
<hr  />
    <table width="100%" border="0">
        <tr>
            <td colspan="6"><div align="center">模块信息查看</div></td>
        </tr>
        <tr>
            <td width="19%">板块名称</td>
        </tr>
        <c:forEach var="boardlist" items="${boardList}">
            <tr>
                <td>${boardlist.name}</td>
            <tr>
                <td>帖子名称</td>
                <td>发帖时间</td>
                <td>点击量</td>
            </tr>
            <c:forEach var="postList" items="${postList}">
                <tr>
                <td><a href="/board/postInfo?post.id=${postList.id}" target="_blank">${postList.name}</a>&nbsp;</td>
                <td>${postList.publishTime}&nbsp;</td>
                <td>${postList.count}&nbsp;</td>
                </tr>
            </c:forEach>
            </tr>
        </c:forEach>
    </table>

    <form id="form1" name="form1" method="post" action="/board/addPost">
        <div align="center">
        <table width="100%" border="0">
            <tr>
                <td></td>
                <td colspan="3" class="tr_title2"><h1>发布帖子</h1></td>
            </tr>

            <tr>
                <td width="20%">主题：</td>
                <td width="60%"><input name="name" type="text" id="post.name" size="40"/></td>
                <td width="20%">&nbsp;</td>
            </tr>
            <tr>
                <td>内容：</td>
                <td><textarea name="content" cols="70" rows="8"></textarea></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>板块类型：</td>
                <td>
                    <select name="home">
                        <c:forEach var="boardlist" items="${boardList}">
                            <option value="${boardlist.id}">${boardlist.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="3">　　　　　　　　　
                    <input type="submit" name="Submit" value="提交" />
                    　　　　　　　　　　
                    <input type="reset" name="button" id="button" value="重置" /></td>
            </tr>
        </table>
        </div>
    </form>

</body>
</html>
