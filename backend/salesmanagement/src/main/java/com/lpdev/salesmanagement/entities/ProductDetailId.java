package com.lpdev.salesmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductDetailId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int productId;
	private int propertyId;

	public ProductDetailId() {
	}

	public ProductDetailId(int productId, int propertyId) {
		this.productId = productId;
		this.propertyId = propertyId;
	}

	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column(name = "property_id", nullable = false)
	public int getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductDetailId))
			return false;
		ProductDetailId castOther = (ProductDetailId) other;

		return (this.getProductId() == castOther.getProductId()) && (this.getPropertyId() == castOther.getPropertyId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductId();
		result = 37 * result + this.getPropertyId();
		return result;
	}

}
