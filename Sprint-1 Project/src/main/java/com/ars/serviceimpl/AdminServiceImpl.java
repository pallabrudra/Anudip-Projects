package com.ars.serviceimpl;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.dao.AdminDAO;
import com.ars.daoimpl.AdminDAOImpl;
import com.ars.entity.Admin;
import com.ars.exception.GlobalException;
import com.ars.model.AdminDTO;
import com.ars.service.AdminService;


public class AdminServiceImpl implements AdminService{
	private static final Logger logger=LoggerFactory.getLogger(AdminServiceImpl.class);
	AdminDAO aDao=new AdminDAOImpl();
	//method for admin registration in service layer
	@Override
	public void registerAdmin(Admin admin) {
		logger.info("Admin details have been saved.");
		aDao.registerAdmin(admin);
		
	}
	//method for admin Login in service layer
	@Override
	public boolean loginAdmin(String userName, String password) {
		logger.info("Admin has successfully logged in.");
		return aDao.loginAdmin(userName, password);
		
	}
	//method for get admin  in service layer
	@Override
	public AdminDTO getAdminById(int id) {
		Admin admin	=aDao.getAdminById(id);
		if(admin!=null)
		{
			logger.info("Admin details retrieved successfully.");
			return new ModelMapper().map(admin, AdminDTO.class); //converting entity to DTO
		}
			throw new GlobalException("Admin details does not exist!!");
	}
	//method for delete admin  in service layer
	@Override
	public void deleteAdmin(int id) throws PersistenceException {
		
		aDao.deleteAdmin(id);
		logger.info("Admin details deleted.");
	}
	//method for update admin  in service layer
	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin a=aDao.updateAdmin(id, admin);
		logger.info("Admin details have been updated successfully.");
		return new ModelMapper().map(a, AdminDTO.class); //converting entity to DTO
	}

}
