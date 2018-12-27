package com.baizhi.util;

import java.util.List;

public class PageBean<T> {
	// 已知数据
	private int pageNum; // 当前页，从请求那边传来
	private int pageSize; // 每页显示的数据条数
	private int totalRecord; // 总的记录条数，查询数据库得到的数据

	// 需要计算得来
	private int totalPage; // 总页数，通过totalRecord和pageSize得来
	// 开始条数
	private int startIndex;
	// 结束条数
	private int finish;

	// 将每页需要展示的数据放在List集合中
	private List<T> list;

	// 分页显示的页数，比如页面上显示1、2、3、4、5页，start就为1，end为5，这也是算出来的
	private int start;
	private int end;

	// 通过pageNum，pageSize，totalRecord计算得来totalPage和startIndex条数据
	// 构造方法中将pageNum，pageSize，totalRecord获得
	public PageBean(int pageNum, int pageSize, int totalRecord) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;

		// to taPage总页数
		if (totalRecord % pageSize == 0) {
			// 说明整数，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条的数据
			this.totalPage = totalRecord / pageSize;
		} else {
			// 不整除，就要在加一页，来显示多余数据
			this.totalPage = totalRecord / pageSize + 1;
		}

		// 开始条数
		this.startIndex = (pageNum - 1) * pageSize + 1;
		// 结束条数
		this.finish = pageNum * pageSize;

		this.start = 1;
		this.end = 5;
		// 显示页的算法
		// 显示5页
		if (totalPage <= 5) {
			// 总页数都小于5，那么end就为总页数的值了
			this.end = this.totalPage;
		} else {
			// 总页数大于5，那么就要根据当前时几页，来判断start和end为多少了
			this.start = pageNum - 2;
			this.end = pageNum + 2;

			if (start <= 0) {
				// 比如当前是第1页，或者第2页，那么就不如这个规则
				this.start = 1;
				this.end = 5;
			}
			if (end > this.totalPage) {
				// 比如当前页数是倒数第2页或着最后一页，也同样不符合上面那个规则
				this.end = totalPage;
				this.start = end - 4;
			}
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "PageBean [pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", totalRecord=" + totalRecord + ", totalPage="
				+ totalPage + ", startIndex=" + startIndex
				+ ", finish=" + finish + ", list=" + list
				+ ", start=" + start + ", end=" + end + "]";
	}

}
