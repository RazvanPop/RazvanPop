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

public class AngajatConnection {

	protected static final Logger LOGGER=Logger.getLogger(PlantaConnection.class.getName());
	private static final String insertStatementString ="INSERT INTO angajat(nume,username,parola)"+ " VALUES (?,?,?)";
	private final static String findStatementString= "SELECT * FROM angajat where nume = ?";
	private final static String deleteStatementString= "DELETE FROM angajat where nume = ?";
	private final static String updateStatementString="UPDATE angajat SET username=?, parola=? where nume=?";
	private final static String viewAllStatementString="SELECT * FROM angajat";	
	
	/*
	public Planta findByDenumire(String denumire)
	{
		Planta toReturn=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findStatementString);
			findStatement.setString(1,denumire);
			rez=findStatement.executeQuery();
			rez.next();
			
			//String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn=new Planta(denumire, tip, specie, carnivor, zona);
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:findByDenumire "+ e.getMessage());
		}
		finally 
		{
			ConnectionFactory.close(rez);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public Planta findByTip(String tip)
	{
		Planta toReturn=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findStatementString);
			findStatement.setString(2,tip);
			rez=findStatement.executeQuery();
			rez.next();
			
			String denumire=rez.getString("denumire");
			//String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn=new Planta(denumire, tip, specie, carnivor, zona);
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:findByTip "+ e.getMessage());
		}
		finally 
		{
			ConnectionFactory.close(rez);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	
	public Planta findByZona(String zona)
	{
		Planta toReturn=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findStatementString);
			findStatement.setString(5,zona);
			rez=findStatement.executeQuery();
			rez.next();
			
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			//String zona=rez.getString("zona");
			toReturn=new Planta(denumire, tip, specie, carnivor, zona);
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:findByZona "+ e.getMessage());
		}
		finally 
		{
			ConnectionFactory.close(rez);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	public Planta findBySpecie(String specie)
	{
		Planta toReturn=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findStatementString);
			findStatement.setString(3,specie);
			rez=findStatement.executeQuery();
			rez.next();
			
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			//String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn=new Planta(denumire, tip, specie, carnivor, zona);
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:findBySpecie "+ e.getMessage());
		}
		finally 
		{
			ConnectionFactory.close(rez);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public Planta findByCarnivor(String carnivor)
	{
		Planta toReturn=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findStatementString);
			findStatement.setString(4,carnivor);
			rez=findStatement.executeQuery();
			rez.next();
			
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			//String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn=new Planta(denumire, tip, specie, carnivor, zona);
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:findByCarnivor "+ e.getMessage());
		}
		finally 
		{
			ConnectionFactory.close(rez);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	*/
	
	public static int insert(Angajat angajat)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement insertStatement=null;
		int insertedId=-1;
		try
		{
			insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);		
			insertStatement.setString(1, angajat.getName());
			insertStatement.setString(2,angajat.getUsername());
			insertStatement.setString(3, angajat.getPass());
			insertStatement.executeUpdate();
		    ResultSet rez=insertStatement.getGeneratedKeys();
			if (rez.next())
			{
				insertedId=rez.getInt(1);
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"AngajatConnection:insert "+e.getMessage());
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
			LOGGER.log(Level.WARNING,"AngajatConnection:delete "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deleteId;
	}
	
	public static int update(Angajat angajat)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement updateStatement=null;
		int id=0;
		try
		{
			updateStatement= dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			
			updateStatement.setString(1,angajat.getUsername());
			updateStatement.setString(2, angajat.getPass());
			updateStatement.setString(3, angajat.getName());
			updateStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"AngajatConnection:update "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return id;
	}
	
	public static List<Angajat> createObjects(ResultSet resultSet) 
	{
		List<Angajat> list=new ArrayList<Angajat>();
		
		try
		{
			while(resultSet.next())
			{
				String nume=resultSet.getString(1);
				String username=resultSet.getString(2);
				String parola=resultSet.getString(3);

			list.add(new Angajat(nume,username,parola));
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,e.getMessage());
		}
			return list;
	}
	
	public static List<Angajat> viewAll()
	{
		List<Angajat> list_angajat=new ArrayList<Angajat>();
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement viewStatement=null;
		try
		{
			viewStatement= dbConnection.prepareStatement(viewAllStatementString, Statement.RETURN_GENERATED_KEYS);
			ResultSet rez=viewStatement.executeQuery();
			list_angajat=createObjects(rez);
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
		return list_angajat;	
	}
	
}
