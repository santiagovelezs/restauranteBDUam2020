package uam.bd.restaurante.BD.DAOmysql;

import java.sql.Connection;
import java.util.List;

import uam.bd.restaurante.BD.DAO.DAO;
import uam.bd.restaurante.BD.Model.Producto;

public class ProductoDAOImpl implements DAO<Producto>
{

	private final Connection connection;

	public ProductoDAOImpl(Connection connection) 
	{
		super();
		this.connection = connection;
	}

	@Override
	public List<Producto> getAll() throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getBy(String id) throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Producto t) throws Exception 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Producto t) throws Exception 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Producto t) throws Exception 
	{
		// TODO Auto-generated method stub
		return false;
	}	
	
}
