package za.co.cellc.springjms.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJms
@Configuration
public class JmsConfig {	
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("inbound.queue");
	}
	
	
	
}
