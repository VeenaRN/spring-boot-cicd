package coms.TravelApplication.service;

import coms.TravelApplication.Repo.CustomerRepository;
import coms.TravelApplication.entities.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		return customerOptional.orElse(null);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public String updateCustomer(Customer customer) {
		if (customerRepository.existsById(customer.getId())) {
			Customer updatedCustomer = customerRepository.save(customer);
			return updatedCustomer != null ? "Success" : "Error";
		}
		return "Customer not found";
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer getCustomerByEmailAndPassword(String email, String password) {
		return customerRepository.findByEmailAndPassword(email, password);
	}

}
