package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import java.util.HashSet;

public class Instructor extends Persona {
	private Integer id;
	private Integer horasDeVuelo;
	private HashSet<Alumno> alumno;
	
	public Instructor(String nombre, String apellido, Integer dni, Integer id) {
		super(nombre, apellido, dni);
		this.id = id;
		this.alumno = new HashSet<Alumno>();
		this.horasDeVuelo = 0;
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
	

	public Integer pilotear(Integer horas) {
		this.setHorasDeVuelo(this.getHorasDeVuelo() + horas);
		return this.getHorasDeVuelo();
	}
	
}
