package in.sharmait.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import in.sharmait.model.Customer;
import in.sharmait.util.KafkaConstant;

@Service("customerService")
public class CustomerService {
	
	/**
	 * This method is used to consumer messages from kafka topic
	 * 
	 * @param c
	 * @return
	 */

	@KafkaListener(topics = KafkaConstant.TOPIC, groupId = KafkaConstant.GROUP_ID)
	public List<Customer> listner(@Payload List<Customer> customer) {
		System.out.println("***Msg recieved from Kafka Topic ::" + customer);
		return customer;
	}
}
