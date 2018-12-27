$(function() {
	$("#address").change(function (){
		var a = $("#address").val();
		if(a!=0){
			var full_address = $("#address option:selected").text();
			// 异步请求
			$.ajax({
				url:"../address/queryAddress.do",
				type:"POST",
				data:"full_address="+full_address,
				// dataType:'',  // 预定数据响应回来的格式
				success:function(data){
					$("#receiveName").prop("value",data.receive_name);
					$("#fullAddress").prop("value",data.full_address);
					$("#postalCode").prop("value",data.zipcode);
					$("#phone").prop("value",data.receive_tel);
					$("#mobile").prop("value",data.receive_phone);
					$("#fullAddress").prop("readonly","readonly");
				},
				error:function(){
					alert("网络连接超时");
				}
			});
		}else{
			$("#receiveName").prop("value",null);
			$("#fullAddress").prop("value",null);
			$("#postalCode").prop("value",null);
			$("#phone").prop("value",null);
			$("#mobile").prop("value",null);
			$("#fullAddress").removeProp("readonly");
		}
	});
	
	$("#f :input").blur(function() {
		/*~~~~~~~~~"receive_name"~~~~~~~~~~~~~*/
		if($(this).is("#receiveName")) {
			var receive_name = $(this).val();
			if(receive_name != ""){
				var pattern = /^[\u4E00-\u9FA5A-Za-z]+$/;
				if(pattern.test(receive_name)){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#errorName").removeClass();
					$("#errorName").addClass("onSuccess");
					$("#errorName").text("  正确");
					$("#errorName").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#errorName").removeClass();
					$("#errorName").addClass("onError");
					$("#errorName").text("  请正确输入姓名");
					$("#errorName").prepend(img);
				}
			}else{
				var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#errorName").removeClass();
				$("#errorName").addClass("onError");
				$("#errorName").text("  姓名不能为空");
				$("#errorName").prepend(img);
			}
		}
		/*~~~~~~~~~"full_address"~~~~~~~~~~~~~*/
		if($(this).is("#fullAddress")) {
			var full_address = $(this).val();
			if(full_address != ""){
				var pattern = /^[\u4E00-\u9FA5A-Za-z]+$/;
				if(pattern.test(full_address)){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#errorfullAddress").removeClass();
					$("#errorfullAddress").addClass("onSuccess");
					$("#errorfullAddress").text("  正确");
					$("#errorfullAddress").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#errorfullAddress").removeClass();
					$("#errorfullAddress").addClass("onError");
					$("#errorfullAddress").text("  请正确输入地址");
					$("#errorfullAddress").prepend(img);
				}
			}else{
				var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#errorfullAddress").removeClass();
				$("#errorfullAddress").addClass("onError");
				$("#errorfullAddress").text("  地址不能为空");
				$("#errorfullAddress").prepend(img);
			}
		}
		/*~~~~~~~~~"zipcode"~~~~~~~~~~~~~*/
		if($(this).is("#postalCode")) {
			var zipcode = $(this).val();
			if(zipcode != ""){
				var pattern = /(^[0-9]{6}$)/;
				if(pattern.test(zipcode)){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#errorpostalCode").removeClass();
					$("#errorpostalCode").addClass("onSuccess");
					$("#errorpostalCode").text("  正确");
					$("#errorpostalCode").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#errorpostalCode").removeClass();
					$("#errorpostalCode").addClass("onError");
					$("#errorpostalCode").text("  邮政编码格式错误");
					$("#errorpostalCode").prepend(img);
				}
			}else{
				var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
				$("#errorpostalCode").removeClass();
				$("#errorpostalCode").addClass("onError");
				$("#errorpostalCode").text("  邮政编码不能为空");
				$("#errorpostalCode").prepend(img);
			}
		}
		/*~~~~~~~~~"receive_tel"~~~~~~~~~~~~~*/
		if($(this).is("#phone")) {
			var receive_tel = $(this).val();
			if(receive_tel != ""){
				var pattern = /(^[1][3-8][0-9]{9}$)/;
				if(pattern.test(receive_tel)){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#errorphone").removeClass();
					$("#errorphone").addClass("onSuccess");
					$("#errorphone").text("  正确");
					$("#errorphone").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#errorphone").removeClass();
					$("#errorphone").addClass("onError");
					$("#errorphone").text("  电话号码格式错误");
					$("#errorphone").prepend(img);
				}
			}else{
				var receive_phone = $("#mobile").val();
				if(receive_phone==""){
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#errorphone").removeClass();
					$("#errorphone").addClass("onError");
					$("#errorphone").text("  电话和手机必须填写其中之一");
					$("#errorphone").prepend(img);
				}else{
					$("#errorphone").removeClass();
					$("#errorphone").text("");
				}
			}
		}
		/*~~~~~~~~~"receive_phone"~~~~~~~~~~~~~*/
		if($(this).is("#mobile")) {
			var receive_phone = $(this).val();
			if(receive_phone != ""){
				var pattern = /(^[1][3-8][0-9]{9}$)/;
				if(pattern.test(receive_phone)){
					var img = $("<img src='../images/right.gif' width='12' height='12' align='top'>");
					$("#errormobile").removeClass();
					$("#errormobile").addClass("onSuccess");
					$("#errormobile").text("  正确");
					$("#errormobile").prepend(img);
				}else{
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#errormobile").removeClass();
					$("#errormobile").addClass("onError");
					$("#errormobile").text("  手机格式错误");
					$("#errormobile").prepend(img);
				}
			}else{
				var receive_tel = $("#phone").val();
				if(receive_tel==""){
					var img = $("<img src='../images/wrong.gif' width='12' height='12' align='top'>");
					$("#errormobile").removeClass();
					$("#errormobile").addClass("onError");
					$("#errormobile").text("  电话和手机必须填写其中之一");
					$("#errormobile").prepend(img);
				}else{
					$("#errormobile").removeClass();
					$("#errormobile").text("");
				}
			}
		}
	});
	
	$("#btnClientRegister2").click(function() {
		$("#f input").trigger("blur");
		
		var errorName = $("#errorName").prop("class");
		var errorfullAddress = $("#errorfullAddress").prop("class");
		var errorpostalCode= $("#errorpostalCode").prop("class");
		var errorphone = $("#errorphone").prop("class");
		var errormobile = $("#errormobile").prop("class");
		
		var boolean = errorName=="onSuccess"&&errorfullAddress=="onSuccess"&&errorpostalCode=="onSuccess"&&(errorphone=="onSuccess"||errormobile=="onSuccess");
		
		if(boolean){
			return true;
		}else{
			return false;
		}
	});
});
