package ar.coby.unlam.Eva02_EscuelaDeVuelo;

public class Turno {
	private Integer anio;
	private Integer mes;
	private Integer dia;
	private Integer hora;
	private Integer horasDeVuelo;
	private Alumno alumno;
	private Instructor instructor;
	private Aeronave aeronave;
	
	public Turno(Integer anio, Integer mes, Integer dia,Integer hora, Integer horasDeVuelo, Alumno alumno, Instructor instructor, Aeronave aeronave) {
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.hora = hora;
		this.horasDeVuelo = horasDeVuelo;
		this.alumno = alumno;
		this.instructor = instructor;
		this.aeronave = aeronave;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
}
