package in.sharmait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sharmait.model.Customer;
import in.sharmait.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * This method is used to Customer records in post request
	 * @param customers
	 * @return
	 */
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody List<Customer> customers) {
		return customerService.add(customers);
	}
}
