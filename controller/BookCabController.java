package coms.TravelApplication.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import coms.TravelApplication.Repo.CabFareRepository;
import coms.TravelApplication.entities.BookCab;
import coms.TravelApplication.entities.CabFares;
import coms.TravelApplication.entities.Customer;
import coms.TravelApplication.entities.Vehicles;
import coms.TravelApplication.service.BookCabService;
import coms.TravelApplication.service.CabFareService;
import coms.TravelApplication.service.CustomerService;
import coms.TravelApplication.service.VehicleService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookCabController {

	@Autowired
	BookCabService bs;

	@Autowired
	CabFareService cs;

	@Autowired
	CustomerService customerservice;;

	@Autowired
	CabFareRepository cr;

	@Autowired
	VehicleService vs;

	@GetMapping("/addBookCab")
	public String showAddBookCabForm(Model m) {
		m.addAttribute("bookCab", new BookCab());
		m.addAttribute("farelist", cs.FareAll());
		m.addAttribute("vehicles", vs.AllVehicle());

		return "addBookCab";
	}

	@PostMapping("/addBookCab")
	public String addBookCab(@ModelAttribute BookCab bookCab, RedirectAttributes redirectAttributes) {

		bs.addBookCab(bookCab);

		String successMessage = "Cab Booked Successfully!";
		redirectAttributes.addFlashAttribute("successMessage", successMessage);
		return "redirect:/addBookCab";
	}

	@GetMapping("/listBookCabs")
	public String listBookCabs(Model model) {
		List<BookCab> bookCabs = bs.listBookCabs();
		model.addAttribute("bookCabs", bookCabs);
		return "listBookCabs";
	}

	@GetMapping("/deleteBookCab/{bid}")
	public String deleteBookCab(@PathVariable int bid) {
		bs.deleteBookCab(bid);
		return "redirect:/listBookCabs";

	}

}
