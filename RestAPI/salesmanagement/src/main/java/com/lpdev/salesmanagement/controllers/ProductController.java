package com.lpdev.salesmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> products = productService.findAll(100);
		return ResponseEntity.ok().body(products);
	}

	/*
	 * phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
	 */
	@GetMapping("/product/{productName}")
	public Product getProduct(@PathVariable(name = "productName") String productName) {
		// @PathVariable lấy ra thông tin trong URL
		// dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép
		// /product/{productName}
		return productService.get(productName);
	}

	/*
	 * @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
	 */
	@PutMapping("/product/{productName}")
	public Product editProduct(@PathVariable(name = "productName") String productName, @RequestBody Product product) {
		// TODO:edit product here
		return product;
	}

	@DeleteMapping("/product/{productName}")
	public ResponseEntity<Product> deleteTodo(@PathVariable(name = "productName") String productName) {
		// TODO: remove product here
		return ResponseEntity.ok().build();
	}

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		productService.add(product);
		// Trả về response với STATUS CODE = 200 (OK)
		// Body sẽ chứa thông tin về đối tượng product vừa được tạo.
		return ResponseEntity.ok().body(product);
	}
}
