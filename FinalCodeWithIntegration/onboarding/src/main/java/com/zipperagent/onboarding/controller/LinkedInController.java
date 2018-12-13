package com.zipperagent.onboarding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/linkedIn")
public class LinkedInController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView linkedin()
	{
		return new ModelAndView("auth");
	}
}
