<%@ page contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: <span class="red_bold">1.确认订单</span> &gt; 2.填写送货地址 &gt; 3.订单成功
		</div>
		<div class="fill_message">
	
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left"><b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left"><b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left"><b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left"><b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left"><b>小计</b>
					</td>
				</tr>
	
				<!-- 订单开始 -->
				<c:forEach items="${sessionScope.map }" var="map">
				<tr>
					<td valign="top">${map.value.id }</td>
					<td valign="top">${map.value.book_name }</td>
					<td valign="top">${map.value.dang_price }</td>
					<td valign="top">${map.value.quantity }</td>
					<td valign="top">${map.value.price*map.value.quantity }</td>
				</tr>
				</c:forEach>
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥${sessionScope.totalDangPrice }</b>
					</td>
				</tr>
			</table>
			<br /> <br /> <br />
			<div class="login_in">
				<a href="${pageContext.request.contextPath }/shoppingTrolley/showAll.do">
					<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消" /></a> 
				<a href="${pageContext.request.contextPath }/address/allAddresses.do?user_id=${sessionScope.login.id}">
					<input id="btnClientRegister"class="button_1" name="submit" type="submit" value="下一步" /></a>
			</div>
	
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

