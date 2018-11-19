package datos;

import modelo.Usuario;

public interface IDatosUsuario {
	
	public void add(Usuario nombre);
	
	public void delete(String nombre);
	
	public Usuario read(String nombre);
	
	public void update(String nombre);
	
	

}
