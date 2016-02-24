package ptp.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		/*
		if(uid !="" && uid != null && uid.length() > 3 && pwd != "" && pwd != null){
			UserLog u = new UserLog();
			Users user = u.login(uid);
			if(user!=null && user.getPwd().equals(pwd)){
				session.setAttribute("user", user);           //Session 为 一个user 对象。
				//System.out.println(session.getAttribute("uid").toString());
			}else{
				//request.setAttribute("login", "Login Fail!");
				System.out.println("Login Error!");
			}
		}
		response.sendRedirect(request.getContextPath());
		*/
	}
	

}
