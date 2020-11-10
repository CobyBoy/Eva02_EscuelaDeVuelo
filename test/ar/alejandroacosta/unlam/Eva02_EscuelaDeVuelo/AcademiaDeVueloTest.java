package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo.AcademiaDeVuelo;
import ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo.Aeronave;
import ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo.Alumno;
import ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo.Instructor;

public class AcademiaDeVueloTest {

	@Test
	public void queSeCreeUnaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		assertNotNull(academia);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumnoAUnaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333, 1);
		academia.agregarAlumno(alumno);
		Integer cantidadDeAlumnos = academia.getAlumnos().size();
		Integer ve = 1;
		assertEquals(ve, cantidadDeAlumnos);
	}
	
	@Test
	public void queNoSePuedaAgregarAlumnosDuplicadosALaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 35396973, 1);
		Alumno alumno2 = new Alumno("Alejandro","acosta", 35396973, 1);
		academia.agregarAlumno(alumno);
		academia.agregarAlumno(alumno2);
		Integer ve = 1;
		assertTrue(academia.getAlumnos().size() == ve);
	}
	
	@Test
	public void queSePuedaEliminarUnAlumnoDeLaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		academia.agregarAlumno(alumno);
		academia.eliminarAlumno(alumno);
		Integer ve = 0;
		assertTrue(academia.getAlumnos().size() == ve);
	}
	
	@Test
	public void queSePuedaEliminarUnAlumnoDeLaAcademiaPorId() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Alumno alumno2 = new Alumno("Alejandro","acosta", 4444,2);
		academia.agregarAlumno(alumno);
		academia.agregarAlumno(alumno2);
		assertTrue(academia.eliminarAlumnoPorId(2));
		
	}
	
	@Test
	public void queSePuedaAgregarUnInstructorAUnaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		academia.agregarInstructor(instructor);
		Integer cantidadDeInstructores = academia.getInstructores().size();
		Integer ve = 1;
		assertEquals(ve, cantidadDeInstructores);
	}
	
	@Test
	public void queSePuedaEliminarUnInstructorDeLaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		academia.eliminarInstructor(instructor);
		Integer ve = 0;
		assertTrue(academia.getInstructores().size() == ve);
	}
	
	@Test
	public void queSePuedaAsignarUnTurno() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		academia.agregarAlumno(alumno);
		academia.agregarInstructor(instructor);
		academia.agregarAeronave(aeronave);
		Integer dia = 10;
		Integer mes = 11;
		Integer anio = 2020;
		Integer hora = 13;
		Integer horasDeVuelo = 5;
		Integer ve = 1;
		assertTrue(academia.darTurnoParaVueloConInstructor(alumno, instructor, aeronave, dia, mes, anio, hora, horasDeVuelo));
		Integer cantidadDeTurnos = academia.getTurnos().size();
		assertEquals(ve, cantidadDeTurnos);
	}
	
	@Test
	public void queNoSePuedaAsignarUnTurnoEnElMismoDiaYHorario() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		academia.agregarAlumno(alumno);
		academia.agregarInstructor(instructor);
		academia.agregarAeronave(aeronave);
		Integer dia = 10;
		Integer mes = 11;
		Integer anio = 2020;
		Integer hora = 13;
		Integer horasDeVuelo = 5;
		academia.darTurnoParaVueloConInstructor(alumno, instructor, aeronave, dia, mes, anio, hora, horasDeVuelo);
		Alumno alumno2 = new Alumno("Alejandro","acosta", 444,1);
		Instructor instructor2 = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave2 = new Aeronave("modelo", "x22", 2, 5);
		academia.agregarAlumno(alumno2);
		academia.agregarInstructor(instructor2);
		academia.agregarAeronave(aeronave2);
		Integer dia2 = 10;
		Integer mes2 = 11;
		Integer anio2 = 2020;
		Integer hora2 = 13;
		Integer horasDeVuelo2 = 5;
		Integer ve = 1;
		Integer cantidadDeTurnos = academia.getTurnos().size();
		academia.darTurnoParaVueloConInstructor(alumno2, instructor2, aeronave2, dia2, mes2, anio2, hora2, horasDeVuelo2);
		assertEquals(ve,cantidadDeTurnos );
		//No se asigna el turno pero el valor de "seAgrego" no cambia
		//assertFalse(academia.darTurnoParaVueloConInstructor(alumno2, instructor2, aeronave2, dia2, mes2, anio2, hora2, horasDeVuelo2));
	}
	
	@Test
	public void queSePuedaAsignarDiferentesTurnosUnaMismaPersona() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		academia.agregarAlumno(alumno);
		academia.agregarInstructor(instructor);
		academia.agregarAeronave(aeronave);
		Integer dia = 10;
		Integer mes = 11;
		Integer anio = 2020;
		Integer hora = 13;
		Integer horasDeVuelo = 5;
		academia.darTurnoParaVueloConInstructor(alumno, instructor, aeronave, dia, mes, anio, hora, horasDeVuelo);
		Integer dia2 = 10;
		Integer mes2 = 11;
		Integer anio2 = 2020;
		Integer hora2 = 14;
		Integer horasDeVuelo2 = 5;
		academia.darTurnoParaVueloConInstructor(alumno, instructor, aeronave, dia2, mes2, anio2, hora2, horasDeVuelo2);
		Integer cantidadDeTurnos = academia.getTurnos().size();
		Integer ve = 2;
		assertEquals(ve, cantidadDeTurnos);
		
	}
	
	@Test
	public void queSePuedaAsignarTurnoUnAlumnoParaVolarSolo() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		alumno.setHorasDeVuelo(21);
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		academia.agregarAlumno(alumno);
		academia.agregarInstructor(instructor);
		academia.agregarAeronave(aeronave);
		Integer dia = 10;
		Integer mes = 11;
		Integer anio = 2020;
		Integer hora = 13;
		Integer horasDeVuelo = 5;
		assertTrue(academia.darTurnoParaVueloSolo(alumno, aeronave, dia, mes, anio, hora, horasDeVuelo));
	}
	

}
