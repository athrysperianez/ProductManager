package com.company.ProductManager.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.company.ProductManager.dto.ProductoDTO;
import com.company.ProductManager.entity.ProductosMonitoreadosEntity;
import com.company.ProductManager.repository.ProductoRepository;

@Service
public class ProductoService {

	private final int RANDOM_FLOOR = 1;
	private final int RANDOM_CEILING = 100;

	ProductoRepository repository;

	public ProductoService(ProductoRepository repository) {
		this.repository = repository;
	}

	public void addProducto(ProductoDTO dto) {
		ProductosMonitoreadosEntity entity = new ProductosMonitoreadosEntity(dto.getNombre(), dto.getSku(),
				dto.getStock());
		repository.save(entity);
	}

	public ProductoDTO findBySku(int sku) {
		ProductosMonitoreadosEntity entity = repository.findBySku(sku);
		return new ProductoDTO(entity.getNombre(), entity.getSku(), entity.getStock(), entity.getUltimaRevision());
	}

	public ProductoDTO check(int sku) {
		int random = generateRandom();
		Calendar c = Calendar.getInstance();
		c.setTime(new java.util.Date());

		if (random % 15 == 0) {
			c.add(Calendar.DATE, 1);
			repository.updateUltimaRev(new Date(c.getTime().getTime()), sku);

		} else if (random % 5 == 0) {
			c.add(Calendar.MINUTE, 30);
			repository.updateUltimaRev(new Date(c.getTime().getTime()), sku);

		} else if (random % 3 == 0) {
			c.add(Calendar.HOUR, -5);
			repository.updateUltimaRev(new Date(c.getTime().getTime()), sku);

		} else {
			repository.updateUltimaRev(new Date(c.getTime().getTime()), sku);
		}

		ProductosMonitoreadosEntity entity = repository.findBySku(sku);
		return new ProductoDTO(entity.getNombre(), entity.getSku(), entity.getStock(), entity.getUltimaRevision());
	}

	private int generateRandom() {
		Random rand = new Random();
		return rand.nextInt(RANDOM_CEILING + 1 - RANDOM_FLOOR) - RANDOM_FLOOR;
	}
}
