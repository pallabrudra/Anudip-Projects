	package com.ars;

	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.*;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.junit.jupiter.api.AfterAll;
	import org.junit.jupiter.api.AfterEach;
	import org.junit.jupiter.api.BeforeAll;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars.config.HibernateUtil;
	import com.ars.entity.Admin;
	import com.ars.model.AdminDTO;
	import com.ars.service.AdminService;
	import com.ars.serviceimpl.AdminServiceImpl;
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class AdminTest {

		AdminService adminService = new AdminServiceImpl();
		
		
		private static SessionFactory sessionFactory;
		private Session session;
		
		@BeforeAll
		static void setUp()
		{
			sessionFactory=HibernateUtil.getSessionFactory();
		}
		
		@BeforeEach
		 void OpenSession()
		{
			session=sessionFactory.openSession();
		}
		
		@AfterEach
		void closeSession()
		{
			if(session!= null)
				session.close();
			System.out.println("Session closed");
		}
		
		@AfterAll
		static void tearDown()
		{
			if(sessionFactory!=null)
				sessionFactory.close();
			System.out.println("Session factory closed");
		}
		//testing for admin registration
//		@Test
		//@Order(1)
//		void testRegisterAdmin()
//		{
//			Transaction tx = session.beginTransaction();
//			Admin admin = Admin.builder().aName("Monalisa").email("monalisa@gmail.com").UserName("madmin").
//					password("admin1234").role("admin").build();
//			Integer i = (Integer) session.save(admin);
//			tx.commit();
//			assertThat(i>0).isTrue();
//			
//			
//		}
		//testing for get admin 
//		@Test
		//@Order(2)
//		void testGetAdminById()
//		{
//			AdminDTO adto = adminService.getAdminById(14);
//			assertThat(adto.getAName()).isEqualTo("Monalisa");
//			
//		}
		//testing for Update admin
//		@Test
		//@Order(3)
//		void testUpdateAirlineUsingService()
//		{
//			Transaction tx=session.beginTransaction();
//			Admin ad=new Admin();
//			ad.setAName("Monalisa Chakroborty");
//			AdminDTO adto=adminService.updateAdmin(14, ad);
//			tx.commit();
//			assertThat(adto.getAName()).isEqualTo("Monalisa Chakroborty");
//		}
		//testing for delete admin
//		@Test
		//@Order(4)
//		@DisplayName(value="Negative Test Case")
//		void testDeleteAdmin()
//		{
//			adminService.deleteAdmin(16);
//			
//			assertThrows(Exception.class, ()-> adminService.getAdminById(16) );
//		}
		

}
