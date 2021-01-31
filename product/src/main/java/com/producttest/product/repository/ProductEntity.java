package com.producttest.product.repository;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "product")
@Entity
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id", insertable = false, nullable = false)
    private Integer productId;

    @Column(name = "product_lat", nullable = false)
    private Double productLat;

    @Column(name = "product_lon", nullable = false)
    private Double productLon;

    @Column(name = "create_date", nullable = false)
    private Timestamp createDate;

    @Column(name = "product_title", nullable = false)
    private String productTitle;

    @Column(name = "product_description")
    private String productDescription = "NULL";

    @Column(name = "product_price", nullable = false)
    private Float productPrice;

    @Column(name = "product_unit", nullable = false)
    private Integer productUnit;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getProductLat() {
		return productLat;
	}

	public void setProductLat(Double productLat) {
		this.productLat = productLat;
	}

	public Double getProductLon() {
		return productLon;
	}

	public void setProductLon(Double productLon) {
		this.productLon = productLon;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(Integer productUnit) {
		this.productUnit = productUnit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}