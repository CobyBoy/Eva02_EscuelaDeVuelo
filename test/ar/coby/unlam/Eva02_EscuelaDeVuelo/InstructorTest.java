package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstructorTest {

	@Test
	public void queSeCreeUnInstructor() {
		Instructor instructor = new Instructor("Coby", "Acosta", 3344, 1, 5);
		assertNotNull(instructor);
	}
	
	@Test
	public void queAgregueHorasCuandoVueloSolo() {
		Instructor instructor = new Instructor("Coby", "Acosta", 3344, 1, 5);
		Integer ve = 10;
		assertEquals(ve, instructor.pilotearSolo(5));
	}

	@Test
	public void agregarAlumnoAInstructor() {
		Instructor instructor = new Instructor("Coby", "Acosta", 3344, 1, 5);
		Alumno alumno = new Alumno("Alum", "No", 33333333);
		instructor.agregarAlumno(alumno);
	}
}
