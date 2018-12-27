<%@ page contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2 class="t_xsrm">新书热卖榜</h2>
<div id="NewProduct_1_o_t" onmouseover="">
	
	<c:forEach items="${requestScope.newHotBook }" var="product">
	<ul>
		<li><a target='_blank' href="${pageContext.request.contextPath }/product/queryProduct.do?id=${product.id }">${product.book_name }</a></li>
	</ul>
	</c:forEach>
	<h3 class="second">
		<span class="dot_r"> </span><a href="javascript:volid(0);" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>