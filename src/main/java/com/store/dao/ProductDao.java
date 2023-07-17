package com.store.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.store.entities.Products;

@Repository
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addUpdateProduct(Products product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
//	public void updateProduct(Products product) {
//		this.hibernateTemplate.update(product);
//	}
//	
	
	
	public List<Products> getAllProducts(){
		List<Products> products=this.hibernateTemplate.loadAll(Products.class);	
		return products;
	}
	
	public Products getProduct(int productId){
		Products products=this.hibernateTemplate.get(Products.class,productId);	
		return products;
	}
	
	@Transactional
	public void deleteProduct(int productId) {
		Products product=this.hibernateTemplate.get(Products.class, productId);
		this.hibernateTemplate.delete(product);
	}
	
}
