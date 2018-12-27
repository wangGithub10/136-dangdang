$(function() {
	$("#f :input").blur(function (){
		/*~~~~~~~~~email~~~~~~~~~~~~~*/
		if($(this).is("#txtEmail")) {
			var email = $(this).val();
			if(email != ""){
				var pattern = /(^[a-zA-Z0-9]{3,10}@[a-zA-Z0-9]{2,10}\.[c][o][m]$)/;
				if(pattern.test(email)){
					// 异步请求判断用户是否重复
					$.ajax({
						url:"../user/queryUser.do",
						type:"POST",
						data:"email="+email,
						// dataType:"",  // 预定数据响应回来的格式
						success:function(data) {
							if(data){
								var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
								$("#emailinfo").removeClass();
								$("#emailinfo").addClass("onSuccess");
								$("#emailinfo").text("  电子邮件地址可用");
								$("#emailinfo").prepend(img);
							}else{
								var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
								$("#emailinfo").removeClass();
								$("#emailinfo").addClass("onError");
								$("#emailinfo").text("  抱歉，邮件地址已经被使用");
								$("#emailinfo").prepend(img);
							}
						},
						error:function(){
							alert("网络连接超时");
						}
					});
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#emailinfo").removeClass();
					$("#emailinfo").addClass("onError");
					$("#emailinfo").text("  电子邮件地址格式错误");
					$("#emailinfo").prepend(img);
				}
			}else{
				var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#emailinfo").removeClass();
				$("#emailinfo").addClass("onError");
				$("#emailinfo").text("  电子邮件不能为空");
				$("#emailinfo").prepend(img);
			}
		}
		/*~~~~~~~~~nickname~~~~~~~~~~~~~*/
		if($(this).is("#txtNickName")) {
			var nickname = $(this).val();
			if(nickname != ""){
				var pattern = /(^[a-zA-Z0-9\u4e00-\u9fa5]{2,20}$)/;
				if(pattern.test(nickname)){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#nameinfo").removeClass();
					$("#nameinfo").addClass("onSuccess");
					$("#nameinfo").text("  正确");
					$("#nameinfo").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#nameinfo").removeClass();
					$("#nameinfo").addClass("onError");
					$("#nameinfo").text("  昵称的长度不符合要求");
					$("#nameinfo").prepend(img);
				}
			}else{
				var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#nameinfo").removeClass();
				$("#nameinfo").addClass("onError");
				$("#nameinfo").text("  昵称不能为空");
				$("#nameinfo").prepend(img);
			}
		}
		/*~~~~~~~~~password~~~~~~~~~~~~~*/
		if($(this).is("#txtPassword")) {
			var password = $(this).val();
			if(password != ""){
				var pattern = /(^[a-zA-Z0-9]{6,20}$)/;
				if(pattern.test(password)){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#passwordinfo").removeClass();
					$("#passwordinfo").addClass("onSuccess");
					$("#passwordinfo").text("  正确");
					$("#passwordinfo").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#passwordinfo").removeClass();
					$("#passwordinfo").addClass("onError");
					$("#passwordinfo").text("  密码的长度不符合要求");
					$("#passwordinfo").prepend(img);
				}
			}else{
				var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#passwordinfo").removeClass();
				$("#passwordinfo").addClass("onError");
				$("#passwordinfo").text("  密码不能为空");
				$("#passwordinfo").prepend(img);
			}
		}
		/*~~~~~~~~~password1~~~~~~~~~~~~~*/
		if($(this).is("#txtRepeatPass")) {
			var password = $("#txtPassword").val();
			var password1 = $("#txtRepeatPass").val();
			if(password1 != ""){
				if(password==password1){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#password1info").removeClass();
					$("#password1info").addClass("onSuccess");
					$("#password1info").text("  正确");
					$("#password1info").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#password1info").removeClass();
					$("#password1info").addClass("onError");
					$("#password1info").text("  两次输入的密码不同");
					$("#password1info").prepend(img);
				}
			}else{
				var img = $("<br/><img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#password1info").removeClass();
				$("#password1info").addClass("onError");
				$("#password1info").text("  确认密码不能为空");
				$("#password1info").prepend(img);
			}
		}
		/*~~~~~~~~~txtVerifyCode~~~~~~~~~~~~~*/
		if($(this).is("#txtVerifyCode")) {
			var code = $(this).val();
			if(code != ""){
				$.ajax({
					url:"../user/verify.do",
					type:"POST",
					data:"code="+code,
					// dataType:"",  // 预定数据响应回来的格式
					success:function(data) {
						if(data){
							var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
							$("#codeinfo").removeClass();
							$("#codeinfo").addClass("onSuccess");
							$("#codeinfo").text("  正确");
							$("#codeinfo").prepend(img);
						}else{
							var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
							$("#codeinfo").removeClass();
							$("#codeinfo").addClass("onError");
							$("#codeinfo").text("  验证码输入错误");
							$("#codeinfo").prepend(img);
						}
					},
					error:function() {
						alert("网络连接超时");
					}
				});
			}else{
				var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#codeinfo").removeClass();
				$("#codeinfo").addClass("onError");
				$("#codeinfo").text("  验证码不能为空");
				$("#codeinfo").prepend(img);
			}
		}
	});
	
	$("#btnClientRegister").click(function() {
		$("#f input").trigger("blur");
		var onError = $(".onError").length;
		if(onError){
			return false;
		}else{
			return true;
		}
	});
});
