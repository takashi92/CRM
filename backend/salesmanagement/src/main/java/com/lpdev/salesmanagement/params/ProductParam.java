package com.lpdev.salesmanagement.params;

import java.util.HashMap;
import java.util.Map;

public class ProductParam {

	private Integer id;
	private Integer brandId;
	private String name;
	private Integer quantity;
	private Double entryPrice;
	private Double price;
	private Map<String, PropertyValueParam> properties = new HashMap<String, PropertyValueParam>();
	private String note;
	private Long created;
	private Long updated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getEntryPrice() {
		return entryPrice;
	}

	public void setEntryPrice(Double entryPrice) {
		this.entryPrice = entryPrice;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Map<String, PropertyValueParam> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, PropertyValueParam> properties) {
		this.properties = properties;
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
