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

@WebServlet("/delete")
public class deleteBusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		try{
			
		    int id = Integer.parseInt(request.getParameter("id"));
		    
		    busDao dao = new busDao(DBConnect.getConn());
		    boolean f = dao.deleteBus(id);
		    
		    if(f){
		    	session.setAttribute("ntfk", "Bus Deleted Succesfully!");
				response.sendRedirect("busReport.jsp");
		    }
		    else{
		    	session.setAttribute("ntfk", "Something Went Wrong.");
				response.sendRedirect("busReport.jsp");
		    }

		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
