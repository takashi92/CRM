package com.lpdev.salesmanagement.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill_details", catalog = "sales_management")
public class BillDetails implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BillDetailsId id;
	private Bills bills;
	private Products products;
	private Integer quantity;
	private Integer sale;
	private Double price;
	private String note;
	private Long created;
	private Long updated;

	public BillDetails() {
	}

	public BillDetails(BillDetailsId id, Bills bills, Products products) {
		this.id = id;
		this.bills = bills;
		this.products = products;
	}

	public BillDetails(BillDetailsId id, Bills bills, Products products, Integer quantity, Integer sale, Double price,
			String note, Long created, Long updated) {
		this.id = id;
		this.bills = bills;
		this.products = products;
		this.quantity = quantity;
		this.sale = sale;
		this.price = price;
		this.note = note;
		this.created = created;
		this.updated = updated;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "billId", column = @Column(name = "bill_id", nullable = false)),
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
	public BillDetailsId getId() {
		return this.id;
	}

	public void setId(BillDetailsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id", nullable = false, insertable = false, updatable = false)
	public Bills getBills() {
		return this.bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
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

	@Column(name = "sale")
	public Integer getSale() {
		return this.sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
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
