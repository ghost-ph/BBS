<%@ page contentType="text/html; charset=gb2312" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>无标题文档</title>

  <script language="javascript" type="text/javascript" src="js/selector.js">
  </script>


  <link href="css/birthday.css" rel="stylesheet" type="text/css" />

  <link href="global.css" rel="stylesheet" type="text/css" />
</head>

<body>

<form id="form1" name="form1" method="post" action="Post_PostInsert.action">
  <table width="100%" border="0">
    <tr>
      <td colspan="3" class="tr_title2">发布帖子</td>
    </tr>
    <tr>
      <td width="20%">主题：</td>
      <td width="60%"><input name="post.name" type="text" id="post.name" size="40"/></td>
      <td width="20%">&nbsp;</td>
    </tr>
    <tr>
      <td>内容：</td>
      <td><textarea name="content " cols="70" rows="8"></textarea></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>发布时间：</td>
      <td><input name="post.publishTime" type="text" class="input" id="post.publishTime"
                 onfocus="show_cele_date(pubdate,'','',pubdate)" size="40" /></td>
      <td><input type="hidden" name="post.sid" value="1"/><input type="hidden" name="post.bid" value="1"/><input type="hidden" name="post.aid" value="1"/><input type="hidden" name="post.count" value="1"/>&nbsp;</td>
    </tr>

    <tr>
      <td colspan="3">　　　　　　　　　
        <input type="submit" name="Submit" value="提交" />
        　　　　　　　　　　
        <input type="reset" name="button" id="button" value="重置" /></td>
    </tr>
  </table>
</form>
</body>
</html>
