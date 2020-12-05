package uam.bd.restaurante.BD.Model;

public abstract class Persona
{	
	protected String cedula;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String telefono;
	protected boolean is_active;
	
	public Persona(String cedula, String nombre, String apellido, String email, String telefono, boolean is_active)
	{
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.is_active = is_active;
	}	
}
