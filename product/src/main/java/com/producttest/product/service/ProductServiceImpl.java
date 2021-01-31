package com.producttest.product.service;

import java.lang.invoke.MethodHandles;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producttest.product.bean.ProductBean;
import com.producttest.product.repository.ProductEntity;
import com.producttest.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	ProductRepository productRepository;
	private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private java.sql.Timestamp parseTimestamp(String timestamp) {
	    try {
	        return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	
	@Override
	public boolean addProductService(ProductBean productBean) {

		LOGGER.info("In addProductService service");
		boolean isAddedFlag = false;
		try {
			ProductEntity productEntityObj = new ProductEntity();
			productEntityObj.setProductLat(Double.parseDouble(productBean.getProductLat()));
			productEntityObj.setProductLon(Double.parseDouble(productBean.getProductLon()));
			productEntityObj.setProductDescription(productBean.getProductDescription());
			productEntityObj.setProductTitle(productBean.getProductTitle());
			productEntityObj.setCreateDate(parseTimestamp(DATE_TIME_FORMAT.format(new Date())));
			productEntityObj.setProductPrice(Float.parseFloat(productBean.getProductPrice()));
			productEntityObj.setProductUnit(Integer.parseInt(productBean.getProductUnit()));

			productRepository.save(productEntityObj);
			isAddedFlag = true;
		} catch (Exception e) {
			LOGGER.error("Exception =" + e);
		}
		return isAddedFlag;
	}

	@Override
	public List<ProductEntity> fetchProdusts(Map<String, Object> reqData) {

		LOGGER.info("In fetchProdusts service");
		List<ProductEntity> productEntityObjList = null;
		try {
			productEntityObjList = productRepository.listProducts(Float.parseFloat((String) reqData.get("lat")),
					Float.parseFloat((String) reqData.get("lon")), Integer.parseInt((String) reqData.get("radius")));

		} catch (Exception e) {
			LOGGER.error("Exception =" + e);
		}
		return productEntityObjList;
	}

	
	
}
