package servicios;

import modelo.Usuario;

public interface IServiciosUsuario {
	
	public boolean check(String nombre);
	
	public void update(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, String fechaRegistro, String nombreBusqueda);
	
	public void add(Usuario usuario);
	
	public Usuario crearUsuario(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, String fechaRegistro);
	
	public void delete(String nombre);
	
	public Usuario read(String nombre);
	

}
