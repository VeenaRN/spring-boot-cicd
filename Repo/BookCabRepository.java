package coms.TravelApplication.Repo;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;



import coms.TravelApplication.entities.BookCab;


public interface BookCabRepository extends JpaRepository<BookCab,Integer> {
	List<BookCab> findByCustomerId(int customerId);
}
