package in.sharmait.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import in.sharmait.model.Customer;
import in.sharmait.util.KafkaConstants;


@Service
public class CustomerService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public String add(List<Customer> customers) {
		if(!customers.isEmpty()) {
			for (Customer c : customers) {
				kafkaTemplate.send(KafkaConstants.TOPIC, c);
				System.out.println("************Msg published to Kafka topic***************");
			}//for loop
		}//if 
		return "Customer Record Added To Kafka Queue Successfully...!!!!";
	}
}
