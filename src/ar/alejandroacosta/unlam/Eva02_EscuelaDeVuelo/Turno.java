package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turno other = (Turno) obj;
		if (anio == null) {
			if (other.anio != null)
				return false;
		} else if (!anio.equals(other.anio))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "<Turno:"+"\n" +"[anio=" + anio + ", mes=" + mes + ", dia=" + dia + ", hora=" + hora + ", horasDeVuelo="
				+ horasDeVuelo + ","+"\n" +"alumno=" + alumno + ","+"\n" +"instructor=" + instructor + ","+" \n" +"aeronave=" + aeronave + ">";
	}
}
