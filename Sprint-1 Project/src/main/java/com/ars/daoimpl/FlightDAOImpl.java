package com.ars.daoimpl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.FlightDAO;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;

public class FlightDAOImpl implements FlightDAO{
	private static final Logger logger=LoggerFactory.getLogger(FlightDAOImpl.class);
	//method for save flights in DAO layer
	@Override
	public void saveFlight(Flight flight) {
		try(Session session=HibernateUtil.getSession())
		{
			//adding new flight details
			session.beginTransaction();
			session.save(flight);
			
			//java object saved to database
			session.getTransaction().commit();
			logger.info("new Flight details has been added"+flight.toString()
			+" and creation time is: "+new java.util.Date());
			//clear the session
			session.clear();
		}
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}	
		
	}
	//method for update flights in DAO layer
	@Override
	public Flight updateFlight(int id, Flight flight) {
		try (Session session=HibernateUtil.getSession()){
			Flight fl=(Flight)session.load(Flight.class, id);
			//fl.setFlight_id(flight.getFlight_id());
			fl.setAvailableSeats(flight.getAvailableSeats());
			fl.setDate(flight.getDate());
			fl.setDestination(flight.getDestination());
			fl.setSource(flight.getSource());
			fl.setTime(flight.getTime());
			fl.setTotalSeats(flight.getTotalSeats());
			fl.setTravellerClass(flight.getTravellerClass());
			fl.setAirline(flight.getAirline());
			session.beginTransaction();
			session.saveOrUpdate(fl);
			session.getTransaction().commit();
			logger.info("update flight successfully"+fl.toString()
			+" and creation time is: "+new java.util.Date());
			return fl;	
		}catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
		
		return null;
	}
	//method for get flights in DAO layer
	@Override
	public Flight getFlight(int id) {
		try(Session session=HibernateUtil.getSession())
		{
		Flight flight =(Flight)session.get(Flight.class, id);
		logger.info("flight details fetch successfully"+flight.toString()
		+" and creation time is: "+new java.util.Date());
		return flight;
		}
			 catch (HibernateException e) {
					System.out.println("hibernate exception is: "+ e);
				}
					
				catch (Exception e) {
					System.out.println("exception is: "+ e);
				}	
        
		return null;
	}
	//method for delete flights in DAO layer
	@Override
	public void deleteFlight(int id) throws PersistenceException {
		try(Session session=HibernateUtil.getSession()){
			Flight fl=session.load(Flight.class, id);
			
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "do you want to delete?",
					"select what you want to delete or not?",JOptionPane.YES_NO_OPTION);
				
			if(input==0)
			{
				session.delete(fl);
			}
			else
			JOptionPane.showMessageDialog(null, " wants to retain it!!!");
			logger.info("flight details deleted successfully"+fl.toString()
			+" and creation time is: "+new java.util.Date());
			session.getTransaction().commit();
			
			}catch (HibernateException e) {
				System.out.println("hibernate exception is: "+ e);
			}
				
			catch ( PersistenceException e) {
				throw new PersistenceException("You can not delete because you have booking with us");
			}
			
		
	}
	//method for check flights in DAO layer
	@Override
	public List<Flight> checkFlight(String from, String to,LocalDate date) {
	        try(Session session=HibernateUtil.getSession())
	        {
	        	String q="from Flight as f where f.source=:s and f.destination=:d and f.date=:da";
	        	Query query=session.createQuery(q);
	        	query.setParameter("s", from);
	        	query.setParameter("d", to);
	        	query.setParameter("da", date);
	        	List<Flight> flights=query.list();
	        	logger.info("list of flights fetched successfully"+flights.toString()
				+" and creation time is: "+new java.util.Date());
	        	return flights;
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
