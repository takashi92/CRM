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
	private Product product;
	private Supplier supplier;
	private Double price;
	private Integer quantity;
	private String note;
	private Long created;
	private Long updated;

	public Supply() {
	}

	public Supply(SupplyId id, Product product, Supplier supplier) {
		this.id = id;
		this.product = product;
		this.supplier = supplier;
	}

	public Supply(SupplyId id, Product product, Supplier supplier, Double price, Integer quantity, String note,
			Long created, Long updated) {
		this.id = id;
		this.product = product;
		this.supplier = supplier;
		this.price = price;
		this.quantity = quantity;
		this.note = note;
		this.created = created;
		this.updated = updated;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
			@AttributeOverride(name = "supplierId", column = @Column(name = "supplier_id", nullable = false)) })
	public SupplyId getId() {
		return this.id;
	}

	public void setId(SupplyId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id", nullable = false, insertable = false, updatable = false)
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
