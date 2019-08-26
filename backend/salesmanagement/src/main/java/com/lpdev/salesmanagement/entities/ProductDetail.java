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
@Table(name = "product_detail", catalog = "sales_management")
public class ProductDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private ProductDetailId id;
	private Product product;
	private Property property;
	private String name;
	private String note;
	private Long created;
	private Long updated;

	public ProductDetail() {
	}

	public ProductDetail(ProductDetailId id, Product product, Property property) {
		this.id = id;
		this.product = product;
		this.property = property;
	}

	public ProductDetail(ProductDetailId id, Product product, Property property, String name, String note, Long created,
			Long updated) {
		this.id = id;
		this.product = product;
		this.property = property;
		this.name = name;
		this.note = note;
		this.created = created;
		this.updated = updated;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
			@AttributeOverride(name = "propertyId", column = @Column(name = "property_id", nullable = false)) })
	public ProductDetailId getId() {
		return this.id;
	}

	public void setId(ProductDetailId id) {
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
	@JoinColumn(name = "property_id", nullable = false, insertable = false, updatable = false)
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
