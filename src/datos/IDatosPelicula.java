package datos;

/*
 * @autor: María Victoria, Charo Arreola, Ana María, Ángel Martin 
 * @since: 19/11/2018/V1
 */

import java.util.List;

import modelo.Pelicula;

public interface IDatosPelicula {
	
	public boolean check(String nombre);
		
	//public Pelicula crearPelicula(String nombre, String fechaEstreno, String categoria );
	
	public void update(String nombre, String añoEstreno, String categoria, String nombrebusqueda);
	
	public void add(Pelicula pelicula);
	
	public void delete(String nombre);
	
	public String read(String nombre);
	
	//public static void cargarPeliculas();

	//public static void cargarPeliculas(String url);
	
	public List<Pelicula> listaPorAbono(String abono);
	
	public List<Pelicula> listaPorCategoria(String categoria);
	public List<Pelicula> listFilms();
	
	

}
