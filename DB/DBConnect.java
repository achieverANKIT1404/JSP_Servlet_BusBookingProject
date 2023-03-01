package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection conn;
	
	public static Connection getConn(){
		
		String url="jdbc:mysql://localhost:3306/busbooking",uname="root",passwrd="abc123";
		
		try{
			
			if(conn==null){
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				conn = DriverManager.getConnection(url,uname,passwrd);
				
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
	
		return conn;
	}
}
