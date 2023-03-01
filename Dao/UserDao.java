package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.entity.User;
import com.entity.book;
import com.entity.busData;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class UserDao {

	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(User u){
		
		boolean f = false;
		
		try{
			
			PreparedStatement ps = conn.prepareStatement("insert into users(fname,lname,email,password) values(?,?,?,?)");
			
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			
			int i = ps.executeUpdate();
			if(i==1){
				
				f = true;
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	public User login(String fname, String password){
		
		User u = null;
		
		try{
			
			PreparedStatement ps = conn.prepareStatement("select * from users where fname=? and password=?");
			
			ps.setString(1, fname);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				u = new User();
				
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		return u;
	}
	
public boolean bookTicket(book bt){
		
		boolean f = false;
		
		try{
			
			PreparedStatement ps = conn.prepareStatement("insert into booktb(email,ph,date,nperson,addr,price) values(?,?,?,?,?,?)");
			
			ps.setString(1, bt.getEmail());
			ps.setString(2, bt.getPh());
			ps.setString(3, bt.getDate());
			ps.setString(4, bt.getNperson());
			ps.setString(5, bt.getAddr());
			ps.setString(6, bt.getPrice());
			
			int i = ps.executeUpdate();
			if(i==1){
				
				f = true;
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return f;
	}

public boolean updateReport(book bt){
	
	boolean f = false;
			
			try{
				
				PreparedStatement ps = conn.prepareStatement("update booktb set email=?,ph=?,date=?,nperson=?,addr=?,price=? where id =?");
				
				ps.setString(1, bt.getEmail());
				ps.setString(2, bt.getPh());
				ps.setString(3, bt.getDate());
				ps.setString(4, bt.getNperson());
				ps.setString(5, bt.getAddr());
				ps.setString(6, bt.getPrice());
			    ps.setInt(7, bt.getId());
			    
			    int i = ps.executeUpdate();
			    
			    if(i==1){
			    	
			    	f = true;
			    }
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return f;
	    }
	
	public book getTravlerById(int id){
		
		book bt = null;
		
		try{
			
			PreparedStatement ps = conn.prepareStatement("select * from booktb where id =?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				
	            bt = new book();
				
				bt.setId(rs.getInt(1));
				bt.setEmail(rs.getString(2));
				bt.setPh(rs.getString(3));
				bt.setDate(rs.getString(4));
				bt.setNperson(rs.getString(5));
			    bt.setAddr(rs.getString(6));
			    bt.setPrice(rs.getString(7));
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return bt;
	}
	
public ArrayList<book> getAllReports(){
		
		ArrayList<book> list = new ArrayList<book>();
		
		book bt = null;
		
		try{
			
			PreparedStatement ps = conn.prepareStatement("select * from booktb order by id ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				bt = new book();
				
				bt.setId(rs.getInt(1));
				bt.setEmail(rs.getString(2));
				bt.setPh(rs.getString(3));
				bt.setDate(rs.getString(4));
				bt.setNperson(rs.getString(5));
			    bt.setAddr(rs.getString(6));
			    bt.setPrice(rs.getString(7));
				
				list.add(bt);
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return list;
	}

public boolean deleteReport(int id){
	
	boolean f = false;
	
	try{
		
		PreparedStatement ps = conn.prepareStatement("delete  from booktb where id=?");
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		
		if(i==1){
			
			f = true;
		}
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	return f;
}

}
