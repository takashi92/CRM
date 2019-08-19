package com.lpdev.salesmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "storage", catalog = "sales_management")
public class Storage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer productId;
	private Products products;
	private Integer quantity;
	private Double price;
	private String note;
	private Long created;
	private Long updated;

	public Storage() {
	}

	public Storage(Products products) {
		this.products = products;
	}

	public Storage(Products products, Integer quantity, Double price, String note, Long created, Long updated) {
		this.products = products;
		this.quantity = quantity;
		this.price = price;
		this.note = note;
		this.created = created;
		this.updated = updated;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "products"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "product_id", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "created")
	public Long getCreated() {
		return this.created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	@Column(name = "updated")
	public Long getUpdated() {
		return this.updated;
	}

	public void setUpdated(Long updated) {
		this.updated = updated;
	}

}
