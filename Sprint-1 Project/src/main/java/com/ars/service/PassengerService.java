package com.ars.service;

import javax.persistence.PersistenceException;

import com.ars.entity.Passenger;
import com.ars.exception.GlobalException;
import com.ars.model.PassengerDTO;

public interface PassengerService {
void savePassenger(Passenger passenger);
boolean login(String userName,String password);
PassengerDTO updatePassenger(int id,Passenger passenger);
PassengerDTO getPassengerById(int id) throws GlobalException;
void deletePassenger(int id)throws PersistenceException;
}
