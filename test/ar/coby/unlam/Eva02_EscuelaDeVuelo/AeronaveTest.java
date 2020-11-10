package ar.coby.unlam.Eva02_EscuelaDeVuelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AeronaveTest {

	@Test
	public void queCalculeHorasRestantesParaElProximoService() {
		Aeronave cessna = new Aeronave("Cessna 152","LV-CHC", 50, 25);
		
		Integer ve = 550;
		assertEquals(ve,cessna.calcularHorasRestantesParaElProximoService());
	}
	
	@Test
	public void queCalculeCiclosRestantesParaElProximoService() {
		Aeronave cessna = new Aeronave("Cessna 152","LV-CHC", 50, 25);
		
		Integer ve = 275;
		assertEquals(ve,cessna.calcularCiclosRestantesParaElProximoService());
	}
	
	@Test
	public void queSeComputenLasHorasDeVuelo() {
		
		Aeronave cessna = new Aeronave("Cessna 152","LV-CHC", 50, 25);
		
		cessna.volar(5);
		Integer ve2 = 545;
		
		assertEquals(ve2,cessna.calcularHorasRestantesParaElProximoService());
	}
	
	@Test
	public void queSeComputenLosCiclosDeVuelo() {
		
		Aeronave cessna = new Aeronave("Cessna 152","LV-CHC", 50, 25);
		
		cessna.volar(5);
		cessna.volar(5);
		cessna.volar(5);
		Integer ve2 = 272;
		
		assertEquals(ve2,cessna.calcularCiclosRestantesParaElProximoService());
	}
	
	@Test
	public void queNoPuedaVolarConMasHorasDeLasPermitidasAntesDelService() {
		Aeronave cessna = new Aeronave("Cessna 152","LV-CHC", 650, 25);
		
		assertFalse(cessna.volar(5));
	}
	
	@Test
	public void queNoPuedaVolarConMasCiclosDeLosPermitidosAntesDelService() {
		Aeronave cessna = new Aeronave("Cessna 152","LV-CHC", 50, 350);
		
		assertFalse(cessna.volar(5));
	}
	

}
