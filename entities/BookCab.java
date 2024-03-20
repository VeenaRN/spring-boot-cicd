package coms.TravelApplication.entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookCab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;

	private Integer customerId;

	private String date;

	@ManyToOne
	@JoinColumn(name = "from_id", referencedColumnName = "cid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CabFares fromloc;

	@ManyToOne
	@JoinColumn(name = "to_id", referencedColumnName = "cid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CabFares toloc;

	@ManyToOne
	@JoinColumn(name = "vehicle_num", referencedColumnName = "vid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Vehicles vno;

	private String custname;

	private int phone;

	private int fare;

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public CabFares getFromloc() {
		return fromloc;
	}

	public void setFromloc(CabFares fromloc) {
		this.fromloc = fromloc;
	}

	public CabFares getToloc() {
		return toloc;
	}

	public void setToloc(CabFares toloc) {
		this.toloc = toloc;
	}

	public Vehicles getVno() {
		return vno;
	}

	public void setVno(Vehicles vno) {
		this.vno = vno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		// return "[" + fromloc + ", " + toloc + "]";
		return "Cab is booked from " + fromloc + " to " + toloc + " successfully.";
		// return fromloc ;
	}
//	

}
