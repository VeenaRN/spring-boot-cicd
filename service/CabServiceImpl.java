package coms.TravelApplication.service;

//import java.util.HashMap;

import java.util.List;

//import java.util.Map;
import java.util.Optional;

//import org.hibernate.sql.results.ResultsLogger_.logger;
//import org.hibernate.boot.jaxb.JaxbLogger_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.TravelApplication.Repo.CabFareRepository;
import coms.TravelApplication.entities.CabFares;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;

@Service
public class CabServiceImpl implements CabFareService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	CabFareRepository cr;

	@Override
	public String AddFare(CabFares cabfare) {

		CabFares c = cr.save(cabfare);// save into db
		if (c != null)
			return "Success";
		return "Err";
	}

	@Override
	public List<CabFares> FareAll() {

		List<CabFares> cablist = cr.findAll();

		return cablist;
	}

	@Override
	public void DeleteFare(int cid) {
		cr.deleteById(cid);

	}

	@Override
	public CabFares getFareById(int cid) {
		Optional<CabFares> optionalCabFare = cr.findById(cid);
		if (optionalCabFare.isPresent()) {
			return optionalCabFare.get();
		} else {
			return null;
		}
	}

	@Override
	public void updateFare(CabFares cabfare) {
		cr.save(cabfare);

	}

}
