package org.kafka.producer.wikimedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SpringApplication.run(SpringBootProducerApplication.class); 
        
    }
}
