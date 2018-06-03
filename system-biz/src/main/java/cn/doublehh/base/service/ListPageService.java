package cn.doublehh.base.service;

import cn.doublehh.base.pojo.ListPage;

import java.util.List;

public interface ListPageService<T> {
	
	ListPage<T> listPaged(List<T> list, int page, int rows);
}
