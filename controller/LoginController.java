
package coms.TravelApplication.controller;

import coms.TravelApplication.entities.Customer;

import coms.TravelApplication.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("customerId")
public class LoginController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/login")
	public String showLoginForm() {
		return "Login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		if (email.equals("admin@gmail.com") && password.equals("admin")) {
			return "redirect:/admindashboard";
		}

		Customer customer = customerService.getCustomerByEmailAndPassword(email, password);
		if (customer != null) {
			session.setAttribute("customerId", customer.getId());

			return "redirect:/customerdashboard";

		} else {

			model.addAttribute("error", "Invalid email or password");
			return "Login";
		}
	}

	@GetMapping("/customerdashboard")
	public String customerDashboard(Model model) {
		return "CustomerDashboard";
	}

	@GetMapping("/admindashboard")
	public String adminDashboard(Model model) {
		return "AdminDashboard";
	}
}
