package com.ars.service;

import javax.persistence.PersistenceException;

import com.ars.entity.Airline;
import com.ars.model.AirlineDTO;

public interface AirlineService {
void saveAirline(Airline airline);
void assignAirlineToFlight(int flightId, int airId);
AirlineDTO updateAirlneById(int id,Airline airline);
AirlineDTO getAirlineByName(String name);
void deleteAirline(int id)throws PersistenceException;

}
