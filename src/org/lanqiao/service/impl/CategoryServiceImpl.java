package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.CategoryDao;
import org.lanqiao.dao.impl.CategoryDaoImpl;
import org.lanqiao.dao.impl.NewsDaoImpl;
import org.lanqiao.entity.Category;
import org.lanqiao.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao dao =new CategoryDaoImpl();
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	@Override
	public Category getCategory(String cid) {
		// TODO Auto-generated method stub
		return dao.getCategory(cid);
	}

}
