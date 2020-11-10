package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

public interface InstructorRepository {
	public Boolean agregarInstructorEnAcademia(Instructor instructor);
	
	public Instructor buscarInstructorPorId (Integer idInstructor);
	
	public Boolean eliminarInstructorDeAcademia(Instructor instructor);

	public Boolean eliminarInstructorPorId(Integer idInstructor);

	public Boolean agregarInstructorConAlumno(Instructor instructor);


}
