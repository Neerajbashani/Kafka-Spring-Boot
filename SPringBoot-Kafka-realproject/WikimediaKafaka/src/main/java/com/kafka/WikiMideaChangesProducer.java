package com.kafka;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

import okio.Timeout;

@Service
public class WikiMideaChangesProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikiMideaChangesProducer.class);

	private KafkaTemplate<String, String> kafkaTemplate;

	public WikiMideaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage() throws InterruptedException {

		String topic = "wikimidea-recantChange";

		// to read real time stream data for we use event source

		EventHandler even = new WikimediaChangesHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange/";
		EventSource.Builder builder = new EventSource.Builder(even, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		TimeUnit.MINUTES.sleep(10);
		
	}

}
