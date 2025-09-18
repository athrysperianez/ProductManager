package com.company.ProductManager.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos_monitoreados")
public class ProductosMonitoreadosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int sku;
	private int stock;
	private Date ultimaRevision;

	public ProductosMonitoreadosEntity() {
	}

	public ProductosMonitoreadosEntity(int id, String nombre, int sku, int stock, Date ultimaRevision) {
		this.id = id;
		this.nombre = nombre;
		this.sku = sku;
		this.stock = stock;
		this.ultimaRevision = ultimaRevision;
	}	

	public ProductosMonitoreadosEntity(String nombre, int sku, int stock) {
		this.nombre = nombre;
		this.sku = sku;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
