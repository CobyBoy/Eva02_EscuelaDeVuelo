package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

public class Alumno extends Persona implements PilotoRepository, Comparable<Alumno>{
	private Integer id = 0;
	private final Integer horasDeVueloParaVolarSolo = 20;
	private Integer horasDeVuelo;
	private Integer horasDeVueloQueFaltanParaVolarSolo;
	
	public Alumno(String nombre, String apellido, Integer dni, Integer id) {
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
	public Boolean pilotearSolo() {
		calcularHorasDeVueloQueFaltanParaVolarSolo();
		return this.horasDeVuelo >= this.horasDeVueloParaVolarSolo;
	}

	public void pilotear(Integer horas) {
		 this.setHorasDeVuelo(this.getHorasDeVuelo() + horas);
		 calcularHorasDeVueloQueFaltanParaVolarSolo();
	}
	//fixear devuelve negativos
	public void calcularHorasDeVueloQueFaltanParaVolarSolo() {
		this.setHorasDeVueloQueFaltanParaVolarSolo(this.horasDeVueloParaVolarSolo - this.getHorasDeVuelo());
	}
	
	public void pilotearConInstructor(Alumno alumno, Instructor instructor, Integer horas) {		
		this.setHorasDeVuelo(this.getHorasDeVuelo() + horas);
		 this.horasDeVueloQueFaltanParaVolarSolo= this.horasDeVueloParaVolarSolo - this.getHorasDeVuelo();
		instructor.setHorasDeVuelo(instructor.getHorasDeVuelo() + horas);
	}

	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", horasDeVueloParaVolarSolo=" + horasDeVueloParaVolarSolo + ", horasDeVuelo="
				+ horasDeVuelo + ", horasDeVueloQueFaltanParaVolarSolo=" + horasDeVueloQueFaltanParaVolarSolo + "]"+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return this.getDni() - o.getDni();
	}	
	
}
