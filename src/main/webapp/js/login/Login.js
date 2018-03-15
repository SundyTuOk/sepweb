$(document).ready(function()
{
	//光标在输入框
	if($("input[name='userName']").val()==null||$("input[name='userName']").val()=="")
	{
		$("input[name='userName']").focus();
	}	
	if($("input[name='passWord']").val()==null||$("input[name='passWord']").val()=="")
	{
		$("input[name='passWord']").focus();
	}	
	if($("input[name='checkCode']").val()==null||$("input[name='checkCode']").val()=="")
	{
		$("input[name='checkCode']").focus();
	}	
	
	//点击切换验证码
	 $('#kaptchaImage').click(  
             function() 
             {  
                 $(this).hide().attr('src','Kaptcha.jpg?' + Math.floor(Math.random() * 100)).fadeIn();  
             });  
	 

});  


       
 
