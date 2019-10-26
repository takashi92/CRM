package com.lpdev.salesmanagement.common;

import java.util.Optional;

import com.lpdev.salesmanagement.entities.Product;

public class Validator {
	/**
	 * Kiểm tra một object Product có hợp lệ không
	 * 
	 * @param product
	 * @return
	 */
	public boolean isValidProduct(Product product) {
		return Optional.ofNullable(product).filter(t -> !this.isEmpty(t.getName()))
				.filter(t -> !this.isEmpty(t.getBrandName())).isPresent();
	}

	public boolean isEmpty(String param) {
		return param == null || param.isEmpty();
	}
}
