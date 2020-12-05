package uam.bd.restaurante.BD.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uam.bd.restaurante.BD.DAO.DAO;
import uam.bd.restaurante.BD.DAOmysql.ClienteDAOImpl;
import uam.bd.restaurante.BD.DAOmysql.RepartidorDAOImpl;
import uam.bd.restaurante.BD.Model.Cliente;
import uam.bd.restaurante.BD.Model.Repartidor;
import uam.bd.restaurante.BD.MysqlConnector.DBConnection;

@RestController
public class RepartidorController {
private DAO<Repartidor> repartidorDAO;
	
	public RepartidorController()
	{
		repartidorDAO = new RepartidorDAOImpl(DBConnection.getConnection());
	}
	
	@PostMapping(path="/repartidor")
	public boolean saveCliente(@RequestBody Repartidor received) throws Exception
	{
		System.out.println("POST: "+received.getApellido());
		boolean save = repartidorDAO.save(received);
		
		return save;
	}
}
