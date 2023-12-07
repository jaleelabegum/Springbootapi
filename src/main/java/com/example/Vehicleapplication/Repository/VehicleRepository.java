package com.example.Vehicleapplication.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Vehicleapplication.Entity.VehicleEntity;
@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
	@Query(value = "select count(*) from vehicle_details where vehicle_number = ? ", nativeQuery = true)
    Integer checkVehicleNumberAlreadyExists(String vehicleNumber);

	Optional<VehicleEntity> findByVehicleNumber(String vehicleNumber);

	List<VehicleEntity> findByRtoDivision(String rtoDivision);
	
	@Modifying
	void deleteByvehicleNumber(String vehicleNumber);
    
	@Query(value = "select vehicle_insurance from vehicle_details where vehicle_number = ?" , nativeQuery = true)
	Boolean  getVehicleInsurance(String vehicleNumber);
	
	@Query(value = "select vehicle_number from vehicle_details where rto_division = ?" , nativeQuery = true)
	List<String> getVehicleNumberListByRtoDivision(String rtoDivision );
	
	@Query(value = "select * from vehicle_details where year_of_registration =? and rto_state = ?",nativeQuery = true)
	List<VehicleEntity> getVehicleGroupByDivision(Integer year, String state);
    
	@Query(value = "select * from vehicle_details where rto_division = ?",nativeQuery = true)
	List<VehicleEntity> getVehicleDetailsByDivision(String rtoDivision);
    
	@Query(value="select * from vehicle_details where vehicle_number in (:vehicleNumber)",nativeQuery = true)
	List<VehicleEntity> findAllByvehicleNumber(List<String> vehicleNumber);
    
	@Query(value = "select * from vehicle_details where vehicle_number in (:vehicleNumber)",nativeQuery=true)
	List<VehicleEntity> findAllVehicleByVehicleNumber(List<String> vehicleNumber);
    
	@Query(value = "select * from vehicle_details where vehicle_insurance in (:vehicleInsurance)",nativeQuery = true)
	List<VehicleEntity> findAllVehicleByVehicleInsurance(Boolean vehicleInsurance);
    
	@Query(value = "select * from vehicle_details where year_of_registration <2000",nativeQuery=true )
	List<VehicleEntity> updateAllVehicleFlaseBeforeYear2000(Boolean vehicleInsurance);


}
