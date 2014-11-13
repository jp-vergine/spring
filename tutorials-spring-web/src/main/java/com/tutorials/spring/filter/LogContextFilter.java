package com.tutorials.spring.filter;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;


public class LogContextFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		MDC.put("hostname",  InetAddress.getLocalHost().getHostName());
		MDC.put("remoteaddr", request.getRemoteAddr());

		if (session != null) {
			String user = (String) session.getAttribute("user");
			MDC.put("user", user);
		}

		try {
			chain.doFilter(httpRequest, httpResponse);
		} finally {
			MDC.clear();
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
