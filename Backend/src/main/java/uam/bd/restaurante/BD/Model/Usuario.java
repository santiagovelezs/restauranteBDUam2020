package uam.bd.restaurante.BD.Model;

public class Usuario extends Empleado
{
	private String password;

	public Usuario(String cedula, String nombre, String apellido, String email, String telefono, boolean is_active, String password) 
	{
		super(cedula, nombre, apellido, email, is_active, telefono);		
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
	}

}
