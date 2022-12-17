package project_pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Db {

	
	public void menu() {
		System.out.println("********* Database Management *************");
		System.out.println("1.Enter new record");
		System.out.println("2.Edit existing record details");
		System.out.println("3.Display all records");
		System.out.println("4.Remove record form database");
		System.out.println("5.Exit");



	}

	public void add_record() {
		try {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/olstore","root","");
	    	   PreparedStatement ps = con.prepareStatement("Insert into info values(?,?,?,?)");
	    	   Scanner sc = new Scanner(System.in);
	    	   System.out.println("Enter Customer Id");
	    	   int id = sc.nextInt();
	    	   System.out.println("Enter Customer Name");
	    	   String name = sc.next();
	    	   System.out.println("Enter Customer Address");
	    	   String adr = sc.next();
	    	   System.out.println("Enter Customer Contact Number");
	    	   int num = sc.nextInt();
	    	   
	    	   ps.setInt(1, id);
	    	   ps.setString(2,name);
	    	   ps.setString(3,adr);
	    	   ps.setInt(4, num);
	    	   
	    	   int i = ps.executeUpdate();
	    	   System.out.println("Customer Record Inserted Successfully");
	    	   
	       }
	       catch (Exception e)
	       {
	    	   System.out.println(e);
	       }

		
	}

	
	public void edit_record() {
		try {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/olstore","root","");
	    	   PreparedStatement ps = con.prepareStatement("Update info set name=? where id=?");
	    	   Scanner sc = new Scanner(System.in);
	    	   
	    	   System.out.println("Enter name");
	    	   String name = sc.next();
	    	   System.out.println("Enter Id");
	    	   int id = sc.nextInt();
	    	   
	    	   
	    	   ps.setString(1,name);
	    	   ps.setInt(2, id);
	    	   
	    	   int i = ps.executeUpdate();
	    	   System.out.println("Customer Record Updated Successfully");
	    	   
	       }
	       catch (Exception e)
	       {
	    	   System.out.println(e);
	       }


		
	}

	
	public void display_records() {
		try {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/olstore","root","");
	    	   java.sql.Statement st = con.createStatement();
	    	   ResultSet rs = st.executeQuery("Select * from info");
	    			   
	    	   System.out.println("ID "+"Name "+"Address  "+"Contact Number");
	    	   while(rs.next())
	    	   {
	    		   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
//	    		   int i = rs.getInt(1);
	    		   
	    	   }
	    	   
	       }
	       catch (Exception e)
	       {
	    	   System.out.println(e);
	       }


	}

	
	public void remove_record() {
		try {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/olstore","root","");
	    	   PreparedStatement ps = con.prepareStatement("Delete from info where id=?");
	    	   Scanner sc = new Scanner(System.in);
	    	   
	    	   System.out.println("Enter Customer Id:");
	    	   int id = sc.nextInt();
	    	   ps.setInt(1, id);
	    	   
	    	   int i = ps.executeUpdate();
	    	   System.out.println("Record Deleted Successfully");
	    	   
	       }
	       catch (Exception e)
	       {
	    	   System.out.println(e);
	       }


		
	}


}
