import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import modelo.Usuario;

/**
 * 
 * @author Ana Maria
 * 
 * En esta clase definimos los metodos para realizar las pruebas unitarias para el usuario
 *
 */
	


public class TestUsuario {
	
	/**
	 * 
	 * En este metodo definimos que la pelicula está ya en la BBDD
	 */
	//PARA COMPROBAR QUE LA PELICULA ESTÁ REPETIDA
	
	@org.junit.Test
	public void CheckRepeatUser(){
		
		String resultadoReal = ("SELECT * FROM usuarios WHERE nombre = 'pepe'");
		String resultadoEsperado = ("SELECT * FROM usuarios WHERE nombre = 'pepe'");
		assertEquals(resultadoReal,resultadoEsperado);
	
	}
	
	/**
	 * 
	 * En este metodo definimos que el usuario no se encuentra en la BBDD
	 */
	
	//COMPROBAMOS QUE EL USUARIO NO SE ENCUENTRA EN LA BBD

	@org.junit.Test
	
	public void CheckNullUser(){
		String resultadoReal = ("SELECT * FROM usuarios WHERE nombre= 'agapito'");
		String resultadoEsperado = ("El usuario no se encuentra en la BBDD");
		assertNull(resultadoEsperado,resultadoReal);
		}
	

}
