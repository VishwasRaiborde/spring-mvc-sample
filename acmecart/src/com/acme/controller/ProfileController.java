package com.acme.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acme.commons.constants.ACME;
import com.acme.commons.entities.profile.CompanyUserEx;
import com.acme.commons.entities.profile.PersonUserEx;
import com.acme.commons.entities.profile.User;
import com.acme.services.profile.IProfile;
import com.acme.services.profile.InvalidProfileException;
import com.acme.services.profile.ProfileException;

@Controller
public class ProfileController {

	

	@Autowired
	@Qualifier("ProfileImpl")
	IProfile iProfile;
	
	static final Logger errorLog = Logger.getLogger("reportsLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");
	

	@RequestMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		if(principal == null){
			return "login" ;
		}
		try {

			User securedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("userID",   securedUser.getUserID());
			model.addAttribute("userName", securedUser.getUsername());
			model.addAttribute("password", securedUser.getPassword());
			
			User user = iProfile.getUserByID(securedUser.getUserID());
			model.addAttribute("user", user);

		} catch (InvalidProfileException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			return ACME.GLOBAL_ERROR_PAGE;

		}
		return "profile";
	}

	@RequestMapping("/saveProfile")
	public String saveProfile(Model model, Principal principal,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,

			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,

			@RequestParam("companyName") String companyName,
			@RequestParam("vatNo") String vatNo,

			@RequestParam("type") String type) {

		if(principal == null){
			return "login" ;
		}
		User securedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {

			securedUser = iProfile.getUserByID(securedUser.getUserID());
			
			
			if (securedUser instanceof PersonUserEx) {

				PersonUserEx person = (PersonUserEx) securedUser;
				person.setUserName(userName);
				person.setPassword(password);

				person.setFirstName(firstName);
				person.setLastName(lastName);
				iProfile.saveUpdateProfile(person);
				
				PersonUserEx personRetrieved = (PersonUserEx)iProfile.getUserByID(securedUser.getUserID());
				model.addAttribute("user", personRetrieved);
				model.addAttribute("userID",   personRetrieved.getUserID());
				model.addAttribute("userName", personRetrieved.getUsername());
				model.addAttribute("password", personRetrieved.getPassword());
				
				model.addAttribute(ACME.MESSAGE, ACME.MESSAGE_SUCCESS_USER_SAVED);
				return "profile";

			} else if (securedUser instanceof CompanyUserEx) {

				CompanyUserEx company = (CompanyUserEx) securedUser;

				company.setUserName(userName);
				company.setPassword(password);

				company.setCompanyName(companyName);
				company.setVatNo(Integer.parseInt(vatNo));
				iProfile.saveUpdateProfile(company);
				
				CompanyUserEx companyRetrieved = (CompanyUserEx)iProfile.getUserByID(securedUser.getUserID());
				model.addAttribute("user", companyRetrieved);
				model.addAttribute("userID",   companyRetrieved.getUserID());
				model.addAttribute("userName", companyRetrieved.getUsername());
				model.addAttribute("password", companyRetrieved.getPassword());
				
				model.addAttribute(ACME.MESSAGE, ACME.MESSAGE_SUCCESS_USER_SAVED);
				return "profile";
			}

		} catch (ProfileException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			model.addAttribute(ACME.MESSAGE, ACME.MESSAGE_FAILURE_USER_SAVED);
			return "profile";

		} catch (InvalidProfileException e) {
			if(errorLog.isTraceEnabled()){
				errorLog.error(e.getMessage());
			}
			model.addAttribute(ACME.MESSAGE, ACME.MESSAGE_FAILURE_USER_SAVED);
			return "profile";
		}
		return "profile";
		
	}

}
