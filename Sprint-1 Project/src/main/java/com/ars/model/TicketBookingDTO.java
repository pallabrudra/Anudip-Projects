package com.ars.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TicketBookingDTO {
	
	private int ticketId;
	
	private int no_of_passenger;
	private double totalFare;
	
	private Date Date=new Date();


	private Flight flightId;
	
	private Airline airlineId;
	
	private Passenger passengerId;

}
