package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.Dao.busDao;
import com.entity.busData;

@WebServlet("/update")
public class updateBusServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		try{
			
			String uid = request.getParameter("id");
			int id = Integer.parseInt(uid);
			String bno = request.getParameter("bno");
			String bname = request.getParameter("bname");
			String fcity = request.getParameter("fcity");
			String tcity = request.getParameter("tcity");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String price = request.getParameter("price");
			
			busData bs = new busData();
			
			bs.setId(id);
			bs.setBusNo(bno);
			bs.setBusName(bname);
			bs.setFromCity(fcity);
			bs.setToCity(tcity);
			bs.setDate(date);
			bs.setTime(time);
			bs.setTicketPrice(price);
			
			busDao dao = new busDao(DBConnect.getConn());
			boolean f = dao.updateBus(bs);
			
			if(f){
				
				session.setAttribute("ntf", "Bus Updated Succesfully.");
				response.sendRedirect("busReport.jsp");
			}
			else{
				session.setAttribute("ntf", "Something Went Wrong!");
				response.sendRedirect("busReport.jsp");
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
