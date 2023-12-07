package com.example.Vehicleapplication.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Vehicleapplication.DTO.VehicleDto;
import com.example.Vehicleapplication.Entity.VehicleEntity;
import com.example.Vehicleapplication.Exception.ExceptionHandling;
import com.example.Vehicleapplication.Repository.VehicleRepository;


@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	public VehicleEntity addVehicles(VehicleDto vehicleDto) throws ExceptionHandling {
		// TODO Auto-generated method stub
		if (vehicleRepository.checkVehicleNumberAlreadyExists(vehicleDto.getVehicleNumber()) > 0) {
			throw new ExceptionHandling("VehicleNumber  already Exists");
		}
	   
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicleEntity.setVehicleInsurance(vehicleDto.isVehicleInsurance());
		vehicleEntity.setVehicleType(vehicleDto.getVehicleType());
		vehicleEntity.setRtoDivision(vehicleDto.getRtoDivision());
		vehicleEntity.setRtoState(vehicleDto.getRtoState());
		vehicleEntity.setYearOfRegistration(vehicleDto.getYearOfRegistration());
		return  vehicleRepository.save(vehicleEntity);
		}

	@Override
	public List<VehicleEntity> findAll() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		vehicleRepository.deleteAll();
	}

	@Override
	public VehicleEntity updateVehicleService(VehicleDto vehicleDto) {
		// TODO Auto-generated method stub
		VehicleEntity vehicleEntity1 = vehicleRepository.findById(vehicleDto.getId()).get();
		//VehicleEntity vehicleEntity1 = new VehicleEntity();
		vehicleEntity1.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicleEntity1.setVehicleInsurance(vehicleDto.isVehicleInsurance());
		vehicleEntity1.setVehicleType(vehicleDto.getVehicleType());
		vehicleEntity1.setRtoDivision(vehicleDto.getRtoDivision());
		vehicleEntity1.setRtoState(vehicleDto.getRtoState());
		vehicleEntity1.setYearOfRegistration(vehicleDto.getYearOfRegistration());
		return  vehicleRepository.save(vehicleEntity1);
	}

	@Override
	public List<VehicleEntity> listOfVehicles(List<VehicleDto> vehicleDto) {
		// TODO Auto-generated method stub
        List<VehicleEntity> listVehicleEntity = new ArrayList<VehicleEntity>();
		
		for(VehicleDto vt: vehicleDto) {
			/*if(vehicleRepository.checkGmailALreadyExists(vt.getEmail()) > 0) {
				throw new ExceptionHandling("Email already Exists");
			}*/
			VehicleEntity vehicleEntity1 = new VehicleEntity();
			vehicleEntity1.setVehicleNumber(vt.getVehicleNumber());
			vehicleEntity1.setVehicleInsurance(vt.isVehicleInsurance());
			vehicleEntity1.setVehicleType(vt.getVehicleType());
			vehicleEntity1.setRtoDivision(vt.getRtoDivision());
			vehicleEntity1.setRtoState(vt.getRtoState());
			vehicleEntity1.setYearOfRegistration(vt.getYearOfRegistration());
			
			listVehicleEntity.add(vehicleRepository.save(vehicleEntity1));
			
		}
		return listVehicleEntity;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		vehicleRepository.deleteById(id);
		
	}

	@Override
	public Optional<VehicleEntity> getByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return vehicleRepository.findByVehicleNumber(vehicleNumber);
	}

	//@Override
	public List<VehicleEntity> getVehicleDetailByRtoDivision(String rtoDivision) {
		// TODO Auto-generated method stub
		return vehicleRepository.findByRtoDivision(rtoDivision);
	}

	
	 @Override
	 @Transactional
	 public void deleteByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		 vehicleRepository.deleteByvehicleNumber(vehicleNumber);
	}

	@Override
	public List<VehicleEntity> findByRtoDivision() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getVehicleInusranceByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return vehicleRepository.getVehicleInsurance(vehicleNumber);
	}

	@Override
	public List<String> getVehicleNumberListByRtoDivision(String rtoDivision) {
		// TODO Auto-generated method stub
		return vehicleRepository.getVehicleNumberListByRtoDivision(rtoDivision);
	}

	@Override
	public Map<String, List<VehicleEntity>> getVehicleGroupByDivision(Integer year, String state) {
		// TODO Auto-generated method stub
		List<VehicleEntity> vehicleEntityList = vehicleRepository.getVehicleGroupByDivision(year, state);
		Map<String, List<VehicleEntity>> vehicleGroupByDivision = new HashMap<String, List<VehicleEntity>>();
		for(VehicleEntity vt:vehicleEntityList) {
			if(!vehicleGroupByDivision.containsKey(vt.getRtoDivision())) {
			vehicleGroupByDivision.put(vt.getRtoDivision(),new ArrayList<VehicleEntity>());
			vehicleGroupByDivision.get(vt.getRtoDivision()).add(vt);
			}
			else {
				vehicleGroupByDivision.get(vt.getRtoDivision()).add(vt);
				}
			 
			
			
		}
		return vehicleGroupByDivision;
	}

	@Override
	public Map<String, List<VehicleEntity>> getVehicleDetailsByDivision(String rtoDivision) {
		// TODO Auto-generated method stub
		List<VehicleEntity> vehicleEntityList = vehicleRepository.getVehicleDetailsByDivision(rtoDivision);
		Map<String, List<VehicleEntity>> vehicleDetailsGroupByDivision = new HashMap<String, List<VehicleEntity>>();
		for(VehicleEntity vt:vehicleEntityList) {
			if(!vehicleDetailsGroupByDivision.containsKey(vt.getVehicleNumber())) {
			vehicleDetailsGroupByDivision.put(vt.getVehicleNumber(),new ArrayList<VehicleEntity>());
			vehicleDetailsGroupByDivision.get(vt.getVehicleNumber()).add(vt);
			}
			else {
				vehicleDetailsGroupByDivision.get(vt.getVehicleNumber()).add(vt);
				}
			 
			
			
		}
		return vehicleDetailsGroupByDivision;
	}

	@Override
	public List<VehicleEntity> updateVehicleInsuranceByVehicleNumber(List<String> vehicleNumber, Boolean vehicleInsurance) {
		// TODO Auto-generated method stub
		List<VehicleEntity> vehicleEntity1 = vehicleRepository.findAllByvehicleNumber(vehicleNumber);
		for(VehicleEntity vt:vehicleEntity1) {
			vt.setVehicleInsurance(vehicleInsurance);
			vehicleRepository.save(vt);
		}
		return vehicleEntity1;
	}

	@Override
	public List<VehicleEntity> getAllVehicleDetailsByVehicleNumber(List<String> vehicleNumber) {
		// TODO Auto-generated method stub
		List<VehicleEntity> vehicleEntity1 = vehicleRepository.findAllVehicleByVehicleNumber(vehicleNumber);
		for(VehicleEntity vt:vehicleEntity1) {
			vehicleRepository.save(vt);
		}
		return vehicleEntity1;
	}

	@Override
	public List<VehicleEntity> getAllListOfVehicleDetailsByVehicleInsurance(Boolean vehicleInsurance) {
		// TODO Auto-generated method stub
		List<VehicleEntity> vehicleEntity1 = vehicleRepository.findAllVehicleByVehicleInsurance(vehicleInsurance);
		for(VehicleEntity vt: vehicleEntity1) {
			vehicleRepository.save(vt);
		}
		return vehicleEntity1;
	}

	public List<VehicleEntity> updateVehicleInsuranceByFalseBeforeYear2000(Boolean vehicleInsurance) {
		// TODO Auto-generated method stub
		List<VehicleEntity> vehicleEntity1 = vehicleRepository.updateAllVehicleFlaseBeforeYear2000(vehicleInsurance);
		for(VehicleEntity vt:vehicleEntity1) {
			vt.setVehicleInsurance(vehicleInsurance);
			vehicleRepository.save(vt);
		}
		return vehicleEntity1;
	}
	



}
