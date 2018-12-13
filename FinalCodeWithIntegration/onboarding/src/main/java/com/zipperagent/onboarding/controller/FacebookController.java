package com.zipperagent.onboarding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/facebook")

public class FacebookController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView facebook()
	{
		return new ModelAndView("index");
	}

}
