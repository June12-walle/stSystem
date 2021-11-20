<%@page import="com.offcn.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
%>
<%
	User user=(User)session.getAttribute("user");	
	System.out.print(user);
	if(user==null){
		response.sendRedirect(path+"login.jsp");
	}
%>