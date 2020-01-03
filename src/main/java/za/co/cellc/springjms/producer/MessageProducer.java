package za.co.cellc.springjms.producer;

import java.util.Map;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import za.co.cellc.springjms.model.MessageBean;

@RestController
public class MessageProducer {
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping(value="/message")
	public ResponseEntity<String> publish(@RequestBody MessageBean messageBean){
		
		jmsTemplate.convertAndSend(queue, messageBean);
		
		return new ResponseEntity(messageBean, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/createMessage")
	public ResponseEntity<String> createMsg(@RequestBody MessageBean messageBean){
		return null;
		
	}
	
	@RequestMapping("/")
    public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
        return modelAndView;
    }

}
