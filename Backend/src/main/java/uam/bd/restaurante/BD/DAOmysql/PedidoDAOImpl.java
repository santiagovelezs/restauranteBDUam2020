package uam.bd.restaurante.BD.DAOmysql;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uam.bd.restaurante.BD.DAO.DAO_Foreign;
import uam.bd.restaurante.BD.Model.Pedido;


public class PedidoDAOImpl implements DAO_Foreign<Pedido>
{
	private final Connection connection;

	public PedidoDAOImpl(Connection connection)
	{
		this.connection = connection;
	}

	@Override
	public List<Pedido> getAll() throws Exception {
         List<Pedido> elements = new ArrayList<>();
        
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM pedido");
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next())
        {
        	Pedido pedido = createPedido(resultSet);        	          
            elements.add(pedido);
        }
        
        return elements;
	}

	@Override
	public Pedido getBy(String numero) throws Exception {
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM pedido WHERE numero = ?");
        int id=Integer.parseInt(numero);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) 
		{
			return createPedido(resultSet);
		} 
		else 
		{
			return null;
		}
	}

	@Override
	public boolean save(Pedido t) throws Exception {
		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO pedido"
						+ "( fecha, cliente, usuario, estado, id_envio)"
						+ " VALUES (?, ?, ?, ?, ?)");
		
		statement.setDate(1, t.getFecha());
		statement.setString(2, t.getCliente());
		statement.setString(3, t.getEmpleado());
		statement.setInt(4, t.getEstado());
		statement.setInt(5, t.getIdEnvio());
		

		int affectedRows = statement.executeUpdate();

		return affectedRows > 0;
	}

	@Override
	public boolean update(Pedido t) throws Exception {
		PreparedStatement statement = connection
				.prepareStatement("UPDATE pedido "
						+ "SET fecha=?, cliente=?, usuario=?, estado=?, id_envio=?"
						+ " WHERE cedula=?");

		statement.setDate(1, t.getFecha());
		statement.setString(2, t.getCliente());
		statement.setString(3, t.getEmpleado());
		statement.setInt(4, t.getEstado());
		statement.setInt(5, t.getIdEnvio());

		return statement.executeUpdate() > 0;
	}

	@Override
	public boolean delete(Pedido t) throws Exception {
		PreparedStatement statement = connection
				.prepareStatement("DELETE FROM pedido "
						+ " WHERE numero=?");
		
		statement.setInt(1, t.getNumero());		

		return statement.executeUpdate() > 0;
	}

	
	
	
	private Pedido createPedido(ResultSet resultSet) throws SQLException
    {
		Pedido pedido = new Pedido(
                resultSet.getInt("nombre"),
                resultSet.getDate("fecha"),
                resultSet.getString("cliente"),
                resultSet.getInt("estado"),
                resultSet.getString("usuario"),
                resultSet.getInt("id_envio")
        );

        return pedido;
    }

	@Override
	public List<Pedido> getAllById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
