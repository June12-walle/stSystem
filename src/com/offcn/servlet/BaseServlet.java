package com.offcn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override //重写HttpServlet方法
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//乱码处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//利用反射技术，获取方法标识，省去下面的类直接继承HttpServlet时要进行的复杂的分支判断
		String method = request.getParameter("method");		//获取regist.jsp传过来的方法标识
		//System.out.println(method);
		Class clazz=this.getClass();		//获取类对象
		try {
			//通过类对象clazz调用getMethod方法,方法传参，得到要执行的m方法
			Method m = clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, request,response);		//反射执行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
