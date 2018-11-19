package servicios;

import java.util.Date;

import datos.IDatosUsuario;
import datos.UsuariosImp;
import modelo.Usuario;

public class ServiciosUsuarioImp implements IServiciosUsuario {
	
	//Usuario u = new Usuario();
	
	IDatosUsuario datosU = new UsuariosImp();
	
	public boolean check(String nombre){
		
		return true;
	}

	public Usuario crearUsuario(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, String fechaRegistro){
		
		return new Usuario().crearUsuario(nombreCompleto, fechaNacimiento, ciudadResidencia, paqueteAbono, fechaRegistro);
		
		
		/*return u;*/
	}
	
	public void add(Usuario usuario){

		new UsuariosImp().add(usuario);

	
	}
	
	public void delete(String nombre){
		
		new UsuariosImp().delete(nombre);
	}
	
	public Usuario read(String nombre){
		
		
		
		return new UsuariosImp().read(nombre);
	}
	
	public void update(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, String fechaRegistro, String nombreBusqueda){
		new UsuariosImp().update(nombreCompleto, fechaNacimiento, ciudadResidencia, fechaRegistro, nombreBusqueda);
	}

} 
