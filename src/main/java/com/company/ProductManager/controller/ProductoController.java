package com.company.ProductManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ProductManager.dto.ProductoDTO;
import com.company.ProductManager.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {

	private ProductoService service;
	
	public ProductoController(ProductoService service) {
		this.service = service;
	}
	
	@PostMapping("/productos")
	public void addProducto(@RequestBody ProductoDTO producto) {
		service.addProducto(producto);
	}
	
	@GetMapping("/productos/{sku}")
	public ProductoDTO getBySku(@PathVariable(value="sku") int sku) {
		return service.findBySku(sku);
	}
	
	@PutMapping("/productos/{sku}/chequeo")
	public ProductoDTO check(@PathVariable(value="sku") int sku) {
		return service.check(sku);
	}

}
