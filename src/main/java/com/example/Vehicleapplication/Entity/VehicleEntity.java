package com.example.Vehicleapplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Vehicle_Details")
public class VehicleEntity {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Vehicle_Id")
	private Integer Id;
		
	@Column(name="Vehicle_Number")
	private String vehicleNumber;
	
	@Column(name="Vehicle_Insurance")
	private boolean vehicleInsurance;
	
	@Column(name="Vehicle_Type")
	private String vehicleType;
	
	@Column(name="Rto_Division")
	private String rtoDivision;
	
	@Column(name="Rto_State")
	private String rtoState;
	
	@Column(name="Year_Of_Registration")
	private Integer yearOfRegistration;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public boolean isVehicleInsurance() {
		return vehicleInsurance;
	}

	public void setVehicleInsurance(boolean vehicleInsurance) {
		this.vehicleInsurance = vehicleInsurance;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getRtoDivision() {
		return rtoDivision;
	}

	public void setRtoDivision(String rtoDivision) {
		this.rtoDivision = rtoDivision;
	}

	public String getRtoState() {
		return rtoState;
	}

	public void setRtoState(String rtoState) {
		this.rtoState = rtoState;
	}

	public Integer getYearOfRegistration() {
		return yearOfRegistration;
	}

	public void setYearOfRegistration(Integer yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}


}
