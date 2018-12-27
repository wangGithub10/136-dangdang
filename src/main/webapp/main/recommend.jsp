<%@ page contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h2>编辑推荐</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>

		<c:forEach items="${requestScope.recommend }" var="product">
			<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a href='${pageContext.request.contextPath }/product/queryProduct.do?id=${product.id }' target='_blank'>
						<img id="img" class="imgs" src="${pageContext.request.contextPath }/productImages/${product.img_name }" width=70 border=0 /></a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a href='${pageContext.request.contextPath }/product/queryProduct.do?id=${product.id }' target='_blank' title='输赢'>${product.book_name }</a>
					</h3>
					<h4>
						作者：${product.author } <br />
						出版社：${product.publishing }&nbsp;&nbsp;&nbsp;&nbsp;
						出版时间：<fmt:formatDate value="${product.publish_time }" pattern="yyyy-MM-dd"/>
					</h4>
					<h5>
						简介：${product.content_introduct }
					</h5>
					<h6>
						定价：￥${product.price }&nbsp;&nbsp;
						当当价：￥${product.dang_price }
					</h6>
					<div class=line_xx></div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
