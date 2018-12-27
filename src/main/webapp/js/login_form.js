$(function() {
	$("#ctl00").submit(function (){
		var email = $("#txtUsername").val();
		var password = $("#txtPassword").val();
		if(email != "" && password != ""){
			var pattern = /(^[a-zA-Z0-9]{3,10}@[a-zA-Z0-9]{2,10}\.[c][o][m]$)/;
			if(!pattern.test(email)){
				$("#divErrorMssage").text("邮箱格式错误");
				return false;
			}
			return true;
		}else{
			$("#divErrorMssage").text("请输入邮箱或密码");
			return false;
		}
	});
});
