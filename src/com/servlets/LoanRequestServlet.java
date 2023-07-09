package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbConnect.CustomerDBConncet;


@WebServlet("/LoanRequestServlet")
public class LoanRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("accNo");
		String name = request.getParameter("name");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String salary = request.getParameter("salary");
		String loanAmount = request.getParameter("amount");              
		String description = request.getParameter("description");
		boolean isSuccess;
		
		boolean insertValue = CustomerDBConncet.insertLoanDetails(userId,name,nic,email,phone,salary,loanAmount,description  );      
		
		if(insertValue == true) {
		    RequestDispatcher dis = request.getRequestDispatcher("userprofile.jsp");
		    dis.forward(request, response);  
	    }
	    else {
	    	System.out.println("<script type=\"text/javascript\">");
	    	System.out.println("alert('Somthing Happened!!! Your NIC is already in the system');");
	    	System.out.println("location='insertcustomer.jsp';");
	    	System.out.println("</script>");
	    }
	}

}
