/**
 * 
 */
package com.producttest.product.bean;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author pras9
 *
 *{
productLat : "",
 productLon : "",
   productTitle : "",
	 productDescription : "",
	   productPrice : "",
		 productUnit : "",
}
 */
@Component
public class ProductBean {


	    @JsonProperty("productLat") 
	    public String getProductLat() { 
			 return this.productLat; } 
	    public void setProductLat(String productLat) { 
			 this.productLat = productLat; } 
	    String productLat;
	    @JsonProperty("productLon") 
	    public String getProductLon() { 
			 return this.productLon; } 
	    public void setProductLon(String productLon) { 
			 this.productLon = productLon; } 
	    String productLon;
	    @JsonProperty("productTitle") 
	    public String getProductTitle() { 
			 return this.productTitle; } 
	    public void setProductTitle(String productTitle) { 
			 this.productTitle = productTitle; } 
	    String productTitle;
	    @JsonProperty("productDescription") 
	    public String getProductDescription() { 
			 return this.productDescription; } 
	    public void setProductDescription(String productDescription) { 
			 this.productDescription = productDescription; } 
	    String productDescription;
	    @JsonProperty("productPrice") 
	    public String getProductPrice() { 
			 return this.productPrice; } 
	    public void setProductPrice(String productPrice) { 
			 this.productPrice = productPrice; } 
	    String productPrice;
	    @JsonProperty("productUnit") 
	    public String getProductUnit() { 
			 return this.productUnit; } 
	    public void setProductUnit(String productUnit) { 
			 this.productUnit = productUnit; } 
	    String productUnit;
	


}
