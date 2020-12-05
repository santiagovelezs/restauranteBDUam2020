package uam.bd.restaurante.DAOmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import uam.bd.restaurante.DAO.DAO_Foreign;
import uam.bd.restaurante.model.LineaPedido;

public class LineaPedidoDAOImpl implements DAO_Foreign<LineaPedido>{
      
	private  final Connection connection;

	public LineaPedidoDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public List getAll() throws Exception {
        List<LineaPedido> elements = new ArrayList<>();
        
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM productos_pedido");
        ResultSet resultSet = statement.executeQuery();
        
        while(resultSet.next())
        {
            LineaPedido lineaPedido = createLineaPedido(resultSet);
            
            elements.add(lineaPedido);
        }
        
        return elements;
	}

	@Override
	public LineaPedido getBy(int id) throws Exception {
        PreparedStatement statement =
                connection.prepareStatement("SELECT * FROM productos_pedido WHERE id_pedido = ?");

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return createLineaPedido(resultSet);
            } else {
                return null;
            }
		
	}

	@Override
	public boolean save(LineaPedido t) throws Exception {
		PreparedStatement statement =
	            connection.prepareStatement(
	                    "INSERT INTO productos_pedido(id_pedido, id_producto, cantidad, valor_un) VALUES (?,?,?,?)", 
	                    Statement.RETURN_GENERATED_KEYS);
	        
	        statement.setInt(1, t.getIdPedido());
	        statement.setString(2, t.getIdProducto());
	        statement.setInt(3, t.getCantidad());
	        statement.setFloat(4, t.getValorUnit());
	        
	        
	        int affectedRows = statement.executeUpdate();
	        
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        generatedKeys.next();
	        t.setIdPedido(generatedKeys.getInt(1));

	        return affectedRows > 0;
	}

	@Override
	public boolean update(LineaPedido t) throws Exception {
		PreparedStatement statement =
	            connection.prepareStatement("UPDATE productos_pedido  id_producto=?, cantidad=?, valor_un=? WHERE id-pedido=?");

		
        statement.setString(2, t.getIdProducto());
        statement.setInt(3, t.getCantidad());
        statement.setFloat(4, t.getValorUnit());

	        return statement.executeUpdate() > 0;
	}

	@Override
	public boolean delete(LineaPedido t) throws Exception {
		
	}

	@Override
	public List<LineaPedido> getAllById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	 
	 private LineaPedido createLineaPedido(ResultSet resultSet) throws SQLException
	    {
	        LineaPedido lineaPedido = new LineaPedido(
	                resultSet.getInt("id_pedido"),
	                resultSet.getFloat("valor_un"),
	                resultSet.getString("id_producto"),
	                resultSet.getInt("cantidad")
	                
	        );

	        return lineaPedido;
	    }
	
	
	
}
