package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlumnoTest {

	@Test
	public void queCreeUnAlumno() {
		Alumno alumno = new Alumno("Alum", "No", 33333333);
		assertNotNull(alumno);
	}
	
	
	
	@Test
	public void quePuedaVolarSoloSiCumpleConLasHorasDeVuelo() {
		Alumno alumno = new Alumno("Alum", "No", 33333333);
		alumno.setHorasDeVuelo(21);
	}
	
	@Test
	public void queNoPuedaVolarSoloSiNoCumpleConLasHorasDeVuelo() {
		Alumno alumno = new Alumno("Alum", "No", 33333333);
		alumno.setHorasDeVuelo(19);
	}

}
