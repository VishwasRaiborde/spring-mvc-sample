package com.acme.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	static final Logger errorLog = Logger.getLogger("reportsLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model,HttpSession session) {
		
		return "login";
	}

	@RequestMapping(value = "/failed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/error")
	public ModelAndView getErrorPage(@RequestParam("error") String error) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("errorMsg", error);
		return new ModelAndView("error", model);
	}
}
