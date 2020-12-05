package uam.bd.restaurante.BD.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uam.bd.restaurante.BD.DAO.DAO;
import uam.bd.restaurante.BD.DAOmysql.EmpleadoDAOImpl;
import uam.bd.restaurante.BD.Model.Empleado;
import uam.bd.restaurante.BD.MysqlConnector.DBConnection;

@RestController
public class EmpleadoController 
{
	private DAO<Empleado> empleadoDAO;
	
	public EmpleadoController()
	{
		empleadoDAO = new EmpleadoDAOImpl(DBConnection.getConnection());
	}
	
	@PostMapping(path="/empleado")
	public boolean saveEmpleado(@RequestBody Empleado received) throws Exception
	{
		System.out.println("POST: "+received.getApellido());
		boolean save = empleadoDAO.save(received);
		
		return save;
	}
	
	@GetMapping("/")		
	public String index()
	{		
		return "Welcome To the restaurant API";
	}
}
