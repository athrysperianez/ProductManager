package com.company.ProductManager.dto;

import java.util.Date;

public class ProductoDTO {

	private String nombre;
	private int sku;
	private int stock;
	private Date ultimaRevision;

	public ProductoDTO() {
	}

	public ProductoDTO(String nombre, int sku, int stock) {
		this.nombre = nombre;
		this.sku = sku;
		this.stock = stock;
	}

	public ProductoDTO(String nombre, int sku, int stock, Date ultimaRevision) {
		this.nombre = nombre;
		this.sku = sku;
		this.stock = stock;
		this.ultimaRevision = ultimaRevision;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getUltimaRevision() {
		return ultimaRevision;
	}

	public void setUltimaRevision(Date ultimaRevision) {
		this.ultimaRevision = ultimaRevision;
	}
}
