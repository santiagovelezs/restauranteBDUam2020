package uam.bd.restaurante.BD.Controllers;

import java.util.List;

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
	public String saveEmpleado(@RequestBody Empleado received) throws Exception
	{
		System.out.println("POST: "+received.getApellidos());
		String save = empleadoDAO.save(received);
		
		return save;
	}
	
	@GetMapping("/empleado")		
	public List<Empleado> get() throws Exception
	{		
		List<Empleado> empleados = empleadoDAO.getAll();
		return empleados;
	}
}
