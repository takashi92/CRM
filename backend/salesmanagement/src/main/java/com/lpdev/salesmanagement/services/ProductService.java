package com.lpdev.salesmanagement.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Brand;
import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.entities.ProductDetail;
import com.lpdev.salesmanagement.entities.ProductDetailId;
import com.lpdev.salesmanagement.entities.Property;
import com.lpdev.salesmanagement.entities.PropertyValue;
import com.lpdev.salesmanagement.params.ProductParam;
import com.lpdev.salesmanagement.params.PropertyValueParam;
import com.lpdev.salesmanagement.repositories.BrandRepository;
import com.lpdev.salesmanagement.repositories.ProductDetailRepository;
import com.lpdev.salesmanagement.repositories.ProductRepository;
import com.lpdev.salesmanagement.repositories.PropertyRepository;
import com.lpdev.salesmanagement.repositories.PropertyValueRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	PropertyValueRepository propertyValueRepository;

	@Autowired
	ProductDetailRepository productDetailRepository;

	public CommonResult saveOrUpdate(ProductParam productParam) {
		try {
			long time = new Date().getTime();
			Integer brandId = productParam.getBrandId();
			Optional<Brand> opBrand = brandRepository.findById(brandId);
			if (!opBrand.isPresent()) {
				return CommonResult.getResult(false, "Brand ID = " + brandId + " is not exist", null);
			}

			Integer id = productParam.getId();

			if (id == null) {
				Product product = new Product();
				product.setBrand(opBrand.get());
				product.setName(productParam.getName());
				product.setQuantity(productParam.getQuantity());
				product.setEntryPrice(productParam.getEntryPrice());
				product.setPrice(productParam.getPrice());
				product.setNote(productParam.getNote());
				product.setCreated(time);
				productRepository.save(product);

				productParam.getProperties().forEach((key, value) -> {
					Optional<Property> opProperty = propertyRepository.findById(key);
					if (!opProperty.isPresent()) {
						return;
					}

					Optional<PropertyValue> opPropertyValue = propertyValueRepository.findById(value.getId());
					if (!opPropertyValue.isPresent()) {
						return;
					}

					ProductDetail productDetail = new ProductDetail();
					productDetail.setId(new ProductDetailId(product.getId(), opPropertyValue.get().getId()));
					productDetail.setCreated(time);
					productDetailRepository.save(productDetail);
				});
				return CommonResult.getResult(true, "created Brand successful", productParam);
			}

			Product product = new Product();
			product.setBrand(opBrand.get());
			product.setName(productParam.getName());
			product.setQuantity(productParam.getQuantity());
			product.setEntryPrice(productParam.getEntryPrice());
			product.setPrice(productParam.getPrice());
			product.setNote(productParam.getNote());
			product.setCreated(time);
			productRepository.save(product);

			productParam.getProperties().forEach((key, value) -> {
				Optional<Property> opProperty = propertyRepository.findById(key);
				if (!opProperty.isPresent()) {
					return;
				}

				Optional<PropertyValue> opPropertyValue = propertyValueRepository.findById(value.getId());
				if (!opPropertyValue.isPresent()) {
					return;
				}

				ProductDetail productDetail = new ProductDetail();
				productDetail.setId(new ProductDetailId(product.getId(), opPropertyValue.get().getId()));
				productDetail.setCreated(time);
				productDetailRepository.save(productDetail);
			});
			return CommonResult.getResult(true, "updated Product successful", productParam);
		} catch (RuntimeException re) {
			throw re;
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
				productParam.setName(product.getName());
				productParam.setQuantity(product.getQuantity());
				productParam.setEntryPrice(product.getEntryPrice());
				productParam.setPrice(product.getPrice());
				Map<String, PropertyValueParam> properties = new HashMap<String, PropertyValueParam>();
				Set<ProductDetail> productDetails = product.getProductDetails();
				productDetails.forEach(productDetail -> {
					PropertyValue propertyValue = productDetail.getPropertyValue();
					PropertyValueParam propertyValueParam = new PropertyValueParam();
					propertyValueParam.setId(propertyValue.getId());
					propertyValueParam.setName(propertyValue.getName());
					properties.put(propertyValue.getProperty().getCode(), propertyValueParam);
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
