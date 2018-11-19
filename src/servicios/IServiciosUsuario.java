package servicios;

import java.util.Date;

import modelo.Usuario;

public interface IServiciosUsuario {
	
	public boolean check(String nombre);
	
	//public void update(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, Date fechaRegistro);
	
	public void add(Usuario usuario);
	
	public Usuario crearUsuario(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, Date fechaRegistro);
	
	public void delete(String nombre);
	
	public Usuario read(String nombre);
	

}
