package com.lpdev.salesmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BillDetailId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int billId;
	private int productId;

	public BillDetailId() {
	}

	public BillDetailId(int billId, int productId) {
		this.billId = billId;
		this.productId = productId;
	}

	@Column(name = "bill_id", nullable = false)
	public int getBillId() {
		return this.billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BillDetailId))
			return false;
		BillDetailId castOther = (BillDetailId) other;

		return (this.getBillId() == castOther.getBillId()) && (this.getProductId() == castOther.getProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getBillId();
		result = 37 * result + this.getProductId();
		return result;
	}

}
