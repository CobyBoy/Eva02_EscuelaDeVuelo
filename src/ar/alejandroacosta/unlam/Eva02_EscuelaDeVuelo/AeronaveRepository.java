package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

public interface AeronaveRepository {
	public Boolean agregarAeronaveAAcademia(Aeronave aeronave) throws Exception;
	public Boolean eliminarAeronaveDeAcademia(Aeronave aeronave) throws Exception;
}
