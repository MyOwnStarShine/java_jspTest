<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>

<div id="signin">
	<a href="<%=path %>/"><div class="logo"></div></a>

	<form name="form1" method="post" action="<%=path %>/login">
		<ul class="simpleul">
			<li><div class="font">用户名</div>
				<div>
					<input type="text" name="uid" />
				</div></li>
			<li><div class="font">密码</div>
				<div>
					<input type="password" name="pwd" />
				</div></li>
			<li><input type="submit" name="submit" value="登录"
				class="btn-primary" /></li>
		</ul>
	</form>

</div>

<%@ include file="footer.jsp"%>
