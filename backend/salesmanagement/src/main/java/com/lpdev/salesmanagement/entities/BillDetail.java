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
@Table(name = "bill_detail", catalog = "sales_management")
public class BillDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BillDetailId id;
	private Bill bill;
	private Product product;
	private Integer quantity;
	private Integer sale;
	private Double price;
	private String note;
	private Long created;
	private Long updated;

	public BillDetail() {
	}

	public BillDetail(BillDetailId id, Bill bill, Product product) {
		this.id = id;
		this.bill = bill;
		this.product = product;
	}

	public BillDetail(BillDetailId id, Bill bill, Product product, Integer quantity, Integer sale, Double price,
			String note, Long created, Long updated) {
		this.id = id;
		this.bill = bill;
		this.product = product;
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
	public BillDetailId getId() {
		return this.id;
	}

	public void setId(BillDetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id", nullable = false, insertable = false, updatable = false)
	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
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