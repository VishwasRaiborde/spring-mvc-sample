package com.acme.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acme.commons.constants.ACME;
import com.acme.commons.entities.product.ProductView;
import com.acme.commons.entities.profile.User;
import com.acme.commons.entities.purchaseorder.PurchaseOrder;
import com.acme.commons.entities.purchaseorder.PurchaseOrderView;
import com.acme.services.product.BasketException;
import com.acme.services.product.IProduct;
import com.acme.services.product.ProductException;
import com.acme.services.purchaseorder.CartException;
import com.acme.services.purchaseorder.IPurchaseOrder;

@Controller
public class PurchaseOrderController {

	@Autowired
	@Qualifier("PurchaseOrderImpl")
	IPurchaseOrder iPurchaseOrder;
	
	@Autowired
	@Qualifier("ProductImpl")
	IProduct iProduct;
	
	static final Logger errorLog = Logger.getLogger("reportsLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");

	@RequestMapping("/addToCart")
	public String showDetails(Model model,Principal principal,HttpSession session,
			@RequestParam("id") long id,
			@RequestParam("qty") Integer qty,
			@RequestParam("supplierId") Integer supplierId) {
		
		if(principal == null){
			return "login" ;
		}
		

		try {

			PurchaseOrder purchaseOrder = new PurchaseOrder();
			User user  = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			purchaseOrder.setProductId(id);
			purchaseOrder.setQuantity(qty);
			purchaseOrder.setSupplierId(supplierId);
			purchaseOrder.setUserID(user.getUserID());
			purchaseOrder.setTransactionTime(new Date());
			
			iPurchaseOrder.saveOrUpdatePurchaseOrder(purchaseOrder);
			
			// back to the same details page after saving the order
			List<ProductView> productDetails = (List<ProductView>)iProduct.getProductDetails(id);
			
			model.addAttribute("productDetails", productDetails);
			model.addAttribute(ACME.MESSAGE, ACME.MESSAGE_SUCCESS_CART_SAVED);
	
			return "displayDetails";
			
		} catch (CartException e) {
			
			model.addAttribute(ACME.MESSAGE, ACME.MESSAGE_FAILURE_CART_SAVED);	
			return "displayDetails";
			
		} catch (ProductException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			model.addAttribute(ACME.MESSAGE, ACME.MESSAGE_FAILURE_PRODUCT_DETAILS);	
			return "displayDetails";
		}
		
	}
	
	
	@RequestMapping(value = "/getCart")
	public String getCart(Model model, Principal principal) {
		
		if(principal == null){
			return "login" ;
		}
		
		try {
			User user  = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if(user != null){
				
				List<PurchaseOrderView>  purchaseOrderView = iProduct.getBasketByUserId(user.getUserID());
				if(purchaseOrderView != null && purchaseOrderView.size() > 0){

					model.addAttribute("purchaseOrders",purchaseOrderView);
				
				}else{
					
					model.addAttribute("purchaseOrders",purchaseOrderView);
					model.addAttribute(ACME.MESSAGE,ACME.MESSAGE_CART_EMPTY);
				}
				
			}
			
		} catch (BasketException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			return ACME.GLOBAL_ERROR_PAGE;
		}
		return "cartDetails";
		
	}
	@RequestMapping(value = "/removeOrder")
	public String removeOrder(
			Model model,
			@RequestParam("orderID") long orderID,
			@RequestParam("id") long id,
			Principal principal) {
		
		if(principal == null){
			return "login" ;
		}
		
		try {
			
			iProduct.removeProductFromCart(orderID);
			User user  = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if(user != null){
				List<PurchaseOrderView>  purchaseOrder = iProduct.getBasketByUserId(user.getUserID());
				model.addAttribute("purchaseOrders",purchaseOrder);
			
			}
			
		} catch (BasketException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			
			return ACME.GLOBAL_ERROR_PAGE;
		} catch (ProductException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			return ACME.GLOBAL_ERROR_PAGE;
		}
		return "cartDetails";
		
	}
}