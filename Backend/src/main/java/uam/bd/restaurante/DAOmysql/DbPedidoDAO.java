package uam.bd.restaurante.DAOmysql;

import com.sun.jdi.connect.spi.Connection;

import uam.bd.restaurante.DAO.DAO;
import uam.bd.restaurante.model.Pedido;

public class DbPedidoDAO {
	private final Connection connection;

	public DbPedidoDAO(Connection connection) {
		this.connection = connection;
	}


	
}
