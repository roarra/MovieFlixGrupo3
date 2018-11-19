package servicios;

import java.util.List;

import datos.PeliculasImp;
import modelo.Pelicula;

public class ServiciosPeliculasImp implements IServiciosPelicula{

	public boolean check(String nombre){
		return false;
		
		}
		
		public Pelicula crearPelicula(String nombre, String fechaEstreno, String categoria ){
			
			return new Pelicula().crearPelicula(nombre, fechaEstreno, categoria);
			
	}
	
	public void update(String nombre, String añoEstreno, String categoria, String nombrebusqueda){
	
		new PeliculasImp().update(nombre,añoEstreno, categoria, nombrebusqueda);
	}
	
	public void add(Pelicula pelicula){
		
		new PeliculasImp().add(pelicula);

	}
	
	public void delete(String nombre){
		
		new PeliculasImp().delete(nombre); 
	}
	
	public String read(String nombre){
		
		
		
		return new PeliculasImp().read(nombre);
	}
	
	public static void cargarPeliculas(){
		String url = "fichero.txt";
		cargarPeliculas(url);
	}

	public static void cargarPeliculas(String url){
		PeliculasImp.cargarPelis(url);;
		
	}
	
	public List<Pelicula> listaPorAbono(String abono){
		
		return new PeliculasImp().listaPorAbono(abono);
	}
	
	public List<Pelicula> listaPorCategoria(String categoria){
		
		return new PeliculasImp().listaPorCategoria(categoria);
	}
	
	public List<Pelicula> listFilms(){
		
		return new PeliculasImp().listFilms();
	}
	
	
	@Override
	public Pelicula crearPelicula(String nombre, int fechaEstreno, String categoria) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
 
 