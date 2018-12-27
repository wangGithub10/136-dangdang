<%@ page contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(function() {
				var count = 5;
				var time = function() {
					if(count == 0){
						window.location.href="${pageContext.request.contextPath}/main/main.jsp";
					}else{
						$("#sp").text(count);
						count --;
						setTimeout(time,1000);
					}
				};
				time();
			});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单步骤: 1.确认订单 &gt; 2.填写送货地址 &gt; <span class="red_bold">3.订单成功</span>
		</div>
	
		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="../images/login_success.jpg" />
				</div>
				<h5>订单已经生成</h5>
				<h6>您刚刚生成的订单号是：${requestScope.order.id }，金额总计${requestScope.order.total_price }</h6>
	
				<ul>
					<li class="nobj">您现在可以：</li>
					<li><a href="../main/main.jsp">继续浏览并选购商品</a></li>
				</ul><br/>
	
				<h6>还有<span id="sp"></span>秒自动跳转首页</h6>
			</div>
		</div>
	
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

