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
		
		String req_attr = "";
		String redirect_url = "register.jsp";
		int success = 1;
		if(username == null || username.length()<3){
			req_attr = "用户名必须大于等于3个字符";
			success = 0;
		}
		if(passwd == null || passwd.length()<6){
			req_attr = "密码必须大于等于6个字符";
			success = 0;
		}
		if(!passwd.equals(re_passwd)){
			req_attr = "两次输入的密码不一致";
			success = 0;
		}
		
		if(success>0){
			Users user = new Users();
			int userid = user.register(username, passwd, truename, nickname, sex);
			if(userid > 0){
				HttpSession session=request.getSession();
				session.setAttribute("username", username);     //Session 为 一个user 对象。
				session.setAttribute("userid", userid);
				redirect_url =  "/";
			}else{
				req_attr = "保存信息失败，请重试";
			}
		}
		request.setAttribute("register_error", req_attr);
		request.getRequestDispatcher(redirect_url).forward(request, response);		//使用这个方法才能在前台接收到这里传过去的参数
	}
	
}
