package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import java.util.HashSet;
import java.util.Iterator;

public class AcademiaDeVuelo implements AlumnoRepository, InstructorRepository, AeronaveRepository{

	private String nombre;
	private HashSet<Instructor> instructores;
	private HashSet<Alumno> alumnos; 
	private HashSet<Aeronave> aeronaves; 
	private HashSet<Turno> turnos; 

	public AcademiaDeVuelo(String nombre) {
		this.nombre = nombre;
		this.instructores = new HashSet<Instructor>();
		this.alumnos = new HashSet<Alumno>();
		this.aeronaves = new HashSet<Aeronave>();
		this.turnos = new HashSet<Turno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Instructor> getInstructores() {
		return instructores;
	}

	public void setInstructores(HashSet<Instructor> instructores) {
		this.instructores = instructores;
	}

	public HashSet<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(HashSet<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public HashSet<Aeronave> getAeronaves() {
		return aeronaves;
	}

	public void setAeronaves(HashSet<Aeronave> aeronaves) {
		this.aeronaves = aeronaves;
	}

	public HashSet<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(HashSet<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public Boolean agregarInstructor(Instructor instructor) {
		Instructor instructorEncontrado = buscarInstructor(instructor);
		if (instructorEncontrado != null) {
			instructor.setId(this.instructores.size() + 1);
			return this.instructores.add(instructor);
		}
		else return false;
	}
	@Override
	public Instructor buscarInstructor (Instructor instructor) {
		Integer id = instructor.getId();
		for (Instructor instructorIt : instructores) {
			instructorIt.getId().equals(id);
			return instructorIt;
		}
		return null;
		
	}

	@Override
	public Boolean eliminarInstructor(Instructor instructor) {
		if (this.instructores.contains(instructor)) {
			return this.instructores.remove(instructor);
		}
		else return false;
	}

	@Override
	public Boolean eliminarInstructorPorId(Integer idInstructor) {
		Iterator<Instructor> it = this.instructores.iterator();
		while (it.hasNext()) {
			Instructor instructor = it.next();
			if (instructor.getId().equals(idInstructor)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean agregarAlumno(Alumno alumno) {
		if (alumno != null) {
			alumno.setId(this.alumnos.size() + 1);
			return this.alumnos.add(alumno);
		}
		else return false;
		
	}
	
	@Override
	public Alumno buscarAlumno (Alumno alumno) {
		Integer id = alumno.getId();
		for (Alumno alumnoIt : alumnos) {
			alumnoIt.getId().equals(id);
			return alumnoIt;
		}
		return null;
		
	}

	@Override
	public Boolean eliminarAlumno(Alumno alumno) {
		if (this.alumnos.contains(alumno)) {
			return this.alumnos.remove(alumno);
		}
		else return false;
	}

	@Override
	public Boolean eliminarAlumnoPorId(Integer IdAlumno) {
		Iterator<Alumno> it = this.alumnos.iterator();
		while (it.hasNext()) {
			Alumno alumno = it.next();
			if (alumno.getId().equals(IdAlumno)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean agregarAeronave(Aeronave aeronave) {
		return this.aeronaves.add(aeronave);
	}

	@Override
	public Boolean eliminarAeronave(Aeronave aeronave) {
		return this.aeronaves.remove(aeronave);
	}
	
	public Boolean darTurnoParaVueloConInstructor(Alumno alumno, Instructor instructor, Aeronave aeronave, Integer dia, Integer mes, Integer anio, Integer hora, Integer horasDeVuelo) {
		Boolean seAgrego = false;
		if (this.alumnos.contains(alumno) && this.instructores.contains(instructor)) {
			Turno turnoNuevo = new Turno(anio, mes, dia, hora, horasDeVuelo, alumno, instructor, aeronave);
			if (this.turnos.isEmpty()) {
				 this.turnos.add(turnoNuevo);
				  seAgrego = true;
			}
			else {
				for (Turno turnoGuardado : this.turnos) {
				if (!turnoGuardado.getDia().equals(turnoNuevo.getDia()) ||
						turnoGuardado.getDia().equals(turnoNuevo.getDia()) && turnoGuardado.getHora() != turnoNuevo.getHora() 
					) {
					this.turnos.add(turnoNuevo);
				};
				};
				seAgrego = true;
			};
			 
		};
		return seAgrego;
		
	};
	
	public Boolean darTurnoParaVueloSolo (Alumno alumno, Aeronave aeronave, Integer dia, Integer mes, Integer anio, Integer hora, Integer horasDeVuelo) {
		Boolean seAgrego = false;
		if (this.alumnos.contains(alumno) ) {
			Turno turnoNuevo = new Turno(anio, mes, dia, hora, horasDeVuelo, alumno, null, aeronave);
			if (this.turnos.isEmpty()) {
				 this.turnos.add(turnoNuevo);
				  seAgrego = true;
			}
			else {
				for (Turno turnoGuardado : this.turnos) {
				if (!turnoGuardado.getDia().equals(turnoNuevo.getDia()) ||
						turnoGuardado.getDia().equals(turnoNuevo.getDia()) && turnoGuardado.getHora() != turnoNuevo.getHora() 
					) {
					this.turnos.add(turnoNuevo);
				};
				};
				seAgrego = true;
			};
			 
		};
		
		return seAgrego;
	}
}
