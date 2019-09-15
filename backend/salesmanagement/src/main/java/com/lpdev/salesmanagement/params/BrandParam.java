package com.lpdev.salesmanagement.params;

public class BrandParam {
	
	private int id;
	private String name;
	private String note;
	private Long created;
	private Long updated;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Long getCreated() {
		return created;
	}
	
	public void setCreated(Long created) {
		this.created = created;
	}
	
	public Long getUpdated() {
		return updated;
	}
	
	public void setUpdated(Long updated) {
		this.updated = updated;
	}
}
