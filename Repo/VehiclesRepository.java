package coms.TravelApplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.TravelApplication.entities.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles,Integer>{

}
