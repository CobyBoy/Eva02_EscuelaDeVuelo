package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import java.util.HashSet;

public class Instructor extends Persona implements PilotoRepository, AlumnoRepository{
	private Integer id;
	private Integer horasDeVuelo;
	private HashSet<Alumno> alumno;
	
	public Instructor(String nombre, String apellido, Integer dni, Integer id, Integer horasDeVuelo) {
		super(nombre, apellido, dni);
		this.id = id;
		this.horasDeVuelo = horasDeVuelo;
		this.alumno = new HashSet<Alumno>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHorasDeVuelo() {
		return horasDeVuelo;
	}

	public void setHorasDeVuelo(Integer horasDeVuelo) {
		this.horasDeVuelo = horasDeVuelo;
	}
	

	@Override
	public Boolean pilotearSolo(Integer horas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean agregarAlumno(Alumno alumno) {
		return this.alumno.add(alumno);
	}

	@Override
	public Boolean eliminarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminarAlumnoPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno buscarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
