package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo.Instructor;

public class InstructorTest {

	@Test
	public void queSeCreeUnInstructor() {
		Instructor instructor = new Instructor("Coby", "Acosta", 3344, 1);
		assertNotNull(instructor);
	}
	
	@Test
	public void queAgregueHorasCuandoVueloSolo() {
		Instructor instructor = new Instructor("Coby", "Acosta", 3344, 1);
		Integer ve = 5;
		assertEquals(ve, instructor.pilotear(5));
	}
}
