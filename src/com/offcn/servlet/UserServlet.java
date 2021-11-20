package com.offcn.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.offcn.entity.User;
import com.offcn.service.UserService;

@WebServlet("/user")		//请求路径
public class UserServlet extends BaseServlet {
	UserService userService = new UserService();

	public void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 获取用户信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verify");
		// 封装用户对象
		User user = new User(username, password);
		boolean flag = userService.checkLogin(user, verifyCode, request.getSession());
		if (flag) {
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("msg", "用户或密码有误！ ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	// 验证生成的验证码与用户输入的是否相同
	public void checkVerifyCode(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String verifyCode = request.getParameter("verify");
		boolean flag = userService.checkVerifyCode(verifyCode, request.getSession());
		response.getWriter().print(flag);
	}

	// 退出登录
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	// 注册页面用户名验证
	public void checkUserName(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");		//获取表单 用户名
		boolean flag = userService.checkUserName(username);		//调用servive层的方法来验证
		response.getWriter().print(flag);			//返回值直接输出给前台
	}

	// 注册页面邮箱验证
	public void checkEmail(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		boolean flag = userService.checkEmail(email);
		response.getWriter().print(flag);
	}

	// 注册页面邮箱验证
	public void regist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//获取用户信息
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		//封装用户对象
		User user=new User(name, email, username, password, new Date());
		boolean flag=userService.regist(user);
		if (flag) {
			response.sendRedirect("login.jsp");
		}
	}
}
