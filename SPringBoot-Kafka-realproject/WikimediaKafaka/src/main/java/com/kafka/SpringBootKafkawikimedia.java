package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkawikimedia implements CommandLineRunner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SpringApplication.run(SpringBootKafkawikimedia.class);
	}
	@Autowired
private WikiMideaChangesProducer changesProducer;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		changesProducer.sendMessage();
	}

}
