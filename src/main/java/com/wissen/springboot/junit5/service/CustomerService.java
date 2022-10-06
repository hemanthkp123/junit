package com.wissen.springboot.junit5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wissen.springboot.junit5.customer.Customer;
@Service
public class CustomerService {
	final List<Customer> customers = new ArrayList<>();

	public CustomerService() {
		customers.add(new Customer("hemanth", "abcd1234"));
		customers.add(new Customer("kumar", "defg1234"));
		customers.add(new Customer("Shiva", "tyu789"));
		customers.add(new Customer("Bharath", "hgdsah1234"));
		customers.add(new Customer("Raghu", "dhgsui1234"));
	}

	public boolean verifyValidCustomer(String userId, String password) {
		return customers.stream().anyMatch(cust -> cust.equals(new Customer(userId, password)));
	}
}
