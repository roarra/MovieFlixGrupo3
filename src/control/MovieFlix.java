package control;

import java.util.List;

import datos.PeliculasImp;
import gui.Menu;
import modelo.Pelicula;
import modelo.Usuario;
import servicios.IServiciosPelicula;
import servicios.IServiciosUsuario;
import servicios.ServiciosPeliculasImp;
import servicios.ServiciosUsuarioImp;
import utilidades.LecturaDatos;

public class MovieFlix {

			IServiciosUsuario servicesUsuario = new ServiciosUsuarioImp();
			IServiciosPelicula servicesPelicula = new ServiciosPeliculasImp();
		
		
	public void arrancar() {
		
		boolean seguir = true;
		
		do{
			
			Menu.imprimeMenu();
			seguir= this.seleccionarOpciones();
			
		}
		
		while(seguir);

		System.out.println("Terminar Sesion");
			
			
		}
	
	public boolean seleccionarOpciones(){
		
		boolean continuar = true;
		
		try{
			
			switch(LecturaDatos.leerInt()){
			
			case 1: //AñADIR PELICULAS A TRAVES DEL FICHERO
				
			//servicesPelicula.add(); AQUI VA EL DE AñADIR PELICULAS CON EL FICHERO
				/*String url = "fichero.txt";
				ServiciosPeliculasImp.cargarPeliculas(url);
				ServiciosPeliculasImp.cargarPeliculas();*/
				
			break;
			
			case 2: 
				//AñADIR PELICULAS CON PARAMETROS
				Pelicula pelicula1 = new Pelicula("El rey proscrito", "2018", "Thriller");
				servicesPelicula.add(pelicula1);
				break;
				
			case 3:
				
				//LISTAR PELICULAS
				
				List<Pelicula> lista1 = servicesPelicula.listFilms();
				for(Pelicula elemento: lista1){
					
					LecturaDatos.escribir(elemento.toString());
				}
				
				//servicesPelicula.  AQUI VA EL DE LISTAR PELICULAS
				break;
				
			case 4:
				
				//ELIMINAR PELICULAS
				Pelicula pelicula2 = new Pelicula("El rey proscrito", "2018", "Thriller");
				servicesPelicula.delete(pelicula2.getNombre());
				break;
				
			case 5:
				
				//AQUI VA EL METODO DE PELICULAS MAS VISTAS
				
			case 6:
				
				//AQUI VA EL METODO DE PELICULAS MAS VALORADAS
				
			case 7:
				
				//AQUI VA EL METODO DE PELICULAS QUE VER DE ACUERDO AL TIPO DE ABONO
				
				Usuario usuario = new Usuario("pepe", "1991", "Madrid", "basico", "13/11/2018");
				
				List<Pelicula> lista2 = servicesPelicula.listaPorAbono(usuario.getPaqueteAbono());
				
				for(Pelicula elemento: lista2){
					
					LecturaDatos.escribir(elemento.toString());
				}
				
				break;
				
				
				
			case 8:
				
				//AQUI VA EL LISTADO DE PELICULAS POR CATEGORIA
				
				String categoria = "Aventuras";
				
				List<Pelicula> lista3 = servicesPelicula.listaPorCategoria(categoria);
				
				for(Pelicula elemento: lista3){
					
					LecturaDatos.escribir(elemento.toString());
				
				}
				break;
			case 9:
				
				//BUSCAR PELICULA
				String nombre = "Venom";
				LecturaDatos.escribir(servicesPelicula.read(nombre).toString());
				break;
				
			case 10:
				
				//AÑADIR USUARIO
				Usuario usuario1 = new Usuario("Ignacio", "1987", "Valencia", "basico", "29/10/2018" );
				servicesUsuario.add(usuario1);
				break;
				
			case 11:
				
				//METODO ACTUALIZAR USUARIO
				servicesUsuario.update("Ignacio", "1987", "Barcelona", "extra", "29/10/2018","paco");
				break;
				
			case 12:
				
				//LISTAR USUARIO
				String nombre2 =  "pepe";
				LecturaDatos.escribir(servicesUsuario.read(nombre2).toString());
				break;
				
			case 13:
				
				//ELIMINAR USUARIO
				String nombre3 = "Ignacio";
				servicesUsuario.delete(nombre3);
				break;
				
			case 14:
				
				//AÑADIR CATEGORIA
				break;
				
			case 15:
				
				//ACTUALIZAR CATEGORIA
				break;
				
			case 16:
				
				//VER CATEGORIAS
				break;
				
			case 17:
				
				//ELIMINAR CATEGORIA
				break;
				
			case 0:
				
				continuar = salir();
				break;
				
			}
				
		}
		
		catch (Exception e){
			
			System.out.println("Error: "+e.toString());
		}
		
		return continuar;
		
	}
		private boolean salir() throws Exception {
			
			String pregunta = LecturaDatos.leerString("�Estas seguro?: S/N: ");

		System.out.println("Terminar Sesion");
		
		return (pregunta.toUpperCase().charAt(0) != 'S');
			
			
		}
	
	
}
	
	
	
	
	


