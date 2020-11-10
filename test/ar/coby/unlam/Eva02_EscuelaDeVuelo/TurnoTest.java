package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TurnoTest {
	@Test
	public void queSeHayaCreadoUnTurno() {
		Alumno alumno = new Alumno("alejandro", "acosta", 35396973);
		Instructor instructor = new Instructor("Jorge", "ape", 33333, 1, 2);
		Aeronave aeronave = new Aeronave("css", "x22", 2, 3);
		Turno turno = new Turno(2020, 11, 11, 13, 3, alumno, instructor, aeronave);
		assertNotNull(turno);
	}
	

}
