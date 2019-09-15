package com.lpdev.salesmanagement.params;

public class StorageParam {

	private ProductParam productParam;
	private Integer quantity;
	private Double price;
	private String note;
	private Long created;
	private Long updated;

	public ProductParam getProductParam() {
		return productParam;
	}

	public void setProductParam(ProductParam productParam) {
		this.productParam = productParam;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
