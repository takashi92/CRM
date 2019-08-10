package com.lpdev.salesmanagement.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SupplyId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer productId;
	private Integer supplierId;
	private Double price;
	private Integer quantity;
	private String note;
	private Date created;
	private Date updated;

	public SupplyId() {
	}

	public SupplyId(Date created, Date updated) {
		this.created = created;
		this.updated = updated;
	}

	public SupplyId(Integer productId, Integer supplierId, Double price, Integer quantity, String note, Date created,
			Date updated) {
		this.productId = productId;
		this.supplierId = supplierId;
		this.price = price;
		this.quantity = quantity;
		this.note = note;
		this.created = created;
		this.updated = updated;
	}

	@Column(name = "product_id")
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "supplier_id")
	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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
		if (!(other instanceof SupplyId))
			return false;
		SupplyId castOther = (SupplyId) other;

		return ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null
				&& castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())))
				&& ((this.getSupplierId() == castOther.getSupplierId()) || (this.getSupplierId() != null
						&& castOther.getSupplierId() != null && this.getSupplierId().equals(castOther.getSupplierId())))
				&& ((this.getPrice() == castOther.getPrice()) || (this.getPrice() != null
						&& castOther.getPrice() != null && this.getPrice().equals(castOther.getPrice())))
				&& ((this.getQuantity() == castOther.getQuantity()) || (this.getQuantity() != null
						&& castOther.getQuantity() != null && this.getQuantity().equals(castOther.getQuantity())))
				&& ((this.getNote() == castOther.getNote()) || (this.getNote() != null && castOther.getNote() != null
						&& this.getNote().equals(castOther.getNote())))
				&& ((this.getCreated() == castOther.getCreated()) || (this.getCreated() != null
						&& castOther.getCreated() != null && this.getCreated().equals(castOther.getCreated())))
				&& ((this.getUpdated() == castOther.getUpdated()) || (this.getUpdated() != null
						&& castOther.getUpdated() != null && this.getUpdated().equals(castOther.getUpdated())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
		result = 37 * result + (getSupplierId() == null ? 0 : this.getSupplierId().hashCode());
		result = 37 * result + (getPrice() == null ? 0 : this.getPrice().hashCode());
		result = 37 * result + (getQuantity() == null ? 0 : this.getQuantity().hashCode());
		result = 37 * result + (getNote() == null ? 0 : this.getNote().hashCode());
		result = 37 * result + (getCreated() == null ? 0 : this.getCreated().hashCode());
		result = 37 * result + (getUpdated() == null ? 0 : this.getUpdated().hashCode());
		return result;
	}

}
