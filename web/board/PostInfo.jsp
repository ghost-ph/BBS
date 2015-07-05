<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" %>
<%@ page import="com.org.po.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/global.css" rel="stylesheet" type="text/css"/>
    <link href="../../global.css" rel="stylesheet" type="text/css"/>
    <link href="global.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <table width="100%" border="0" align=center valign=middle>
        <tr>
            <td colspan="2" class="tr_title2">帖子详细信息浏览</td>
        </tr>
        <tr>
            <td width="15%">帖子主题：${post.name}</td>
            <td width="20%">发帖时间：${post.publishTime}</td>
        </tr>
        <tr>
            <td>帖子内容：</td>
        </tr>
        <tr>
            <td width="10" ></td>
            <td WIDTH="90%" bgcolor="#ffe4c4">${post.content}</td>
        </tr>
        <tr>
            <td bgcolor="#696969">发帖人:${student.nickName}</td>
        </tr>
        <tr>
            <td bgcolor="#696969">点击量:${post.count} &nbsp;</td>
        </tr>
        </table>
    <table width="100%" border="0" align=center valign=middle>

            <c:forEach var="list" items="${ReplyList}" varStatus="status" >
                <tr>
                    <td colspan="2">
                            <table width="100%" border="0">
                                <tr>
                                    <td width="15%" bgcolor="#deb887">回帖人：${requestScope.studentList[status.index].getNickName()}&nbsp;</td>
                                    <td width="7%">回复时间：</td>
                                    <td width="80%">${list.publishTime}&nbsp;</td>
                                </tr>

                                <tr>
                                    <td >回复内容：</td>
                                    <td colspan="3" bgcolor="#ffe4c4">${list.content}</td>
                                </tr>
                                <tr>
                                    <td colspan="4">
                                    </td> <td colspan="4">
                                    </td>
                                </tr>
                            </table>
                    </td>
                </tr>
            </c:forEach>
    </table>
        <table width="100%" border="0" align=center valign=middle>
        <tr>
            <td colspan="2">
                <form id="form1" name="form1" method="post" action="/board/addReply">
                        <table width="100%" border="0">
                            <tr>
                                <td colspan="2"><h3>快速回复</h3></td>
                            </tr>
                            <tr>
                                <td width="20%">主题：</td>
                                <td width="60%"><input name="name" type="text" id="post.name" size="40"/></td>
                                <td width="20%">&nbsp;</td>
                            </tr>
                            <tr>
                                <td>内容</td>
                                <td><textarea name="content" cols="80" rows="5"></textarea></td>
                                <td><input type="hidden" name="post.id" value="${post.id}"/></td>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" name="Submit3" value="提交"/>
                                    <input type="reset" name="Submit4" value="重置"/></td>
                            </tr>
                        </table>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
