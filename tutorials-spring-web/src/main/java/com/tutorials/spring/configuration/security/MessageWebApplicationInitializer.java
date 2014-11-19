package com.tutorials.spring.configuration.security;
//
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MessageWebApplicationInitializer  {

	
}

/*
public class MessageWebApplicationInitializer extends  AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebApplicationContext.class };
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[] { "/" };
	}

	// ... other overrides ...
}*/
