package com.offcn.utils;

public class PageTool {
	public PageTool(int totalCount, String currentPage) {
		this.totalCount = totalCount;
		initCurrentPage(currentPage);
		this.pageSize=3;//页容量写死，但可以修改
		initTotalPages();
		initPrePage();
		initNextPage();
		initStartIndex();
	}
	//给当前页码初始化
	private void initCurrentPage(String currentPage) {
		if (currentPage==null) {
			this.currentPage=1;
		}else {
			this.currentPage=Integer.valueOf(currentPage);
		}
	}
	//计算总页数
	private void initTotalPages() {
		this.totalPages=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
	}
	//上一页
	private void initPrePage() {
		if (currentPage==1) {
			this.prePage=1;
		}else {
			this.prePage=currentPage-1;
		}
	}
	//下一页
	private void initNextPage() {
		if (currentPage==totalPages) {
			this.nextPage=totalPages;
		}else {
			this.nextPage=currentPage+1;
		}
	}
	//每页第一条记录的超始下标
	private void initStartIndex() {
		this.startIndex=pageSize*(currentPage-1);
	}
	private int pageSize;//页容量
	private int totalCount;//总记录数
	private int totalPages;//总页数
	private int currentPage;//当前页码
	private int prePage;//上一页
	private int nextPage;//下一页
	private int startIndex;//每页第一条记录的超始下标
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
}