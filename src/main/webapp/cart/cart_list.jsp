<%@ page contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(function() {
				var map = "${sessionScope.map}";
				if(map != ""){
					$("#div_no_choice").addClass("objhide");
				}else{
					$("#div_no_choice").removeClass();
				}
			});
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />
	
		</div>
		<div id="div_choice" class="choice_merch">
			<c:if test="${sessionScope.map != null }">
			<h2 id="cart_tips">您已选购以下商品</h2>
			</c:if>
			<div class="choice_bord">
				<c:if test="${sessionScope.map != null }">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6"><span>&nbsp;</span></td>
						<td><span class="span_w1">商品名</span></td>
						<td class="buy_td_5"><span class="span_w2">市场价</span></td>
						<td class="buy_td_4"><span class="span_w3">当当价</span></td>
						<td class="buy_td_1"><span class="span_w2">数量</span></td>
						<td class="buy_td_2"><span>变更数量</span></td>
						<td class="buy_td_1"><span>删除</span></td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">&nbsp;</td>
					</tr>
	
					<!-- 购物列表开始 -->
					<c:forEach items="${sessionScope.map }" var="map">
					<tr class='td_no_bord'>
						<td style='display: none'>9317290</td>
						<td class="buy_td_6"><span class="objhide"><img /></span></td>
						<td><a href="${pageContext.request.contextPath }/product/queryProduct.do?id=${map.value.id }">${map.value.book_name }</a></td>
						<td class="buy_td_5"><span class="c_gray">${map.value.price }</span></td>
						<td class="buy_td_4">&nbsp;&nbsp; <span>￥${map.value.dang_price }</span>
						</td>
						<td class="buy_td_1">&nbsp;&nbsp;${map.value.quantity }</td>
	
						<td><input class="del_num" type="text" size="3" maxlength="4" value="${map.value.quantity }" id="w${map.value.id }" />
							<a href="javascript:" onclick="location='${pageContext.request.contextPath }/shoppingTrolley/updateQuantity.do?id=${map.value.id}&quantity='+document.getElementById('w${map.value.id }').value">变更</a></td>
						<td><a href="${pageContext.request.contextPath }/shoppingTrolley/delete.do?id=${map.value.id}">删除</a></td>
					</tr>
					</c:forEach>
					<!-- 购物列表结束 -->
				</table>
				</c:if>
				
				<div id="div_no_choice">
					<div class="choice_title"></div>
					<div class="no_select">您还没有挑选商品[<a href="../main/main.jsp">继续挑选商品&gt;&gt;</a>]</div>
				</div>
				
				<c:if test="${sessionScope.map != null }">
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品&gt;&gt;</a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省： <span class="c_red"> ￥<span id="total_economy">${requestScope.fold }</span>
							</span> <span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span>
							</span> )
							</span> <span style="font-size: 14px">|</span> <span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${sessionScope.totalDangPrice }</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='../order/order_info.jsp'>
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
				</c:if>
			</div>
		</div>
	
		<!-- 用户删除恢复区 -->
	
		<c:if test="${sessionScope.map2 != null }">
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">您已删除以下商品，如果想重新购买，请点击“恢复”</div>
			<table class=tabl_del id=del_table>
			
				<tbody>
				
					<c:forEach items="${sessionScope.map2 }" var="map2">
					<tr>
						<td width="58" class=buy_td_6>&nbsp;</td>
						<td width="365" class=t2><a href="${pageContext.request.contextPath }/product/queryProduct.do?id=${map2.value.id }">${map2.value.book_name }</a></td>
						<td width="106" class=buy_td_5>￥${map2.value.price }</td>
						<td width="134" class=buy_td_4><span>￥${map2.value.dang_price }</span></td>
						<td width="56" class=buy_td_1><a href="${pageContext.request.contextPath }/shoppingTrolley/restore.do?id=${map2.value.id}">恢复</a></td>
						<td width="16" class=objhide>&nbsp;</td>
					</tr>
					</c:forEach>
					
					<tr class=td_add_bord>
						<td colspan=8>&nbsp;</td>
					</tr>
					
				</tbody>
				
			</table>
		</div>
		</c:if>
	
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



