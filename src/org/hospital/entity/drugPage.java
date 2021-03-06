package org.hospital.entity;

import java.util.List;

public class drugPage {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private List<drug> drugs;
	public drugPage() {

	}
	public drugPage(int currentPage, int pageSize, int totalCount, int totalPage, List<drug> drugs) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.drugs = drugs;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	//自动计算总页数
	//总页数=数据总数%页面大小==0？数据总数/页面总数：数据总数/页面总数+1
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage() {
		this.totalPage = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}
	public List<drug> getDrugs() {
		return drugs;
	}
	public void setDrugs(List<drug> drugs) {
		this.drugs = drugs;
	}
}
