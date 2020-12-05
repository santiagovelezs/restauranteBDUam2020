package uam.bd.restaurante.BD.Controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public boolean saveUsuario(@RequestBody Usuario received) throws Exception
	{
		System.out.println("POST: "+received.getPassword());	
		try 
		{
			return usuarioDAO.save(received);
		} 
		catch (SQLIntegrityConstraintViolationException e) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado con cédula "+received.getCedula()+" no existe", e);
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}		
		
	}
	
	@GetMapping("/usuario")		
	public List<Usuario> get() throws Exception
	{		
		List<Usuario> usuarios = usuarioDAO.getAll();
		return usuarios;
	}
}
