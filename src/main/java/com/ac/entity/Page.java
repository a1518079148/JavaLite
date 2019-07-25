package com.ac.entity;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;

/**
 * 分页对象
 */
public class Page<E> {
	/**
	 * 页码，从1开始
	 */
	private int pageNo;
	/**
	 * 页面大小
	 */
	private int pageSize;

	/**
	 * 总数
	 */
	private long total;
	/**
	 * 总页数
	 */
	private int pages;

	/**
	 * 数据列表
	 */
	private List<E> list;

	public Page() {
		super();
	}

	public Page(int pageNo, int pageSize, FindIterable<E> it, Long total) {
		this.pageNo = pageNo > 0 ? pageNo : 1;
		this.pageSize = pageSize;
		this.list = it.into(new ArrayList<E>());
		setTotal(total);
	}

	public Page(int pageNo, int pageSize, AggregateIterable<E> it, Long total) {
		this.pageNo = pageNo > 0 ? pageNo : 1;
		this.pageSize = pageSize;
		this.list = it.into(new ArrayList<E>());
		setTotal(total);
	}

	public Page(int pageNo, int pageSize, List<E> it, Long total) {
		this.pageNo = pageNo > 0 ? pageNo : 1;
		this.pageSize = pageSize;
		this.list = it;
		setTotal(total);
	}

	public List<E> getList() {
		return list;
	}

	public int getPages() {
		return pages;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
		if (pageSize > 0) {
			pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
		} else {
			pages = 0;
		}
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Page{");
		sb.append("pageNo=").append(pageNo);
		sb.append(", pageSize=").append(pageSize);
		sb.append(", total=").append(total);
		sb.append(", pages=").append(pages);
		sb.append('}');
		return sb.toString();
	}
}
