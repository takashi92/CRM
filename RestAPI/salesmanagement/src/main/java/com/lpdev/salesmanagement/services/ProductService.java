package com.lpdev.salesmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.common.Validator;
import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Validator validator;

	/**
	 *
	 * @param limit - Giới hạn số lượng lấy ra
	 * @return Trả về danh sách List<Product> dựa theo limit, nếu limit == null thì
	 *         trả findAll()
	 */
	public List<Product> findAll(Integer limit) {
		return Optional.ofNullable(limit).map(value -> productRepository.findAll(PageRequest.of(0, value)).getContent())
				.orElseGet(() -> productRepository.findAll());
	}

	/**
	 * @return Trả về đối tượng Todo sau khi lưu vào DB, trả về null nếu không thành
	 *         công
	 */
	public Product add(Product product) {
		if (validator.isValidProduct(product)) {
			return productRepository.save(product);
		}
		return null;
	}

	/**
	 * @return Trả về đối tượng Product dựa vào productName
	 */
	public Product get(String productName) {
		if (validator.isEmpty(productName)) {
			return null;
		}
		return productRepository.findById(productName).get();
	}

}
