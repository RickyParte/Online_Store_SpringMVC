package com.store.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.store.entities.Products;
import com.store.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AddUpdate");
		mv.addObject("getUrl","addUpdateProduct");
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public RedirectView deleteProduct(@PathVariable("id") int productId,HttpServletRequest request,HttpSession s) {
		this.productService.deleteProduct(productId);
//		System.out.println((product.getProductId())+" "+product.getProductName());
		RedirectView rv=new RedirectView();
		rv.setUrl(request.getContextPath()+"/products/getproducts");
		return rv;
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView updateProduct(@PathVariable("id") int productId,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("data",this.productService.getProduct(productId));
		System.out.println();
		mv.addObject("getUrl",request.getContextPath()+"/products/addUpdateProduct");
		mv.setViewName("AddUpdate");
		return mv;
	}
	
	@RequestMapping(path="/addUpdateProduct",method=RequestMethod.POST)
	public RedirectView updateProductRequest(@ModelAttribute Products product,HttpServletRequest request) {
		RedirectView rv=new RedirectView();
		this.productService.addUpdateProduct(product);
		System.out.println(product.getProductName());
		rv.setUrl(request.getContextPath()+"/products/getproducts");
		return rv;
	}
	
	
	@RequestMapping("/getproducts")
	public String getProducts(Model model) {
		List<Products> products=productService.getProducts();
		model.addAttribute("products", products);
//		System.out.println(products);
		return "list";
	}
}
