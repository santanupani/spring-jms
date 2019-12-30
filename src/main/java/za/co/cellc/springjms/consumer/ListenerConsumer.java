package za.co.cellc.springjms.consumer;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import za.co.cellc.springjms.model.MessageBean;

@Component
@EnableJms
public class ListenerConsumer {
	private final Logger logger = LoggerFactory.getLogger(ListenerConsumer.class);
	
	@JmsListener(destination = "inbound.queue")
	public void receivedMessage(MessageBean messageBean) throws JMSException{
		
		logger.info("Message received");
		
		
	}

}
