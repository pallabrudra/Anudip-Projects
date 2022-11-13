package com.ars.serviceimpl;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.dao.PassengerDAO;
import com.ars.daoimpl.PassengerDAOImpl;
import com.ars.entity.Passenger;
import com.ars.exception.GlobalException;
import com.ars.model.PassengerDTO;
import com.ars.service.PassengerService;

public class PassengerServiceImpl implements PassengerService{
	private static final Logger logger=LoggerFactory.getLogger(PassengerServiceImpl.class);
	PassengerDAO passengerDAO=new PassengerDAOImpl();
	//method for save passenger  in service layer
	@Override
	public void savePassenger(Passenger passenger) {
		logger.info("Passenger details have been saved.");
		passengerDAO.savePassenger(passenger);
		
	}
	//method for login passenger  in service layer
	@Override
	public boolean login(String userName,String password) {
		logger.info("Passenger has successfully logged in.");
		return passengerDAO.login(userName,password);
	}
	//method for update passenger  in service layer
	@Override
	public PassengerDTO updatePassenger(int id, Passenger passenger) {
		Passenger p=passengerDAO.updatePassenger(id, passenger);
		logger.info("Passenger details have been updated successfully.");
		return new ModelMapper().map(p, PassengerDTO.class); //converting entity to DTO
	}
	//method for get passenger  in service layer
	@Override
	public PassengerDTO getPassengerById(int id) throws GlobalException {
	
	Passenger passanger	=passengerDAO.getPassenger(id);
	if(passanger!=null)
	{
		logger.info("Passenger details retrieved successfully.");
		return new ModelMapper().map(passanger, PassengerDTO.class);//converting entity to DTO
	}
		throw new GlobalException("Passenger details not exist!!");
	}
	//method for delete passenger  in service layer
	@Override
	public void deletePassenger(int id)throws PersistenceException {
		
		passengerDAO.deletePassenger(id);
		logger.info("Passenger details deleted.");
		
	}

	
	
	
	
}
