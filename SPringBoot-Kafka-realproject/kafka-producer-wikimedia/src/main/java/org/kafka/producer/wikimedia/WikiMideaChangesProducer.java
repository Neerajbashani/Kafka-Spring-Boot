package org.kafka.producer.wikimedia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikiMideaChangesProducer {

	
	private static final Logger LOGGER =LoggerFactory.getLogger(WikiMideaChangesProducer.class);
	
	
	
	
	private KafkaTemplate<String, String> kafkaTemplate;


	public WikiMideaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
	
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage() {
		
		String topic="wikimidea-recantChange";
	}
	
	
}
