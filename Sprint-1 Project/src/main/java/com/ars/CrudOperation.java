package com.ars;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import com.ars.entity.Admin;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketGenerationPdf;
import com.ars.model.AdminDTO;
import com.ars.model.AirlineDTO;
import com.ars.model.FlightDTO;
import com.ars.model.PassengerDTO;
import com.ars.model.TicketBookingDTO;
import com.ars.service.AdminService;
import com.ars.service.AirlineService;
import com.ars.service.FlightService;
import com.ars.service.PassengerService;
import com.ars.service.TicketService;
import com.ars.serviceimpl.AdminServiceImpl;
import com.ars.serviceimpl.AirlineServiceImpl;
import com.ars.serviceimpl.FlightServiceImpl;
import com.ars.serviceimpl.PassengerServiceImpl;
import com.ars.serviceimpl.TicketServiceImpl;

public class CrudOperation {

	static PassengerService pservice=new PassengerServiceImpl();
	static FlightService fService=new FlightServiceImpl();
	static AirlineService aService=new AirlineServiceImpl();
	static TicketService tService=new TicketServiceImpl();
	static AdminService aservice = new AdminServiceImpl();
	static Scanner sc =new Scanner(System.in);
	//this method is responsible to perform crud of admin
	public static void crudAdmin()
	{
		String xx;
		while(true) {
		System.out.println("============================================================================");
System.out.println( "Press r. To read Admin details\nPress u. To update Admin details\nPress d. To delete Admin details\n"
		+ "Press q. To quit");
System.out.println("============================================================================");
 xx=JOptionPane.showInputDialog("Enter choice","Type here");

 switch(xx) {
 

 case "r":

	try {

	
		AdminDTO aDto=aservice.getAdminById(Integer.parseInt(JOptionPane.showInputDialog("Enter admin id", "type here")));
		System.out.println("Admin details: ");
		System.out.println("Id: "+aDto.getId());
		System.out.println("Name: "+aDto.getAName());
        System.out.println("Email: "+aDto.getEmail());
	}
	catch (Exception e) {
		System.out.println(e);
	}
	
break;
	
 case "u":

	Admin admin=new Admin();
	String name=JOptionPane.showInputDialog("Enter name:","Type here");
	String email=JOptionPane.showInputDialog("Enter email:","Type here");
	String uname=JOptionPane.showInputDialog("Enter user_name:","Type here");
	String pass=JOptionPane.showInputDialog("Enter password:","Type here");
	
	admin.setAName(name);
	admin.setEmail(email);
	admin.setUserName(uname);
	admin.setPassword(pass);
//	passenger.setName("nilanjan dasgupta");
//	passenger.setEmail("nilanjan.d@gamil.com");
//	passenger.setPhno("8890234123");
//	passenger.setUserName("nilanjanD");
//	passenger.setPassword("nilD12");
	
	AdminDTO upPass=aservice.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("enter admin id to update", "type here")),
			admin);
	System.out.println("Admin updated successfully");
break;	

 case "d":
	 try {
	aservice.deleteAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter admin id to delete", "type here")));
	JOptionPane.showMessageDialog(null, "Object is deleted!!");
	 }
	 catch(PersistenceException e)
	 {
		 System.out.println(e.getMessage());
	 }
break;

 case "q":
	 CrudOperation.AdminOpeartion();
	 break;

 }//end of switch
		}
	} //crud admin
	
	//this method is responsible to perform crud  operation of passenger
		public static void crudPassenger()
		{
			String xx;
			while(true) {
			System.out.println("============================================================================");
	System.out.println( "Press r. for read Passenger details\n Press u.for update Passenger details\n Press d.for delete Passenger details\n"
			+ " Press q for quit");
	System.out.println("============================================================================");
	 xx=JOptionPane.showInputDialog("Enter choice","Type here");

	 switch(xx) {
	 

	 case "r":
	
		try {

		
			PassengerDTO pDto=pservice.getPassengerById(Integer.parseInt(JOptionPane.showInputDialog("Enter id", "type here")));
			System.out.println("Passenger details: ");
			System.out.println("Id: "+pDto.getId());
			System.out.println("Name: "+pDto.getName());
	        System.out.println("Ph. No: "+pDto.getPhno());
	        System.out.println("Email: "+pDto.getEmail());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	break;
		
	 case "u":
		 
		Passenger passenger=new Passenger();
		String name=JOptionPane.showInputDialog("Enter name for Update:","Type here");
		String email=JOptionPane.showInputDialog("Enter email for Update:","Type here");
		String phno=JOptionPane.showInputDialog("Enter Phone Number for Update:","Type here");
		String uname=JOptionPane.showInputDialog("Enter user_name for Update:","Type here");
		String pass=JOptionPane.showInputDialog("Enter password for Update:","Type here");
		
		passenger.setName(name);
		passenger.setEmail(email);
		passenger.setPhno(phno);
		passenger.setUserName(uname);
		passenger.setPassword(pass);
		
		PassengerDTO upPass=pservice.updatePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")),
				passenger);
		System.out.println("Passenger updated successfully");
	break;	

	 case "d":
		 try {
		pservice.deletePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to delete", "type here")));
		JOptionPane.showMessageDialog(null, "Object is deleted!!!!");
		 }catch(PersistenceException e)
		 {
			 System.out.println(e.getMessage());
		 }
		 break;

	 case "q":
		 crudOpeartion();
		 break;

	 }//end of switch
			}
		} //crud passenger
		
		
		//this method is responsible to  perform crud operation of flight
		public static void crudFlight()
		{
			String in;
			while(true) {
			System.out.println("============================================================================");
		System.out.println("Press c. for add Flight details\n"
				+ "Press r. for flight details\n Press u.for update flight details\n Press d.for delete flight details\n"
				+ " Press q for quit ");
		System.out.println("============================================================================");
		in=JOptionPane.showInputDialog("Enter choice","Type here");
		
		switch(in) {
		case "c":
		         Flight flight3=new Flight();
		 		System.out.println("Enter the  Avilable Seats: ");
		 		int aseat=sc.nextInt();
		 		System.out.println("Enter the  Total Seats: ");
		 		int tseat=sc.nextInt();
		 		sc.nextLine();
		 		System.out.println("Enter the  traveller class: ");
		 		String tclass=sc.nextLine();
		 		System.out.println("Enter the  time: ");
		 		String t=sc.nextLine();
		 		System.out.println("Enter the date: ");
		 		String d1=sc.nextLine();
		 		LocalDate date1=LocalDate.parse(d1); 
		 		System.out.println("enter the  source: ");
		 		String fsource=sc.nextLine();
		 		System.out.println("enter the  destination: ");
		 		String fdest=sc.nextLine();
		         flight3.setAvailableSeats(aseat);
		         flight3.setTotalSeats(tseat);
		         flight3.setTravellerClass(tclass);
		         flight3.setTime(t);
		         flight3.setDate(date1);
		         flight3.setSource(fsource);
		         flight3.setDestination(fdest);
		         fService.saveFlight(flight3);
		         System.out.println("Flight added successfully!!");
	       break;
		

		case "r":
			try {
				int id;
				System.out.println("enter the id: ");
				id=sc.nextInt();
				FlightDTO fDto=fService.getFlight(id);
				System.out.println("Flight id: "+fDto.getFlight_id());
				System.out.println("Avilable seat: "+fDto.getAvailableSeats());
				System.out.println("Total seat: "+fDto.getTotalSeats());
				System.out.println("Date: "+fDto.getDate());
				System.out.println("Time: "+fDto.getTime());
				System.out.println("Source: "+fDto.getSource());
				System.out.println("Destination: "+fDto.getDestination());
				System.out.println("Travellar class: "+fDto.getTravellerClass());
				System.out.println("Airline id: "+fDto.getAirline());
				
			}catch (Exception e) {
				System.out.println(e);
			}
			
   break;
		case "u":
		Flight f=new Flight();
		System.out.println("Enter the new Avilable Seats: ");
		int a_seat=sc.nextInt();
		System.out.println("Enter the new Total Seats: ");
		int t_seat=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the new traveller class: ");
		String t_class=sc.nextLine();
		System.out.println("Enter the new time: ");
		String time=sc.nextLine();
		System.out.println("Enter the date: ");
		String d=sc.nextLine();
		LocalDate date=LocalDate.parse(d); 
		System.out.println("enter the new source: ");
		String source=sc.nextLine();
		System.out.println("enter the new destination: ");
		String dest=sc.nextLine();
		f.setAvailableSeats(a_seat);
		f.setTotalSeats(t_seat);
		f.setTravellerClass(t_class);
		f.setTime(time);
		f.setDate(date);
		f.setSource(source);
		f.setDestination(dest); 
		FlightDTO upfl=fService.updateFlight(Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")),
				f);
		System.out.println("flight updated successfully");
	  break;
			
		case "d":
			
			try {
				fService.deleteFlight(Integer.parseInt(JOptionPane.showInputDialog("enter id to delete", "type here")));
				JOptionPane.showMessageDialog(null, "Object is deleted!!!!");
				 }catch(PersistenceException e)
				 {
					 System.out.println(e.getMessage());
				 }
				 break;
		case "q":
			AdminOpeartion();
			break;
			default:System.out.println("wrong input");
//		
	}//switch 
		}
} //crud flight
	
		
//this method is responsible to assign flights to airline		
public static void assignAirlineToFlight()
{
	System.out.println("enter the Flight id: ");
	int f_id=sc.nextInt();
	System.out.println("enter the Airline  id: ");
	int a_id=sc.nextInt();
	aService.assignAirlineToFlight(f_id, a_id);
	System.out.println("flight assign to airline successfully");
}
//this method lets you print your boarding pass using your ticket id
public static void boardingPass()
{
	System.out.println();
	TicketBookingDTO tDto=tService.getTicket(Integer.parseInt(JOptionPane.showInputDialog("Enter ticket id", "type here")));
	System.out.println("==============================================================");
	System.out.println("  Airways: "+tDto.getAirlineId().getAirlineName()+"\t\t BOARDING PASS");
	System.out.println("  Ticket No.: "+tDto.getTicketId());
	System.out.println("  Name: "+tDto.getPassengerId().getName()+"\t\tNo. of passengers: "+tDto.getNo_of_passenger());
	System.out.println("  From: "+tDto.getFlightId().getSource()+"\t\t\tTo: "+tDto.getFlightId().getDestination());
	System.out.println("  Flight: "+tDto.getFlightId().getFlight_id()+"\t\t\tDate:"+tDto.getFlightId().getDate());
	System.out.println("=============================================================");
}

