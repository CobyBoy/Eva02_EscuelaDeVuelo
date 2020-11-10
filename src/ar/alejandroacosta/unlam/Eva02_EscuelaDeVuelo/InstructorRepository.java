package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

public interface InstructorRepository {
	public Boolean agregarInstructor(Instructor instructor);
	
	public Instructor buscarInstructor (Integer idInstructor);
	
	public Boolean eliminarInstructor(Instructor instructor);

	public Boolean eliminarInstructorPorId(Integer idInstructor);
}
