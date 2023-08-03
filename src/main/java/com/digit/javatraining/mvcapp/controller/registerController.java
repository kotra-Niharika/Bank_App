package com.digit.javatraining.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javatraining.mvcapp.model.BankApp;

@WebServlet("/Register")
public class registerController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		BankApp bankapp = new BankApp();
		bankapp.setBank_Id(Integer.parseInt(req.getParameter("Bank_Id")));
		bankapp.setBank_Name(req.getParameter("Bank_Name"));
		bankapp.setIFSC_Code(req.getParameter("IFSC_Code"));
		bankapp.setAcc_No(Integer.parseInt(req.getParameter("Acc_No")));
		bankapp.setPin(Integer.parseInt(req.getParameter("pin")));
		bankapp.setCust_Id(Integer.parseInt(req.getParameter("Cust_Id")));
		bankapp.setCust_Name(req.getParameter("Cust_Name"));
		bankapp.setBalance(Integer.parseInt(req.getParameter("Balance")));
		bankapp.setEmail(req.getParameter("Email"));
		bankapp.setPhone(Long.parseLong(req.getParameter("Phone")));
		
		boolean b = bankapp.Register();
		if(b==true) {
			res.sendRedirect("/Mvc_Bank_App/Success.html");
		}
		else {
			res.sendRedirect("/Mvc_Bank_App/Fail.html");
		}
	}

}
