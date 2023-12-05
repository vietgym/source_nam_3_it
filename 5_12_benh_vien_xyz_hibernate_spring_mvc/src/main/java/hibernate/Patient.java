package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_tbl")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="hospital_fee")
	private Double hospitalfee;
	
	public Patient() {

	}
	public Patient(String name) {
		this.name = name;
	}
	public Patient(String name, Double hospitalfee) {
		this.name = name;
		this.hospitalfee = hospitalfee;
	}
	public Patient(int id, String name, Double hospitalfee) {
		this.id = id;
		this.name = name;
		this.hospitalfee = hospitalfee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void name(String name) {
		this.name = name;
	}
	public Double getHospitalfee() {
		return hospitalfee;
	}
	public void hospitalfee(Double hospitalfee) {
		this.hospitalfee = hospitalfee;
	}
	@Override
	public String toString() {
		return "patient [id=" + id + ", name=" + name + ", hospitallFee=" + hospitalfee+ "]";
	}
}

