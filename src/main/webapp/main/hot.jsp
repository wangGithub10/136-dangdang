<%@ page contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="javascript:volid(0);" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${requestScope.hotBook }" var="product">
		<div class="second_d_wai">
			<div class="img">
				<a href="${pageContext.request.contextPath }/product/queryProduct.do?id=${product.id }" target='_blank'>
					<img class="imgs" src="${pageContext.request.contextPath }/productImages/${product.img_name }" border=0 /></a>
			</div>
			<div class="shuming">
				<a href="${pageContext.request.contextPath }/product/queryProduct.do?id=${product.id }" target="_blank">${product.book_name }</a>
			</div>
			<div class="price">定价：￥${product.price }</div>
			<div class="price">当当价：￥${product.dang_price }</div>
		</div>
		<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>