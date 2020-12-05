package uam.bd.restaurante.BD.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uam.bd.restaurante.BD.DAO.DAO;
import uam.bd.restaurante.BD.DAOmysql.ProductoDAOImp;
import uam.bd.restaurante.BD.Model.Producto;
import uam.bd.restaurante.BD.MysqlConnector.DBConnection;
@RestController
public class ProductoController {
private DAO<Producto> productoDAO;
	
	public ProductoController()
	{
		productoDAO = new ProductoDAOImp(DBConnection.getConnection());
	}
	
	@PostMapping(path="/producto")
	public boolean saveProducto(@RequestBody Producto received) throws Exception
	{
		System.out.println("POST: "+received.getNombre());
		boolean save = productoDAO.save(received);
		
		return save;
	}
	
	
}
