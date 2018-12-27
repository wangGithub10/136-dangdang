<%@ page contentType="text/html;charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<!-- <script type="text/javascript" src="../js/prototype-1.6.0.3.js"></script> -->
		<script type="text/javascript" src=" ../js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="../js/magnifier.js"></script>
		<script type="text/javascript"  src="../js/addProduct.js"></script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			$(function (){
				$("#page").click(function (){
					var pageNum = ${requestScope.pageBean.pageNum};
					if(pageNum<=1){
						$("#page").prop("href","#");
					}
				});
				$("#page2").click(function (){
					var pageNum = ${requestScope.pageBean.pageNum};
					var page = ${requestScope.pageBean.totalPage};
					if(pageNum>=page){
						$("#page2").prop("href","#");
					}
				});
				
			});
		</script>
	</head>
	<body>
		&nbsp;
	
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
	
		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg"
				border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp; <a href='${pageContext.request.contextPath }/main/main.jsp'>当当图书</a> &gt;&gt; 
			<font>
				<!-- 一级分类导航 -->
				<c:forEach items="${requestScope.primaryClassification }" var="category">
					<c:if test="${requestScope.sid==0}">
						<strong style='color: #cc3300'>${category.name }</strong></c:if>
					<c:if test="${requestScope.sid!=0}">
						<a href="${pageContext.request.contextPath }/category/secondaryClassification.do?id=${category.id }">
							<strong>${category.name }</strong></a></c:if>
					
				<!-- 二级分类导航 -->
				<c:forEach items="${category.categorys }" var="categorys">
					<c:if test="${requestScope.sid==categorys.id}">
						<strong style='color: #cc3300'>&gt;&gt;${categorys.name }</strong></c:if>
				</c:forEach>
				</c:forEach>
				</font>
		</div>
	
		<div class="book">
	
			<!--左栏开始-->
			<c:forEach items="${requestScope.primaryClassification }" var="category">
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>分类浏览</h2>
						<ul>
							<li>
								<div>
									<c:if test="${requestScope.sid==0}">
										<div class=second_fenlei3><a id="id" style='color: #cc3300' href="${pageContext.request.contextPath }/category/secondaryClassification.do?id=${category.id }">全部&nbsp;(${category.goods_count })</a></div>
									</c:if>
									<c:if test="${requestScope.sid!=0}">
										<div class=second_fenlei><a id="id" href="${pageContext.request.contextPath }/category/secondaryClassification.do?id=${category.id }">全部&nbsp;(${category.goods_count })</a></div>
									</c:if>
								</div>
							</li>
							<div class="clear"></div>
	
							<!--2级分类开始-->
							<c:forEach items="${category.categorys }" var="categorys">
							<li>
								<div>
									<div class=second_fenlei>&middot;</div>
									<c:if test="${categorys.id==requestScope.sid}">
										<div class=second_fenlei3>
											<a id="sid" style='color: #cc3300' href="${pageContext.request.contextPath }/category/secondaryClassification.do?id=${category.id }&sid=${categorys.id }">${categorys.name }&nbsp;(${categorys.goods_count })</a>
										</div>
									</c:if>
									<c:if test="${categorys.id!=requestScope.sid}">
										<div class=second_fenlei>
											<a id="sid" href="${pageContext.request.contextPath }/category/secondaryClassification.do?id=${category.id }&sid=${categorys.id }">${categorys.name }&nbsp;(${categorys.goods_count })</a>
										</div>
									</c:if>
								</div>
							</li>
							<div class="clear"></div>
							</c:forEach>
							</c:forEach>
							<!--2级分类结束-->
	
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--左栏结束-->
	
			<!--中栏开始-->
			<div class="book_center">
	
				<!--图书列表开始-->
				<div id="divRight" class="list_right">
	
					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">排序方式</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">按上架时间 降序</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">
	
							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
								<a id='page' name='link_page_next' href="${pageContext.request.contextPath }/category/secondaryClassification.do?id=${requestScope.id }&sid=${requestScope.sid }&pageNum=${requestScope.pageBean.pageNum-1 }">
									<img src='../images/page_up.gif' />
								</a>
							</div>
	
							<div class='list_r_title_text3b'>第${requestScope.pageBean.pageNum	 }页/共${requestScope.pageBean.totalPage }页</div>
	
							<div class='list_r_title_text3a'>
								<a id='page2' name='link_page_next' href="${pageContext.request.contextPath }/category/secondaryClassification.do?id=${requestScope.id }&sid=${requestScope.sid }&pageNum=${requestScope.pageBean.pageNum+1 }">
									<img src='../images/page_down.gif' />
								</a>
							</div>
							
							<!--分页导航结束-->
						</div>
					</div>
	
					<!--商品条目开始-->
					<div class="list_r_line"></div>
					<c:forEach items="${requestScope.secondaryClassification.categorys }" var="categorys">
					<c:forEach items="${categorys.product }" var="product">
					<div class="clear"></div>
					<div class="list_r_list">
						<span class="list_r_list_book"><a name="link_prd_img" href='${pageContext.request.contextPath }/product/queryProduct.do?id=${product.id }' target='_blank'>
							<img class="imgs" src="${pageContext.request.contextPath }/productImages/${product.img_name }" />
						</a> </span>
						<h2>
							<a name="link_prd_name" href='${pageContext.request.contextPath }/product/queryProduct.do?id=${product.id }' target='_blank'>${product.book_name }</a>
						</h2>
						<h3>顾客评分：100</h3>
						<h4 class="list_r_list_h4">
							作 者: <a href='#' name='作者'>${product.author }</a>
						</h4>
						<h4>
							出版社： <a href='#' name='出版社'>${product.publishing }</a>
						</h4>
						<h4>出版时间：<fmt:formatDate value="${product.publish_time }" pattern="yyyy-MM-dd"/></h4>
						<h5>${product.content_introduct }</h5>
						<div class="clear"></div>
						<h6>
							<span class="del">￥${product.price }</span> <span class="red">￥${product.dang_price }</span> 节省：￥${product.price-product.dang_price }
						</h6>
						<span class="list_r_list_button">
						<img align="top" src='../images/buttom_goumai.gif' onclick="addProduct(this,${product.id});" style="display: block;" /></span>
						<span id="cartinfo_${product.id }"></span>
					</div>
				<div class="clear"></div>
					<div class="list_r_line"></div>
					</c:forEach>
					</c:forEach>
					<!--商品条目结束-->
					<div id="divBottomPageNavi" class="fanye_bottom"></div>
	
				</div>
				<!--图书列表结束-->
	
			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>
	
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
