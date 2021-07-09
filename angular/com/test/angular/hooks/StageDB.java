package com.test.angular.hooks;
import static com.test.angular.hooks.Config.*;
import static com.test.angular.excel.Excel_Read.*;
import static com.test.angular.hooks.Wait.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.angular.excel.Excel_Read;

public class StageDB
{
	public static Statement st=null;
	public static Connection con=null;
	public static void connectToDB() throws SQLException
	{
		con=DriverManager.getConnection("jdbc:sqlserver://"+host+":"+portNumber+";databasename="+DBName, uname, pass);
		st=con.createStatement();
			
	}
	
	public void vendorDBUpdates(Statement st,String vendorMail) throws SQLException, InterruptedException
	{
		wait2Second();
		String selectQuery="select * from aspnetusers where email="+"'"+vendorMail+"'";
		int vendorId;
		
		ResultSet rs=st.executeQuery(selectQuery);
		rs.next();
		vendorId=rs.getInt(1);
		System.out.println("VendorID:"+vendorId);
		
		String updateBackcheckQuery="update vendorinformation set IsBackgroundCheckDone=1,BackgroundcheckStatus='CONSIDER' where Userid="+vendorId;
		String updateQwilQuery="update vendorinformation set QwilID=1234 where userid="+vendorId;
		
		wait2Second();
		st.execute(updateBackcheckQuery);
		st.execute(updateQwilQuery);
		
	
	}
	

	public void employeeMailConfirm(Statement st,String employeeMail) throws SQLException, InterruptedException
	{
		wait5Second();
				
		String confirmEmail="update aspnetusers set EmailConfirmed=1 where email="+"'"+employeeMail+"'";
			
		st.execute(confirmEmail);
		
	
	}
	
	public void companyStatusUpdate(Statement st, String ownerMail ) throws InterruptedException, SQLException
	{
		wait2Second();
		String selectQuery="select * from aspnetusers where email="+"'"+ownerMail+"'";
		int vendorId;
		
		ResultSet rs=st.executeQuery(selectQuery);
		rs.next();
		vendorId=rs.getInt(1);
		System.out.println("VendorID:"+vendorId);
		
		String updateOwnerStatus="update Cleaning_CompanySetup set Status='Active' where userid="+"'"+vendorId+"'";
		
		st.execute(updateOwnerStatus);
		
		
		
	}
	
	public void confirmEmail() throws InterruptedException, SQLException
	{
		wait2Second();
		String selectQuery="select * from aspnetusers where email="+"'"+Excel_Read.Login_Username+"'";
		
		ResultSet rs=st.executeQuery(selectQuery);
		rs.next();
		int userId=rs.getInt(1);
		
		System.out.println("UserID generated--->"+userId);
		
		String updateQuery="update aspnetusers set EmailConfirmed=1 where id="+"'"+userId+"'";
		st.execute(updateQuery);
		
	}
	
	
	public void DBupdateForCompanyUser(String userEmail) throws InterruptedException, SQLException
	{
		wait2Second();
		String selectQuery="select * from aspnetusers where email="+"'"+userEmail+"'";
		int vendorId;
		
		ResultSet rs=st.executeQuery(selectQuery);
		rs.next();
		vendorId=rs.getInt(1);
		System.out.println("VendorID:"+vendorId);
		
		String updateBackcheckQuery="update vendorinformation set IsBackgroundCheckDone=1,BackgroundcheckStatus='CONSIDER' where Userid="+vendorId;
		
		
		wait2Second();
		st.execute(updateBackcheckQuery);
	
		
		
		String updateCompanyUserActive="update Cleaning_CompanyInvites set Status='Active' where email = '"+userEmail+"'";
		
		st.execute(updateCompanyUserActive);
		
		
	}
	
	public static void closeDB() throws SQLException
	{
		con.close();
			
	}
	
}
