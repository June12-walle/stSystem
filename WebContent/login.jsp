<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*request.getScheme()---获取协议名称：http
request.getServerName()---获取服务器名：localhost
request.getServerPort()---获取端口号：8080
request.getContextPath()---获取项目根目录：stSystem
结果就是：path=http://localhost:8080/stSystem/
*/
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);		//把path存到pageContext：当前页的作用域
	
%>
<!DOCTYPE html>
<html>
<head>
    <title>百院社团活动分享平台</title>
	<meta charset="UTF-8">
	<link rel="icon" href="Images/logo2.ico" type="image/x-icon" />
   <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/jquery-3.4.1.js"></script>
    <style type="text/css">
        body {
            padding-top: 140px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            font-family: "微软雅黑";
            background: url("Images/denlu.jpg");
            background-size: 100%;
            background-repeat: no-repeat;
        }

        .form-signin {
            max-width: 400px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            background: rgba(255,255,255,0.5);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
            font-size: 24px;
            margin-left: 90px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }
		
		
		#message{
			font-size: 14px;
			color:red;
			margin-left: 40px;
		}
		
		.input-block-level{
			width: 300px;
			margin-left: 40px;
		}
		.input-medium{
			margin-left: 40px;
		}
		.code_images{
			width: 115px;
			height: 35px;
			margin-top: -15px;
			margin-left: 10px;
		}
		.error{
			color: red;
			font-size: 12px;
		}
		
    </style>  
</head>
<body>
<div class="container">
	
    <form class="form-signin" method="post" action="user">
    	<input type="hidden" name="method" value="checkLogin">
        <h2 class="form-signin-heading" >管理员登录</h2>
        <span id="message" class="message">${msg }</span><br>
        <input type="text" name="username" class="input-block-level" value="lisi" placeholder="账号">
        <input type="password" name="password" class="input-block-level" placeholder="密码" value="321">
        <input type="text" name="verify" class="input-medium" placeholder="验证码"> 
        <img id="code" class="code_images"  src="${path }authImage" /> <!-- 验证码标签 -->
		<!--  
			验证码功能参考：
			https://www.cnblogs.com/jianlun/articles/5553452.html
		-->
        <p style="text-align: center;">
        <input id="login" type="button" value="登录" name="login" class="btn btn-large btn-primary" style="width: 150px;"/>
        <a href="regist.jsp">请先注册</a>
        </p>
    </form>
</div>
<script type="text/javascript">
	//单击登录按钮时进行非空验证
	$("#login").click(function(){
		//获取账号和密码
		var username=$('[name="username"]').val();
		var password=$('[name="password"]').val();
		var verifyCode=$('[name="verify"]').val();
		//非空验证
		if(username==null||username==""){
			$("#message").text("用户名不能为空！");
			return ;
		}
		if(password==null||password==""){
			$("#message").text("密码不能为空！");
			return ;
		}
		if(code==null||code==""){
			$("#message").text("验证码不能为空！");
			return ;
		}
		$.ajax({
			url:"user",
			data:{"verify":verifyCode,"method":"checkVerifyCode"},
			type:"post",
			dataType:"json",
			success:function(obj){
				if(obj){
					$("form").submit();
				}else{
					$("#message").text("验证码输入有误！");
				}
			}
		})
		
	})
	
	//刷新验证码
	$("#code").click(function() {
		this.src="${path}/authImage?date=" + new Date();
	});
	
</script>
</body>
</html>