<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>华中师范大学校园节能监管平台</title>

<meta name="description" content="User login page" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--basic styles-->
<link rel="shortcut icon" href="img/sf.png" type="image/x-icon" />
<link href="style/indexTest.css" rel="stylesheet" />
<link href="css/common/bootstrap.min.css" rel="stylesheet" />
<link href="css/common/bootstrap-responsive.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/common/font-awesome.min.css" />
<script src="js/common/jquery.min.js"></script>
<script src="js/login/Login.js"></script>

 <script type="text/javascript">
	$(function()
	{
		var height,width;
		resize1=function()
			{
				width = $(window).width();
	        	height= $(window).height();
	        	if(height>768){
					$("#login-box label").css({
						"margin":25+"px"
					})
				}
				else{
					$("#login-box label").css({
						"margin":8+"px"
					})
				}
		
	        	/* 修改整体宽度  */
	        	var outer_div_width;
	        	if(width-100<1200)
	        	{
	        		outer_div_width=width-100;
	        		$("#outer_div").css({"width":outer_div_width+"px"});
	        	}        		
	        	
	        	/* 修改顶部的div高度 */
	        	var outer_div_height;
	        	if(height*0.4<425)
	        	{
	        		
	        		outer_div_height=height*0.4;
	        		$("#outer_head_div").css({"height": outer_div_height+"px"})
	        	}

	        	  var itemCss;
	        	  var LoginCss;
	       		if(parseInt(width)<800)
	       		{
	       		
	       			itemCss={
	       				
						"display": "none"
	       			}
	       			LoginCss={
	       				"float": "right",
						"width": "270px",
						"height": "150px",
						"position": "absolute",
						"top": "20%",
						"right":"20%"
	       			}
	       			/* $(".item").css(itemCss); */
	       			
	       			$(".name").css({"font-weight":"100"});
	       			$("#log").replaceWith("<div id='log' style='margin-left:5%'><h5><i class='icon-leaf green'></i> 盛帆电子节能监管系统</h5></div>");
	       			/* $("#login").replaceWith("<div id='login' style='margin-left:85%'><h6><a href='index.html'>返回首页</a></h6></div>") */
	       			/* $("#exitText").replaceWith("<h6 id='exitText'><span class='white' id='logOutItem'>退出</span></h6>") */
	       			$("#lignt_image").css(itemCss);
	       			$("#login-box").css(LoginCss);
	       		}
	       		else if(parseInt(width)>800&&parseInt(width)<1024)
	       		{
	       			
	       			itemCss={
	       				"float": "right",
	       				"width": "270px",
						"height": "150px",
						"position": "absolute",
						"top": "20%",
						"right":"20%"
	       			}
	       			//$(".item").css(itemCss);
	       			$(".item .name").css({"font-weight":"400"});
	       			$("#logText").replaceWith("<h3 id='logText'><i class='icon-leaf green'></i> <span class='white'>盛帆电子节能监管系统</span></h3>");
	       		/* 	$("#loginText").replaceWith("<h5 id='loginText'><span class='white' >登录</span></h5>")
	       			$("#exitText").replaceWith("<h5 id='exitText'><span class='white' id='logOutItem'>退出</span></h5>") */
	       			$("#login-box").css(itemCss);
	       		}
	       		else if(1024<parseInt(width)&&parseInt(width)<1366)
	       		{
	       			
	       			itemCss={
	       				"float": "right",
	       				"width": "270px",
						"height": "150px",
						"position": "absolute",
						"top": "20%",
						"right":"20%"
	       			}
	       			
	       			//$(".item").css(itemCss); 
	       			outer_div_width=width;
	        		$("#outer_div").css({"width":outer_div_width+"px"});
	        		outer_div_height=height;
	        		$("#outer_head_div").css({"height": outer_div_height-200+"px"})
	       			$(".item .name").css({"font-weight":"600"});
	       			$("#login-box").css(itemCss);
	       		}else {
	       			
	       			outer_div_width=width;
	        		$("#outer_div").css({"width":outer_div_width+"px"});
	        		outer_div_height=height;
	        		$("#outer_head_div").css({"height": outer_div_height-200+"px"})
	       		}
	       		 
	       		/* $("#bannerImg").css({
	       			"width":$("#outer_head_div").width(),
	       			"height":$("#outer_head_div").height(),
	       		}) */
	       		/* var p=$("#bannerImg").position();
	       		var imgWidth=$("#bannerImg").width();
	       		var imgheight=$("#bannerImg").height();
	       		var innerY=imgheight*0.05;
	       		var inertX=imgWidth*0.05; */
	       		/* $("#log").css({"left":p.left+inertX,"top":p.top+innerY});
	       		
	       		$("#login").css({
	       			"left":p.left+imgWidth-$("#login").width()-inertX,
	       			"top":p.top+innerY
	       		}) */
	       		
	       		
		}
	})
</script> 

<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!--page specific plugin styles-->

<!--fonts-->
<!--  
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		-->
<!--ace styles-->

<!-- <link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-responsive.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" /> -->

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!--inline styles related to this page-->


</head>
<style>
.navbar_background {
	width: 100%;
	height: 100%;
	z-index: -1;
}

