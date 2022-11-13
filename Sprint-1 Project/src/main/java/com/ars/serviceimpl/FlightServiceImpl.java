package com.ars.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.dao.FlightDAO;
import com.ars.daoimpl.FlightDAOImpl;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.exception.GlobalException;
import com.ars.model.FlightDTO;
import com.ars.model.PassengerDTO;
import com.ars.service.FlightService;


public class FlightServiceImpl implements FlightService{
	private static final Logger logger=LoggerFactory.getLogger(FlightServiceImpl.class);
	FlightDAO flightDAO=new FlightDAOImpl();
	//method for save flight  in service layer
	@Override
	public void saveFlight(Flight flight) {
		logger.info("Flight details have been saved.");
		flightDAO.saveFlight(flight);
		
	}
	//method for update flight  in service layer
	@Override
	public FlightDTO updateFlight(int id, Flight flight) {
		Flight f=flightDAO.updateFlight(id, flight);
		logger.info("Flight details have been updated successfully.");
		return new ModelMapper().map(f, FlightDTO.class);//converting entity to DTO
	}
	//method for get flight  in service layer
	@Override
	public FlightDTO getFlight(int id) throws GlobalException {
		Flight flight=flightDAO.getFlight(id);
		if(flight!=null)
		{
			logger.info("Flight details retrieved successfully.");
			return new ModelMapper().map(flight, FlightDTO.class);//converting entity to DTO
		}
			throw new GlobalException("Flight details not exist!!");
		}
	
	//method for delete flight  in service layer
	@Override
	public void deleteFlight(int id)throws PersistenceException {
		flightDAO.deleteFlight(id);
		logger.info("Flight details deleted.");
		
	}
	//method for check flight  in service layer
	@Override
	public List<Flight> checkFlight(String from, String to,LocalDate date) {
		logger.info("Flight details is checked.");
		return flightDAO.checkFlight(from, to,date);
	}

}
