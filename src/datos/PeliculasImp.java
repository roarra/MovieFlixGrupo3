package datos;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Pelicula;
import datos.Conexion;

public class PeliculasImp implements IDatosPelicula{
	
	Connection conexion = new Conexion().getConnection();
	

	public void add(Pelicula pelicula) {
		

		Statement st = null;

		try {

			st = conexion.createStatement();

			st.executeUpdate(
					"INSERT INTO peliculas(nombre, añoEstreno, IDCategoria)" + "VALUES ('" + pelicula.getNombre()
							+ "', '" + pelicula.getfechaEstreno() + "', (SELECT IDCategoria FROM categoria WHERE nombre = '" + pelicula.getCategoria() + "'));");
			
			conexion.close();

		}

		catch (SQLException ex) {

			ex.printStackTrace();
		}

	}

	public void delete(String nombre) {
		
		Statement st = null;

		try {

			st = conexion.createStatement();
			
			st.executeUpdate("DELETE FROM peliculas WHERE nombre ='" + nombre + "';");
			
			conexion.close();

		}

		catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

	public String read(String nombre) {
		
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;

		Pelicula pelicula = new Pelicula();
		List<Pelicula> lista = new ArrayList<>();

		try {

			st = conexion.createStatement();
			rs = st.executeQuery("SELECT p.nombre, a�oEstreno, c.nombre FROM peliculas p, categoria c WHERE p.IDCategoria = c.IDCategoria AND p.nombre =  '" + nombre + "';");
			
			

			while (rs.next()) {
				
				pelicula.setNombre(rs.getNString("p.nombre"));
				pelicula.setfechaEstreno(rs.getString("a�oEstreno"));
				pelicula.setCategoria(rs.getString("c.nombre"));
				//int idcat = rs.getInt("IDCategoria");
				//rs1 = st.executeQuery("SELECT nombre FROM categoria WHERE IDCategoria =" + idcat );
				//pelicula.setCategoria(rs1.getString("nombre"));
				

				lista.add(pelicula);

				pelicula = lista.get(0);

			}
			
			conexion.close();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return pelicula.toString();

   
	}

	public void update(String nombre, String a�oEstreno, String categoria, String nombrebusqueda) {
		
		Statement st = null;
		
		try{
			
			st = conexion.createStatement();
			st.executeUpdate("UPDATE peliculas SET nombre = '" + nombre + ", añoEstreno = '" + a�oEstreno + "'" + ", IDCategoria = (SELECT IDCategoria FROM categoria WHERE nombre = '" + categoria + "') WHERE nombre = '" + nombrebusqueda + "';");

			conexion.close();
			
		}catch(SQLException ex){
			
			ex.printStackTrace();
		}
		

	}
	
	public static void cargarPelis(String url){
		File fichero = new File(url);
		Scanner s = null;
		String[] valores = null;
		
		try {
			// Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fichero);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				valores = linea.split(",");
				cargarEnBBDD(valores);
				for(String v:valores){
					System.out.println(v);
				}
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		
	}
	
	public static void cargarEnBBDD(String[] valores){
		Conexion conn = null;
		Statement st = null;
		int res;

		try {

			st = new Conexion().getConnection().createStatement();
			String query = "INSERT INTO peliculas(nombre,añoEstreno,IDCategoria) VALUES('" + valores[0] + "','" + valores[1] + "'," + String.valueOf(valores[2]) + ")";
			System.out.println(query);
			res = st.executeUpdate(query);
			
			


		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		
	}
	
	public List<Pelicula> listFilms(){
		
		List<Pelicula> lista = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		//ResultSet rs1 = null;

		try {

			st = conexion.createStatement();
			rs = st.executeQuery("SELECT p.nombre, añoEstreno, c.nombre FROM peliculas p, categoria c WHERE p.IDCategoria = c.IDCategoria;");
			//rs1 = null;

			while (rs.next()) {

				Pelicula pelicula = new Pelicula();

				pelicula.setNombre(rs.getString("p.nombre"));
				pelicula.setfechaEstreno(rs.getString("añoEstreno"));
				pelicula.setCategoria(rs.getString("c.nombre"));
				//int idcat = rs.getInt("IDCategoria");
				//rs1 = st.executeQuery("SELECT nombre FROM categoria WHERE IDCategoria =" + idcat );
				//pelicula.setCategoria(rs1.getString("nombre"));
				lista.add(pelicula);

			}
			
			conexion.close();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return lista;
		
		
	}
	
	public List<Pelicula> listaPorAbono(String abono){
		List<Pelicula> lista = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		//ResultSet rs1 = null;

		try {

			st = conexion.createStatement();
			rs = st.executeQuery("SELECT p.nombre, añoEstreno, c.nombre FROM peliculas p, abono a, categoria c WHERE p.IDCategoria = c.IDCategoria AND p.IDAbono = a.IDAbono AND a.nombre = '" + abono + "';");
			//rs1 = null;

			while (rs.next()) {

				Pelicula pelicula = new Pelicula();

				pelicula.setNombre(rs.getString("p.nombre"));
				pelicula.setfechaEstreno(rs.getString("añoEstreno"));
				pelicula.setCategoria(rs.getString("c.nombre"));
				
				//int idcat = rs.getInt("IDCategoria");
				//rs1 = st.executeQuery("SELECT nombre FROM categoria WHERE IDCategoria =" + idcat );
				//pelicula.setCategoria(rs1.getString("nombre"));
				lista.add(pelicula);

			}
			
			conexion.close();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return lista;
		
	}
	
	public List<Pelicula> listaPorCategoria(String categoria){
		List<Pelicula> lista = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		//ResultSet rs1 = null;

		try {

			st = conexion.createStatement();
			rs = st.executeQuery("SELECT p.nombre, añoEstreno, c.nombre FROM peliculas p, categoria c WHERE p.IDCategoria = c.IDCategoria AND c.nombre = '" + categoria + "';");
			//rs1 = null;

			while (rs.next()) {

				Pelicula pelicula = new Pelicula();

				pelicula.setNombre(rs.getString("p.nombre"));
				pelicula.setfechaEstreno(rs.getString("añoEstreno"));
				pelicula.setCategoria(rs.getString("c.nombre"));
				//int idcat = rs.getInt("IDCategoria");
				//rs1 = st.executeQuery("SELECT nombre FROM categoria WHERE IDCategoria =" + idcat );
				//pelicula.setCategoria(rs1.getString("nombre"));
				lista.add(pelicula);

			}
			
			conexion.close();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return lista;
		
	}

	@Override
	public boolean check(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

