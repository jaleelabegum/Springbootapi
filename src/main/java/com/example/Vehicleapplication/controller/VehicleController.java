package com.example.Vehicleapplication.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.websocket.server.PathParam;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vehicleapplication.DTO.VehicleDto;
import com.example.Vehicleapplication.Entity.VehicleEntity;
import com.example.Vehicleapplication.Exception.ExceptionHandling;
import com.example.Vehicleapplication.Service.VehicleService;



	@RestController
	public class VehicleController<PersistentEntityResourceAssembler> {
		
		@Autowired
		public VehicleService vehicleService;
		//public VehicleRepository vehicle;
		
		public  VehicleController(VehicleService vehicleService) {
			// TODO Auto-generated constructor stub
			this.vehicleService=vehicleService;
		}
		
		@PostMapping("/addVehicles")
		public VehicleEntity addStudent(@RequestBody VehicleDto vehicleDto)  throws ExceptionHandling{
			return vehicleService.addVehicles(vehicleDto);
		}
		
		@GetMapping("/findAllVehicles")
		public List<VehicleEntity> getVehicle(){
			return vehicleService.findAll();
		}
		
		@DeleteMapping("/deleteAllVehicles")
		private void deleteAllStudent(){
			vehicleService.deleteAll();
		}
		
		@PutMapping("/updateVehicles")
		public VehicleEntity updateVehicle(@RequestBody VehicleDto vehicleDto) {
			return vehicleService.updateVehicleService(vehicleDto);	
		}
		
		@PostMapping("/addListOfVehicles")
		public List<VehicleEntity> listOfVehicles(@RequestBody List<VehicleDto> vehicleDto) {
			return vehicleService.listOfVehicles(vehicleDto);
		}
		
		@DeleteMapping("/vehicleById/{id}")
		private void deleteVehicle(@PathVariable("id") Integer id) throws ExceptionHandling{ 
			vehicleService.delete(id);  
		}  
		
		@DeleteMapping("/vehicleByNumber/{vehicleNumber}")
		public void deleteVehicleByVehicleNumber(@PathVariable String vehicleNumber){ 
			 vehicleService.deleteByVehicleNumber(vehicleNumber);  
		}
		
		@GetMapping("/vehicle/{vehicleNumber}")
		private Optional<VehicleEntity> getVehicleByvehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) {	
			return vehicleService.getByVehicleNumber(vehicleNumber);		
		}
		
		@GetMapping("/rtoDivision/{rtoDivision}")
		private List<VehicleEntity> getVehicleByrtoDivision(@PathVariable("rtoDivision") String rtoDivision)  {	
			return vehicleService.getVehicleDetailByRtoDivision(rtoDivision);		
		}
		
		@GetMapping("/findListOfVehicleNumber")
		public List<VehicleEntity> getVehicleNumberByRtoDivision() throws ExceptionHandling{
			return vehicleService.findByRtoDivision();
		}
		
		@GetMapping("/findVehicleInsurance/{vehicleNumber}")
		private Boolean getVehicleInsuranceByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber)  {	
			return vehicleService.getVehicleInusranceByVehicleNumber(vehicleNumber);		
		}
		
		@GetMapping("/findVehicleNumberListByRtoDivision/{rtoDivision}")
		private List<String> getVehicleNumberListByRtoDivision(@PathVariable("rtoDivision") String rtoDivision)  {	
			return vehicleService.getVehicleNumberListByRtoDivision(rtoDivision);		
		} 
		
		@GetMapping("/getVehicleGroupByDivision/{year}/{state}")
		private Map<String, List<VehicleEntity>> getVehicleGroupByDivision(@PathVariable Integer year, @PathVariable String state ){
			return vehicleService.getVehicleGroupByDivision(year,state);
		}
		
		@GetMapping("/getVehicleDetailsByDivision/{rtoDivision}")
		private Map<String, List<VehicleEntity>> getVehicleDetailsByDivision(@PathVariable  String rtoDivision ){
			return vehicleService.getVehicleDetailsByDivision(rtoDivision);
		}
		
		@PutMapping("/updateVehicleInsurance/{vehicleInsurance}")
		public List<VehicleEntity> updateVehicleInsuranceByVehicleNumber(@RequestBody List<String>vehicleNumber,@PathVariable Boolean vehicleInsurance) {
			return vehicleService.updateVehicleInsuranceByVehicleNumber(vehicleNumber,vehicleInsurance);
			
		}
		
		@GetMapping("/getListOfVehicles/{vehicleNumber}")
		private List<VehicleEntity> getAllVehicleDetailsByVehicleNumber(@PathVariable List<String>vehicleNumber){
			return vehicleService.getAllVehicleDetailsByVehicleNumber(vehicleNumber);
		}
		
		@GetMapping("/getListOfVehicleBasedOnInsurance/{vehicleInsurance}")
		private List<VehicleEntity> getAllListOfVehicleDetailsBasedOnVehicleInsurance(@PathVariable Boolean vehicleInsurance){
			return vehicleService.getAllListOfVehicleDetailsByVehicleInsurance(vehicleInsurance);
		}
		
		@PutMapping("/updateVehicleInsuranceFalse/{vehicleInsurance}")
		public List<VehicleEntity> updateVehicleInsuranceFalse(@PathVariable Boolean vehicleInsurance) {
			return vehicleService.updateVehicleInsuranceByFalseBeforeYear2000(vehicleInsurance);
			
		}
		
		}

	


