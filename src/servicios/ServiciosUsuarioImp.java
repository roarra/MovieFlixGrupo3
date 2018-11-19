package servicios;

/*
 * @autor: María Victoria
 * @since: 19/11/2018/V1
 */

import java.util.List;

import datos.IDatosUsuario;
import datos.UsuariosImp;
import modelo.Usuario;

public class ServiciosUsuarioImp implements IServiciosUsuario {
	
	//Usuario u = new Usuario();
	
	IDatosUsuario datosU = new UsuariosImp();
	
	public boolean check(String nombre){
		
		return true;
	}

	/*
	 * @param: pasamos nombre, fecha de nacimiento, una ciudad, un tipo de paquete y una fecha de registro
	 * @return: devuelve un objeto usuario
	 */
	public Usuario crearUsuario(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, String fechaRegistro){
		
		return new Usuario().crearUsuario(nombreCompleto, fechaNacimiento, ciudadResidencia, paqueteAbono, fechaRegistro);
		
		
		/*return u;*/
	}
	
	/*
	 * @param: damos un objeto usuario para añadirlo en la BBDD
	 */
	public void add(Usuario usuario){

		new UsuariosImp().add(usuario);

	
	}
	
	/*
	 * @param: damos un nombre para borrarlo en la BBDD
	 */
	public void delete(String nombre){
		
		new UsuariosImp().delete(nombre);
	}
	
	/*
	 * @param: damos un nombre  para buscarlo en la BBDD
	 */
	public Usuario read(String nombre){
		
		
		
		return new UsuariosImp().read(nombre);
	}
	
	/*
	 * @param: damos un nombre, una fecha de nacimiento, ciudad, tipo de paquete, fecha de registro y un nombre de busqueda para actualizar un usuario
	 */
	public void update(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String paqueteAbono, String fechaRegistro, String nombreBusqueda){
		new UsuariosImp().update(nombreCompleto, fechaNacimiento, ciudadResidencia, fechaRegistro, nombreBusqueda);
	}
	
	public List<Usuario> listUsers(){
		
		return new UsuariosImp().listUsers();
	}

} 
