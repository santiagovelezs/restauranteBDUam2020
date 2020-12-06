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

import uam.bd.restaurante.BD.DAO.DAO_Foreign;
import uam.bd.restaurante.BD.DAOmysql.PedidoDAOImpl;
import uam.bd.restaurante.BD.Model.Pedido;
import uam.bd.restaurante.BD.MysqlConnector.DBConnection;

@RestController
public class PedidoController 
{
	private DAO_Foreign<Pedido> pedidoDAO;
	
	public PedidoController()
	{
		pedidoDAO = new PedidoDAOImpl(DBConnection.getConnection());
	}
	
	@PostMapping(path="/pedido")
	public boolean savePedido(@RequestBody Pedido t) 
	{			
		try 
		{
			return pedidoDAO.save(t);
		} 
		catch (DataIntegrityViolationException e) 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este Pedido Ya Existe", e);
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}	
	
	@GetMapping("/pedido")		
	public List<Pedido> get()
	{		
		List<Pedido> pedidos;
		try 
		{
			pedidos = pedidoDAO.getAll();
			return pedidos;
		} 
		catch (Exception e) 
		{			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}		
	}
	
	@DeleteMapping("/pedido")
	public boolean deletePedido(@RequestBody Pedido t)
	{
		try 
		{
			return pedidoDAO.delete(t);
		} 
		catch (Exception e) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}
	
	@PutMapping("/pedido")
	public boolean updatePedido(@RequestBody Pedido t)
	{
		try
		{
			return pedidoDAO.update(t);
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error, Exception ", e);
		}
	}
}
