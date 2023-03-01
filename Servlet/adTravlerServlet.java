package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.Dao.UserDao;
import com.entity.book;

@WebServlet("/adTravler")
public class adTravlerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
		
		HttpSession session = request.getSession();		
		
		try{
			
			String email = request.getParameter("email");
			String ph = request.getParameter("ph");
			String date = request.getParameter("date");
			String nperson = request.getParameter("nperson");
			String addr = request.getParameter("addr");
			String price = request.getParameter("price");

		    UserDao dao = new UserDao(DBConnect.getConn());

             book bt = new book(email, ph, date, nperson, addr, price);
 		     boolean f = dao.bookTicket(bt);
 		      		     
 		    if(f){
 				
 		    	session.setAttribute("email", email);
 		    	session.setAttribute("ph", ph);
 		    	session.setAttribute("date", date);
 		    	session.setAttribute("nperson", nperson);
 		    	session.setAttribute("addr", addr);
                session.setAttribute("price", price);
 				session.setAttribute("ntff", "Booked Ticket Succesfully.");
 				response.sendRedirect("ticketReport.jsp");
 			}
 			else{
 				session.setAttribute("ntff", "Something Went Wrong!");
 				response.sendRedirect("TravelDet.jsp");
 			}

		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
