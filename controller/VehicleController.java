package coms.TravelApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import coms.TravelApplication.entities.Vehicles;
import coms.TravelApplication.service.CabFareService;
import coms.TravelApplication.service.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	VehicleService vs;

	@GetMapping("/newvehicle")
	public String NewVehicle(Model m) {
		m.addAttribute("vehicle", new Vehicles());
		return "AddVehicle";
	}

	@PostMapping("newvehicleinfo")
	public String NewVehicle(@ModelAttribute Vehicles vehicle, Model m) {
		String res = vs.AddVehicle(vehicle);
		if (res.equals("Success")) {
			m.addAttribute("info", "Vehicle is Added");
			m.addAttribute("vehicle", new Vehicles());
		}
		return "redirect:/vehicleall";
	}

	@GetMapping("vehicleall")
	public String ViewAll(Model m) {
		List<Vehicles> vehiclelist = vs.AllVehicle();
		m.addAttribute("vehiclelist", vehiclelist);
		return "ViewAllVehicle";
	}

	@GetMapping("delvehicle/{vid}")
	public String DeleteEmployee(@PathVariable int vid) {
		vs.DeleteVehicle(vid);
		return "redirect:/vehicleall";
	}

	@GetMapping("/editvehicle/{vid}")
	public String showEditForm(@PathVariable("vid") int vid, Model m) {
		Vehicles vehicle = vs.getVehicleById(vid);
		m.addAttribute("vehicle", vehicle);
		return "editVehicle";
	}

	@PostMapping("/editvehicle")
	public String editVehicle(@ModelAttribute Vehicles vehicle) {
		vs.updateVehicle(vehicle);
		return "redirect:/vehicleall";
	}

}
