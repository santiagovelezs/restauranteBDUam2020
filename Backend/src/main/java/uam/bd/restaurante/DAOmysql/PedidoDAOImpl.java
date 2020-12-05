package uam.bd.restaurante.DAOmysql;

import java.util.List;
import java.sql.Connection;

import uam.bd.restaurante.DAO.DAO_Foreign;
import uam.bd.restaurante.model.Pedido;

public class PedidoDAOImpl implements DAO_Foreign<Pedido>
{
	private final Connection connection;

	public PedidoDAOImpl(Connection connection)
	{
		this.connection = connection;
	}

	@Override
	public List getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido getBy(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Pedido t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Pedido t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Pedido t) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.util.List<Pedido> getAllById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