//this method is responsible to  perform crud operation of Airline
	public static void crudAirline()
	{
	
		
		String in;
		while(true) {
		System.out.println("============================================================================");
	System.out.println("Press c. for add Airline details\n"
			+ "Press r. for get AIrline details\n Press u.for update Airline details\n Press d.for delete Airline details\n"
			+ " Press q for quit ");
	System.out.println("============================================================================");
	in=JOptionPane.showInputDialog("Enter choice","Type here");
	
	switch(in) {
	
	case "c":
		Airline airline2=new Airline();
		System.out.println("Enter the airline name");
		String a_name=sc.nextLine();
		System.out.println("Enter the airline Fare: ");
		float a_fare=sc.nextFloat();
		
		airline2.setAirlineName(a_name);
		airline2.setFare(a_fare);
	    aService.saveAirline(airline2);
	    System.out.println("Airline saved succeessfully");
	    break;
	case "r":
		try {
			System.out.println("enter the name of airlines: ");
			String name=sc.nextLine();
			AirlineDTO pDto=aService.getAirlineByName(name);
			System.out.println("Airlines details: ");
			System.out.println(pDto.getId());
			System.out.println(pDto.getAirlineName());
			System.out.println(pDto.getFare());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		break;
	case "u":
		Airline airline=new Airline();
		String name;
		
		float fare;
		System.out.println("enter the new airline name: ");
		name=sc.nextLine();
		System.out.println("enter the new airline Fare: ");
		fare=sc.nextFloat();
		airline.setAirlineName(name);
		airline.setFare(fare);
		
		AirlineDTO air=aService.updateAirlneById(Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")),
				airline);
		System.out.println("Airline updated successfully");
	break;	
	case "d":
		try {
		aService.deleteAirline(Integer.parseInt(JOptionPane.showInputDialog("enter id to delete", "type here")));
			JOptionPane.showMessageDialog(null, "Object is deleted!!!!");
			 }catch(PersistenceException e)
			 {
				 System.out.println(e.getMessage());
			 }
			 break;
	case "q":
		AdminOpeartion();
		break;
	}//end of switch
	}//end of while
	}//end of method
		
	//this method is responsible to  perform of booking flights
public static void 	bookFlight()
{
	List<Flight> flights=fService.checkFlight(JOptionPane.showInputDialog("Enter From","Type here"),
			JOptionPane.showInputDialog("Enter To","Type here"),
			LocalDate.parse(JOptionPane.showInputDialog("Enter Date","Type here")));
	System.out.println("Flight Id \t Airline Name \t From \t To \t Fare \t Timing \tDate ");
	for(Flight flight: flights)
	{
		System.out.println(flight.getFlight_id() +"\t\t"+ flight.getAirline().getAirlineName()+"\t"+ 
	flight.getSource()+"\t"+ flight.getDestination()+"\t"+flight.getAirline().getFare()+"\t"+
			flight.getTime()+"\t"+flight.getDate());
	}
		System.out.println("For booking press Yes");
		String choice=JOptionPane.showInputDialog("Enter Here","Type here");
		if(choice.equalsIgnoreCase("yes"))
		{
			int flight_id=Integer.parseInt(JOptionPane.showInputDialog("Enter Flight ID","Type here"));
			int no_of_passenger=Integer.parseInt(JOptionPane.showInputDialog("Enter total passenger","Type here"));
		    LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter Date","Type here"));
		    String pEmail=JOptionPane.showInputDialog("Enter Passenger Email","Type here");
		    String airName=JOptionPane.showInputDialog("Enter AirLine Name","Type here");
		    TicketBookingDTO ticketDTO=tService.bookFlight(flight_id, no_of_passenger, date, pEmail, airName);
		    System.out.println("your booking has done successfully");
		    TicketGenerationPdf.TicketGeneration(ticketDTO);
		
	}
}
	//this method is responsible for checking the flights
	public static void checkFlights()
	{
		List<Flight> flights=fService.checkFlight(JOptionPane.showInputDialog("Enter From","Type here"),
				JOptionPane.showInputDialog("Enter To","Type here"),
				LocalDate.parse(JOptionPane.showInputDialog("Enter Date","Type here")));
		System.out.println("Flight Id \t Airline Name \t From \t To \t Fare \t Timing \tDate ");
		for(Flight flight: flights)
		{
			System.out.println(flight.getFlight_id() +"\t\t"+ flight.getAirline().getAirlineName()+"\t"+ 
		flight.getSource()+"\t"+ flight.getDestination()+"\t"+flight.getAirline().getFare()+"\t"+
				flight.getTime()+"\t"+flight.getDate());
		}
	}
	
		//sub menu to choose menu
		public static void crudOpeartion()
		{

	    	int input;
	    	while(true) {
	    		System.out.println("============================================================================");
	    	System.out.println("Press 1. for Passenger details\n Press 2. for check flights\n"
	    			+ "Press 3. for book flight\nPress 4. for Cancel Booking\n Press 5. for get boarding pass\nPress 6 for quit");
	         input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","Type here"));
	    	System.out.println("============================================================================");
	    	
	    	switch(input){
	    		
	    	case 1:
	    	crudPassenger();
	           break;
	    	
	    	case 2:
	    		checkFlights();
	    		break;
	    		
	    	case 3:
	    		bookFlight();
	    		break;
	    	case 4:
	    		System.out.println("Enter your ticket id");
	    		int id=sc.nextInt();
	    		tService.cancelBooking(id);
				JOptionPane.showMessageDialog(null, "Object is deleted!!!!");
	    		break;
	    	case 5:
	    		boardingPass();
	    		break;
	    	case 6:
	    		App.mainMenu();
	    		break;
	    		
	    	}
	    	}
		}
		//this method is use for admin operatione like flight crud ,airline crud, add flight to airlines
	    	public static void AdminOpeartion()
			{

		    	int input;
		    	while(true) {
		    		System.out.println("============================================================================");
		    	System.out.println("Press 1. for Flight details\n Press 2. for airline details\n"
		    			+ "Press 3. for add flight to airlines\nPress 4. for adminCrud\n Press 5. for quit");
		         input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","Type here"));
		    	System.out.println("============================================================================");
		    	
		    	switch(input){
		    		
		    	case 1:
		    	crudFlight();
		           break;
		    	
		    	case 2:
		    	crudAirline();
		    		break;
    		
		    	case 3:
		    		assignAirlineToFlight();
		    		break;
		    	case 4:
		    		crudAdmin();
		    		break;
		    	case 5:
		    		App.mainMenu();
		    		break;
		    		
	    	}
		    	}	
		    	
		}
}
