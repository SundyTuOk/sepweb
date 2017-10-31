package com.tu.tutest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.commonbase.BaseHttpServlet;

public class TuTest extends BaseHttpServlet {

	private void test1(HttpServletRequest req,HttpServletResponse rsp) throws SQLException
	{
		List<Integer> ammeterIDs = new ArrayList<Integer>();
		
		//查询所有AMMETER_ID
		String sql = "select AMMETER_ID from AMMETER";
		PreparedStatement ps= null;
		ResultSet rs =null;
		Connection conn=null;
		
		conn=getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			ammeterIDs.add(rs.getInt("AMMETER_ID"));
		}
		//查询所有ZAMDATAS+AMMETER_ID 的电表的终止值
		
		
	}
	
	
	public static Connection getConnection() throws SQLException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.7.176:1521:orcl", "VESSCHOOL1760312", "sa_123456");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
