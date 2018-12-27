// 购买异步请求
function addProduct(img,id) {
	$(function() {
		$(img).css("display","none");
		$("#cartinfo_"+id).html("<img align='bottom' src='../images/load.gif' width='14px' height='14px' style='display:inline' align='bottom' />&nbsp;购买中...");
		// 开始异步请求
		$.ajax({
			url:"../shoppingTrolley/purchase.do",
			type:"POST",
			data:"id="+id,
			// dataType:"",  // 预定数据响应回来的格式
			success:function(data){
				if(data==1){
					window.setTimeout(function() {
						$("#cartinfo_"+id).empty();
						$("#cartinfo_"+id).html("<img align='bottom' src='../images/right.gif' width='14px' height='14px' style='display:inline' align='bottom' />&nbsp;购买完成");
						window.setTimeout(function() {
							$("#cartinfo_"+id).empty();
							$(img).css("display","block");
						}, 2000);
					}, 1000);
				}else{
					window.setTimeout(function() {
						$("#cartinfo_"+id).empty();
						$("#cartinfo_"+id).html("<img align='bottom' src='../images/wrong.gif' width='14px' height='14px' style='display:inline' align='bottom' />&nbsp;购买失败");
						window.setTimeout(function() {
							$("#cartinfo_"+id).empty();
							$(img).css("display","block");
						}, 2000);
					}, 1000);
				}
			},
			error:function(){
				alert("网络连接超时");
			}
		});
	});
}