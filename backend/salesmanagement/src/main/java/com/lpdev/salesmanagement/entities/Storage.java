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
@Table(name = "storage", catalog = "sales_management")
public class Storage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private StorageId id;
	private Products products;

	public Storage() {
	}

	public Storage(StorageId id) {
		this.id = id;
	}

	public Storage(StorageId id, Products products) {
		this.id = id;
		this.products = products;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "productId", column = @Column(name = "product_id")),
			@AttributeOverride(name = "quantity", column = @Column(name = "quantity")),
			@AttributeOverride(name = "price", column = @Column(name = "price", precision = 22, scale = 0)),
			@AttributeOverride(name = "note", column = @Column(name = "note")),
			@AttributeOverride(name = "created", column = @Column(name = "created")),
			@AttributeOverride(name = "updated", column = @Column(name = "updated")) })
	public StorageId getId() {
		return this.id;
	}

	public void setId(StorageId id) {
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

}
