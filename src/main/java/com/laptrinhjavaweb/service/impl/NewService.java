package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryid) {
		return newDao.findByCategoryId(categoryid);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreateddate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(newModel.getCatoryCode());
		newModel.setCategoryid(category.getId());
		//newModel.setCreatedby("");
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreateddate(oldNew.getCreateddate());
		updateNew.setCreatedby(oldNew.getCreatedby());
		updateNew.setModifieddate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDao.findOneByCode(updateNew.getCatoryCode());
		updateNew.setCategoryid(category.getId());
		updateNew.setModifiedby("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId() );
	}

	@Override
	public void delete(long[] ids) {
		for (long id:ids) {
			newDao.delete(id);
			System.out.println(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newModel.getCategoryid());
		newModel.setCatoryCode(categoryModel.getCode());
		return newModel;
	}


}
