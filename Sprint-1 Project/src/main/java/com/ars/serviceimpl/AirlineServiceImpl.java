package com.ars.serviceimpl;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.dao.AirlineDAO;
import com.ars.daoimpl.AirlineDAOImpl;
import com.ars.entity.Airline;
import com.ars.exception.GlobalException;
import com.ars.model.AirlineDTO;
import com.ars.service.AirlineService;

public class AirlineServiceImpl implements AirlineService{
	private static final Logger logger=LoggerFactory.getLogger(AirlineServiceImpl.class);
	AirlineDAO airlineDAO=new AirlineDAOImpl();
	//method for save airline  in service layer
	@Override
	public void saveAirline(Airline airline) {
		logger.info("Airline details have been saved.");
		airlineDAO.saveAirline(airline);
		
		
	}
	//method for assign airline to flight  in service layer
	@Override
	public void assignAirlineToFlight(int flightId, int airId) {
		logger.info("Airline has been assigned to a flight.");
		airlineDAO.assignAirlineToFlight(flightId, airId);
		
	}
	//method for update airline  in service layer
	@Override
	public AirlineDTO updateAirlneById(int id,Airline airline) {
		Airline a= airlineDAO.updateAirlineById(id, airline);
		logger.info("Airline details have been updated successfully.");
		return new ModelMapper().map(a, AirlineDTO.class);//converting entity to DTO
	}
	//method for get airline by name  in service layer
	@Override
	public AirlineDTO getAirlineByName(String name) throws GlobalException{
		Airline airline=airlineDAO.getAirlineByName(name);
		if(airline!=null)
		{
			logger.info("Admin details retrieved successfully using name.");
			return new ModelMapper().map(airline, AirlineDTO.class);//converting entity to DTO
		}
		
		throw new GlobalException("Airline details not exist!!");
	}
	//method for delete airline  in service layer
	@Override
	public void deleteAirline(int id) throws PersistenceException {
	
		airlineDAO.deleteAirline(id);
		logger.info("Airline details deleted.");
	}

}
