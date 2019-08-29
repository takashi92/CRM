package com.lpdev.salesmanagement.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Brand;
import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.entities.ProductDetail;
import com.lpdev.salesmanagement.entities.ProductDetailId;
import com.lpdev.salesmanagement.entities.Property;
import com.lpdev.salesmanagement.models.params.ProductParam;
import com.lpdev.salesmanagement.repositories.BrandRepository;
import com.lpdev.salesmanagement.repositories.ProductDetailRepository;
import com.lpdev.salesmanagement.repositories.ProductRepository;
import com.lpdev.salesmanagement.repositories.PropertyRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	ProductDetailRepository productDetailRepository;

	public CommonResult save(ProductParam productParam) {
		CommonResult commonResult = new CommonResult();
		try {
			long time = new Date().getTime();
			Brand brand = brandRepository.findByName(productParam.getBrandName());
			if (brand == null) {
				brand = new Brand();
				brand.setName(productParam.getBrandName());
				brand.setCreated(time);
				brandRepository.save(brand);
			}

			Product product = new Product();
			product.setBrand(brand);
			product.setName(productParam.getName());
			product.setNote(productParam.getNote());
			product.setCreated(time);
			productRepository.save(product);

			productParam.getProperties().forEach((key, value) -> {
				Property property = propertyRepository.findByCode(key);
				if (property == null) {
					property = new Property();
					property.setCode(key);
					property.setCreated(time);
					propertyRepository.save(property);
				}

				ProductDetail productDetail = new ProductDetail();
				productDetail.setId(new ProductDetailId(product.getId(), property.getId()));
				productDetail.setName(value);
				productDetail.setCreated(time);
				productDetailRepository.save(productDetail);
			});
			commonResult.setSuccess(true);
			commonResult.setMessage("Saved Product successful");
			return commonResult;
		} catch (RuntimeException re) {
			commonResult.setSuccess(false);
			commonResult.setMessage(re.toString());
			return commonResult;
		}
	}

	public CommonResult findAll() {
		CommonResult commonResult = new CommonResult();
		try {
			List<ProductParam> productParams = new ArrayList<ProductParam>();
			List<Product> products = productRepository.findAll();
			products.forEach(product -> {
				ProductParam productParam = new ProductParam();
				productParam.setId(product.getId());
				productParam.setBrandName(product.getBrand().getName());
				productParam.setName(product.getName());
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
			if (productParams.isEmpty()) {
				commonResult.setSuccess(false);
				commonResult.setMessage("Get Products no data");
			} else {
				commonResult.setSuccess(true);
				commonResult.setMessage("Get Products successful");
			}
			commonResult.setData(productParams);
			return commonResult;
		} catch (RuntimeException re) {
			commonResult.setSuccess(false);
			commonResult.setMessage(re.toString());
			return commonResult;
		}
	}
}
