package com.ars.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.AirlineDAO;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;

public class AirlineDAOImpl implements AirlineDAO{
	private static final Logger logger=LoggerFactory.getLogger(AirlineDAOImpl.class);
	//method for save airline in DAO layer
	@Override
	public void saveAirline(Airline airline) {
		try(Session session=HibernateUtil.getSession())
		{
			//adding new airline details
			session.beginTransaction();
			session.save(airline);
			
			//java object saved to database
			session.getTransaction().commit();
			logger.info("new Airlines details has been added"+airline.toString()
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
	//method for assign airline to flight in DAO layer
	@Override
	public void assignAirlineToFlight(int flightId, int airId) {
		try(Session session=HibernateUtil.getSession())
		{
		Flight flight=(Flight)session.get(Flight.class, flightId);
		Airline airline =(Airline)session.load(Airline.class, airId);
		
		List<Flight> flights=new ArrayList<>();
		flights.add(flight);
		
		airline.setFlights(flights);
		flight.setAirline(airline);
		
		session.beginTransaction();
		session.saveOrUpdate(airline);
		
		session.getTransaction().commit();
		logger.info("assign airline to flight"+airline.toString()
		+" and creation time is: "+new java.util.Date());
		}
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
	}
	//method for get airline in DAO layer
	@Override
	public Airline getAirlineByName(String name) {
	try(Session session=HibernateUtil.getSession()){
		String query="from Airline a where a.airlineName=:an";
        Query q =session.createQuery(query);
        q.setParameter("an", name);
         Airline airline=(Airline) q.uniqueResult();
         logger.info("fectch airline by name"+airline.toString()
			+" and creation time is: "+new java.util.Date());
         return airline;
	}
	catch (HibernateException e) {
		System.out.println("hibernate exception is: "+ e);
	}
		
	catch (Exception e) {
		System.out.println("exception is: "+ e);
	}
		return null;
	}
	//method for update airline in DAO layer
	@Override
	public Airline updateAirlineById(int id,Airline airline) {
		try (Session session=HibernateUtil.getSession()){
			Airline air=(Airline)session.load(Airline.class, id);
			//air.setId(airline.getId());
			air.setAirlineName(airline.getAirlineName());
			air.setFare(airline.getFare());
			session.beginTransaction();
			session.saveOrUpdate(air);
			session.getTransaction().commit();
			logger.info("airline added successfully"+air.toString()
			+" and creation time is: "+new java.util.Date());
			return air;
			
		} catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
		return null;
	}
	//method for delete airline in DAO layer
	@Override
	public void deleteAirline(int id) throws PersistenceException {

			try(Session session=HibernateUtil.getSession()){
			Airline airline=session.load(Airline.class, id);
			
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "do you want to delete?",
					"select what you want to delete or not?",JOptionPane.YES_NO_OPTION);
				
			if(input==0)
			{
				session.delete(airline);
			}
			else
			JOptionPane.showMessageDialog(null, " wants to retain it!!!");
			logger.info("delete successful"+airline.toString()
			+" and creation time is: "+new java.util.Date());
			session.getTransaction().commit();
			
			}catch (HibernateException e) {
				System.out.println("hibernate exception is: "+ e);
			}
				
			catch ( PersistenceException e) {
				throw new PersistenceException(" can not delete airline because data is booked");
			}
			
		}
	}


