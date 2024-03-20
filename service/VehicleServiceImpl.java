package coms.TravelApplication.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.TravelApplication.Repo.VehiclesRepository;

import coms.TravelApplication.entities.Vehicles;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehiclesRepository vr;

	@Override
	public String AddVehicle(Vehicles vehicle) {

		Vehicles v = vr.save(vehicle);
		if (v != null)
			return "Success";
		return "Err";
	}

	@Override
	public List<Vehicles> AllVehicle() {
		List<Vehicles> vehiclelist = vr.findAll();
		return vehiclelist;
	}

	@Override
	public void DeleteVehicle(int vid) {
		vr.deleteById(vid);

	}

	@Override
	public Vehicles getVehicleById(int vid) {
		Optional<Vehicles> optionalVehicle = vr.findById(vid);
		if (optionalVehicle.isPresent()) {
			return optionalVehicle.get();
		} else {
			return null;
		}

	}

	@Override
	public void updateVehicle(Vehicles vehicle) {
		vr.save(vehicle);

	}

}
