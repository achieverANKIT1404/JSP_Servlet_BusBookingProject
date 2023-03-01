package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.busData;

public class busDao {

	private static Connection conn;

	public busDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addBuses(busData bs){
		
		boolean f = false;

		try{
			
			PreparedStatement ps = conn.prepareStatement("insert into buses(busNo,busName,fromCity,toCity,date,time,ticketPrice)values(?,?,?,?,?,?,?)");
				
				ps.setString(1, bs.getBusNo());
				ps.setString(2, bs.getBusName());
				ps.setString(3, bs.getFromCity());
				ps.setString(4, bs.getToCity());
				ps.setString(5, bs.getDate());
				ps.setString(6, bs.getTime());
				ps.setString(7, bs.getTicketPrice());
			
				 int i = ps.executeUpdate();
				    
				    if(i==1){
				    	
				    	f = true;
				    }
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	    return f;
	}
	
public  ArrayList<busData> getAllBuses(){
		
		ArrayList<busData> list = new ArrayList<>();
		busData bs = null;

		try{
			
			PreparedStatement ps = conn.prepareStatement("select * from buses order by id ");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				bs = new busData();
				
				bs.setId(rs.getInt(1));
				bs.setBusNo(rs.getString(2));
				bs.setBusName(rs.getString(3));
				bs.setFromCity(rs.getString(4));
				bs.setToCity(rs.getString(5));
				bs.setDate(rs.getString(6));
				bs.setTime(rs.getString(7));
				bs.setTicketPrice(rs.getString(8));
				
				list.add(bs);
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return list;
	}

public boolean updateBus(busData bs){
	
	boolean f = false;
			
			try{
				
				PreparedStatement ps = conn.prepareStatement("update buses set busNo=?,busName=?,fromCity=?,toCity=?,date=?,time=?,ticketPrice=? where id =?");
				
			    ps.setString(1, bs.getBusNo());
			    ps.setString(2, bs.getBusName());
			    ps.setString(3, bs.getFromCity());
			    ps.setString(4, bs.getToCity());
			    ps.setString(5, bs.getDate());
			    ps.setString(6, bs.getTime());
			    ps.setString(7, bs.getTicketPrice());
			    ps.setInt(8, bs.getId());
			    
			    int i = ps.executeUpdate();
			    
			    if(i==1){
			    	
			    	f = true;
			    }
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return f;
	    }
public busData getBusById(int id){
	
	busData bs = null;
	
	try{
		
		PreparedStatement ps = conn.prepareStatement("select * from buses where id=?");
		
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			
			bs = new busData();
			
			bs.setId(rs.getInt(1));
			bs.setBusNo(rs.getString(2));
			bs.setBusName(rs.getString(3));
			bs.setFromCity(rs.getString(4));
			bs.setToCity(rs.getString(5));
			bs.setDate(rs.getString(6));
			bs.setTime(rs.getString(7));
			bs.setTicketPrice(rs.getString(8));
			
		}
	}catch(Exception e){
		
		e.printStackTrace();
	}
	return bs;
}
public boolean deleteBus(int id){
	
	boolean f = false;
	
	try{
		
		PreparedStatement ps = conn.prepareStatement("delete  from buses where id=?");
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

public ArrayList<busData> getBusORtCityAndfCity(String fromCity, String toCity, String date){
	
	ArrayList<busData> list = new ArrayList<busData>();
	
	busData bs = null;
	
	try{
		
		PreparedStatement ps = conn.prepareStatement("select * from buses where fromCity=? or toCity=? or date=? order by id");
		
		ps.setString(1, fromCity);
		ps.setString(2, toCity);
		ps.setString(3, date);
		
		ResultSet rs = ps.executeQuery();
        while(rs.next()){
			
			bs = new busData();
			
			bs.setId(rs.getInt(1));
			bs.setBusNo(rs.getString(2));
			bs.setBusName(rs.getString(3));
			bs.setFromCity(rs.getString(4));
			bs.setToCity(rs.getString(5));
			bs.setDate(rs.getString(6));
			bs.setTime(rs.getString(7));
			bs.setTicketPrice(rs.getString(8));
			
			list.add(bs);
			
		}
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	return list;
	
}
}
