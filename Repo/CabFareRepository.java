package coms.TravelApplication.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import coms.TravelApplication.entities.CabFares;

@Repository
public interface CabFareRepository extends JpaRepository<CabFares,Integer>{
	 
	 
	

}
