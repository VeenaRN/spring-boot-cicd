package coms.TravelApplication.controller;

import coms.TravelApplication.entities.Customer;

import coms.TravelApplication.service.CustomerService;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/newcustomer")
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "AddCustomer";
	}

	@PostMapping("/newcustomerinfo")
	public String addCustomer(@ModelAttribute Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/viewallcustomers";
	}

	@GetMapping("/registration")
	public String regNewCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "CustomerRegistration";
	}

	@PostMapping("/customerreg")
	public String regCustomer(@ModelAttribute Customer customer, HttpSession session) {
		Customer savedCustomer = customerService.addCustomer(customer);
		session.setAttribute("customerId", savedCustomer.getId());
		session.setAttribute("customerName", savedCustomer.getName());
		return "CustomerDashboard";
	}

	@GetMapping("/viewallcustomers")
	public String viewAllCustomers(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "ViewAllCustomers";
	}

	@GetMapping("/updatecustomer/{id}")
	public String updateCustomerForm(@PathVariable int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		if (customer != null) {
			model.addAttribute("customer", customer);
			return "UpdateCustomer";
		}
		return "redirect:/viewallcustomers";
	}

	@PostMapping("/updatecustomerinfo")
	public String updateCustomer(@ModelAttribute Customer customer) {
		customerService.updateCustomer(customer);
		return "redirect:/viewallcustomers";
	}

	@GetMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		return "redirect:/viewallcustomers";
	}
}
