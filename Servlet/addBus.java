package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.Dao.busDao;
import com.entity.busData;

@WebServlet("/add_bus")
public class addBus extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try{
			
			String bno = request.getParameter("bno");
			String bname = request.getParameter("bname");
			String fcity = request.getParameter("fcity");
			String tcity = request.getParameter("tcity");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String price = request.getParameter("price");
			
			HttpSession session = request.getSession();
			
			busDao dao = new busDao(DBConnect.getConn());
			
			busData bs = new busData(bno, bname, fcity, tcity, date, time, price);
			
			boolean f = dao.addBuses(bs);
			
	if(f){
				
				session.setAttribute("ntf", "Bus Added Sucessfully.");
				response.sendRedirect("addBuses.jsp");
//				out.print("<p style = 'color:green; margin-top:-48%; margin-left:33pc; font-size:16px; background-color:limegreen; color:white; width:13pc; border-radius:6px; text-align:center; padding:4px;'>Registered Succesfully..</p>");	
			}else{
				session.setAttribute("ntf", "Something Went Wrong!");
				response.sendRedirect("addBuses.jsp");
//				out.print("<h4  style = 'color:green; margin-top:-43%; margin-left:33pc; font-size:16px; background-color:tomato; color:white; width:13pc; border-radius:6px; text-align:center; padding:4px;''>Something Wrong!</h4>");
			}

		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
