package com.company.ProductManager.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.ProductManager.entity.ProductosMonitoreadosEntity;

import jakarta.transaction.Transactional;

public interface ProductoRepository extends CrudRepository<ProductosMonitoreadosEntity, Integer> {

	
	@Query("select u from ProductosMonitoreadosEntity u where u.sku = :sku")
	ProductosMonitoreadosEntity findBySku(int sku);
	
	@Transactional
	@Modifying
	@Query("update ProductosMonitoreadosEntity u set u.ultimaRevision = :newRev where u.sku = :sku")
	void updateUltimaRev(Date newRev, int sku);
}
