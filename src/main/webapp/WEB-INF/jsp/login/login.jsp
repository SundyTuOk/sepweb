<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>华中师范大学校园节能监管平台</title>
</head>
<body>

	<form action="login/login" method="post">
		用户名：<input name="username"><br>
		密码：<input name="password"><br>
		验证码：<input name="verificationCode"><img alt="验证码" src="Kaptcha.jpg"><br>
		<input type="submit" value="登录" />
	</form>
	${errorMsg }

	<div>
		<span>武汉盛帆电子股份有限公司版权所有 鄂ICP备06778号 电话：<span>027-81802522</span> </span>
	</div>
</body>
</html>
