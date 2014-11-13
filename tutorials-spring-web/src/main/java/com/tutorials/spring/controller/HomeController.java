package com.tutorials.spring.controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.spring.configuration.ApplicationListenerBean;

@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("serverName",  InetAddress.getLocalHost().getHostName());

        return mav;
    }
}
