package datos;

/*
 * @autor: Mar�a Victoria, Charo Arreola, Ana Mar�a, �ngel Martin 
 * @since: 19/11/2018/V1
 */

import modelo.Usuario;

public interface IDatosUsuario {
	
	public void add(Usuario nombre);
	
	public void delete(String nombre);
	
	public Usuario read(String nombre);
	
	public void update(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String fechaRegistro, String nombreBusqueda);
	
	

}
