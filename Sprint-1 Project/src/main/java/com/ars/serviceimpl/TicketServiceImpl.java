package com.ars.serviceimpl;

import java.time.LocalDate;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.dao.AirlineDAO;
import com.ars.dao.FlightDAO;
import com.ars.dao.PassengerDAO;
import com.ars.dao.TicketDAO;
import com.ars.daoimpl.AirlineDAOImpl;
import com.ars.daoimpl.FlightDAOImpl;
import com.ars.daoimpl.PassengerDAOImpl;
import com.ars.daoimpl.TicketDAOImpl;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;

import com.ars.entity.TicketBooking;
import com.ars.exception.GlobalException;
import com.ars.model.TicketBookingDTO;
import com.ars.service.TicketService;

public class TicketServiceImpl implements TicketService {
	private static final Logger logger=LoggerFactory.getLogger(TicketServiceImpl.class);
	FlightDAO fdao=new FlightDAOImpl();
	PassengerDAO pdao=new PassengerDAOImpl();
	AirlineDAO adao=new AirlineDAOImpl();
	TicketDAO tdao=new TicketDAOImpl();
	//method for  booking flight  in service layer
	@Override
	public TicketBookingDTO bookFlight(int flight_id, int no_of_passenger, LocalDate date, String pEmail,String airName) {

		Flight flight=fdao.getFlight(flight_id);
		if(flight.getAvailableSeats()>no_of_passenger)
		{
		Passenger p	=pdao.getPassengerByEmail(pEmail);
		Airline airline =adao.getAirlineByName(airName);
		
			float totalFare=airline.getFare()*no_of_passenger;
			int avaiable_seat=(flight.getAvailableSeats()-no_of_passenger);
		TicketBooking bookedTicket =tdao.bookFlight(airline, p, date, flight, no_of_passenger, totalFare, avaiable_seat);
		logger.info("Ticket has been booked.");
		return new ModelMapper().map(bookedTicket, TicketBookingDTO.class);
		}
		
		
		return null;
		
	
	}
	//method for  get ticket  in service layer
	@Override
	public TicketBookingDTO getTicket(int id) {
		TicketBooking tick	= tdao.getTicket(id);
		if(tick!=null)
		{
			logger.info("Ticket details have been retrieved.");
			return new ModelMapper().map(tick, TicketBookingDTO.class);
		}
			throw new GlobalException("Passenger details does not exist!!");
	}
	//method for cancel booking  in service layer
	@Override
	public void cancelBooking(int id) {
		tdao.cancelBooking(id);
		logger.info("Ticket booking has been cancelled.");
	}

}
