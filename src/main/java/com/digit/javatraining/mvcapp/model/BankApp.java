package com.digit.javatraining.mvcapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BankApp {
	int Bank_Id;
	String Bank_Name;
	String IFSC_Code;
	int Acc_No;
	int pin;
	int Cust_Id;
	String Cust_Name;
	int Balance;
	String Email;
	long Phone;
	private Connection con;
	private PreparedStatement pstmt;
	
	public BankApp() {
		String url="jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getBank_Id() {
		return Bank_Id;
	}
	public void setBank_Id(int bank_Id) {
		Bank_Id = bank_Id;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public String getIFSC_Code() {
		return IFSC_Code;
	}
	public void setIFSC_Code(String iFSC_Code) {
		IFSC_Code = iFSC_Code;
	}
	public int getAcc_No() {
		return Acc_No;
	}
	public void setAcc_No(int acc_No) {
		Acc_No = acc_No;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getCust_Id() {
		return Cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		Cust_Id = cust_Id;
	}
	public String getCust_Name() {
		return Cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		Cust_Name = cust_Name;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public boolean Register(){
		try {
			
			String sql = "insert into Bank_App values(?,?,?,?,?,?,?,?,?,?)";
			
			//pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Bank_Id);
			pstmt.setString(2, Bank_Name);
			pstmt.setString(3, IFSC_Code);
			pstmt.setInt(4, Acc_No);
			pstmt.setInt(5, pin);
			pstmt.setInt(6, Cust_Id);
			pstmt.setString(7, Cust_Name);
			pstmt.setInt(8, Balance);
			pstmt.setString(9, Email);
			pstmt.setLong(10, Phone);
			
			int x = pstmt.executeUpdate();
			if(x>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
