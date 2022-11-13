package com.ars.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "booking_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketBooking {


@Id	
@GenericGenerator(name = "ticket_no" , strategy = "com.ars.entity.TicketNoGenerator")
@GeneratedValue(generator = "ticket_no")
private int ticketId;
@Column(name ="total_passenger",length = 9)
private int no_of_passenger;

@Column(length = 200)
private float totalFare;

@Column(name = "travel_date")
private LocalDate Date=LocalDate.now();


@OneToOne
private Flight fId;

@OneToOne
private Airline aId;

@OneToOne
private Passenger pId;

}
