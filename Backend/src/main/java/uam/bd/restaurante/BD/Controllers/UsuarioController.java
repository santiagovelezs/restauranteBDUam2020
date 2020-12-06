package uam.bd.restaurante.BD.Controllers;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping(path="/usuarios")
	public boolean saveUsuario(@RequestBody Usuario t) 
	{			
		try 
		{
			return usuarioDAO.save(t) > 0;
		} 
		catch (DataIntegrityViolationException e) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este Usuario Ya Existe", e);
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}	
	
	@GetMapping("/usuarios")		
	public List<Usuario> get()
	{		
		List<Usuario> usuarios;
		try 
		{
			usuarios = usuarioDAO.getAll();
			return usuarios;
		} 
		catch (Exception e) 
		{			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}		
	}
	
	@DeleteMapping("/usuarios")
	public boolean deleteUsuario(@RequestBody Usuario t)
	{
		try 
		{
			return usuarioDAO.delete(t) > 0;
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}
	
	@PutMapping("/usuarios")
	public boolean updateUsuario(@RequestBody Usuario t)
	{
		try
		{
			return usuarioDAO.update(t) > 0;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}
}