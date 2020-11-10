package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlumnoTest {

	@Test
	public void queSePuedaCrearUnAlumno() {
		Alumno alumno = new Alumno("Alum", "No", 33333333,1);
		assertNotNull(alumno);
	}
	
	
	
	@Test
	public void quePuedaVolarSoloSiCumpleConLasHorasDeVuelo() {
		Alumno alumno = new Alumno("Alum", "No", 33333333,1);
		alumno.pilotear(20);
		assertTrue(alumno.pilotearSolo());
	}
	
	@Test
	public void queNoPuedaVolarSoloSiNoCumpleConLasHorasDeVuelo() {
		Alumno alumno = new Alumno("Alum", "No", 33333333,1);
		alumno.pilotear(19);
		assertFalse(alumno.pilotearSolo());
	}
	
	@Test
	public void queAlPilotearSeLeSumenALasHorasDeVuelo() {
		Alumno alumno = new Alumno("Alum", "No", 33333333,1);
		Instructor instructor = new Instructor("Coby", "Acosta", 3344, 1);
		Integer horas = 5;
		alumno.pilotearConInstructor(alumno, instructor, horas);
		Integer ve = 5;
		assertEquals(ve, alumno.getHorasDeVuelo());
		assertEquals(ve, instructor.getHorasDeVuelo());
	}

}
