package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

import java.util.TreeSet;

public class Instructor extends Persona implements Comparable<Instructor>{
	private Integer id;
	private Integer horasDeVuelo;
	private TreeSet<Alumno> alumnos;
	
	public Instructor(String nombre, String apellido, Integer dni, Integer id) {
		super(nombre, apellido, dni);
		this.id = id;
		this.horasDeVuelo = 0;
		this.alumnos = new TreeSet<Alumno>();
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
	

	public TreeSet<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(TreeSet<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Integer pilotear(Integer horas) {
		this.setHorasDeVuelo(this.getHorasDeVuelo() + horas);
		return this.getHorasDeVuelo();
	}

	@Override
	public String toString() {
		return "INSTRUCTOR [id=" + id + ", horasDeVuelo=" + horasDeVuelo + ", alumnos=" + alumnos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((alumnos == null) ? 0 : alumnos.hashCode());
		result = prime * result + ((horasDeVuelo == null) ? 0 : horasDeVuelo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instructor other = (Instructor) obj;
		if (alumnos == null) {
			if (other.alumnos != null)
				return false;
		} else if (!alumnos.equals(other.alumnos))
			return false;
		if (horasDeVuelo == null) {
			if (other.horasDeVuelo != null)
				return false;
		} else if (!horasDeVuelo.equals(other.horasDeVuelo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Instructor o) {
		return this.getDni() - o.getDni();
	}
	
}
