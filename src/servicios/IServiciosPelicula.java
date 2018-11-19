package servicios;

import java.util.Date;
import java.util.List;

import modelo.Pelicula;

public interface IServiciosPelicula {

public boolean check(String nombre);
	
	public void update(String nombre, String añoEstreno, String categoria, String nombrebusqueda);
	
	public void add(Pelicula pelicula);
	
	//public static void cargarPelis(String url);
	
	//public static void cargarEnBBDD(String[] valores);
	
	public List<Pelicula> listaPorAbono(String abono);
	
	public List<Pelicula> listaPorCategoria(String categoria);
	
	public Pelicula crearPelicula(String nombre, String fechaEstreno, String categoria);
	
	public void delete(String nombre);
	
	public String read(String nombre);
	
	public List<Pelicula> listFilms();
}
