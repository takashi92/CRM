package com.lpdev.salesmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	private String name;

	private String brandName;
	private String properties;
	private Integer number;
	private Double stickerPrice;
	private Double importedPrice;
	private Double importAmount;
	private Double created;
	private Double updated;
	private String note;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getStickerPrice() {
		return stickerPrice;
	}

	public void setStickerPrice(Double stickerPrice) {
		this.stickerPrice = stickerPrice;
	}

	public Double getImportedPrice() {
		return importedPrice;
	}

	public void setImportedPrice(Double importedPrice) {
		this.importedPrice = importedPrice;
	}

	public Double getImportAmount() {
		return importAmount;
	}

	public void setImportAmount(Double importAmount) {
		this.importAmount = importAmount;
	}

	public Double getCreated() {
		return created;
	}

	public void setCreated(Double created) {
		this.created = created;
	}

	public Double getUpdated() {
		return updated;
	}

	public void setUpdated(Double updated) {
		this.updated = updated;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
