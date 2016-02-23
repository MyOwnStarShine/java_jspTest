package ptp.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ptp.user.Users;


public class Register extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String re_passwd = request.getParameter("re_passwd");
		String truename = request.getParameter("truename");
		String nickname = request.getParameter("nickname");
		String sex = request.getParameter("sex");
		
		if(username == null || username.length()<3){
			request.setAttribute("register", "用户名必须大于等于3个字符");
			response.sendRedirect(request.getContextPath() + "/register.jsp");
		}
		if(passwd == null || passwd.length()<6){
			request.setAttribute("register", "密码必须大于等于6个字符");
			response.sendRedirect(request.getContextPath() + "/register.jsp");
		}
		if(passwd != re_passwd){
			request.setAttribute("register", "两次输入的密码不一致");
			response.sendRedirect(request.getContextPath() + "/register.jsp");
		}
		
		Users user = new Users();
		int userid = user.register(username, passwd, truename, nickname, sex);
		if(userid > 0){
			HttpSession session=request.getSession();
			session.setAttribute("username", username);     //Session 为 一个user 对象。
			session.setAttribute("userid", userid);
			response.sendRedirect(request.getContextPath());
		}else{
			response.sendRedirect(request.getContextPath() + "/register.jsp");
		}
	}
	
}
