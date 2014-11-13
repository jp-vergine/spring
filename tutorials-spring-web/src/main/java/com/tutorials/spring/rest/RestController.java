package com.tutorials.spring.rest;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static final String template = "Hello, %s %s!";
    private final AtomicLong counter = new AtomicLong();

    
    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces={"application/json"})
    public @ResponseBody Greeting greeting(@RequestParam(value="civility", defaultValue="M.") String civility, @RequestParam(value="name", defaultValue="World") String name, HttpServletRequest request) {
    	return new Greeting(counter.incrementAndGet(), String.format(template, civility, name));
    }
    
    
    @RequestMapping("/restConsumer")
	public @ResponseBody Page detectDevice(HttpServletRequest request){
    	RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("http://graph.facebook.com/pivotalsoftware", Page.class);
        
        return page;
	}
}