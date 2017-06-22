package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService = new ProductService();
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage(Model model) {
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("productList",productList);
		return "home";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}

	@GetMapping({"/userPage"})
	public String userPage() {
		return "userPage";
	}
	
	@RequestMapping(value="/productList", method = RequestMethod.GET)
	public String addProductPage(Model model) {
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("productList",productList);
		return "productList";
	}
}
