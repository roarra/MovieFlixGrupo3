package servicios;

/*
 * @autor: Ángel Martin 
 * @since: 19/11/2018/V1
 */

import java.util.List;

import datos.PeliculasImp;
import modelo.Pelicula;

public class ServiciosPeliculasImp implements IServiciosPelicula{

	public boolean check(String nombre){
		return false;
		
	}
		
	/*
	 * @param: pasamos nombre, fecha de estreno y una categoria
	 * @return: devuelve un objeto pelicula
	 */
	public Pelicula crearPelicula(String nombre, String fechaEstreno, String categoria ){
			
		return new Pelicula().crearPelicula(nombre, fechaEstreno, categoria);
			
	}
	
	/*
	 * @param: pasamos nombre, fecha de estreno y una categoria y un nombre a buscar
	 */
	public void update(String nombre, String añoEstreno, String categoria, String nombrebusqueda){
	
		new PeliculasImp().update(nombre,añoEstreno, categoria, nombrebusqueda);
	}
	
	/*
	 * @param: pasamos un objeto pelicula para añadir
	 */
	public void add(Pelicula pelicula){
		
		new PeliculasImp().add(pelicula);

	}
	
	/*
	 * @param: pasamos un objeto pelicula para borrar
	 */
	public void delete(String nombre){
		
		new PeliculasImp().delete(nombre); 
	}
	
	/*
	 * @param: pasamos un objeto pelicula para buscar
	 */
	public String read(String nombre){
		
		return new PeliculasImp().read(nombre);
	}
	
	/*
	 * creamos el metodo que crea la url y se llama a si mismo con una url
	 */
	public static void cargarPeliculas(){
		String url = "fichero.txt";
		cargarPeliculas(url);
	}

	/*
	 * @param: pasamos una url para cargarlo en la BBDD
	 */
	public static void cargarPeliculas(String url){
		PeliculasImp.cargarPelis(url);;
		
	}
	
	/*
	 * @return: nos devuelve un conjunto de valores ya buscados en la BBDD
	 */
	public List<Pelicula> listaPorAbono(String abono){
		
		return new PeliculasImp().listaPorAbono(abono);
	}
	
	/*
	 * @return: nos devuelve un conjunto de valores ya buscados en la BBDD
	 */
	public List<Pelicula> listaPorCategoria(String categoria){
		
		return new PeliculasImp().listaPorCategoria(categoria);
	}
	
	/*
	 * @return: nos devuelve un conjunto de valores ya buscados en la BBDD
	 */
	public List<Pelicula> listFilms(){
		
		return new PeliculasImp().listFilms();
	}
	
	
}
 
 