package com.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.Set;

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
import com.ars.dao.PassengerDAO;
import com.ars.daoimpl.PassengerDAOImpl;
import com.ars.entity.Passenger;
import com.ars.exception.GlobalException;
import com.ars.model.PassengerDTO;
import com.ars.service.PassengerService;
import com.ars.serviceimpl.PassengerServiceImpl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PassengerTest {

	private static Validator validator;
	PassengerService passengerService=new PassengerServiceImpl();
	
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	public static void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		sessionFactory=HibernateUtil.getSessionFactory();
	}

	@BeforeEach
	public void OpenSession()
	{
		session=sessionFactory.openSession();
	}
	
	@AfterEach
	public void closeSession()
	{
		if(session!= null)
			session.close();
		System.out.println("Session closed");
	}
	
	@AfterAll
	public static void tearDown()
	{
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session factory closed");
	}
	// testing method for passenger should be not null
//	@Test
//	@Order(1)
//	@DisplayName("Positive Test Case")
//	 void PassengerNotNull()
//	{
//		PassengerDTO passengerDTO=new PassengerDTO("p", "4567856789", "pallab@gamil.com");
//		
//		Set<ConstraintViolation<PassengerDTO>> constraintViolations =
//			      validator.validate( passengerDTO );
//		 //assertEquals( 1, constraintViolations.size() );
//		assertEquals("Name should be more than 2 characters", constraintViolations.iterator().next().getMessage());
//	}
//	testing method for email not null
//	@Test
//	@Order(2)
//	@DisplayName("Negative Test Case")
//	 void PassengerEmailTest()
//	{
//		PassengerDTO passengerDTO=new PassengerDTO("p", "4567856789", null);
//		Set<ConstraintViolation<PassengerDTO>> constraintViolations =
//			      validator.validate( passengerDTO );
//		assertEquals("Email Can Not Be Blank", constraintViolations.iterator().next().getMessage());
//	}
	//testing method for save passenger
//	@Test
//	@Order(3)
//	 void testSavePassenger()
//	{
//		System.out.println("..........Running TestSavePassenger.............");
//		Transaction tx=session.beginTransaction();
//		Passenger pass=Passenger.builder().name("randhir").email("randhir@gmail.com").
//				phno("7003214589").UserName("randhir").password("ran123").role("user").build();
//		Integer i=(Integer) session.save(pass);
//		tx.commit();
//		assertThat(i>0).isTrue();
//			}
//	
	//testing method for update passenger
//	@Test
//	@Order(4)
//	 void testUpdatePassenger()
//	{
//		System.out.println("..........Running TestUpdatePassenger.............");
//		Transaction tx=session.beginTransaction();
//		Passenger pass=Passenger.builder().name("shawain").email("shawin@gmail.com").
//				phno("9906478456").build();
//		session.save(pass);
//		pass.setName("shawin pradhan");
//		
//		assertThat(pass.getName()).isEqualTo("shawin pradhan");
//	}
//	//testing method for update passenger using service
	//@Test
	//@Order(5)
//	 void testUpdatePassengerUsingService()
//	{
//		System.out.println("..........Running TestUpdatePassenger.............");
//		Transaction tx=session.beginTransaction();
//		Passenger p=new Passenger();
//		p.setName("shawin pradhan");
//		p.setEmail("shawin.p@gmail.com");
//		p.setPhno("7895678923");
//		PassengerDTO pdto=passengerService.updatePassenger(25, p);
//		
//		
//		assertThat(pdto.getName()).isEqualTo("shawin pradhan");
//	}
	//testing method for delete passenger
//	@Test
////	@Order(6)
//	 void testdeletePassengerUsingService()
//	{
//		System.out.println(".................Running TestDeletePassenger");
//	
//		passengerService.deletePassenger(13);		
//		assertThrows(GlobalException.class, ()->passengerService.getPassengerById(13));
//		
//	}
	
	
	
	
	
	
	
//	@Test
//	 void testReadPassenger() {
//		PassengerDTO pdto =passengerService.getPassengerById(2);
//		assertThat(pdto.getName()).isEqualTo("chandan");
//	}
	
}
