package coms.TravelApplication.service;

import java.util.List;

//import coms.TravelApplication.entities.CabFares;
import coms.TravelApplication.entities.Vehicles;

public interface VehicleService {

	public String AddVehicle(Vehicles vehicle);

	public List<Vehicles> AllVehicle();

	public void DeleteVehicle(int vid);

	Vehicles getVehicleById(int vid);

	void updateVehicle(Vehicles vehicle);
}
