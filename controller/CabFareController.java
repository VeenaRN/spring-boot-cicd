package coms.TravelApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import coms.TravelApplication.entities.CabFares;
import coms.TravelApplication.service.CabFareService;

@Controller

public class CabFareController {

	@Autowired
	CabFareService cs;

	@GetMapping("/newfare")
	public String Newfare(Model m) {
		m.addAttribute("fare", new CabFares());
		return "AddFare";
	}

	@PostMapping("newfareinfo")
	public String Newfare(@ModelAttribute CabFares fare, Model m) {
		String res = cs.AddFare(fare);
		if (res.equals("Success")) {
			m.addAttribute("info", "Cab Fare is Added");
			m.addAttribute("fare", new CabFares());
		}
		return "redirect:/fareall";
	}

	@GetMapping("fareall")
	public String ViewAll(Model m) {
		List<CabFares> farelist = cs.FareAll();
		m.addAttribute("farelist", farelist);
		return "ViewAllFare";
	}

	@GetMapping("delfare/{cid}")
	public String DeleteEmployee(@PathVariable int cid) {
		cs.DeleteFare(cid);
		return "redirect:/fareall";
	}

	@GetMapping("/editfare/{cid}")
	public String showEditForm(@PathVariable("cid") int cid, Model m) {
		CabFares cabFare = cs.getFareById(cid);
		m.addAttribute("fare", cabFare);
		return "editFare";
	}

	@PostMapping("/editfare")
	public String editFare(@ModelAttribute CabFares cabFare) {
		cs.updateFare(cabFare);
		return "redirect:/fareall";
	}

}
