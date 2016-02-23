<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>

<div id="signin">
	<a href="<%=path %>/"><div class="logo"></div></a>

	<form name="form1" method="post" action="<%=path %>/register">
		<ul class="simpleul">
			<li><div class="font">用户名</div>
				<div>
					<input type="text" name="username" />
				</div></li>
			<li><div class="font">密码</div>
				<div>
					<input type="password" name="passwd" />
				</div></li>
			<li><div class="font">重复密码</div>
				<div>
					<input type="password" name="re_passwd" />
				</div></li>
			<li><div class="font">真实姓名</div>
				<div>
					<input type="password" name="truename" />
				</div></li>
				<li><div class="font">昵称</div>
				<div>
					<input type="password" name="nickname" />
				</div></li>
				<li><div class="font">性别</div>
				<div>
					<select name="sex">
					<option value="0">女</option>
					<option value="1">男</option>
					</select>
				</div></li>
			<li><input type="submit" name="submit" value="注册"
				class="btn-primary" /></li>
		</ul>
	</form>

</div>

<%@ include file="footer.jsp"%>
