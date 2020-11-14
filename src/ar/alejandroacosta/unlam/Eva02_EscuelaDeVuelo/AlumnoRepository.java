package ar.alejandroacosta.unlam.Eva02_EscuelaDeVuelo;

public interface AlumnoRepository {
	
	public Boolean agregarAlumnoAAcademia(Alumno alumno) throws Exception;
	
	public Alumno buscarAlumnoPorId(Integer idAlumno);
	
	public Boolean eliminarAlumnoDeAcademia(Alumno alumno) throws Exception;
	
	public Boolean eliminarAlumnoPorId(Integer id);;

}
