$(function() {
	$(".imgs").mouseover(function(e) {
		// 鼠标移入事件
		// 1.获取图片信息
		var width = this.width;
		var height = this.height;
		// 2.获取鼠标的当前位置
		var top = e.clientX;
		var left = e.clientY;
		// 3.创建一个div
		var div = $("<div id='bigDiv' />").css({
			width : width * 2,
			height : height * 2,
			border : "1px #DCDCDC solid",
			position : "absolute",
			top : left,
			left : top,
			display : "none"
		});
		// 4.创建一个img
		var img = $("<img/>").attr({
			src : this.src
		}).css({
			width : width * 2,
			height : height * 2
		});
		// 5.将img放入div中
		div.append(img);
		// 6.将div放到body中
		$("body").append(div);
		div.show(250);
	}).mousemove(function(e) {
		// 鼠标移入事件
		var x = e.pageX + 10;
		var y = e.pageY + 10;
		$("#bigDiv").css({
			top : y,
			left : x,
		});
	}).mouseout(function() {
		// 鼠标移出事件
		$("#bigDiv").remove();
	});
});