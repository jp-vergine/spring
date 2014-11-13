package com.tutorials.spring.configuration;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerBean {

	private final Logger logger = LoggerFactory.getLogger(ApplicationListenerBean.class);
			
	@Autowired
	private ApplicationContext appContext;
	    
	 
    @PostConstruct
    public void onApplicationConstruct() {
    	
    	logger.debug("Post construct launch");
    	
//    	Map<String,Object> beans = appContext.getBeansWithAnnotation(EnableScheduling.class);
//    	if(beans==null)
//    		logger.debug("no bean found");
//    	else{
//    		for(Entry<String, Object>entry:beans.entrySet()){
//    			logger.debug(entry.getValue());
//    		}
//    	}
//    	
//    	 Object obj = appContext.getBean("scheduledTasks");
    	
    	
    	logger.debug("Post construct completed");
    }
}