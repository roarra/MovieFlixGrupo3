import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datos.PeliculasImp;

public class TestPelicula {

	@Test
	public void CheckRepeatFilm() {
		String resultadoReal = PeliculasImp.add("Humor");
		String resultadoEsperado = 
		assertEquals(resultadoEsperado,resultadoReal);		
	}

}
