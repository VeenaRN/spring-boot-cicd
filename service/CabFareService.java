package coms.TravelApplication.service;

import java.util.List;

import java.util.Map;

import coms.TravelApplication.entities.CabFares;

public interface CabFareService {

	public String AddFare(CabFares cabfare);

	public List<CabFares> FareAll();

	public void DeleteFare(int cid);

	CabFares getFareById(int cid);

	void updateFare(CabFares cabfare);

}
