package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

public class Aeronave {
	private final Integer horasDeVueloParaRevision = 600;
	private final Integer ciclosParaRevision = 300;
	private String modelo;
	private String matricula;
	private Integer horasDeVueloDesdeUltimoService;
	private Integer ciclosRealizadosDesdeElUltimoService;
	
	public Aeronave(String modelo, String matricula, Integer horasDeVueloDesdeUltimoService, Integer ciclosRealizadosDesdeElUltimoService ) {
		this.modelo = modelo;
		this.matricula = matricula;
		this.horasDeVueloDesdeUltimoService = horasDeVueloDesdeUltimoService;
		this.ciclosRealizadosDesdeElUltimoService = ciclosRealizadosDesdeElUltimoService;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getHorasDeVueloDesdeUltimoService() {
		return horasDeVueloDesdeUltimoService;
	}

	public void setHorasDeVueloDesdeUltimoService(Integer horasDeVueloDesdeUltimoService) {
		this.horasDeVueloDesdeUltimoService = horasDeVueloDesdeUltimoService;
	}

	public Integer getCiclosRealizadosDesdeElUltimoService() {
		return ciclosRealizadosDesdeElUltimoService;
	}

	public void setCiclosRealizadosDesdeElUltimoService(Integer ciclosRealizadosDesdeElUltimoService) {
		this.ciclosRealizadosDesdeElUltimoService = ciclosRealizadosDesdeElUltimoService;
	}

	public Integer getHorasDeVueloParaRevision() {
		return horasDeVueloParaRevision;
	}

	public Integer getCiclosParaRevision() {
		return ciclosParaRevision;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciclosParaRevision == null) ? 0 : ciclosParaRevision.hashCode());
		result = prime * result + ((ciclosRealizadosDesdeElUltimoService == null) ? 0
				: ciclosRealizadosDesdeElUltimoService.hashCode());
		result = prime * result
				+ ((horasDeVueloDesdeUltimoService == null) ? 0 : horasDeVueloDesdeUltimoService.hashCode());
		result = prime * result + ((horasDeVueloParaRevision == null) ? 0 : horasDeVueloParaRevision.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		Aeronave other = (Aeronave) obj;
		if (ciclosParaRevision == null) {
			if (other.ciclosParaRevision != null)
				return false;
		} else if (!ciclosParaRevision.equals(other.ciclosParaRevision))
			return false;
		if (ciclosRealizadosDesdeElUltimoService == null) {
			if (other.ciclosRealizadosDesdeElUltimoService != null)
				return false;
		} else if (!ciclosRealizadosDesdeElUltimoService.equals(other.ciclosRealizadosDesdeElUltimoService))
			return false;
		if (horasDeVueloDesdeUltimoService == null) {
			if (other.horasDeVueloDesdeUltimoService != null)
				return false;
		} else if (!horasDeVueloDesdeUltimoService.equals(other.horasDeVueloDesdeUltimoService))
			return false;
		if (horasDeVueloParaRevision == null) {
			if (other.horasDeVueloParaRevision != null)
				return false;
		} else if (!horasDeVueloParaRevision.equals(other.horasDeVueloParaRevision))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aeronave [horasDeVueloParaRevision=" + horasDeVueloParaRevision + ", ciclosParaRevision="
				+ ciclosParaRevision + ", modelo=" + modelo + ", matricula=" + matricula
				+ ", horasDeVueloDesdeUltimoService=" + horasDeVueloDesdeUltimoService
				+ ", ciclosRealizadosDesdeElUltimoService=" + ciclosRealizadosDesdeElUltimoService + "]";
	}

	public Integer calcularHorasRestantesParaElProximoService() {
		return this.horasDeVueloParaRevision - this.horasDeVueloDesdeUltimoService;
	}

	public Integer calcularCiclosRestantesParaElProximoService() {
		return this.ciclosParaRevision - this.ciclosRealizadosDesdeElUltimoService;
	}

	public Boolean volar(Integer horasDeVuelo) {
		if(this.calcularCiclosRestantesParaElProximoService() >= 0 ) {
			this.ciclosRealizadosDesdeElUltimoService++;
			this.horasDeVueloDesdeUltimoService = this.horasDeVueloDesdeUltimoService + horasDeVuelo;
		}return false;
		
	}

}
