package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProductPage() {
		return "addProduct";
	}
	@RequestMapping(value="/updateDetail/{id}", method = RequestMethod.GET)
	public String productDetail(@PathVariable int id, Model model) {
		model.addAttribute("product",productService.getProduct(id));
		return "productDetail";
	}

	@RequestMapping(value="/createProduct", method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
	public String createProduct( @RequestParam("description") String description,
			@RequestParam("price") Double price,
			@RequestParam("productName") String productName,
			@RequestParam("productType") ProductType productType){
		Product product = new Product(productName, description, price, productType);
		productService.save(product);
		return "addProduct";
	}
	@RequestMapping(value="/updateProduct/{id}", method = RequestMethod.POST)
	public String updateProduct(@PathVariable int id,
			@RequestParam("description") String description,
			@RequestParam("price") Double price,
			@RequestParam("productName") String productName,
			@RequestParam("productType") ProductType productType,
			Model model){
		System.out.println("updating");
		System.out.println(description);
		Product p =productService.getProduct(id);
		p.setDescription(description);
		p.setPrice(price);
		p.setProductName(productName);
		p.setProductType(productType);
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("productList",productList);
			return "productList";
	}
	@RequestMapping(value="/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id, Model model){
		productService.delete(productService.getProduct(id));
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("productList",productList);
			return "productList";
	}
	

}
