<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<HTML>
<HEAD>
<TITLE>发现孩子(蒙台梭利儿童教育经典原著) - 图书 - 当当网</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../product_files/dangdang.css" type=text/css rel=Stylesheet>
<LINK href="../product_files/book.css" type=text/css rel=stylesheet>
<!-- <script type="text/javascript"  src="../js/jquery-1.4.min.js"></script> -->
<script type="text/javascript"  src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript"  src="../js/addProduct.js"></script>
		<!-- <script type="text/javascript">
			function addProduct(img,productId) {
				$("#buy").css("display","none");
				$("#cartInfo_"+productId).html('<img align="bottom" src="../images/load.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;购买中...');
				$.getJSON("../cart/addItem.action",
						{ id: productId, time: (new Date()).getTime() }, 
						function(json){
					  		if(json.count==0) {
						  		//没有添加成功
						  		$("#buy").css("display","block");
					  			$("#cartInfo_"+productId).html('<img align="bottom" src="../images/wrong.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;<span style="color:red">购买失败</span>');
					  		}
					  		else {
						  		//添加成功
						  		$("#cartInfo_"+productId).html('<img align="bottom" src="../images/right.gif" width="14" height="14" style="display:inline" align="bottom"/>&nbsp;购买成功');
						  		var timeId=setTimeout(function(){
							  		clearTimeout(timeId);
							  		$("#buy").css("display","block");
							  		$("#cartInfo_"+productId).html("");
							  	}, 2000);
					  		}
						}
					); 
			}
		</script> -->
</HEAD>
<BODY>

<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 10; POSITION: absolute"></DIV>
<DIV id=div_shield></DIV>
<DIV id=main>
<DIV class=mainsearch></DIV>
<DIV class=wrap><!--left start-->
	<!--left end-->
<DIV class=right>
<DIV class=right_wai>
<DIV class=shuming>
<DIV class=shuming_left><SPAN class=black000><A 
name=top_bk></A>${product.book_name }</SPAN> </DIV>
<DIV class=book_case><SPAN class=seriesname>丛书名： 
${product.book_name }</SPAN> </DIV>
<DIV class=empty_box></DIV></DIV>
<DIV class=book_left>
<DIV class=book_pic><A 
href="javascript:ImgBtnChgPrd_Click(this,'http://img39.ddimg.cn/93/5/20867709-1_o.jpg')" 
name=bigpicture_bk><IMG id=img_show_prd 
src="${pageContext.request.contextPath }/productImages/${product.img_name }"></A> </DIV><INPUT id=hid_largepictureurl 
type=hidden> </DIV>
<DIV class=book_right>
<DIV id=author_>作　　者： ${product.author }</DIV>
<DIV id=publisher_>出 版 社： ${product.publishing }</DIV>
<UL>
  <LI>出版时间： <fmt:formatDate value="${product.publish_time }" pattern="yyyy-MM-dd"/> </LI>
  <LI>字　　数： ${product.word_number } </LI>
  <LI>版　　次： ${product.which_edtion } </LI>
  <LI>页　　数： ${product.total_page } </LI>
  <LI>印刷时间： <fmt:formatDate value="${product.print_time }" pattern="yyyy-MM-dd"/> </LI>
  <LI>开　　本： ${product.format } </LI>
  <LI>印　　次： ${product.print_number } </LI>
  <LI>纸　　张： ${product.paper } </LI>
  <LI>I S B N ： ${product.isbn } </LI>
  <LI>包　　装： ${product.packing } </LI></UL>
<DIV id=__categroy_bk>所属分类： <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.00.00.00.00.00" 
target=_blank>图书</A> &gt;&gt; <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.30.00.00.00.00" 
target=_blank>社会科学</A> &gt;&gt; <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.30.07.00.00.00" 
target=_blank>教育</A> &gt;&gt; <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.30.07.04.00.00" 
target=_blank>各级教育</A></DIV>
<DIV class=jiage><SPAN class=gray87>定价：<SPAN class=del 
id=originalPriceTag>￥${product.price }</SPAN></SPAN> <SPAN 
class=redc30>当当价：￥<B>${product.dang_price }</B></SPAN> 节省：￥${product.price-product.dang_price } 
<DIV class=pd_buy_num> 
<DIV class=clear></DIV></DIV>
<DIV class=goumai>
<img src='../product_files/booksale.gif' onclick="addProduct(this,${product.id});" style="display: block;" />
<span id="cartinfo_${product.id }"></span>
<%-- <A  title=购买 onclick="addProduct(this,${product.id})" name=purchase_book>
<IMG  id="buy" src="../product_files/booksale.gif"><span id="cartInfo_${product.id}" ></span></A> --%>
<!--  <A id=favor title=收藏 href="#" name=wishlist_book>
<IMG id=imgfavor src="../product_files/bookz_save.gif"></A>
-->
</DIV>

</DIV></DIV>
<DIV id=dvTPUrls></DIV>
<DIV id=__zhinengbiaozhu_bk>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="../product_files/bg_point1.gif" align=absMiddle> 
编辑推荐</H2>
<DIV 
class=zhengwen>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${product.recommend }</DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="../product_files/bg_point1.gif" align=absMiddle> 
内容简介</H2>
<DIV class=zhengwen>${product.content_introduct }</DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="../product_files/bg_point1.gif" align=absMiddle> 
作者简介</H2>
<DIV class=zhengwen>${product.author_summary}</DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="../product_files/bg_point1.gif" align=absMiddle> 
目录</H2>
<DIV 
class=zhengwen>${product.catalog }</DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="../product_files/bg_point1.gif" align=absMiddle> 
媒体评论</H2>
<DIV class=zhengwen>${product.media_comment }</DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="../product_files/bg_point1.gif" align=absMiddle> 
书摘插图</H2>
<DIV class=zhengwen>${product.excerpt }
</DIV></DIV>
<A name=review_point></A>
	</DIV></DIV>
<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
<DIV id=tag_box_pay style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
<DIV id=div_shield></DIV><!--页尾 开始 -->
<DIV class=public_footer_add_s></DIV><!--09.3.10new-->
<!--页尾 end -->
<!--页尾开始 -->
<%@include file="../common/foot.jsp"%>
<!--页尾结束 -->
</BODY></HTML>
