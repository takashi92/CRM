package com.lpdev.salesmanagement.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BillDetailsId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer billId;
	private Integer productId;
	private Integer quantity;
	private Integer sale;
	private Double price;
	private String note;
	private Date created;
	private Date updated;

	public BillDetailsId() {
	}

	public BillDetailsId(Date created, Date updated) {
		this.created = created;
		this.updated = updated;
	}

	public BillDetailsId(Integer billId, Integer productId, Integer quantity, Integer sale, Double price, String note,
			Date created, Date updated) {
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
		this.sale = sale;
		this.price = price;
		this.note = note;
		this.created = created;
		this.updated = updated;
	}

	@Column(name = "bill_id")
	public Integer getBillId() {
		return this.billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	@Column(name = "product_id")
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	@Column(name = "created", nullable = false, length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "updated", nullable = false, length = 19)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BillDetailsId))
			return false;
		BillDetailsId castOther = (BillDetailsId) other;

		return ((this.getBillId() == castOther.getBillId()) || (this.getBillId() != null
				&& castOther.getBillId() != null && this.getBillId().equals(castOther.getBillId())))
				&& ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null
						&& castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())))
				&& ((this.getQuantity() == castOther.getQuantity()) || (this.getQuantity() != null
						&& castOther.getQuantity() != null && this.getQuantity().equals(castOther.getQuantity())))
				&& ((this.getSale() == castOther.getSale()) || (this.getSale() != null && castOther.getSale() != null
						&& this.getSale().equals(castOther.getSale())))
				&& ((this.getPrice() == castOther.getPrice()) || (this.getPrice() != null
						&& castOther.getPrice() != null && this.getPrice().equals(castOther.getPrice())))
				&& ((this.getNote() == castOther.getNote()) || (this.getNote() != null && castOther.getNote() != null
						&& this.getNote().equals(castOther.getNote())))
				&& ((this.getCreated() == castOther.getCreated()) || (this.getCreated() != null
						&& castOther.getCreated() != null && this.getCreated().equals(castOther.getCreated())))
				&& ((this.getUpdated() == castOther.getUpdated()) || (this.getUpdated() != null
						&& castOther.getUpdated() != null && this.getUpdated().equals(castOther.getUpdated())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBillId() == null ? 0 : this.getBillId().hashCode());
		result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
		result = 37 * result + (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		result = 37 * result + (getSale() == null ? 0 : this.getSale().hashCode());
		result = 37 * result + (getPrice() == null ? 0 : this.getPrice().hashCode());
		result = 37 * result + (getNote() == null ? 0 : this.getNote().hashCode());
		result = 37 * result + (getCreated() == null ? 0 : this.getCreated().hashCode());
		result = 37 * result + (getUpdated() == null ? 0 : this.getUpdated().hashCode());
		return result;
	}

}
