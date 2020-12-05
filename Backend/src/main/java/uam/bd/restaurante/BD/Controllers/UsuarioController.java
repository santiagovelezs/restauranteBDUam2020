package uam.bd.restaurante.BD.Controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uam.bd.restaurante.BD.DAO.DAO;
import uam.bd.restaurante.BD.DAOmysql.UsuarioDAOImpl;
import uam.bd.restaurante.BD.Model.Usuario;
import uam.bd.restaurante.BD.MysqlConnector.DBConnection;

@RestController
public class UsuarioController 
{
	private DAO<Usuario> usuarioDAO;
	
	public UsuarioController()
	{
		usuarioDAO = new UsuarioDAOImpl(DBConnection.getConnection());
	}
	
	@PostMapping(path="/usuario")
	public String saveUsuario(@RequestBody Usuario received)
	{
		System.out.println("POST: "+received.getPassword());
		String save = "";
		try 
		{
			save = usuarioDAO.save(received);
		} 
		catch (SQLIntegrityConstraintViolationException e) 
		{
			save = "No Existe empleado con la cédula "+received.getCedula();
			//e.printStackTrace();
		}
		catch (Exception e) 
		{
			save = "Error: "+e.toString();
			//e.printStackTrace();
		}
		
		return save;
	}
	
	@GetMapping("/usuario")		
	public List<Usuario> get() throws Exception
	{		
		List<Usuario> usuarios = usuarioDAO.getAll();
		return usuarios;
	}
}
