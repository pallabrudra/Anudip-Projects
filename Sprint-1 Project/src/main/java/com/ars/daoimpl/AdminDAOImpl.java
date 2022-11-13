package com.ars.daoimpl;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.AdminDAO;
import com.ars.entity.Admin;
import com.ars.entity.Passenger;

public class AdminDAOImpl implements AdminDAO {
	private static final Logger logger=LoggerFactory.getLogger(AdminDAOImpl.class);
	//method for admin registraion in DAO layer
	@Override
	public void registerAdmin(Admin admin) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		logger.info("new admin details has been added"+admin.toString()
		+" and creation time is: "+new java.util.Date());
		session.close();
		
		
	}
	//method for admin Login in DAO layer
	@Override
	public boolean loginAdmin(String userName, String password) {
		Session session=HibernateUtil.getSession();
		Admin admin=(Admin)session.get(Admin.class,
				Integer.parseInt(JOptionPane.showInputDialog("enter Id:","Type here")));
		
		if(admin.getUserName().equals(userName) && admin.getPassword().equals(password))	
		{
			return true;
			}
		else {
			return false;
		}
		
	}
	//method for get admin in DAO layer
	@Override
	public Admin getAdminById(int id) {
		try(Session session=HibernateUtil.getSession()){
			Admin admin=(Admin)session.get(Admin.class, id);
			logger.info("Admin has been retrieved "+admin.toString() +" at: " +new java.util.Date());
			return admin;
			
			}
			
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
			return null;
	}
	//method for delete admin in DAO layer
	@Override
	public void deleteAdmin(int id) throws PersistenceException {
		try(Session session=HibernateUtil.getSession()){
			Admin ad=session.load(Admin.class, id);
			
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"select what you want to delete or not?",JOptionPane.YES_NO_OPTION);
				
			if(input==0)
			{
				session.delete(ad);
			}
			else
			JOptionPane.showMessageDialog(null, "User wants to retain it!!!");
			logger.info("Admin has been deleted. "+ad.toString() +" at: " +new java.util.Date());
			session.getTransaction().commit();
			
			}catch (HibernateException e) {
				System.out.println("hibernate exception is: "+ e);
			}
				
			catch (PersistenceException e) {
				System.out.println("You cannot delete your account as you have a booking with us.");
			}
	}
	//method for Update admin  in DAO layer
	@Override
	public Admin updateAdmin(int id, Admin admin) {
		try(Session session=HibernateUtil.getSession()){
			Admin adm=(Admin)session.load(Admin.class, id);
			
			//update existing details with new one
			adm.setAName(admin.getAName());
			adm.setEmail(admin.getEmail());	
			adm.setUserName(admin.getUserName());
			adm.setPassword(admin.getPassword());
			
			session.beginTransaction();
			session.saveOrUpdate(adm);
			session.getTransaction().commit();
			logger.info("Admin has been updated. "+adm.toString() +" at: " +new java.util.Date());
			return adm;// return passenger entity
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


