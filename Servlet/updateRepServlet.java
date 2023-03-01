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

@WebServlet("/updates")
public class updateRepServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		try{
			
			 String uid = request.getParameter("id");
    	     int  id = Integer.parseInt(uid);
			String email = request.getParameter("email");
			String ph = request.getParameter("ph");
			String date = request.getParameter("date");
			String nperson = request.getParameter("nperson");
			String addr = request.getParameter("addr");
			String price = request.getParameter("price"); 
			
			book bt = new book();
			
			bt.setId(id);
			bt.setEmail(email);
			bt.setPh(ph);
			bt.setDate(date);
			bt.setNperson(nperson);
			bt.setAddr(addr);
			bt.setPrice(price);

    	    UserDao dao = new UserDao(DBConnect.getConn());
            boolean f = dao.updateReport(bt);
            
            if(f){
				
				session.setAttribute("ntfe", "Ticket Report Updated Succesfully.");
				response.sendRedirect("travelReport.jsp");
			}
			else{
				session.setAttribute("ntfe", "Something Went Wrong!");
				response.sendRedirect("editReport.jsp");
			}
    	    
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
