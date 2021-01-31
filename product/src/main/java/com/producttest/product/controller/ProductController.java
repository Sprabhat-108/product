/**
 * 
 */
package com.producttest.product.controller;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.producttest.product.bean.ProductBean;
import com.producttest.product.repository.ProductEntity;
import com.producttest.product.service.ProductService;


/**
 * @author pras9
 *
 */

@RestController
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String addProduct(@RequestBody ProductBean productBean) {
		LOGGER.info("In addProduct rest services");
		try {
			if (productService.addProductService(productBean)) {
				return "The product has been added successfully.";
			} else {
				return "Error identified...";
			}
		} catch (Exception e) {
			LOGGER.error("Exception =" + e);
			return "Error identified...";
		}
	}
	
	@RequestMapping(value = "/listproduct", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public List<ProductEntity> listProducts(@RequestBody Map<String, Object> requestData)	{
		LOGGER.info("In listProducts rest services"+requestData);
		List<ProductEntity> productEntityObjList = null;
		try {
			productEntityObjList = productService.fetchProdusts(requestData);
		} catch (Exception e) {
			LOGGER.error("Exception =" + e);
		}
		return productEntityObjList;
	}
	
}
