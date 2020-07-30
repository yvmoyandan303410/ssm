package com.bus.utl;

import java.util.List;

public class Page<T> {
	private int currentPage;//当前页数
	private int pageSize;   //页大小
	private int totalRecord;//总记录数
	private List<T> list;   //查到的数据
	
	
	public Page(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	//总页数
	public int getTotalPage(){
		return (totalRecord + (pageSize-1))/ pageSize;
	}
	
	//下一页
	public int getNextPage(){
		if(currentPage >= getTotalPage()){
			return currentPage;
		}
		return currentPage + 1;
	}
	
	//上一页
	public int getPrePage(){
		if(currentPage > 1){
			return currentPage - 1;
		}
		return currentPage;
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
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
