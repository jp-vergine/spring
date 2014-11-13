package com.tutorials.spring.controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/login")
    public RedirectView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RedirectView redirectView = new RedirectView("/loginurlredirection", true, false);
		redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		return redirectView;
	}

	
	@RequestMapping(value = "/loginurlredirection")
	public ModelAndView masuperurlquiachangetologinpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		logger.debug("redirection detected");
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("serverName", InetAddress.getLocalHost().getHostName());

		return mav;
	}
}
