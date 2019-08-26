package com.lpdev.salesmanagement.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Brand;
import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.entities.ProductDetail;
import com.lpdev.salesmanagement.entities.ProductDetailId;
import com.lpdev.salesmanagement.entities.Property;
import com.lpdev.salesmanagement.models.params.ProductParam;
import com.lpdev.salesmanagement.services.BrandService;
import com.lpdev.salesmanagement.services.ProductDetailService;
import com.lpdev.salesmanagement.services.ProductService;
import com.lpdev.salesmanagement.services.PropertyService;

@RestController
@RequestMapping(value = "/lpdev")
public class NhapHangController {

	@Autowired
	BrandService brandService;

	@Autowired
	ProductService productService;

	@Autowired
	PropertyService propertyService;

	@Autowired
	ProductDetailService productDetailService;

	@RequestMapping(method = RequestMethod.POST, value = "import")
	public ResponseEntity<Void> importHang(@RequestBody ProductParam productParam) {

		Brand brand = brandService.findByName(productParam.getBrandName());

		if (brand == null) {
			brand = new Brand();
			brand.setName(productParam.getBrandName());
			brandService.persist(brand);
		}

		Product product = new Product();
		product.setBrand(brand);
		product.setName(productParam.getName());
		product.setCode(productParam.getCode());
		product.setBarCode(productParam.getBarCode());
		product.setNote(productParam.getNote());
		productService.persist(product);

		productParam.getProperties().forEach((key, value) -> {
			Property property = propertyService.findByName(productParam.getBrandName());

			if (property == null) {
				property = new Property();
				property.setCode(key);
				propertyService.persist(property);
			}

			ProductDetail productDetail = new ProductDetail();
			productDetail.setId(new ProductDetailId(product.getId(), property.getId()));
			productDetail.setName(value);

			productDetailService.persist(productDetail);
		});

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "warehouse")
	public ResponseEntity<List<ProductParam>> warehouse() {

		List<ProductParam> productParams = new ArrayList<ProductParam>();
		List<Product> products = productService.findAll();
		products.forEach(product -> {
			ProductParam productParam = new ProductParam();
			productParam.setId(product.getId());
			productParam.setBrandName(product.getBrand().getName());
			productParam.setName(product.getName());
			productParam.setCode(product.getCode());
			productParam.setBarCode(product.getBarCode());
			Map<String, String> properties = new HashMap<String, String>();
			Set<ProductDetail> productDetails = product.getProductDetails();
			productDetails.forEach(productDetail -> {
				properties.put(productDetail.getProperty().getCode(), productDetail.getName());
			});
			productParam.setProperties(properties);
			productParam.setNote(product.getNote());
			productParam.setCreated(product.getCreated());
			productParam.setUpdated(product.getUpdated());
			productParams.add(productParam);
		});

		return new ResponseEntity<List<ProductParam>>(productParams, HttpStatus.OK);
	}
}
