<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"+
	request.getServerPort()+request.getContextPath()+"/";
	pageContext.setAttribute("path", path);
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
    <script type="text/javascript" src="Js/jquery.validate.js"></script>	<!-- 插件 -->
    <script type="text/javascript" src="Js/messages_zh.js"></script>		<!-- 汉化包，把错误消息汉化 -->
    <style type="text/css">
        body {
            padding-top: 140px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            font-family: "微软雅黑";
            background-color: buttonhighlight;
        }

        .form-signin {
            max-width: 600px;
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
        
        .form-signin .form-signin-heading{
        	margin-bottom: 10px;
            font-size: 24px;
            margin-left: 200px;
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
			font-size: 14px;
		}
		
    </style>  
</head>
<body>
<div class="container">	
    <form class="form-signin" method="post" action="user">
    	<input type="hidden" name="method" value="regist">
        <h2 class="form-signin-heading" >管理员注册</h2>
                        姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：
		<input type="text" name="name" class="input-block-level" placeholder="账号">
		<br/>
                        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
        <input id="password" type="password" name="password" class="input-block-level" placeholder="密码">
        <br/>
                       确认密码：<input type="password" name="password2" class="input-block-level" placeholder="确认密码">
        <br/>
                        用&nbsp;&nbsp;户&nbsp;&nbsp;名：<input type="text" id="username" name="username" class="input-block-level" placeholder="用户名">
        <span id="username_msg"></span><br/>		<!-- 这个span标签用来接收错误消息 -->
                        邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：<input type="text" id="email" name="email" class="input-block-level" placeholder="邮箱">
        <span id="email_msg"></span><br/>               
        <p style="text-align: center;">
        <input id="login" type="button" value="注册" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input id="reset" type="reset" value="清空" name="login" class="btn btn-large btn-info" style="width: 100px;"/>
        </p>
    </form>
</div>

<script type="text/javascript">
	//单击事件，提交表单
	$("#login").click(function(){		//#login---按钮，click事件
		$("form").submit();		//form表单，submit()---提交
	}) 
	//前三个表单验证，姓名、密码、确认两次密码等值及非空验证判断，使用WebContent/js/validate插件
	$("form").validate({
		rules:{
			"name":{
				"required":true		//非空
			},
			"password":{
				"required":true,
				"rangelength":[3,10]		//密码长度范围
			},
			"password2":{
				"required":true,
				"rangelength":[3,10],
				"equalTo":"#password"				//用equalTo把两次password进行比较，“#“号是取id
			}
		},
		messages:{		//中文提示的错误消息
			"name":{
				"required":"姓名不能为空"
			},
			"password":{
				"required":"密码不能为空",
				"rangelength":"密码长度必须在3-10个字符"
			},
			"password2":{
				"required":"确认密码不能为空",
				"rangelength":"密码长度必须在3-10个字符",
				"equalTo":"两次密码不一致"
			}
		},
		errorElement:"error"		//错误消息的文字样式
	});

	 //用户名文本框失去焦点时验证是否可用来注册
	 $("#username").blur(function(){		//blur---失去焦点
		//获取账号，alert（）；---弹出提示框，输出（）里的内容
		var username=$("#username").val();
		//非空验证
		if(username==null||username==""){		//两种空的情况，null没有值，“”空字符串
			$("#username_msg").text("用户名不能为空！").css("color","red");	//#username_msg---传到上面的span标签
			return ;
		}	//表单非空验证通过，接下来向后台查询是否已经注册过
		$.ajax({			//传到servlet层---BaseServlet---UserServlet
			url:"user",		//对应后台servelet地址
			data:{"username":username,"method":"checkUserName"},		//传递的数据，"method"标记:"checkUserName"方法名
			type:"post",		//请求类型
			dataType:"json",		//返回值类型
			success:function(obj){		//回调函数，服务器向客户端返回结果
				if(obj){
					$("#username_msg").text("该用户名已被注册！").css("color","red");
				}else{
					$("#username_msg").text("用户名验证通过！").css("color","green");
				}
			}
		})
	}) 
	
	//邮箱文本框失去焦点时验证是否可用来注册
	 $("#email").blur(function(){
		//获取账号
		var email=$("#email").val();
		//正则表达式验证邮箱格式是否合格
		var regEmail=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		//非空验证
		if(email==null||email==""){
			$("#email_msg").text("邮箱不能为空！").css("color","red");
			return ;
		}else if(!(regEmail.test(email))){
			$("#email_msg").text("邮箱格式不正确！").css("color","red");
			return ;
		}
		$.ajax({
			url:"user",
			data:{"email":email,"method":"checkEmail"},
			type:"post",
			dataType:"json",
			success:function(obj){
				if(obj){
					$("#email_msg").text("该邮箱已被注册！").css("color","red");
				}else{
					$("#email_msg").text("邮箱验证通过！").css("color","green");
				}
			}
		})
	})
</script>
</body>
</html>