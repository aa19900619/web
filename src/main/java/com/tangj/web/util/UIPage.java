package com.tangj.web.util;

import java.util.List;

import com.github.pagehelper.Page;

public class UIPage {

	public UIPage(){}
	
	private int total;				//总记录数
	private List<?> list;		//显示数据
	private int curPage;			//显示数据
	private String page;			//分页html
	private int pageSize;			//每页显示数
	private int countPage;			//总页数
	
	public UIPage(List<?> list) /*throws BaseException*/{
		Page<?> pagebean = (Page<?>) list;
		this.total = (int)pagebean.getTotal();
		this.pageSize = pagebean.getPageSize();
		this.curPage = pagebean.getPageNum();
		this.list = pagebean.getResult();
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getPage() {
		if( this.total == 0 ){
			return "";
		}
		
		int pageCount = getMaxPage(this.total, this.pageSize);	//总页数
		int start = this.curPage - 3 <= 0 ? 1 : this.curPage - 2;
		int end = pageCount - this.curPage >= 2 ? this.curPage + 2 : pageCount;
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<div class='text-l mt-20'>");
		buffer.append("<div class='laypage_main laypageskin_default'>");
		
		
		if( this.curPage == 1 ){
			buffer.append("<a href='javascript:void(0);' class='laypage_prev disabled'>上一页</a>");
		}else{
			buffer.append("<a href='javascript:void(0)' class='laypage_prev' onclick='page(" + (this.curPage-1) + ")'>上一页</a>");
			if( this.curPage >= 4 ){
				buffer.append("<a href='javascript:void(0)' class='laypage_prev' onclick='page(1)'>..</a>");
			}
		}
		
		for( int i = start ; i <= end ; i++ ){
			if( i == this.curPage ){
				buffer.append("<span class='laypage_prev'>"+i+"</span>");
			}else{
				buffer.append("<a href='javascript:void(0)' class='laypage_prev' onclick='page(" + i + ")'>"+i+"</a>");
			}
		}
		
		if( this.curPage == pageCount || pageCount == 0 ){
			buffer.append("<a href='javascript:void(0)' class='laypage_prev disabled'>下一页</a>");
		}else{
			if( ( pageCount - this.curPage ) > 2 ){
				buffer.append("<a href='javascript:void(0)' class='laypage_prev' onclick='page(" + pageCount + ")'>..</a>");
			}
			buffer.append("<a href='javascript:void(0)' class='laypage_prev' onclick='page(" + ( this.curPage + 1) +")'>下一页</a>");
		}
		buffer.append("</div>").append("</div>");
		
		page = buffer.toString();
		return page;
	}

	public int getMaxPage(int max,int size){
		return ( max + size - 1 ) / size;
	}

	public int getCountPage() {
		countPage = ( this.total + this.pageSize - 1 ) / this.pageSize;
		return countPage; 
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	
}
