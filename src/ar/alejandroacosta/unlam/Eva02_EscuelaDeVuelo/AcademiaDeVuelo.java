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
	public Boolean agregarInstructorEnAcademia (Instructor instructor) throws NullPointerException{
		if (instructor != null) 
			return this.instructores.add(instructor);
		else throw new NullPointerException("Ha enviado un objeto Null, no se ha eliminado el instructor");		
	}
	
	@Override
	public Boolean agregarInstructorConAlumno(Instructor instructor) throws NullPointerException {
		Boolean agregado = false;
		if (instructor == null) {
			throw new NullPointerException("Ha enviado un objeto Null, no se ha agregado el instructor");
		}
		else {
		TreeSet<Alumno> alumnosDeInstructor = instructor.getAlumnos();
		Iterator<Alumno> it = alumnosDeInstructor.iterator();
		while (it.hasNext()) {
			Alumno alumno = (Alumno) it.next();
			if (buscarAlumnoPorId(alumno.getId()) != null) {
				 this.instructores.add(instructor);
				 agregado = true;
				 break;
			}
		}
		return agregado;}	
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
	public Boolean eliminarInstructorDeAcademia(Instructor instructor) throws NullPointerException{
		if (this.instructores.contains(instructor)) return this.instructores.remove(instructor);
		else if (instructor == null) throw new NullPointerException("Ha enviado un objeto Null, no se ha eliminado el instructor");	
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
	public Boolean agregarAlumnoAAcademia(Alumno alumno) throws NullPointerException{
		if (alumno != null)
			return this.alumnos.add(alumno);
		else throw new NullPointerException("Ha enviado un objeto Null, no se ha agregado el alumno");	
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
			if (this.alumnos.contains(alumno)) return this.alumnos.remove(alumno);
			else if(alumno == null) throw new NullPointerException("Ha enviado un objeto Null, no se ha eliminado el alumno");	
			else return false;
	}

	@Override
	public Boolean eliminarAlumnoPorId(Integer IdAlumno) {
		Boolean eliminado = false;
		Iterator<Alumno> it = this.alumnos.iterator();
		while (it.hasNext()) {
			Alumno alumno = it.next();
			if (alumno.getId().equals(IdAlumno)) {
				it.remove();
				eliminado = true;
				break;
			}
		}
		return eliminado;
	}

	@Override
	public Boolean agregarAeronaveAAcademia(Aeronave aeronave) throws NullPointerException {
		if (aeronave != null) 
			return this.aeronaves.add(aeronave);
		else throw new NullPointerException("Ha enviado un objeto Null, no se ha agregado la aeronave");
	}

	@Override
	public Boolean eliminarAeronaveDeAcademia(Aeronave aeronave) throws NullPointerException{
		if (this.aeronaves.contains(aeronave)) return this.aeronaves.remove(aeronave);
		else if (aeronave == null) throw new NullPointerException("Ha enviado un objeto Null, no se ha eliminado la aeronave");
		else return false;
	}
	
	public Boolean darTurnoParaVueloConInstructor(Turno nuevoTurno) throws NullPointerException  {
		Boolean seAgrego = false;
		if (nuevoTurno !=null) {
			if (nuevoTurno.getAlumno() != null && nuevoTurno.getAeronave() != null && nuevoTurno.getInstructor() != null) {
				if (this.turnos.isEmpty()) {
					if (this.alumnos.contains(nuevoTurno.getAlumno()) && this.instructores.contains(nuevoTurno.getInstructor())
							&& this.aeronaves.contains(nuevoTurno.getAeronave())) {
						TreeSet<Alumno> alumnoDeTurno = new TreeSet<Alumno>();
						alumnoDeTurno.add(nuevoTurno.getAlumno());
						nuevoTurno.getInstructor().setAlumnos(alumnoDeTurno);
						nuevoTurno.getAeronave().setAlumnoQuePuedePilotear(nuevoTurno.getAlumno());
						nuevoTurno.getAeronave().setInstructor(nuevoTurno.getInstructor());
						nuevoTurno.getAlumno().pilotear(nuevoTurno.getHorasDeVuelo());
						nuevoTurno.getInstructor().pilotear(nuevoTurno.getHorasDeVuelo());
						this.turnos.add(nuevoTurno);
						seAgrego = true;
					}
					else return seAgrego;
				}
				else {
						for (Turno turnoGuardado : this.turnos) {
						if (!turnoGuardado.getDia().equals(nuevoTurno.getDia()) ||
								turnoGuardado.getDia().equals(nuevoTurno.getDia()) && 
								turnoGuardado.getHora() != nuevoTurno.getHora() 
							) {
							TreeSet<Alumno> alumnoDeTurno = new TreeSet<Alumno>();
							alumnoDeTurno.add(nuevoTurno.getAlumno());
							nuevoTurno.getInstructor().setAlumnos(alumnoDeTurno);
							nuevoTurno.getAeronave().setAlumnoQuePuedePilotear(nuevoTurno.getAlumno());
							nuevoTurno.getAeronave().setInstructor(nuevoTurno.getInstructor());
							nuevoTurno.getAlumno().pilotear(nuevoTurno.getHorasDeVuelo());
							nuevoTurno.getInstructor().pilotear(nuevoTurno.getHorasDeVuelo());
							this.turnos.add(nuevoTurno);
							seAgrego = true;
						};
						};
					};
					
			}
			return seAgrego;
		}
		else throw new NullPointerException("No se ha creado un turno ya que Alumno:"+nuevoTurno.getAlumno()+" es null"+"\n"
				+",  Aeronave: "+nuevoTurno.getAeronave()+" es null o Instructor: "+nuevoTurno.getInstructor()+" es null");
 
		};
	
	public Boolean darTurnoParaVueloSolo (Turno nuevoTurno) throws NullPointerException {
		Boolean seAgrego = false;
		if (nuevoTurno.getAlumno() != null && nuevoTurno.getAeronave() != null) {
			if (this.turnos.isEmpty()) {
				if (siElTurnoParaVolarSoloSePuedeDar(nuevoTurno)) {
					 nuevoTurno.getAeronave().setAlumnoQuePuedePilotear(nuevoTurno.getAlumno());
					 nuevoTurno.getAlumno().pilotear(nuevoTurno.getHorasDeVuelo());
					 this.turnos.add(nuevoTurno);
					 seAgrego = true;
				}
				else return seAgrego;
			}
			else for (Turno turnoGuardado : this.turnos) {
				if (!turnoGuardado.getDia().equals(nuevoTurno.getDia()) ||
						turnoGuardado.getDia().equals(nuevoTurno.getDia()) && turnoGuardado.getHora() != nuevoTurno.getHora() 
					) {
					nuevoTurno.getAeronave().setAlumnoQuePuedePilotear(nuevoTurno.getAlumno());
					nuevoTurno.getAlumno().pilotear(nuevoTurno.getHorasDeVuelo());
					this.turnos.add(nuevoTurno);
					seAgrego = true;
				};
				};
				return seAgrego;
		}
		else throw new NullPointerException("No se ha creado un turno ya que Alumno:"+nuevoTurno.getAlumno()+" es null"+"\n"
		+" o Aeronave: "+nuevoTurno.getAeronave()+" es null");
		};
		
	
	public Boolean siElTurnoParaVolarSoloSePuedeDar(Turno turno) {
		return this.alumnos.contains(turno.getAlumno()) && turno.getAlumno().pilotearSolo() 
		&& this.aeronaves.contains(turno.getAeronave());
	}

	@Override
	public String toString() {
		return "AcademiaDeVuelo [nombre=" + nombre + ","+ "\n"+ "instructores=" + instructores + ","+"\n"+"alumnos=" + alumnos
				+ ","+"\n"+ "aeronaves=" + aeronaves + ", turnos=" + turnos + "]";
	}
}
