package uam.bd.restaurante.DAOmysql;

import java.sql.Connection;
import java.util.List;

import uam.bd.restaurante.DAO.DAO;
import uam.bd.restaurante.model.Producto;

public class ProductoDAOImp implements DAO<Producto>{

	private final Connection connection;

	public ProductoDAOImp(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public List getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getBy(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Producto t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Producto t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Producto t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
