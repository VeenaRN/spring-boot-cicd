package coms.TravelApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cab_fares")
public class CabFares {

	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	// @Column(name="going_from")
	private String fromloc;

	// @Column(name="going_to")
	private String toloc;

	private int fare;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFromloc() {
		return fromloc;
	}

	public void setFromloc(String fromloc) {
		this.fromloc = fromloc;
	}

	public String getToloc() {
		return toloc;
	}

	public void setToloc(String toloc) {
		this.toloc = toloc;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

}
