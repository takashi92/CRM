package com.lpdev.salesmanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Brand;
import com.lpdev.salesmanagement.entities.Products;
import com.lpdev.salesmanagement.models.params.ProductParam;
import com.lpdev.salesmanagement.services.BrandService;
import com.lpdev.salesmanagement.services.ProductsService;

@RestController
@RequestMapping(value = "/lpdev")
public class NhapHangController {

	@Autowired
	BrandService brandService;

	@Autowired
	ProductsService productsService;

	@RequestMapping(method = RequestMethod.POST, value = "import")
	public ResponseEntity<Void> importHang(@RequestBody ProductParam productParam) {

		Brand brand = brandService.findByName(productParam.getBrandName());

		if (brand == null) {
			brand = new Brand();
			brand.setName(productParam.getBrandName());
			brandService.persist(brand);
		}

		Products product = new Products();
		product.setBrand(brand);
		product.setName(productParam.getName());
		product.setCode(productParam.getCode());
		product.setBarCode(productParam.getBarCode());
		product.setProperties(productParam.getProperties());
		product.setNote(productParam.getNote());
		productsService.persist(product);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "warehouse")
	public ResponseEntity<List<ProductParam>> warehouse() {

		List<ProductParam> productParams = new ArrayList<ProductParam>();
		List<Products> products = productsService.findAll();
		products.forEach(product -> {
			ProductParam productParam = new ProductParam();
			productParam.setId(product.getId());
			productParam.setBrandName(product.getBrand().getName());
			productParam.setName(product.getName());
			productParam.setCode(product.getCode());
			productParam.setBarCode(product.getBarCode());
			productParam.setProperties(product.getProperties());
			productParam.setNote(product.getNote());
			productParam.setCreated(product.getCreated());
			productParam.setUpdated(product.getUpdated());
			productParams.add(productParam);
		});

		return new ResponseEntity<List<ProductParam>>(productParams, HttpStatus.OK);
	}
}
