<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" > 
<head> 
  <meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>X2CDN</title> 
  <link rel="stylesheet" href="<%=path %>/css/default.css" type="text/css"/>
  <script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
  <script type="text/javascript" src="<%=path %>/js/comm.js"></script>
  <script type="text/javascript" src="<%=path %>/js/default.js"></script> 
</head> 
<body>
<div id="signin">
<div class="logo"></div>


	<form name="form1" method="post" action="<%=path %>/UserPost?action=adduser">
		<ul class="simpleul">
			<li><div class="font">用户名</div><div><input type="text" name="uid" /></div></li>
			<li><div class="font">密码</div><div><input type="password" name="pwd" /></div></li>
			<li><input type="submit" name="submit" value="登录" class="btn-primary" /></li>
		</ul>
	</form>
</div>

</body> 
</html> 
