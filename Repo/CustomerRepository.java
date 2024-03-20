package coms.TravelApplication.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coms.TravelApplication.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByEmailAndPassword(String email, String password);
}
