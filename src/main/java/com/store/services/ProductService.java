package com.store.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dao.ProductDao;
import com.store.entities.*;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public List<Products> getProducts(){
		List<Products> products=this.productDao.getAllProducts();
		return products;
	}
	
	public Products getProduct(int productId) {
		Products product=this.productDao.getProduct(productId);
		return product;
	}
	
	public void deleteProduct(int productId) {
		this.productDao.deleteProduct(productId);
	}
	
	public void addUpdateProduct(Products product) {
		this.productDao.addUpdateProduct(product);
	}
}
