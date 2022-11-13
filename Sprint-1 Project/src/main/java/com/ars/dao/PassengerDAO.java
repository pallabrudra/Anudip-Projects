package com.ars.dao;

import javax.persistence.PersistenceException;

import com.ars.entity.Passenger;

public interface PassengerDAO {
	
void savePassenger(Passenger passenger);
boolean login(String userName,String password);
Passenger updatePassenger(int id,Passenger passenger);
Passenger  getPassenger(int id);
void deletePassenger(int id)throws PersistenceException;
Passenger getPassengerByEmail(String email);
}
