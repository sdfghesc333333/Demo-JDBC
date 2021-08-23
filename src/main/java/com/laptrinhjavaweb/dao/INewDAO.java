package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(long categoryid);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);

	int getTotalItem();
	List<NewModel> findAll(Pageble pageble);
}
