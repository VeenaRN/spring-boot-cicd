package coms.TravelApplication.service;

import java.util.List;

import coms.TravelApplication.entities.BookCab;
import coms.TravelApplication.entities.CabFares;

public interface BookCabService {
	// changed
	String addBookCab(BookCab bookCab);

	List<BookCab> listBookCabs();

	void deleteBookCab(int bid);

	List<BookCab> getBookingsByCustomerId(int customerId);

	public BookCab getBookingById(int bid);

}
