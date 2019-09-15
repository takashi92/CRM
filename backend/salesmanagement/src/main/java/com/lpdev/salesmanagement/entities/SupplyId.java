package com.lpdev.salesmanagement.entities;
// Generated Sep 15, 2019 11:38:00 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SupplyId generated by hbm2java
 */
@Embeddable
public class SupplyId implements java.io.Serializable {

	private int productId;
	private int supplierId;

	public SupplyId() {
	}

	public SupplyId(int productId, int supplierId) {
		this.productId = productId;
		this.supplierId = supplierId;
	}

	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "supplier_id", nullable = false)
	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SupplyId))
			return false;
		SupplyId castOther = (SupplyId) other;

		return (this.getProductId() == castOther.getProductId()) && (this.getSupplierId() == castOther.getSupplierId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductId();
		result = 37 * result + this.getSupplierId();
		return result;
	}

}
