package ar.coby.unlam.Eva02_EscuelaDeVuelo;

public class Alumno extends Persona implements PilotoRepository{
	private Integer id;
	private final Integer horasDeVueloParaVolarSolo = 20;
	private Integer horasDeVuelo;
	private Integer horasDeVueloQueFaltanParaVolarSolo;
	
	public Alumno(String nombre, String apellido, Integer dni) {
		super(nombre, apellido, dni);
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

	public Integer getHorasDeVueloQueFaltanParaVolarSolo() {
		return horasDeVueloQueFaltanParaVolarSolo;
	}

	public void setHorasDeVueloQueFaltanParaVolarSolo(Integer horasDeVueloQueFaltanParaVolarSolo) {
		this.horasDeVueloQueFaltanParaVolarSolo = horasDeVueloQueFaltanParaVolarSolo;
	}

	public Integer getHorasDeVueloParaVolarSolo() {
		return horasDeVueloParaVolarSolo;
	}
	
	@Override
	public Boolean pilotearSolo(Integer horas) {
		return this.horasDeVuelo >= this.horasDeVueloParaVolarSolo;
	}

	public Integer pilotearConInstructor(Alumno alumno, Instructor instructor, Integer horas) {		
		this.setHorasDeVuelo(this.getHorasDeVuelo() + horas);
		return this.getHorasDeVuelo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((horasDeVuelo == null) ? 0 : horasDeVuelo.hashCode());
		result = prime * result + ((horasDeVueloParaVolarSolo == null) ? 0 : horasDeVueloParaVolarSolo.hashCode());
		result = prime * result
				+ ((horasDeVueloQueFaltanParaVolarSolo == null) ? 0 : horasDeVueloQueFaltanParaVolarSolo.hashCode());
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
		Alumno other = (Alumno) obj;
		if (horasDeVuelo == null) {
			if (other.horasDeVuelo != null)
				return false;
		} else if (!horasDeVuelo.equals(other.horasDeVuelo))
			return false;
		if (horasDeVueloParaVolarSolo == null) {
			if (other.horasDeVueloParaVolarSolo != null)
				return false;
		} else if (!horasDeVueloParaVolarSolo.equals(other.horasDeVueloParaVolarSolo))
			return false;
		if (horasDeVueloQueFaltanParaVolarSolo == null) {
			if (other.horasDeVueloQueFaltanParaVolarSolo != null)
				return false;
		} else if (!horasDeVueloQueFaltanParaVolarSolo.equals(other.horasDeVueloQueFaltanParaVolarSolo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", horasDeVueloParaVolarSolo=" + horasDeVueloParaVolarSolo + ", horasDeVuelo="
				+ horasDeVuelo + ", horasDeVueloQueFaltanParaVolarSolo=" + horasDeVueloQueFaltanParaVolarSolo + "]";
	}

}