package com.laptrinhjavaweb.model;

public class NewModel extends AbstractModel<NewModel> {
	private String title;
	private String thumbnail;
	private String shortdescription;
	private String content;
	private long categoryid;
	private String catoryCode;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}
	public String getCatoryCode() {
		return catoryCode;
	}
	public void setCatoryCode(String catoryCode) {
		this.catoryCode = catoryCode;
	}
	
	
}
