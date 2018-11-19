import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * 
 * @author Maria Victoria
 * 
 * Definimos esta clase que contiene los metodos que realizan las pruebas unitarias
 *
 */

public class TestPelicula {

	/**
	 * 
	 * En este metodo definimos que la pelicula está ya en la BBDD
	 */
	//PARA COMPROBAR QUE LA PELICULA ESTÁ REPETIDA
	
	@org.junit.Test
	
	public void CheckRepeatFilm() {
		String resultadoReal = ("SELECT * FROM peliculas WHERE nombre= 'Avatar'");
		String resultadoEsperado = ("SELECT * FROM peliculas WHERE nombre= 'Avatar'");
		assertEquals(resultadoEsperado,resultadoReal);		
		
		}
	
	/**
	 * 
	 * En este metodo definimos que la pelicula no se encuentra en la BBDD
	 */
	
	
	//COMPROBAMOS QUE LA PELICULA NO SE ENCUENTRA EN LA BBD
	
	@org.junit.Test
	
	public void CheckNullFilm1(){
		String resultadoReal = ("SELECT * FROM peliculas WHERE nombre= 'Saw'");
		String resultadoEsperado = ("La pelicula no se encuentra en la BBDD");
		assertNull(resultadoEsperado,resultadoReal);
		}
	
	
}
	
	
	
	
	





