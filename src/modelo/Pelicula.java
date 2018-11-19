package modelo;

public class Pelicula {
	
	private String nombre;
	private String fechaEstreno;
	private String categoria;
	
	
	public Pelicula() {
		super();
	}
	
	
	public Pelicula(String nombre, String fechaEstreno, String categoria) {
		super();
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getfechaEstreno() {
		return fechaEstreno;
	}
	public void setfechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", anioEstreno=" + fechaEstreno + ", categoria=" + categoria + "]";
	}
	
	
	public Pelicula crearPelicula(String nombre, String fechaEstreno2, String categoria ){
		
		Pelicula p = new Pelicula();
		
		p.setNombre(nombre);
		p.setfechaEstreno(fechaEstreno2);
		p.setCategoria(categoria);
		
		return p;
		
	}
	
	
	

}
