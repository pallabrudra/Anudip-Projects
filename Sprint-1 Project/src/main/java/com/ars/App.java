/*
 * 
 * This the an airline reservation system Application using core java and hibernate(use layered architecture)
 * 
 */
package com.ars;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ars.entity.Admin;
import com.ars.entity.Passenger;
import com.ars.service.AdminService;
import com.ars.service.PassengerService;
import com.ars.serviceimpl.AdminServiceImpl;
import com.ars.serviceimpl.PassengerServiceImpl;

public class App 
{
	//execution point of the application
    public static void main( String[] args )
    {
    	
      mainMenu();
    }
    static Scanner  sc=new Scanner(System.in);
    //main menu
    public static void mainMenu()
    {
    	System.out.println("Press A for Admin\nPress U for Passenger\n Press Q for exit");
        String choice=JOptionPane.showInputDialog("Enter choice","Type here");
       
         switch(choice)
         {
         case "A": mainAdmin();
         break;
         
         case "U": mainUser();
         break;
         
         case "Q": System.exit(0);
         }	
    }
  //this method responsible for registration and login of Admin
    public static void mainAdmin()
    {
              AdminService aService=new AdminServiceImpl();
    	
    	 String choice;
    	   while(true) {
    	    	System.out.println("Press R for Registration\nPress L for Login\n Press Q for exit");
    	        choice=JOptionPane.showInputDialog("Enter choice","Type here");
    	      
    	        switch(choice)
    	        {
    	        
    	        case "R":
    	       
    		        Admin admin=new Admin();
    		        System.out.println("Enter Name: ");
    		        String ad_name=sc.nextLine();
    		        System.out.println("Enter Email: ");
    		        String ad_email=sc.nextLine();
    		        System.out.println("Enter UserName: ");
    		        String ad_uname=sc.nextLine();
    		        System.out.println("Enter Password: ");
    		        String ad_pass=sc.nextLine();
    		        System.out.println("enter Role: ");
    		        String ad_role=sc.nextLine();
    		        admin.setAName(ad_name);
    		       admin.setEmail(ad_email);
    		       admin.setUserName(ad_uname);
    		       admin.setPassword(ad_pass);
    		       admin.setRole(ad_role);
    		        
    		       aService.registerAdmin(admin);
    		       
    		        System.out.println("Admin Registration has done successfully");
    		        break;
    		        
    	        case "L":
    	        	boolean status=aService.loginAdmin(JOptionPane.showInputDialog("Enter UserName","Type here"),
    	        			JOptionPane.showInputDialog("Enter password","Type here"));
    	        	if(status==true)
    	        		CrudOperation.AdminOpeartion();
    	        	else
    	        		System.out.println("Invalid Credentials!!");
    	        	System.exit(0);
    	        	break;
    	        	
    	        case "Q":
    	        	mainMenu();
    	        }
    	       }
    }
    //this method responsible for registration and login of passenger
    public static void mainUser()
    {
     PassengerService pservice=new PassengerServiceImpl();
    String choice;
   while(true) {
    	System.out.println("Press R for Registration\nPress L for Login\n Press Q for exit");
        choice=JOptionPane.showInputDialog("Enter choice","Type here");
      
        switch(choice)
        {
        
        case "R":
        	Passenger passenger1=new Passenger();
        	System.out.println("Enter the Name: ");
        	String p_name=sc.nextLine();
        	System.out.println("Enter the Email: ");
        	String p_email=sc.nextLine();
        	System.out.println("Enter the UserName: ");
        	String p_uname=sc.nextLine();
        	System.out.println("Enter the Password: ");
        	String p_pass=sc.nextLine();
        	System.out.println("Enter the Role: ");
        	String p_role=sc.nextLine();
        	System.out.println("Enter the Phone Number: ");
        	String p_ph=sc.nextLine();
        	
	        passenger1.setName(p_name);
	        passenger1.setEmail(p_email);
	        passenger1.setPhno(p_ph);
	        passenger1.setUserName(p_uname);
	        passenger1.setPassword(p_pass);
	        passenger1.setRole(p_role);
	        
	        //for save passenger,invoking savePassenger() method from service class
	        pservice.savePassenger(passenger1);
	        
	        System.out.println("passenger Registration has done successfully");
	        break;
	        
        case "L":
        	boolean status=pservice.login(JOptionPane.showInputDialog("Enter UserName","Type here"),
        			JOptionPane.showInputDialog("Enter password","Type here"));
        	if(status==true)
        		CrudOperation.crudOpeartion();
        	else
        		System.out.println("Invalid Credentials!!");
        	System.exit(0);
        	break;
        	
        case "Q":
        	mainMenu();
        }
       }
    }
}
