package datos;

/*
 * @autor: María Victoria, Charo Arreola, Ana María, Ángel Martin 
 * @since: 19/11/2018/V1
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import datos.Conexion;
import modelo.Usuario;


public class UsuariosImp implements IDatosUsuario {
	
	Connection conexion = new Conexion().getConnection();

	/*
	 * @param: le pasamos un objeto de tipo usuario el cual vamos a insertar en la BBDD
	 */
	public void add(Usuario usuario){

		
		Statement st = null;

		try {

			st = conexion.createStatement();

			st.executeUpdate("INSERT INTO usuarios(nombre, fechaNacimiento, ciudad, fechaAbono, IDAbono) VALUES ('" + usuario.getNombreCompleto()
							+ "', '" + usuario.getfechaNacimiento() + "', '" + usuario.getCiudadResidencia()+ "','" + usuario.getFechaRegistro()+ "', (SELECT IDAbono FROM abono WHERE abono.nombre = '" + usuario.getPaqueteAbono() + "'));");

			conexion.close();
		}

		catch (SQLException ex) {

			ex.printStackTrace();

		}
		
	}
	/*
	 * @param: le pasamos un nombre el cual vamos a borrar en la BBDD
	 */
	public void delete(String nombre){
		
		Statement st = null;
		
		try {
			
			st = conexion.createStatement();
			st.executeUpdate("DELETE FROM usuarios WHERE nombre = '" + nombre + "';");
			
			conexion.close();
		}
		catch (SQLException ex) {

			ex.printStackTrace();

		}
		
	}
	/*
	 * @param: le pasamos un nombre el cual vamos a buscar en la BBDD
	 */
	public Usuario read(String nombre){
		
		Statement st = null;
		ResultSet rs = null;

		Usuario usuario = new Usuario();
		List<Usuario> lista = new ArrayList<>();

		try {

			st = conexion.createStatement();
			rs = st.executeQuery("SELECT * FROM usuarios WHERE nombre = '" + nombre + "';");
			
			

			while (rs.next()) {
				
				usuario.setNombreCompleto(rs.getString("nombre"));
				usuario.setfechaNacimiento(rs.getString("fechaNacimiento"));
				usuario.setCiudadResidencia(rs.getString("ciudad"));
				usuario.setFechaRegistro(rs.getString("fechaAbono"));
				

				lista.add(usuario);

				usuario = lista.get(0);

			}
			
			conexion.close();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return usuario;

		
	
	}
	
	/*
	 * @param: le pasamos un nombre, una fecha, ciudad, fecha de registro y nombre a buscar el cual vamos a actualizar en la BBDD
	 */
	public void update(String nombreCompleto, String fechaNacimiento, String ciudadResidencia, String fechaRegistro, String nombreBusqueda){
		Statement st = null;
		
		try{
			
			st = conexion.createStatement();
			String query = "UPDATE usuarios SET nombre = '" + nombreCompleto + "', fechaNacimiento = '" + fechaNacimiento + "', ciudad = '" + ciudadResidencia + "', fechaAbono = '" + fechaRegistro + "' WHERE nombre = '" + nombreBusqueda + "';";
			st.executeUpdate(query);

			conexion.close();
			
		}catch(SQLException ex){
			
			ex.printStackTrace();
		}
	}
	
	public List<Usuario> listUsers(){
		List<Usuario> lista = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		//ResultSet rs1 = null;

		try {

			st = conexion.createStatement();
			rs = st.executeQuery("SELECT u.nombre, u.fechaNacimiento, u.ciudad, u.fechaAbono,  a.nombre FROM usuarios u, abono a WHERE a.IDAbono = u.IDAbono;");
		

			while (rs.next()) {

				Usuario usuario = new Usuario();

				usuario.setNombreCompleto(rs.getString("u.nombre"));
				usuario.setfechaNacimiento(rs.getString("u.fechaNacimiento"));
				usuario.setCiudadResidencia(rs.getString("u.ciudad"));
                usuario.setFechaRegistro(rs.getString("u.fechaAbono"));
                usuario.setPaqueteAbono(rs.getString("a.nombre"));
				lista.add(usuario);

			}
			
			conexion.close();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return lista;
	}
}
