package com.producttest.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	
	@Query(value = "SELECT product_id,product_lat,product_lon,create_date,product_title,product_description,product_price,product_unit, ACOS( SIN( RADIANS( product_lat ) ) * SIN( RADIANS( ?1 ) ) + COS( RADIANS( product_lat ) ) * COS( RADIANS( ?1 )) * COS( RADIANS( product_lon ) - RADIANS( ?2 )) ) * 6380 AS distance FROM product WHERE ACOS( SIN( RADIANS( product_lat ) ) * SIN( RADIANS( ?1 ) ) + COS( RADIANS( product_lat ) ) * COS( RADIANS( ?1 )) * COS( RADIANS( product_lon ) - RADIANS( ?2 )) ) *6380 < ?3 ORDER BY distance",nativeQuery = true)
	public List<ProductEntity> listProducts(@Param("lat") float lat, @Param("lon") float lon,@Param("radius") int radius);
}
