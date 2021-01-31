package com.producttest.product.service;

import java.util.List;
import java.util.Map;

import com.producttest.product.bean.ProductBean;
import com.producttest.product.repository.ProductEntity;

public interface ProductService {

	
	abstract boolean addProductService(ProductBean productBean);
	
	abstract List<ProductEntity> fetchProdusts(Map<String, Object> reqData);
}
