package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

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
//Alumno
	@Test
	public void queSePuedaAgregarUnAlumnoAUnaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333, 1);
		try {
			academia.agregarAlumnoAAcademia(alumno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer cantidadDeAlumnos = academia.getAlumnos().size();
		Integer ve = 1;
		assertEquals(ve, cantidadDeAlumnos);
	}
	
	@Test
	public void queNoSePuedaAgregarAlumnosDuplicadosALaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 35396973, 1);
		Alumno alumno2 = new Alumno("Alejandro","acosta", 35396973, 1);
		try {
			academia.agregarAlumnoAAcademia(alumno);
			academia.agregarAlumnoAAcademia(alumno2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer ve = 1;
		assertTrue(academia.getAlumnos().size() == ve);
	}
	//falta agregar una excepcion si no lo encuentra
	@Test
	public void queSePuedaEliminarUnAlumnoDeLaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		try {
			academia.agregarAlumnoAAcademia(alumno);
			academia.eliminarAlumnoDeAcademia(alumno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer ve = 0;
		assertTrue(academia.getAlumnos().size() == ve);

	}
	//falta agregar una excepcion si no lo encuentra
	@Test
	public void queSePuedaEliminarUnAlumnoDeLaAcademiaPorId() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Alumno alumno2 = new Alumno("Alejandro","acosta", 4444,2);
		try {
			academia.agregarAlumnoAAcademia(alumno);
			academia.agregarAlumnoAAcademia(alumno2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer ve = 1;
		assertTrue(academia.eliminarAlumnoPorId(alumno2.getId()));
		Integer cantidadDeAlumnos = academia.getAlumnos().size();
		assertEquals(ve, cantidadDeAlumnos);
	}

//Instructor
	@Test
	public void queSePuedaAgregarUnInstructorAUnaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		try {
			academia.agregarInstructorEnAcademia(instructor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer cantidadDeInstructores = academia.getInstructores().size();
		Integer ve = 1;
		assertEquals(ve, cantidadDeInstructores);
	}
	
	@Test
	public void queNoSePuedaAgregarUnInstructorDuplicadoAUnaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Instructor instructor2 = new Instructor("InstrucName", "InstrucApe", 12345, 2);
		try {
			academia.agregarInstructorEnAcademia(instructor);
			academia.agregarInstructorEnAcademia(instructor2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer cantidadDeInstructores = academia.getInstructores().size();
		Integer ve = 1;
		assertEquals(ve, cantidadDeInstructores);
	}
	//falta agregar una excepcion si no lo encuentra
	@Test
	public void queSePuedaEliminarUnInstructorDeLaAcademia() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		try {
			academia.agregarInstructorEnAcademia(instructor);
			academia.eliminarInstructorDeAcademia(instructor);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer ve = 0;
		assertTrue(academia.getInstructores().size() == ve);
	}
	//falta agregar una excepcion si no lo encuentra
	@Test
	public void queSePuedaEliminarUnInstructorDeLaAcademiaPorId() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Instructor instructor2 = new Instructor("InstrucName", "InstrucApe", 123, 2);
		try {
			academia.agregarInstructorEnAcademia(instructor);
			academia.agregarInstructorEnAcademia(instructor2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Integer ve = 1;
		assertTrue(academia.eliminarInstructorPorId(instructor2.getId()));
		Integer cantidadDeAlumnos = academia.getInstructores().size();
		assertEquals(ve, cantidadDeAlumnos);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumnoJuntoConSuInstructor() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Alumno alumno2 = new Alumno("Alejandro","acosta", 222222,2);
		alumno.setHorasDeVuelo(0);
		alumno.pilotear(21);
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		TreeSet<Alumno> alumnos = new TreeSet<Alumno>();
		alumnos.add(alumno);
		alumnos.add(alumno2);
		instructor.setAlumnos(alumnos);
		Iterator<Alumno> it = alumnos.iterator();
		while (it.hasNext()) {
			Alumno alumnoIt = (Alumno) it.next();
			academia.agregarAlumnoAAcademia(alumnoIt);
		}
		try {
			assertTrue(academia.agregarInstructorConAlumno(instructor));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//Aeronave 
	@Test
	public void k() {
		
	}

//Turno
	@Test
	public void queNoSePuedaAsignarUnTurnoEnElMismoDiaYHorario() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		Turno turno = new Turno(2020, 11, 10, 13, 5, alumno, instructor, aeronave);
		academia.agregarAlumnoAAcademia(alumno);
		academia.agregarInstructorEnAcademia(instructor);
		academia.agregarAeronaveAAcademia(aeronave);
		academia.darTurnoParaVueloConInstructor(turno);
		Alumno alumno2 = new Alumno("Alejandro","acosta", 444,1);
		Instructor instructor2 = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave2 = new Aeronave("modelo", "x22", 2, 5);
		academia.agregarAlumnoAAcademia(alumno2);
		academia.agregarInstructorEnAcademia(instructor2);
		academia.agregarAeronaveAAcademia(aeronave2);
		Turno mismoTurno = new Turno(2020, 11, 10, 13, 5, alumno, instructor, aeronave);
		Integer ve = 1;
		Integer cantidadDeTurnos = academia.getTurnos().size();
		academia.darTurnoParaVueloConInstructor(mismoTurno);
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
		Turno turno = new Turno(2020, 11, 10, 13, 5, alumno, instructor, aeronave);
		academia.agregarAlumnoAAcademia(alumno);
		academia.agregarInstructorEnAcademia(instructor);
		academia.agregarAeronaveAAcademia(aeronave);
		academia.darTurnoParaVueloConInstructor(turno);
		Turno otroTurno = new Turno(2020, 11, 10, 14, 5, alumno, instructor, aeronave);
		academia.darTurnoParaVueloConInstructor(otroTurno);
		Integer cantidadDeTurnos = academia.getTurnos().size();
		Integer ve = 2;
		assertEquals(ve, cantidadDeTurnos);
		
	}
	
	@Test
	public void queSePuedaAsignarUnTurnoParaVolarConInstructor() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		Alumno alumno2= new Alumno("Alejandro","acosta", 44,2);
		Instructor instructor = new Instructor("InstrucName", "InstrucApe", 12345, 1);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		Turno turno = new Turno(2020, 11, 10, 13, 5, alumno, instructor, aeronave);
		try {
			academia.agregarAlumnoAAcademia(alumno);
			academia.agregarAlumnoAAcademia(alumno2);
			academia.agregarInstructorEnAcademia(instructor);
			academia.agregarAeronaveAAcademia(aeronave);
			TreeSet<Alumno> alumnos = new TreeSet<Alumno>();
			alumnos.add(alumno);
			alumnos.add(alumno2);
			instructor.setAlumnos(alumnos);
			assertTrue(academia.darTurnoParaVueloConInstructor(turno));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Integer ve = 1;
		System.out.println(academia.getTurnos());
		Integer cantidadDeTurnos = academia.getTurnos().size();
		assertEquals(ve, cantidadDeTurnos);
	}
	
	@Test
	public void queSePuedaAsignarTurnoUnAlumnoParaVolarSolo() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		alumno.setHorasDeVuelo(20);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		Turno turno = new Turno(2020, 11, 10, 13, 5, alumno, null, aeronave);
		
		try {
			academia.agregarAlumnoAAcademia(alumno);
			academia.agregarAeronaveAAcademia(aeronave);
			assertTrue(academia.darTurnoParaVueloSolo(turno));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(academia.getTurnos());
	}
	
	@Test
	public void queNoSePuedaAsignarTurnoUnAlumnoParaVolarSoloSiNoCumpleConLaCantidadDeHoras() {
		AcademiaDeVuelo academia = new AcademiaDeVuelo("FlyMeToTheMoon");
		Alumno alumno = new Alumno("Alejandro","acosta", 333333,1);
		alumno.setHorasDeVuelo(19);
		Aeronave aeronave = new Aeronave("modelo", "x22", 2, 3);
		Turno turno = new Turno(2020, 11, 10, 13, 5, alumno, null, aeronave);
		try {
			academia.agregarAlumnoAAcademia(alumno);
			academia.agregarAeronaveAAcademia(aeronave);
			assertFalse(academia.darTurnoParaVueloSolo(turno));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
