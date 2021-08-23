package com.laptrinhjavaweb.model;

public class CommentModel extends AbstractModel<CommentModel> {
	private String content;
	private long user_id;
	private long new_id;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getNew_id() {
		return new_id;
	}
	public void setNew_id(long new_id) {
		this.new_id = new_id;
	}
	
	
}
