package cn.doublehh.base.service.impl;


import cn.doublehh.base.pojo.ListPage;
import cn.doublehh.base.service.ListPageService;

import java.util.List;


public class ListPageServiceImpl<T> implements ListPageService<T> {

	@Override
	public ListPage<T> listPaged(List<T> list, int page, int rows) {
		//获取list集合中总记录数
		int listSize = list.size();
		//System.out.println("总记录数="+listSize);
		
		int pages = 1;
		//根据list集合中的记录数以及分页行数得到总共页数
		if ((listSize%rows) == 0) {
			pages = listSize/rows;
		}else {
			pages = listSize/rows+1;
		}
		
		//System.out.println("总页数="+pages);
		if (pages == 0) {
			pages = 1;
		}
		
		//根据获取当前页记录集合
		//如果总页数为1
		if (pages == 1) {
			return new ListPage<T>(pages, page, rows, list ,listSize);
		}else {
			if (page>pages) {
				page = pages;
			}if (page <1) {
				page = 1;
			}
			//如果总页数大于1,计算该页之前的记录数
			int beforeRows = (page-1)*rows;
			//System.out.println("该页之前记录数="+beforeRows);
			
			//记录数在list中的索引
			int rowsIndex = beforeRows;
			int rowsEndIndex = beforeRows+rows;
			if (rowsEndIndex > listSize) {
				rowsEndIndex = listSize;
			}
			List<T> resultList = list.subList(rowsIndex, rowsEndIndex);
			return new ListPage<T>(pages, page, rows, resultList,listSize);
		}
	}

}
