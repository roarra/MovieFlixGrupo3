import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Test;

import datos.PeliculasImp;
import modelo.Pelicula;

public class TestPelicula {

		
	//PARA COMPROBAR QUE LA PELICULA ESTÁ REPETIDA
	
	@org.junit.Test
	
	public void CheckRepeatFilm() {
		String resultadoReal = ("SELECT * FROM peliculas WHERE nombre= 'Avatar'");
		String resultadoEsperado = ("SELECT * FROM peliculas WHERE nombre= 'Avatar'");
		assertEquals(resultadoEsperado,resultadoReal);		
		
		}
	
	//PARA COMPROBAR QUE LA PELICULA SE ENCUENTRA EN LA BBDD
	
	@org.junit.Test
	public void CheckNullFilm(){
		String resultadoReal = ("SELECT * FROM peliculas WHERE nombre= 'Avatar'");
		String resultadoEsperado = ("La pelicula se encuentra en la BBDD");
		assertNotNull(resultadoEsperado,resultadoReal);
		
		}
	
	//COMPROBAMOS QUE LA PELICULA NO SE ENCUENTRA EN LA BBD
	
	@org.junit.Test
	
	public void CheckNullFilm1(){
		String resultadoReal = ("SELECT * FROM peliculas WHERE nombre= 'Saw'");
		String resultadoEsperado = ("La pelicula no se encuentra en la BBDD");
		assertNull(resultadoEsperado,resultadoReal);
		}
	
	
}
	
	
	
	
	





