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

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "bill_details", catalog = "sales_management")
@Proxy(lazy = false)
public class BillDetails implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BillDetailsId id;
	private Bills bills;
	private Products products;

	public BillDetails() {
	}

	public BillDetails(BillDetailsId id) {
		this.id = id;
	}

	public BillDetails(BillDetailsId id, Bills bills, Products products) {
		this.id = id;
		this.bills = bills;
		this.products = products;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "billId", column = @Column(name = "bill_id")),
			@AttributeOverride(name = "productId", column = @Column(name = "product_id")),
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity")),
			@AttributeOverride(name = "sale", column = @Column(name = "sale")),
			@AttributeOverride(name = "price", column = @Column(name = "price", precision = 22, scale = 0)),
			@AttributeOverride(name = "note", column = @Column(name = "note")),
			@AttributeOverride(name = "created", column = @Column(name = "created", nullable = false, length = 19)),
			@AttributeOverride(name = "updated", column = @Column(name = "updated", nullable = false, length = 19)) })
	public BillDetailsId getId() {
		return this.id;
	}

	public void setId(BillDetailsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id", insertable = false, updatable = false)
	public Bills getBills() {
		return this.bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

}
