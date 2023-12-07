package com.example.Vehicleapplication.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.Vehicleapplication.DTO.VehicleDto;
import com.example.Vehicleapplication.Entity.VehicleEntity;
import com.example.Vehicleapplication.Exception.ExceptionHandling;

public interface VehicleService {
	VehicleEntity addVehicles(VehicleDto vehicleDto) throws ExceptionHandling;

	void deleteAll();

	VehicleEntity updateVehicleService(VehicleDto vehicleDto);

	List<VehicleEntity> listOfVehicles(List<VehicleDto> vehicleDto);

	void delete(Integer id);

	Optional<VehicleEntity> getByVehicleNumber(String vehicleNumber);

	List<VehicleEntity> getVehicleDetailByRtoDivision(String rtoDivision);



	void deleteByVehicleNumber(String vehicleNumber);

	List<VehicleEntity> findAll();
	
	List<VehicleEntity> findByRtoDivision();

	//List<VehicleEntity> findByRtoDivision(List<VehicleDto> vehicleDto);

	Boolean getVehicleInusranceByVehicleNumber(String vehicleNumber);
	
	List<String> getVehicleNumberListByRtoDivision(String rtoDivision );

	Map<String, List<VehicleEntity>> getVehicleGroupByDivision(Integer year, String state);

	Map<String, List<VehicleEntity>> getVehicleDetailsByDivision(String rtoDivision);

	//VehicleEntity updateVehicleInsuranceByVehicleNumber(String vehicleNumber, String vehicleInsurance);

	List<VehicleEntity> updateVehicleInsuranceByVehicleNumber(List<String> vehicleNumber, Boolean vehicleInsurance);

	List<VehicleEntity> getAllVehicleDetailsByVehicleNumber(List<String> vehicleNumber);

	List<VehicleEntity> getAllListOfVehicleDetailsByVehicleInsurance(Boolean vehicleInsurance);

	List<VehicleEntity> updateVehicleInsuranceByFalseBeforeYear2000(Boolean vehicleInsurance);



}
