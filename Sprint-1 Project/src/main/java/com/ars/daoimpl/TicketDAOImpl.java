package com.ars.daoimpl;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.TicketDAO;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketBooking;

public class TicketDAOImpl implements TicketDAO{
	private static final Logger logger=LoggerFactory.getLogger(TicketDAOImpl.class);
	//method for book flight in DAO layer
	@Override
	public TicketBooking bookFlight(Airline airline, Passenger p, LocalDate date, Flight f, int no_of_passenger,
			float total_fare, int available_seat) {
		try(Session session=HibernateUtil.getSession())
		   {
			  session.beginTransaction();
			
			  TicketBooking ticketBooking=new TicketBooking();
			  ticketBooking.setAId(airline);
			  ticketBooking.setDate(date);
			  ticketBooking.setFId(f);
			  ticketBooking.setNo_of_passenger(no_of_passenger);
			  ticketBooking.setPId(p);
			  ticketBooking.setTotalFare(total_fare);
			  session.save(ticketBooking);
			  f.setAvailableSeats(available_seat);
			  session.saveOrUpdate(f);
			  session.getTransaction().commit();
			  logger.info("Ticket booking  successful"+ticketBooking.toString()
				+" and creation time is: "+new java.util.Date());
			 return ticketBooking;
			  
		   }catch (HibernateException e) {
				System.out.println("hibernate exception is: "+ e);
			}
				
			catch (Exception e) {
				System.out.println("exception is: "+ e);
			}
		return null;

	}
	//method for cancel booking in DAO layer
	@Override
	public void cancelBooking(int id) {
		try (Session session=HibernateUtil.getSession()){
			TicketBooking tb=(TicketBooking)session.load(TicketBooking.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "do you want to Cancel?",
					"select what you want to Cancel or not?",JOptionPane.YES_NO_OPTION);
				
			if(input==0)
			{
				int nop=tb.getNo_of_passenger();
				tb.getFId().setAvailableSeats(tb.getFId().getAvailableSeats()+nop);
				session.delete(tb);
				
				
			}
			else
			JOptionPane.showMessageDialog(null, "User wants to retain it!!!");
			logger.info("Ticket cancel  successful"+tb.toString()
			+" and creation time is: "+new java.util.Date());
			session.getTransaction().commit();
			
			}catch (HibernateException e) {
				System.out.println("hibernate exception is: "+ e);
			}
				
		}
	//method for get boarding pass in DAO layer
	@Override
	public TicketBooking getTicket(int id) {
		try(Session session=HibernateUtil.getSession()){
			TicketBooking tick=(TicketBooking)session.get(TicketBooking.class, id);
			logger.info("Ticket details has been retrieved "+tick.toString() +" at: " +new java.util.Date());
			return tick;
			
			}
			
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
			return null;
	
	}
		
	}


