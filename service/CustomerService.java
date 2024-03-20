package coms.TravelApplication.service;

//CustomerService.java

import java.util.List;

import coms.TravelApplication.entities.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer getCustomerById(int id);

	Customer addCustomer(Customer customer);

	String updateCustomer(Customer customer);

	void deleteCustomer(int id);

	Customer getCustomerByEmailAndPassword(String email, String password);
}
