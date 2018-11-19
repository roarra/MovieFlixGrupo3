package datos;


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
}
