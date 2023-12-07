package com.example.Vehicleapplication.DTO;

public class VehicleDto {
	private Integer Id;
	private String VehicleNumber;
	private boolean VehicleInsurance;
	private String VehicleType;
	private String RtoDivision;
	private String RtoState;
	private Integer YearOfRegistration;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getVehicleNumber() {
		return VehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.VehicleNumber = vehicleNumber;
	}
	
	public void setVehicleInsurance(boolean vehicleInsurance) {
		this.VehicleInsurance = vehicleInsurance;
	}
	
	public boolean isVehicleInsurance() {
		return VehicleInsurance;
	}
	public String getVehicleType() {
		return VehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.VehicleType = vehicleType;
	}
	public String getRtoDivision() {
		return RtoDivision;
	}
	public void setRtoDivision(String rtoDivision) {
		this.RtoDivision = rtoDivision;
	}
	public String getRtoState() {
		return RtoState;
	}
	public void setRtoState(String rtoState) {
		this.RtoState = rtoState;
	}
	public Integer getYearOfRegistration() {
		return YearOfRegistration;
	}
	public void setYearOfRegistration(Integer yearOfRegistration) {
		this.YearOfRegistration = yearOfRegistration;
	}	
}



