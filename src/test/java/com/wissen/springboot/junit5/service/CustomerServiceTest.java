package com.wissen.springboot.junit5.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceTest {
	@Autowired
	CustomerService customerService;
	@Test
	void verifyValidCustomerTest() {
		assertTrue(customerService.verifyValidCustomer("hemanth","abcd1234"));
	}

	@Test
	void verifyInValidCustomerTest() {
		assertFalse(customerService.verifyValidCustomer("Chandan","abcd1234"));
	}
}
