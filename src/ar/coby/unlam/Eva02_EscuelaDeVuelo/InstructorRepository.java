package ar.coby.unlam.Eva02_EscuelaDeVuelo;

public interface InstructorRepository {
	public Boolean agregarInstructor(Instructor instructor);
	
	public Instructor buscarInstructor (Instructor instructor);
	
	public Boolean eliminarInstructor(Instructor instructor);

	public Boolean eliminarInstructorPorId(Integer idInstructor);
}
