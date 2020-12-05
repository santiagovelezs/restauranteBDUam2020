package uam.bd.restaurante.DAOmysql;

import java.sql.Connection;
import java.util.List;

import uam.bd.restaurante.DAO.DAO;
import uam.bd.restaurante.model.Persona;

public class PersonaDAOImpl implements DAO<Persona>{
	
	private final Connection connection;

	public PersonaDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public List getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getBy(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Persona t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Persona t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Persona t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
   
}
