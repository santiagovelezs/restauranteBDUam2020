package uam.bd.restaurante.model;

public abstract class Persona {

	
	protected String cedula;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String telefono;
	public Persona(String cedula, String nombre, String apellido, String email, String telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	
	
	
	
}
