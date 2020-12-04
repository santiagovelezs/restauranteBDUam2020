package uam.bd.restaurante.model;

public class Producto {

	private String codigo;
	private String nombre;
	private String descripcion;
	private float valor;
	public Producto(String codigo, String nombre, String descripcion, float valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
