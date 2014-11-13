package com.tutorials.spring.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class ScheduledTasks implements ApplicationListener<BrokerAvailabilityEvent>{

	@Autowired
	private MessageSendingOperations<String> messagingTemplate;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    	
    @Scheduled(fixedRate = 5000)
    public void run() {
    	this.messagingTemplate.convertAndSend("/scheduledTasks", "The time is now " + dateFormat.format(new Date()));
    }



	public void onApplicationEvent(BrokerAvailabilityEvent event) {
		// TODO Auto-generated method stub
	}
}