.top_level {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	margin: 0px;
	min-height: 45px;
}
</style>
	
<body style="width:100%"  onresize="resize1()" onLoad="resize1()">
	<!-- 包含整个内容的DIv -->
	<div id="outer_div">

		<!-- log 最上面的Div -->
		<!-- <div id="login_log_div">

			log 标志
			<div id="log" style="margin-left:5%">
				<h1>
					<i class="icon-leaf green"></i> 华中师范大学校园节能监管平台
				</h1>
			</div>

			<div id="login" style="margin-left:85%">
				<h3>
					<a href="welcome.html">返回首页</a>
				</h3>
			</div>
		</div> -->
		<div class="navbar container-fluid" style="height: 95px">
			<!-- <img class="navbar_background" src="img/main/nvabar_background.png" /> -->

			<div class="top_level">
				<div class="container-fluid">
					<a href="javascript:void(0);" class="brand"> <img src="images/toubu.png" /><span  class="menu-text" style="color:#005c6c; font-family:楷体;font-weight:bold;  font-size: 140%;">校园节能监管平台 </span>
					</a>

					<ul class="nav ace-nav pull-right">
						<!-- <li style="background-color: rgba(255, 255, 255, 0)"><a
							data-toggle="dropdown" href="javascript:void(0);"
							class="dropdown-toggle"> <img class="nav-user-photo"
								src="assets/avatars/user.jpg" alt="Jason's Photo" /> <span
								 style="color:'#f5f5f5';font-size:100%"> 欢迎您	</span></li> -->

						<!-- <li style="background-color: rgba(255, 255, 255, 0)"><a
							href="welcome.html" class="dropdown-toggle"> <i
								class="icon-home"></i> <span class="menu-text" style="font-size:150%">返回首页 </span>
						</a></li> -->

					</ul>
				</div>
			</div>
		</div>
		<div id="login_content_div" style="background-size:100%;background-image:url('images/denglu.png');background-repeat:no-repeat;">
			<!-- <img id="lignt_image" src="images/811.jpg" /> -->


				<div id="login-box" class="login-box visible widget-box no-border">
				<div class="widget-body" id="loginbody">
					<div class="widget-main">
						<h4 class="blue lighter bigger" style="text-align:center">
							<i class="icon-coffee green"></i> 登录信息
						</h4>
<!-- 
						<div class="space-6"></div> -->

						<form action="test" method="post">
							<fieldset>
								<label> 
									<span class="block input-icon input-icon-right">用户名:<i class="icon-user"></i><input type="text" name="userName">  </span> 
								</label>
								 <label>
									<span class="block input-icon input-icon-right">密     码 :<input
										type="password"  
										name="passWord"> <i class="icon-lock"></i> </span> </label> 
										
								<label>
									<span class="block input-icon input-icon-right">验证码:<input type="text" name="checkCode" style="width: 32%">
										<i class="icon-lock"></i> <img src="Kaptcha.jpg" alt="点击切换验证码"
										id="kaptchaImage" style="width: 30%;height:30px;margin-bottom: 2pxl;border: 2px solid rgb(169, 165, 165);"> </span> 
								</label>

								<!-- <div class="space"></div> -->

								<div class="clearfix">
									<label class="inline" > <input
										type="checkbox" name="savePassword" value="checked"> <span
										class="lbl"> 记住密码</span> </label>

									<div>
										<%
											HttpSession httpSession = request.getSession();
											String loginErrorInfo=null;
											if(httpSession.getAttribute("loginErrorInfo")!=null)
												loginErrorInfo=httpSession.getAttribute("loginErrorInfo").toString();
											//System.out.println("loginErrorInfo:"+loginErrorInfo);
											
										 %>
										<span class="lbl" style="color:red; " >
										<%
											//为了不显示null在前台
											if(loginErrorInfo==null)
												loginErrorInfo="";
										 %>
										<%= loginErrorInfo%>
										<%
											//登陆成功以后前台不在显示登陆错误信息
											httpSession.removeAttribute("loginErrorInfo");
										 %>				
											
										</span>
									</div>
									<button type="submit"
										class="width-35 pull-right btn btn-small btn-primary">
										<i class="icon-key"></i> 登录
									</button>

								</div>

								<!-- <div class="space-4"></div> -->
							</fieldset>
						</form>



					</div>
				</div>
				<!--/widget-body-->
				</div>
				<!--/login-box-->




			</div>
		</div>

	</div>

	<div class="footer" >
		<div class="footer-inner">
			<!-- #section:basics/footer -->
			<div class="footer-content">
				<span class="bigger-120">武汉盛帆电子股份有限公司版权所有 鄂ICP备06778号 电话：<span
					class="blue bolder">027-81802522</span> </span> <span
					class="action-buttons"> <a href="#"> <i
						class="ace-icon fa fa-twitter-square light-blue bigger-150"></i> </a>

					<a href="#"> <i
						class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
				</a> <a href="#"> <i
						class="ace-icon fa fa-rss-square orange bigger-150"></i> </a> </span>
			</div>
			<!-- /section:basics/footer -->
		</div>
	</div>

</body>
</html>
