package com.laptrinhjavaweb.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	private Long id;
	private Timestamp createddate;
	private Timestamp modifieddate;
	private String createdby;
	private String modifiedby;
	private long[] ids;
	private List<T> listResult = new ArrayList<>();
	private Integer page;
	private Integer totalPage;
	private Integer maxPageItem;
	private Integer	totalItem;
	private String sortName;
	private String sortBy;
	private String alert;
	private String message;
	private String type;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public long[] getIds() {
		return ids;
	}
	public void setIds(long[] ids) {
		this.ids = ids;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	
}
