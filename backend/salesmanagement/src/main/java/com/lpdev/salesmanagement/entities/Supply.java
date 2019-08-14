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
@Table(name = "supply", catalog = "sales_management")
public class Supply implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private SupplyId id;
	private Products products;
	private Supplier supplier;

	public Supply() {
	}

	public Supply(SupplyId id) {
		this.id = id;
	}

	public Supply(SupplyId id, Products products, Supplier supplier) {
		this.id = id;
		this.products = products;
		this.supplier = supplier;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "productId", column = @Column(name = "product_id")),
			@AttributeOverride(name = "supplierId", column = @Column(name = "supplier_id")),
			@AttributeOverride(name = "price", column = @Column(name = "price", precision = 22, scale = 0)),
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity")),
			@AttributeOverride(name = "note", column = @Column(name = "note")),
			@AttributeOverride(name = "created", column = @Column(name = "created", nullable = false, length = 19)),
			@AttributeOverride(name = "updated", column = @Column(name = "updated", length = 19)) })
	public SupplyId getId() {
		return this.id;
	}

	public void setId(SupplyId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id", insertable = false, updatable = false)
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
