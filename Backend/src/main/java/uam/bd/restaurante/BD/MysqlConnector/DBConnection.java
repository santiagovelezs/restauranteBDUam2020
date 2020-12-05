package uam.bd.restaurante.BD.MysqlConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;;

public class DBConnection 
{
	private static Connection conn = null;

	public static Connection getConnection() 
	{
		if (conn == null) 
		{
			String url = "jdbc:mysql://localhost/restaurante";	        
	        Properties properties = new Properties();
	        properties.put("user", "santi");
	        properties.put("password", "1926");
			try 
			{				
				conn = DriverManager.getConnection(url, properties);
				System.out.println("Connnn");
			} 
			catch (SQLException e)
			{
				Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return conn;
	}

	public static void closeConnection() 
	{
		if (conn != null) 
		{
			try 
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}	

	public static void closeStatement(Statement st) 
	{
		if (st != null) 
		{
			try 
			{
				st.close();
			} 
			catch (SQLException e) 
			{
				Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	public static void closeResultSet(ResultSet rs) 
	{
		if (rs != null)
		{
			try 
			{
				rs.close();
			} 
			catch (SQLException e) 
			{
				Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
}
