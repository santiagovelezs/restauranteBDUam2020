package uam.bd.restaurante.BD.Model;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {
     private int numero;
     private Date fecha;
     private String cliente;
     private int estado;
     private String empleado;
     private int idEnvio;
     private ArrayList<LineaPedido> productos;
     private float total;
     
     
	public Pedido(int numero, Date fecha, String cliente, int estado, String empleado, int idEnvio ) {
		this.numero = numero;
		this.fecha = fecha;
		this.cliente = cliente;
		this.estado = estado;
		this.empleado = empleado;
		this.idEnvio= idEnvio;
		this.productos = new ArrayList<>();
		this.total=total;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	public void aniadirProducto(LineaPedido e) {
		
		
		this.productos.add(e);
	
	}
	
    public int getIdEnvio() {
		return idEnvio;
	}


	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}


	public ArrayList<LineaPedido> getProductos() {
		return productos;
	}


	public void setProductos(ArrayList<LineaPedido> productos) {
		this.productos = productos;
	}


	public boolean eliminarProducto(Producto e) {
    	for(int i=0;i<productos.size();i++) {
    	
    	if(productos.get(i).equals(e)) {
    	this.productos.remove(i);
    	return true;
    	}
    	
    	}
    	return false;
    }
    
    public float getTotal() {
    	
    	
    	for(int i=0;i<productos.size();i++) {
    		total+=productos.get(i).getSubTotal();
    	}
    	return total;
    }
	
}
