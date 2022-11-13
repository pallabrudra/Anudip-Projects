package com.ars.daoimpl;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.PassengerDAO;
import com.ars.entity.Passenger;

public class PassengerDAOImpl implements PassengerDAO{

	private static final Logger logger=LoggerFactory.getLogger(PassengerDAOImpl.class);
	//method for save Passenger in DAO layer
	@Override
	public void savePassenger(Passenger passenger) {
		try(Session session=HibernateUtil.getSession())
		{
			//adding new passenger details
			session.beginTransaction();
			session.save(passenger);
			
			//java object saved to database
			session.getTransaction().commit();
			logger.info("new passenger details has been added"+passenger.toString()
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
	//method for login passenger in DAO layer
	@Override
	public boolean login(String userName,String password) {
		Session session=HibernateUtil.getSession();
	Passenger p=(Passenger)session.get(Passenger.class,
			Integer.parseInt(JOptionPane.showInputDialog("enter Id:","Type here")));
	
	if(p.getUserName().equals(userName) && p.getPassword().equals(password))	
	{
		return true;

		}
	else {
		return false;
	}
	}
	//method for update passenger in DAO layer
	@Override
	public Passenger updatePassenger(int id, Passenger passenger) {
		try(Session session=HibernateUtil.getSession()){
		Passenger pass=(Passenger)session.load(Passenger.class, id);
		
		//update existing details with new one
		pass.setName(passenger.getName());
		pass.setEmail(passenger.getEmail());	
		pass.setPhno(passenger.getPhno());
		pass.setUserName(passenger.getUserName());
		pass.setPassword(passenger.getPassword());
		
		session.beginTransaction();
		session.saveOrUpdate(pass);
		session.getTransaction().commit();
		logger.info("passenger update successful"+passenger.toString()
		+" and creation time is: "+new java.util.Date());
		return pass;// return passenger entity
		}
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
		return null;
	}
	//method for get passenger by id in DAO layer
	@Override
	public Passenger getPassenger(int id) {
		try(Session session=HibernateUtil.getSession()){
		Passenger passenger=(Passenger)session.get(Passenger.class, id);
		logger.info("read passenger detalis"+passenger.toString()
		+" and creation time is: "+new java.util.Date());
		return passenger;
		
		}
		
	catch (HibernateException e) {
		System.out.println("hibernate exception is: "+ e);
	}
		
	catch (Exception e) {
		System.out.println("exception is: "+ e);
	}
		return null;
	}
	//method for delete passenger in DAO layer
	@Override
	public void deletePassenger(int id)throws PersistenceException {
		try(Session session=HibernateUtil.getSession()){
		Passenger passn=session.load(Passenger.class, id);
		
		session.beginTransaction();
		int input=JOptionPane.showConfirmDialog(null, "do you want to delete?",
				"select what you want to delete or not?",JOptionPane.YES_NO_OPTION);
			
		if(input==0)
		{
			session.delete(passn);
		}
		else
		JOptionPane.showMessageDialog(null, "User wants to retain it!!!");
		logger.info("deleted successfuly"+passn.toString()
		+" and creation time is: "+new java.util.Date());
		session.getTransaction().commit();

		}catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch ( PersistenceException e) {
			throw new PersistenceException("You can not delete because you have booking with us");
		}
		
	}
	//method for get passenger by email in DAO layer
	@Override
	public Passenger getPassengerByEmail(String email) {
		try(Session session=HibernateUtil.getSession()){
			String query="from Passenger p where p.email=:e";
		Query q=session.createQuery(query);
		q.setParameter("e", email);
		   Passenger p=(Passenger)q.uniqueResult();
		   logger.info("read passenger detalis by email"+p.toString()
			+" and creation time is: "+new java.util.Date());
		   return p;
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






