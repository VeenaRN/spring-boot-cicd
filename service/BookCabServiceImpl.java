package coms.TravelApplication.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.TravelApplication.Repo.BookCabRepository;
import coms.TravelApplication.entities.BookCab;
import coms.TravelApplication.entities.CabFares;

@Service
public class BookCabServiceImpl implements BookCabService {

	@Autowired
	BookCabRepository br;

	@Override
	public String addBookCab(BookCab bookCab) {

		try {
			br.save(bookCab);
			return "Success";

		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	@Override
	public List<BookCab> listBookCabs() {
		// TODO Auto-generated method stub
		return br.findAll();
	}

	@Override
	public void deleteBookCab(int bid) {
		br.deleteById(bid);

	}

//	@Override
//	public List<BookCab> getBookingByCustomerId(int bid) {
//		return br.findByCustomerId(bid);
//	}

	@Override
	public BookCab getBookingById(int bid) {
		Optional<BookCab> bookOptional = br.findById(bid);
		return bookOptional.orElse(null);
	}

	@Override
	public List<BookCab> getBookingsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return br.findByCustomerId(customerId);
	}

}
