package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;


public class Instructor extends Persona {
	private Integer id;
	private Integer horasDeVuelo;
	private Alumno alumno;
	
	public Instructor(String nombre, String apellido, Integer dni, Integer id) {
		super(nombre, apellido, dni);
		this.id = id;
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
	

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Integer pilotear(Integer horas) {
		this.setHorasDeVuelo(this.getHorasDeVuelo() + horas);
		return this.getHorasDeVuelo();
	}
	
}
