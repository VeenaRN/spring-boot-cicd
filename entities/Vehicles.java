package coms.TravelApplication.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vehicles")
public class Vehicles {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vid;
	
	//@Column(name="vehicle_name")
	private String name;
	
	//@Column(name="vehicle_number")
	private int number;
	
	//@Column(name="owner_name")
	private String ownname;
	
	//@Column(name="number_of_seatings")
	private int seating;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getOwnname() {
		return ownname;
	}

	public void setOwnname(String ownname) {
		this.ownname = ownname;
	}

	public int getSeating() {
		return seating;
	}

	public void setSeating(int seating) {
		this.seating = seating;
	}

	
	
	

}
