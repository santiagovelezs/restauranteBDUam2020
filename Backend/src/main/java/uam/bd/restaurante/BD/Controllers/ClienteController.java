package uam.bd.restaurante.BD.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uam.bd.restaurante.BD.DAO.DAO;
import uam.bd.restaurante.BD.DAOmysql.ClienteDAOImpl;
import uam.bd.restaurante.BD.Model.Cliente;
import uam.bd.restaurante.BD.MysqlConnector.DBConnection;

@RestController
public class ClienteController {
private DAO<Cliente> clienteDAO;
	
	public ClienteController()
	{
		clienteDAO = new ClienteDAOImpl(DBConnection.getConnection());
	}
	
	@PostMapping(path="/cliente")
	public boolean saveCliente(@RequestBody Cliente received) throws Exception
	{
		System.out.println("POST: "+received.getApellidos());
		boolean save = clienteDAO.save(received);
		
		return save;
	}
}
