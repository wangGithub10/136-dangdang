<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<style>
		     .onError{ color: red; }
		     .onSuccess{ color: green; }
	    </style>
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="../js/address_form.js"></script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 &gt; <span class="red_bold"> 2.填写送货地址</span> &gt; 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址： <select id="address" name="address_id">
					<option value="0" selected="selected">填写新地址</option>
					<!-- 循环展示地址 -->
					<c:if test="${requestScope.allAddresses != null}">
					<c:forEach items="${requestScope.allAddresses }" var="address">
						<option value="${address.id }">${address.full_address }</option>
					</c:forEach>
					</c:if>
					<!-- 循环展示地址 -->
				</select>
			</p>
			<form name="ctl00" method="post" action="${pageContext.request.contextPath }/address/insert.do" id="f">
				<input type="hidden" name="id" id="addressId" />
	
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">收件人姓名：</td>
						<td><input type="text" class="text_input" name="receive_name" id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>请填写有效的收件人姓名</p>
								<span id="errorName"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">收件人详细地址：</td>
						<td><input type="text" name="full_address" class="text_input" id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>请填写有效的收件人的详细地址</p>
								<span id="errorfullAddress"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">邮政编码</td>
						<td><input type="text" class="text_input" name="zipcode" id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>请填写有效的收件人的邮政编码</p>
								<span id="errorpostalCode"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">电话</td>
						<td><input type="text" class="text_input" name="receive_tel" id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>请填写有效的收件人的电话</p>
								<span id="errorphone"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">手机</td>
						<td><input type="text" class="text_input" name="receive_phone" id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>请填写有效的收件人的手机</p>
								<span id="errormobile"></span>
							</div>
						</td>
					</tr>
				</table>
	
				<div class="login_in">
					<a href="${pageContext.request.contextPath }/order/order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="button" value="取消" /></a>
					<input id="btnClientRegister2" class="button_1" name="submit" type="submit"value="下一步" />
				</div>
				
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

