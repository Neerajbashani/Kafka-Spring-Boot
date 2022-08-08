package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangesHandler implements EventHandler{

	private String topic;
	public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate,String topic) {
	this.topic=topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	private KafkaTemplate<String, String> kafkaTemplate;

	private static final Logger logger=LoggerFactory.getLogger(WikimediaChangesHandler.class);
	
	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Event handle"+messageEvent.getData());
		kafkaTemplate.send(topic,messageEvent.getData());
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
