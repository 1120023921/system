package cn.doublehh.base.pojo;

import java.io.Serializable;
import java.util.List;

public class ListPage<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//总记录数
	private int total;
	
	//当前页
	private int currentPage;
	
	//总页数
	private int pages;
	
	//结果集
	private List<T> list;
	
	//行数
	private int rows;
	
	public ListPage(int beforePages, int beforePage, int beforeRows, List<T> beforList , int listTotal) {
		this.currentPage = beforePage;
		this.list = beforList;
		this.rows = beforeRows;
		this.pages = beforePages;
		this.total = listTotal;
		System.out.println("listSize="+list.size());
	}
	
	
	
    public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public int getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getPages() {
		return pages;
	}



	public void setPages(int pages) {
		this.pages = pages;
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}



	public int getRows() {
		return rows;
	}



	public void setRows(int rows) {
		this.rows = rows;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ListPaged{");

        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", currentPage=").append(currentPage);
        
        sb.append('}');
        System.out.println(sb.toString());
        return sb.toString();
    }
}
