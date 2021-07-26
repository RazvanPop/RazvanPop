package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminConnection {

	protected static final Logger LOGGER=Logger.getLogger(PlantaConnection.class.getName());
	private static final String insertStatementString ="INSERT INTO administrator(nume,username,parola)"+ " VALUES (?,?,?)";
	private final static String findStatementString= "SELECT * FROM administrator where nume = ?";
	private final static String deleteStatementString= "DELETE FROM administrator where nume = ?";
	private final static String updateStatementString="UPDATE administrator SET username=?, parola=? where nume=?";
	private final static String viewAllStatementString="SELECT * FROM administrator";	
	
	
	public static int insert(Admin administrator)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement insertStatement=null;
		int insertedId=-1;
		try
		{
			insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);		
			insertStatement.setString(1, administrator.getName());
			insertStatement.setString(2,administrator.getUsername());
			insertStatement.setString(3, administrator.getPass());
			insertStatement.executeUpdate();
		    ResultSet rez=insertStatement.getGeneratedKeys();
			if (rez.next())
			{
				insertedId=rez.getInt(1);
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"AdminConnection:insert "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	
	public static int delete(String nume)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement deleteStatement=null;
		int deleteId=-1;
		
		try
		{
			deleteStatement= dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setNString(1,nume);
			deleteStatement.executeUpdate();
			ResultSet rez=deleteStatement.getGeneratedKeys();
			if (rez.next())
			{
				deleteId=rez.getInt(1);
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"AdminConnection:delete "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deleteId;
	}
	
	public static int update(Admin administrator)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement updateStatement=null;
		int id=0;
		try
		{
			updateStatement= dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			
			updateStatement.setString(1,administrator.getUsername());
			updateStatement.setString(2, administrator.getPass());
			updateStatement.setString(3, administrator.getName());
			updateStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"AdminConnection:update "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return id;
	}
	
	public static List<Admin> createObjects(ResultSet resultSet) 
	{
		List<Admin> list=new ArrayList<Admin>();
		
		try
		{
			while(resultSet.next())
			{
				String nume=resultSet.getString(1);
				String username=resultSet.getString(2);
				String parola=resultSet.getString(3);

			list.add(new Admin(nume,username,parola));
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,e.getMessage());
		}
			return list;
	}
	
	public static List<Admin> viewAll()
	{
		List<Admin> list_admin=new ArrayList<Admin>();
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement viewStatement=null;
		try
		{
			viewStatement= dbConnection.prepareStatement(viewAllStatementString, Statement.RETURN_GENERATED_KEYS);
			ResultSet rez=viewStatement.executeQuery();
			list_admin=createObjects(rez);
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:viewAll "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(viewStatement);
			ConnectionFactory.close(dbConnection);
		}
		return list_admin;	
	}
}
