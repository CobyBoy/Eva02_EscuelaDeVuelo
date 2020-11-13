package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class AcademiaDeVuelo implements AlumnoRepository, InstructorRepository, AeronaveRepository{

	private String nombre;
	private TreeSet<Instructor> instructores;
	private TreeSet<Alumno> alumnos; 
	private HashSet<Aeronave> aeronaves; 
	private HashSet<Turno> turnos; 

	public AcademiaDeVuelo(String nombre) {
		this.nombre = nombre;
		this.instructores = new TreeSet<Instructor>();
		this.alumnos = new TreeSet<Alumno>();
		this.aeronaves = new HashSet<Aeronave>();
		this.turnos = new HashSet<Turno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Instructor> getInstructores() {
		return instructores;
	}

	public void setInstructores(TreeSet<Instructor> instructores) {
		this.instructores = instructores;
	}

	public TreeSet<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(TreeSet<Alumno> alumnos) {
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
	public Boolean agregarInstructorEnAcademia (Instructor instructor) {
		if (instructor != null) 
			return this.instructores.add(instructor);
		else return false;	
	}
	
	@Override
	public Boolean agregarInstructorConAlumno(Instructor instructor) {
		TreeSet<Alumno> alumnosDeInstructor = instructor.getAlumnos();
		Iterator<Alumno> it = alumnosDeInstructor.iterator();
		while (it.hasNext()) {
			Alumno alumno = (Alumno) it.next();
			if (buscarAlumnoPorId(alumno.getId()) != null) {
				 return this.instructores.add(instructor);
			}
		}
		return false;	
	}
	
	@Override
	public Instructor buscarInstructorPorId (Integer idInstructor) {
		for (Instructor instructorIt : instructores) {
			instructorIt.getId().equals(idInstructor);
			return instructorIt;
		}
		return null;
		
	}

	@Override
	public Boolean eliminarInstructorDeAcademia(Instructor instructor) {
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
	public Boolean agregarAlumnoAAcademia(Alumno alumno) {
			return this.alumnos.add(alumno);
	}
	
	@Override
	public Alumno buscarAlumnoPorId (Integer idAlumno) {
		for (Alumno alumnoIt : this.alumnos) {
			if (alumnoIt.getId().equals(idAlumno))
			return alumnoIt;
		}
		return null;
	}

	@Override
	public Boolean eliminarAlumnoDeAcademia (Alumno alumno) throws NullPointerException{
			if (alumno != null)
				return this.alumnos.remove(alumno);
			else throw new NullPointerException("Ha enviado un objeto Null, no se ha eliminado el alumno");	
	}

	@Override
	public Boolean eliminarAlumnoPorId(Integer IdAlumno) {
		Boolean eliminado = false;
		Iterator<Alumno> it = this.alumnos.iterator();
		while (it.hasNext()) {
			Alumno alumno = it.next();
			if (alumno.getId().equals(IdAlumno)) {
				it.remove();
			}
			eliminado = true;
		}
		return eliminado;
	}

	@Override
	public Boolean agregarAeronave(Aeronave aeronave) {
		return this.aeronaves.add(aeronave);
	}

	@Override
	public Boolean eliminarAeronave(Aeronave aeronave) {
		return this.aeronaves.remove(aeronave);
	}
	
	public Boolean darTurnoParaVueloConInstructor(Turno nuevoTurno) {
		Boolean seAgrego = false;
		if (this.alumnos.contains(nuevoTurno.getAlumno()) && this.instructores.contains(nuevoTurno.getInstructor())
				&& this.aeronaves.contains(nuevoTurno.getAeronave())) {
			if (this.turnos.isEmpty()) {
				 this.turnos.add(nuevoTurno);
				  seAgrego = true;
			}
			else {
				for (Turno turnoGuardado : this.turnos) {
				if (!turnoGuardado.getDia().equals(nuevoTurno.getDia()) ||
						turnoGuardado.getDia().equals(nuevoTurno.getDia()) && turnoGuardado.getHora() != nuevoTurno.getHora() 
					) {
					this.turnos.add(nuevoTurno);
				};
				};
				seAgrego = true;
			};
			 
		};
		return seAgrego;
		
	};
	
	public Boolean darTurnoParaVueloSolo (Turno turno) {
		Boolean seAgrego = false;
		if (this.alumnos.contains(turno.getAlumno()) && turno.getAlumno().pilotearSolo()) {
			if (this.turnos.isEmpty()) {
				 this.turnos.add(turno);
				  seAgrego = true;
			}
			else {
				for (Turno turnoGuardado : this.turnos) {
				if (!turnoGuardado.getDia().equals(turno.getDia()) ||
						turnoGuardado.getDia().equals(turno.getDia()) && turnoGuardado.getHora() != turno.getHora() 
					) {
					this.turnos.add(turno);
				};
				};
				seAgrego = true;
			};
			 
		};
		
		return seAgrego;
	}

	@Override
	public String toString() {
		return "AcademiaDeVuelo [nombre=" + nombre + ","+ "\n"+ "instructores=" + instructores + ","+"\n"+"alumnos=" + alumnos
				+ ","+"\n"+ "aeronaves=" + aeronaves + ", turnos=" + turnos + "]";
	}
}
