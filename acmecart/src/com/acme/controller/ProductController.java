package com.acme.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acme.commons.constants.ACME;
import com.acme.commons.entities.product.Product;
import com.acme.commons.entities.product.ProductView;
import com.acme.services.product.IProduct;
import com.acme.services.product.ProductException;

@Controller
public class ProductController {


	static final Logger errorLog = Logger.getLogger("reportsLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");
	
	@Autowired
	@Qualifier("ProductImpl")
	IProduct iProduct;

	@RequestMapping("/product")
	public String getProducts(Model model) {

		List<Product> books = null;
		List<Product> games = null;

		try {

			books = iProduct.getProductsByCategory(1000);
			games = iProduct.getProductsByCategory(1001);

			model.addAttribute("books", books);
			model.addAttribute("games", games);
			
			if(infoLog.isInfoEnabled()){
				infoLog.info("Fetched products as per categories");
			}

			return "productList";

		} catch (ProductException e) {
			
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}

			return ACME.GLOBAL_ERROR_PAGE;
	}
		
	}

	@RequestMapping("/showDetails")
	public String showDetails(Model model, Principal principal , @RequestParam("id") long id) {
		if(principal == null){
			return "login" ;
		}
		try {

			List<ProductView> productDetails = (List<ProductView>) iProduct.getProductDetails(id);
			model.addAttribute("productDetails", productDetails);
			
			if(infoLog.isInfoEnabled()){
				infoLog.info("Fetched products Details");
			}
			
			return "displayDetails";

		} catch (ProductException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			return ACME.GLOBAL_ERROR_PAGE;

		}

	}

}
