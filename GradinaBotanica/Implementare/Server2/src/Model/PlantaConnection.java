package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;






public class PlantaConnection /*implements Subject*/{

	protected static final Logger LOGGER=Logger.getLogger(PlantaConnection.class.getName());
	private static final String insertStatementString ="INSERT INTO planta(denumire,tip,specie,carnivor,zona)"+ " VALUES (?,?,?,?,?)";
	private final static String findDenStatementString= "SELECT * FROM planta where denumire = ?";
	private final static String findTipStatementString= "SELECT * FROM planta where tip = ?";
	private final static String findZonaStatementString= "SELECT * FROM planta where zona = ?";
	private final static String findSpecieStatementString= "SELECT * FROM planta where specie = ?";
	private final static String findCarnivorStatementString= "SELECT * FROM planta where carnivor = ?";
	private final static String deleteStatementString= "DELETE FROM planta where denumire = ?";
	private final static String updateStatementString="UPDATE planta SET tip=?, specie=?, carnivor=?, zona=? where denumire=?";
	private final static String viewAllStatementString="SELECT * FROM planta";	
	
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public List<Planta> findByDenumire(String denumire2)
	{
		List<Planta> toReturn=new ArrayList<Planta>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findDenStatementString);
			findStatement.setString(1,denumire2);
			rez=findStatement.executeQuery();
			rez.next();
			
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn.add(new Planta(denumire, tip, specie, carnivor, zona));
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
	
	public List<Planta> findByTip(String tip2)
	{
		List<Planta> toReturn=new ArrayList<Planta>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findTipStatementString);
			findStatement.setString(1,tip2);
			rez=findStatement.executeQuery();
			//rez.next();

			while(rez.next())
			{
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn.add(new Planta(denumire, tip, specie, carnivor, zona));
			}
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
	
	
	public List<Planta> findByZona(String zona2)
	{
		List<Planta> toReturn=new ArrayList<Planta>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{	
			findStatement= dbConnection.prepareStatement(findZonaStatementString);
			findStatement.setString(1,zona2);
			rez=findStatement.executeQuery();
			//rez.next();
			
			while(rez.next())
			{
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn.add(new Planta(denumire, tip, specie, carnivor, zona));
			}
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
	public List<Planta> findBySpecie(String specie2)
	{
		List<Planta> toReturn=new ArrayList<Planta>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findSpecieStatementString);
			findStatement.setString(1,specie2);
			rez=findStatement.executeQuery();
		//	rez.next();
			
			while(rez.next())
			{
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn.add(new Planta(denumire, tip, specie, carnivor, zona));
			}
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
	
	public List<Planta> findByCarnivor(String carnivor2)
	{
		List<Planta> toReturn=new ArrayList<Planta>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement=null;
		ResultSet rez=null;
		
		try
		{
			findStatement= dbConnection.prepareStatement(findCarnivorStatementString);
			findStatement.setString(1,carnivor2);
			rez=findStatement.executeQuery();
		//	rez.next();
			
			while(rez.next())
			{
			String denumire=rez.getString("denumire");
			String tip=rez.getString("tip");
			String specie=rez.getString("specie");
			String carnivor=rez.getString("carnivor");
			String zona=rez.getString("zona");
			toReturn.add(new Planta(denumire, tip, specie, carnivor, zona));
			}
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
	
	
	
	public static int insert(Planta planta)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement insertStatement=null;
		int insertedId=-1;
		try
		{
			insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);		
			insertStatement.setString(1, planta.getDenumire());
			insertStatement.setString(2,planta.getTip());
			insertStatement.setString(3, planta.getSpecie());
			insertStatement.setString(4, planta.getCarnivor());
			insertStatement.setString(5,planta.getZona());
			insertStatement.executeUpdate();
		    ResultSet rez=insertStatement.getGeneratedKeys();
			if (rez.next())
			{
				insertedId=rez.getInt(1);
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:insert "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return insertedId;
	}
	public static int delete(String denumire)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement deleteStatement=null;
		int deleteId=-1;
		
		try
		{
			deleteStatement= dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setNString(1,denumire);
			deleteStatement.executeUpdate();
			ResultSet rez=deleteStatement.getGeneratedKeys();
			if (rez.next())
			{
				deleteId=rez.getInt(1);
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:delete "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deleteId;
	}
	
	public static int update(Planta planta)
	{
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement updateStatement=null;
		int id=0;
		try
		{
			updateStatement= dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			//updateStatement.setString(1, planta.getDenumire());
			updateStatement.setString(1,planta.getTip());
			updateStatement.setString(2, planta.getSpecie());
			updateStatement.setString(3, planta.getCarnivor());
			updateStatement.setString(4,planta.getZona());
			updateStatement.setString(5, planta.getDenumire());
			updateStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,"PlantaConnection:update "+e.getMessage());
		}
		finally
		{
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return id;
	}
	
	public static List<Planta> createObjects(ResultSet resultSet) 
	{
		List<Planta> list=new ArrayList<Planta>();
		
		try
		{
			while(resultSet.next())
			{
				String denumire=resultSet.getString(1);
				String tip=resultSet.getString(2);
				String specie=resultSet.getString(3);
				String carnivor=resultSet.getString(4);
				String zona=resultSet.getString(5);
			list.add(new Planta(denumire,tip,specie,carnivor,zona));
			}
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.WARNING,e.getMessage());
		}
			return list;
	}
	
	public static List<Planta> viewAll()
	{
		List<Planta> plante=new ArrayList<Planta>();
		Connection dbConnection=ConnectionFactory.getConnection();
		PreparedStatement viewStatement=null;
		try
		{
			viewStatement= dbConnection.prepareStatement(viewAllStatementString, Statement.RETURN_GENERATED_KEYS);
			ResultSet rez=viewStatement.executeQuery();
			plante=createObjects(rez);
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
		return plante;	
	}
/*
	@Override
	public void attach(Controller.Observer o) {
		observers.add((Observer) o);	
	}

	@Override
	public void dettach(Controller.Observer o) {
		observers.remove((Observer) o);	
	}
	
	
	public void notifyAllObservers() {
		      for (Observer observer : observers)
		      {
		         ((Controller.Observer) observer).updateP(this);
		      }	
	}
	public void addplanta(Planta p)
	{
		notifyAllObservers();
	}
	*/
}
